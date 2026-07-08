package sv.uca.nexauca.presentation.screens.attendance

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import sv.uca.nexauca.presentation.attendance.viewmodel.ValidationViewModel
import sv.uca.nexauca.presentation.core.theme.Space_Grotesk


@Composable
fun WaitValidationScreen(

    viewModel: ValidationViewModel = viewModel(),

    onValidationSuccess: () -> Unit

) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.startValidation()

    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center

        ) {

            Text(

                text = "NEXA UCA",
                fontSize = 32.sp,
                fontFamily = Space_Grotesk,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0B3C8A)

            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(

                text = "Validando requisitos",
                fontWeight = FontWeight.Medium

            )

            Spacer(modifier = Modifier.height(30.dp))

            CircularProgressIndicator()

            Spacer(modifier = Modifier.height(30.dp))

            ValidationCard(

                "Validando estudiante",

                Icons.Default.Person,

                state.studentValidated

            )

            ValidationCard(

                "Validando proyecto",

                Icons.Default.Work,

                state.projectValidated

            )

            ValidationCard(

                "Validando horario",

                Icons.Default.Schedule,

                state.scheduleValidated

            )

            ValidationCard(

                "Validando ubicación",

                Icons.Default.LocationOn,

                state.locationValidated

            )

            AnimatedVisibility(

                visible = state.finished

            ) {

                Column(

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )

                    Icon(

                        Icons.Default.CheckCircle,

                        contentDescription = null,

                        tint = Color(0xFF2E7D32),

                        modifier = Modifier.size(64.dp)

                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(

                        text = "¡Acceso Confirmado!",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32),
                        style = MaterialTheme.typography.titleLarge

                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(

                        text = "Iniciando jornada..."

                    )

                }

            }

        }

    }

}

@Composable
private fun ValidationCard(

    title: String,

    icon: ImageVector,

    completed: Boolean

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        shape = RoundedCornerShape(18.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Icon(

                imageVector = icon,

                contentDescription = null,

                tint = if (completed)
                    Color(0xFF2E7D32)
                else
                    Color(0xFF0B3C8A)

            )

            Spacer(
                modifier = Modifier.size(16.dp)
            )

            Column(

                modifier = Modifier.weight(1f)

            ) {

                Text(

                    text = title,

                    fontWeight = FontWeight.Bold

                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(

                    text =
                        if (completed)
                            "Completado"
                        else
                            "Validando..."

                )

            }

            if (completed) {

                Icon(

                    imageVector = Icons.Default.CheckCircle,

                    contentDescription = null,

                    tint = Color(0xFF2E7D32)

                )

            } else {

                CircularProgressIndicator(

                    modifier = Modifier.size(22.dp),

                    strokeWidth = 2.dp

                )

            }

        }

    }

}