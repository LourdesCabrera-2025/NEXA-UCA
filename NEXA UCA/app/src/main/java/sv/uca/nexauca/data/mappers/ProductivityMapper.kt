package sv.uca.nexauca.data.mappers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.ui.graphics.Color
import sv.uca.nexauca.data.models.ActividadRecienteItem
import sv.uca.nexauca.presentation.core.components.cards.EstadisticaCard
import sv.uca.nexauca.presentation.core.components.charts.DiaActividad
import sv.uca.nexauca.presentation.core.components.tables.ActividadReciente
import sv.uca.nexauca.presentation.core.components.tables.EstadoActividad
import java.text.SimpleDateFormat
import java.util.Locale
import sv.uca.nexauca.presentation.screens.productivity.ProductividadUiState

private val NOMBRES_DIAS = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábados", "Domingo")

fun ProductividadUiState.toEstadisticaCards(): List<EstadisticaCard> {
    val horasTexto = if (horasEstaSemana == horasEstaSemana.toInt().toDouble()) {
        "${horasEstaSemana.toInt()}h"
    } else {
        "%.1fh".format(horasEstaSemana)
    }
    return listOf(
        EstadisticaCard(
            icono = Icons.Filled.CheckCircle,
            colorIcono = Color(0xFF16A34A),
            fondoIcono = Color(0xFFDCFCE7),
            valor = aprobadas.toString(),
            etiqueta = "Aprobadas\nHoras completas"
        ),
        EstadisticaCard(
            icono = Icons.Filled.HourglassBottom,
            colorIcono = Color(0xFFD97706),
            fondoIcono = Color(0xFFFEF3C7),
            valor = pendientes.toString(),
            etiqueta = "Pendientes\nSolicitudes"
        ),
        EstadisticaCard(
            icono = Icons.Filled.CalendarMonth,
            colorIcono = Color(0xFF2563EB),
            fondoIcono = Color(0xFFDBEAFE),
            valor = horasTexto,
            etiqueta = "Esta semana\nRegistradas"
        )
    )
}

fun ProductividadUiState.toDiasActividad(): List<DiaActividad> {
    val maximo = actividadPorDia.maxOrNull()?.takeIf { it > 0 } ?: 1.0
    return actividadPorDia.mapIndexed { index, horas ->
        DiaActividad(
            nombre = NOMBRES_DIAS[index],
            valor = (horas / maximo).toFloat().coerceIn(0.05f, 1f)
        )
    }
}

fun List<ActividadRecienteItem>.toActividadReciente(): List<ActividadReciente> {
    val formatoFecha = SimpleDateFormat("d MMMM yyyy - HH:mm:ss", Locale("es", "ES"))

    return map { item ->
        val esInterno = item.projectType.contains("interno", ignoreCase = true)
        val (icono, colorIcono, fondoIcono) = if (esInterno) {
            Triple(Icons.Filled.MenuBook, Color(0xFF16A34A), Color(0xFFDCFCE7))
        } else {
            Triple(Icons.Filled.Groups, Color(0xFF2563EB), Color(0xFFDBEAFE))
        }

        val duracionTexto = if (item.checkOut != null) {
            val segundos = item.checkOut.seconds - item.checkIn.seconds
            val horas = segundos / 3600
            val minutos = (segundos % 3600) / 60
            "${horas}h ${minutos.toString().padStart(2, '0')}m"
        } else {
            "En curso"
        }

        ActividadReciente(
            icono = icono,
            colorIcono = colorIcono,
            fondoIcono = fondoIcono,
            titulo = item.title,
            fechaHora = formatoFecha.format(item.checkIn.toDate()),
            estado = if (item.approved) EstadoActividad.APROBADO else EstadoActividad.PENDIENTE,
            duracion = duracionTexto
        )
    }
}