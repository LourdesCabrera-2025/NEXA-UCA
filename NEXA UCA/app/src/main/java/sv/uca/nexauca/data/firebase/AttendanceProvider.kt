package sv.uca.nexauca.data.firebase

import com.google.firebase.Timestamp
import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.dataconnect.instance
import java.util.UUID

class AttendanceProvider(

    private val connector: NexaConnector = NexaConnector.instance

) {

    suspend fun createAttendance(
        participantId: UUID,
        checkIn: Timestamp,
        latitude: Double,
        longitude: Double,
        status: String
    ) =
        connector.createAttendance.execute(
            participantId = participantId,
            checkIn = checkIn,
            latitude = latitude,
            longitude = longitude,
            status = status
        )

    suspend fun getActiveAttendance(
        participantId: UUID
    ) =
        connector.getActiveAttendance.execute(
            participantId = participantId
        )

    suspend fun updateAttendanceStatus(
        id: UUID,
        status: String
    ) =
        connector.updateAttendanceStatus.execute(
            id = id,
            status = status
        )

    suspend fun updateAttendanceCheckOut(
        id: UUID,
        checkOut: Timestamp
    ) =
        connector.updateAttendanceCheckOut.execute(
            id = id,
            checkOut = checkOut
        )

}