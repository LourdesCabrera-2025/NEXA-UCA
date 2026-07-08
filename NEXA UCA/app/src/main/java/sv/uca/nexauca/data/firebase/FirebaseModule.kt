package sv.uca.nexauca.data.firebase

import android.content.Context
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import sv.uca.nexauca.data.services.location.LocationApiService
import sv.uca.nexauca.data.database.AppDatabase
import sv.uca.nexauca.data.repositories.api.ActivityApiRepository
import sv.uca.nexauca.data.repositories.api.AttendanceApiRepository
import sv.uca.nexauca.data.repositories.api.ParticipantRepository
import sv.uca.nexauca.data.repositories.api.ProjectScheduleRepository
import sv.uca.nexauca.data.repositories.api.StudentApiRepository
import sv.uca.nexauca.data.repositories.impl.ActivityRepositoryImpl
import sv.uca.nexauca.data.repositories.impl.AttendanceRepositoryImpl
import sv.uca.nexauca.data.repositories.impl.ParticipantRepositoryImpl
import sv.uca.nexauca.data.repositories.impl.ProjectScheduleRepositoryImpl
import sv.uca.nexauca.data.repositories.impl.StudentRepositoryImpl
import sv.uca.nexauca.data.services.attendance.AttendanceService
import sv.uca.nexauca.data.services.gps.GpsService
import sv.uca.nexauca.data.services.validation.ValidationService

object FirebaseModule {

    private lateinit var appContext: Context

    private lateinit var database: AppDatabase

    fun init(context: Context) {

        appContext = context.applicationContext

        database = Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "nexa_database"
        ).build()

    }

    // -----------------------------
    // Services
    // -----------------------------

    val gpsService: GpsService by lazy {

        GpsService(appContext)

    }

    val validationService: ValidationService by lazy {

        ValidationService(

            studentRepository = studentRepository,

            participantRepository = participantRepository,

            scheduleRepository = scheduleRepository

        )

    }

    val attendanceService: AttendanceService by lazy {

        AttendanceService(

            validationService = validationService,

            gpsService = gpsService,

            attendanceRepository = attendanceRepository

        )

    }

    // -----------------------------
    // Repositories
    // -----------------------------

    val studentRepository: StudentApiRepository by lazy {

        StudentRepositoryImpl()

    }

    val attendanceRepository: AttendanceApiRepository by lazy {

        AttendanceRepositoryImpl(

            AttendanceProvider(),

            database.attendanceDao()

        )

    }

    val activityRepository: ActivityApiRepository by lazy {

        ActivityRepositoryImpl(

            ActivityProvider(),

            database.activityDao()

        )

    }

    val participantRepository: ParticipantRepository by lazy {

        ParticipantRepositoryImpl(

            ParticipantProvider()

        )

    }

    val scheduleRepository: ProjectScheduleRepository by lazy {

        ProjectScheduleRepositoryImpl(

            ProjectScheduleProvider()

        )

    }

    val httpClient by lazy {

        HttpClient(OkHttp) {

            install(ContentNegotiation) {

                json()

            }

        }

    }

    val locationApiService by lazy {

        LocationApiService(httpClient)

    }


}



