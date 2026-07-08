package sv.uca.nexauca.data.services.attendance

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.*
import sv.uca.nexauca.R
import sv.uca.nexauca.data.firebase.FirebaseModule
import sv.uca.nexauca.data.models.AttendanceStatus
import sv.uca.nexauca.data.services.gps.GpsService

class AttendanceForegroundService : Service() {

    companion object {

        const val CHANNEL_ID = "attendance_channel"

        const val NOTIFICATION_ID = 1001

        const val EXTRA_ATTENDANCE_ID = "attendance_id"

        const val EXTRA_PARTICIPANT_ID = "participant_id"

        const val EXTRA_PROJECT_LATITUDE = "project_latitude"

        const val EXTRA_PROJECT_LONGITUDE = "project_longitude"

        const val EXTRA_ALLOWED_RADIUS = "allowed_radius"

    }

    private val attendanceRepository by lazy {

        FirebaseModule.attendanceRepository

    }

    private lateinit var gpsService: GpsService

    private val serviceScope = CoroutineScope(
        SupervisorJob() + Dispatchers.IO
    )

    private var timerJob: Job? = null

    private var gpsJob: Job? = null

    private var attendanceId = ""

    private var participantId = ""

    private var projectLatitude = 0.0

    private var projectLongitude = 0.0

    private var allowedRadius = 0.0

    private var elapsedSeconds = 0L

    private var finished = false

    override fun onCreate() {

        super.onCreate()

        gpsService = GpsService(this)

        createNotificationChannel()

    }

    override fun onStartCommand(

        intent: Intent?,

        flags: Int,

        startId: Int

    ): Int {

        attendanceId =
            intent?.getStringExtra(EXTRA_ATTENDANCE_ID).orEmpty()

        participantId =
            intent?.getStringExtra(EXTRA_PARTICIPANT_ID).orEmpty()

        projectLatitude =
            intent?.getDoubleExtra(
                EXTRA_PROJECT_LATITUDE,
                0.0
            ) ?: 0.0

        projectLongitude =
            intent?.getDoubleExtra(
                EXTRA_PROJECT_LONGITUDE,
                0.0
            ) ?: 0.0

        allowedRadius =
            intent?.getDoubleExtra(
                EXTRA_ALLOWED_RADIUS,
                0.0
            ) ?: 0.0

        startForeground(

            NOTIFICATION_ID,

            buildNotification()

        )

        startTimer()

        startNotificationUpdater()

        startGpsMonitor()

        return START_STICKY

    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun buildNotification(): Notification {

        return NotificationCompat.Builder(

            this,

            CHANNEL_ID

        )

            .setContentTitle("NEXA UCA")

            .setContentText("Horas sociales en progreso")

            .setSmallIcon(R.drawable.ic_launcher_foreground)

            .setOngoing(true)

            .build()

    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(

                CHANNEL_ID,

                "Horas Sociales",

                NotificationManager.IMPORTANCE_LOW

            )

            val manager =
                getSystemService(NotificationManager::class.java)

            manager.createNotificationChannel(channel)

        }

    }

    private fun startTimer() {

        timerJob?.cancel()

        timerJob = serviceScope.launch {

            while (isActive && !finished) {

                delay(1000)

                elapsedSeconds++

            }

        }

    }

    private fun startGpsMonitor() {

        gpsJob?.cancel()

        gpsJob = serviceScope.launch {

            while (isActive && !finished) {

                delay(30000)

                val location =
                    gpsService.getCurrentLocation()
                        ?: continue

                val inside = gpsService.isInsideRadius(

                    currentLatitude = location.latitude,

                    currentLongitude = location.longitude,

                    projectLatitude = projectLatitude,

                    projectLongitude = projectLongitude,

                    allowedRadius = allowedRadius

                )

                if (!inside) {

                    handleOutsideArea()

                }

            }

        }

    }

    private suspend fun handleOutsideArea() {

        finished = true

        timerJob?.cancel()

        gpsJob?.cancel()

        if (elapsedSeconds < 3600) {

            attendanceRepository.updateAttendanceStatus(

                attendanceId,

                AttendanceStatus.Rechazado

            )

            attendanceRepository.updateAttendanceCheckOut(

                attendanceId,

                System.currentTimeMillis().toString()

            )

            stopSelf()

            return

        }

        attendanceRepository.updateAttendanceStatus(

            attendanceId,

            AttendanceStatus.Aprobado

        )

        attendanceRepository.updateAttendanceCheckOut(

            attendanceId,

            System.currentTimeMillis().toString()

        )

        stopSelf()

    }

    suspend fun finishAttendance() {

        if (finished) return

        finished = true

        timerJob?.cancel()

        gpsJob?.cancel()

        attendanceRepository.updateAttendanceStatus(

            attendanceId,

            AttendanceStatus.Aprobado

        )

        attendanceRepository.updateAttendanceCheckOut(

            attendanceId,

            System.currentTimeMillis().toString()

        )

        stopSelf()

    }

    fun getElapsedSeconds(): Long {

        return elapsedSeconds

    }

    fun isRunning(): Boolean {

        return !finished

    }

    override fun onDestroy() {

        timerJob?.cancel()

        gpsJob?.cancel()

        serviceScope.cancel()

        super.onDestroy()

    }

    private fun updateNotification() {

        val minutes = elapsedSeconds / 60

        val seconds = elapsedSeconds % 60

        val notification = NotificationCompat.Builder(

            this,

            CHANNEL_ID

        )
            .setContentTitle("NEXA UCA")
            .setContentText(
                String.format(
                    "Horas sociales: %02d:%02d",
                    minutes,
                    seconds
                )
            )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOnlyAlertOnce(true)
            .setOngoing(true)
            .build()

        val manager =
            getSystemService(
                NotificationManager::class.java
            )

        manager.notify(

            NOTIFICATION_ID,

            notification

        )

    }

    private fun startNotificationUpdater() {

        serviceScope.launch {

            while (isActive && !finished) {

                delay(1000)

                updateNotification()

            }

        }

    }

}
