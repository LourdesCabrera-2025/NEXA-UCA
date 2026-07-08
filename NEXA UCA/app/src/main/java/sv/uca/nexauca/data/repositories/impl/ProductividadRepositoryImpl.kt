package sv.uca.nexauca.data.repositories.impl

import sv.uca.nexauca.dataconnect.instance

import com.google.firebase.Timestamp
import sv.uca.nexauca.data.repositories.api.ProductividadApiRepository
import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.presentation.core.state.ResultState
import sv.uca.nexauca.data.models.ActividadRecienteItem


class ProductividadRepositoryImpl : ProductividadApiRepository {

    private val connector = NexaConnector.instance

    override suspend fun getHorasPorTipo(uid: String): ResultState<List<Pair<String, Double>>> {
        return try {
            val result = connector.getHorasPorTipo.execute(uid = uid)
            val horas = result.data.participants.map { p ->
                p.project.projectType.name to p.accumulateHours
            }
            ResultState.Success(horas)
        } catch (e: Exception) {
            ResultState.Error(e.message ?: "No se lograron cargar las horas")
        }
    }

    override suspend fun getActividadesUsuario(uid: String): ResultState<List<Boolean>> {
        return try {
            val result = connector.getActividadesUsuario.execute(uid = uid)
            val estados = result.data.activities.map { it.approved }
            ResultState.Success(estados)
        } catch (e: Exception) {
            ResultState.Error(e.message ?: "No se lograron cargar las actividades")
        }
    }

    override suspend fun getAsistenciasSemana(
        uid: String,
        inicioSemana: Timestamp,
        finSemana: Timestamp
    ): ResultState<List<Pair<Timestamp, Timestamp?>>> {
        return try {
            val result = connector.getAsistenciasSemana.execute(
                uid = uid,
                inicioSemana = inicioSemana,
                finSemana = finSemana
            )
            val asistencias = result.data.attendances.map { it.checkIn to it.checkOut }
            ResultState.Success(asistencias)
        } catch (e: Exception) {
            ResultState.Error(e.message ?: "No se lograron cargar las asistencias")
        }
    }

    override suspend fun getActividadReciente(
        uid: String,
        limite: Int
    ): ResultState<List<ActividadRecienteItem>> {
        return try {
            val result = connector.getActividadReciente.execute(uid = uid, limite = limite)
            val items = result.data.activities.map { a ->
                ActividadRecienteItem(
                    id = a.id,
                    title = a.title,
                    approved = a.approved,
                    checkIn = a.attendance.checkIn,
                    checkOut = a.attendance.checkOut,
                    projectName = a.attendance.participant.project.name,
                    projectType = a.attendance.participant.project.projectType.name
                )
            }
            ResultState.Success(items)
        } catch (e: Exception) {
            ResultState.Error(e.message ?: "No se logro cargar la actividad reciente")
        }
    }


override suspend fun getTodasActividades(uid: String): ResultState<List<ActividadRecienteItem>> {
    return try {
        val result = connector.getTodasActividades.execute(uid = uid)
        val items = result.data.activities.map { a ->
            ActividadRecienteItem(
                id = a.id,
                title = a.title,
                approved = a.approved,
                checkIn = a.attendance.checkIn,
                checkOut = a.attendance.checkOut,
                projectName = a.attendance.participant.project.name,
                projectType = a.attendance.participant.project.projectType.name
            )
        }
        ResultState.Success(items)
    } catch (e: Exception) {
        ResultState.Error(e.message ?: "No se logro cargar el historial")
    }
}
}

