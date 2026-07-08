package sv.uca.nexauca.presentation.screens.attendance

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import sv.uca.nexauca.presentation.screens.attendance.AttendanceViewModel
import sv.uca.nexauca.presentation.core.theme.Inter
import sv.uca.nexauca.presentation.core.theme.Space_Grotesk

@Composable
fun AttendanceScreen(

    viewModel: AttendanceViewModel = viewModel(),

    onFinish: () -> Unit

) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.startAttendance()

    }

    Scaffold(

        containerColor = Color(0xFFFAFBFB)

    ) { padding ->

        Column(

            modifier = Modifier

                .fillMaxSize()

                .padding(padding)

                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(

                text = "NEXA UCA",

                style = MaterialTheme.typography.headlineMedium,

                fontFamily = Space_Grotesk,

                fontWeight = FontWeight.Bold,

                color = Color(0xFF022873)

            )

            Spacer(modifier = Modifier.height(36.dp))

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(24.dp),

                elevation = CardDefaults.cardElevation(6.dp)

            ) {

                Column(

                    modifier = Modifier.padding(24.dp),

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Icon(

                        Icons.Default.Timer,

                        contentDescription = null,

                        modifier = Modifier.size(70.dp),

                        tint = Color(0xFF022873)

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(

                        text = state.elapsedTime,

                        style = MaterialTheme.typography.displaySmall,

                        fontFamily = Space_Grotesk,

                        fontWeight = FontWeight.Bold

                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(

                        text = "Tiempo transcurrido",

                        fontFamily = Inter

                    )

                }

            }

            Spacer(modifier = Modifier.height(24.dp))

        }
    }
}

