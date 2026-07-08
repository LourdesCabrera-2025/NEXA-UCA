package sv.uca.nexauca.data.repositories.api

import com.google.firebase.Timestamp
import sv.uca.nexauca.presentation.core.state.ResultState
import sv.uca.nexauca.data.models.ActividadRecienteItem

interface ProductividadApiRepository {

    suspend fun getHorasPorTipo(uid: String): ResultState<List<Pair<String, Double>>>

    suspend fun getActividadesUsuario(uid: String): ResultState<List<Boolean>>

    suspend fun getTodasActividades(uid: String): ResultState<List<ActividadRecienteItem>>

    suspend fun getAsistenciasSemana(
        uid: String,
        inicioSemana: Timestamp,
        finSemana: Timestamp
    ): ResultState<List<Pair<Timestamp, Timestamp?>>>

    suspend fun getActividadReciente(
        uid: String,
        limite: Int
    ): ResultState<List<ActividadRecienteItem>>
}