package sv.uca.nexauca.presentation.screens.settings

import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.sharp.ExitToApp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import sv.uca.nexauca.presentation.core.components.cards.ApplicationItem
import sv.uca.nexauca.presentation.core.components.cards.SettingsItem
import sv.uca.nexauca.presentation.core.components.cards.ThemeSystem
import sv.uca.nexauca.presentation.core.events.UIEvent
import sv.uca.nexauca.presentation.core.theme.Inter
import sv.uca.nexauca.presentation.core.theme.Space_Grotesk
import sv.uca.nexauca.presentation.core.utils.getInitials

@Composable
fun Settings(
    viewModel: SettingsViewModel = viewModel(),
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    var showLogoutDialog by remember { mutableStateOf(false) }
    val student = uiState.student

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            if (event is UIEvent.NavigateToLogin) {
                onNavigateToLogin()
            }
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFFAFBFB)
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onNavigateToHome
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBackIosNew,
                            contentDescription = "Back",
                            modifier = Modifier.size(26.dp),
                            tint = Color(0xFF022873)
                        )
                    }
                    Text(
                        text = "NEXA UCA",
                        fontSize = 32.sp,
                        fontFamily = Space_Grotesk,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF022873)
                    )
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "notification",
                        modifier = Modifier.size(26.dp),
                        tint = Color(0xFF022873)
                    )
                }
                Spacer(modifier = Modifier.height(26.dp))

                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(
                            text = "Configuración",
                            fontSize = 17.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Gestiona tu cuenta y preferencias",
                            fontSize = 14.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Light,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFAFBFB)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(10.dp)

                        ) {
                            student?.let { dataStudentsItem ->
                                Row(
                                    modifier = Modifier
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(75.dp)
                                            .clip(RoundedCornerShape(16.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        val initials = remember(dataStudentsItem.user.fullName) {
                                            getInitials(dataStudentsItem.user.fullName)
                                        }
                                        if (!dataStudentsItem.user.photoUrl.isNullOrBlank()) {
                                            AsyncImage(
                                                model = dataStudentsItem.user.photoUrl,
                                                contentDescription = "perfil",
                                                modifier = Modifier
                                                    .width(95.dp)
                                                    .height(100.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                contentScale = ContentScale.Crop
                                            )
                                        } else {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(Color(0xFF6750A4)),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = initials,
                                                    color = Color.White,
                                                    fontSize = 22.sp,
                                                    fontFamily = Inter,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 20.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.Start
                                    ) {
                                        Text(
                                            text = "${dataStudentsItem.user.fullName}",
                                            fontSize = 12.sp,
                                            fontFamily = Inter,
                                            fontWeight = FontWeight.Medium,
                                            color = Color.Black
                                        )

                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = "${dataStudentsItem.user.email}",
                                            fontWeight = FontWeight.Normal,
                                            fontFamily = Inter,
                                            fontSize = 12.sp,
                                            color = Color.DarkGray
                                        )

                                        Spacer(modifier = Modifier.height(4.dp))

                                        AssistChip(
                                            modifier = Modifier
                                                .width(90.dp)
                                                .height(32.dp)
                                                .align(Alignment.Start),
                                            onClick = {},

                                            colors = AssistChipDefaults.assistChipColors(
                                                containerColor = Color(0xFFdbeafe)
                                            ),
                                            border = null,
                                            shape = RoundedCornerShape(5.dp),
                                            label = {
                                                Text(
                                                    text = "${dataStudentsItem.user.role.name}",
                                                    fontSize = 10.sp,
                                                    fontFamily = Inter,
                                                    fontWeight = FontWeight.Medium,
                                                    color = Color(0xFF3A4BFC)
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Cuenta",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = Inter,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFAFBFB)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column {
                                SettingsItem(
                                    title = "Editar perfil",
                                    subtitle = "Actualiza tu información personal",
                                    icon = Icons.Rounded.Person,
                                    onClick = {
                                    }
                                )
                                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                                SettingsItem(
                                    title = "Seguridad",
                                    subtitle = "Opciones de seguridad de tu cuenta",
                                    icon = Icons.Rounded.Security,
                                    onClick = {

                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Aplicación",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = Inter,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFAFBFB)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {

                            ApplicationItem(
                                title = "Notificaciones",
                                subtitle = "Gestiona tus notificaciones",
                                icon = Icons.Rounded.Notifications,
                                checked = uiState.isNotificationsEnabled,
                                onCheckedChange = { viewModel.toggleNotification(it) }
                            )
                            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

                            ApplicationItem(
                                title = "Ubicación",
                                subtitle = "Permitir acceso a tu ubicación",
                                icon = Icons.Rounded.LocationOn,
                                checked = uiState.isLocationEnabled,
                                onCheckedChange = { viewModel.toggleLocation(it) }
                            )
                            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

                            ThemeSystem(
                                title = "Tema de la aplicación",
                                subtitle = "Selecciona el tema de la app",
                                icon = Icons.Rounded.DarkMode
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Soporte",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = Inter,
                            color = Color.DarkGray
                        )

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFAFBFB)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            ThemeSystem(
                                title = "Versión de NEXA UCA",
                                subtitle = "Versión 1.0.0",
                                icon = Icons.Rounded.Info
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .animateContentSize()
                                .align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFCECEE),
                                contentColor = Color(0xFFDB2C32)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {showLogoutDialog = true}
                        ) {

                            if(isLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    color = Color(0xFFDB2C32),
                                    strokeWidth = 2.dp
                                )

                            } else {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Rounded.ExitToApp,
                                    contentDescription = null,
                                    modifier =  Modifier.size(24.dp)
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(
                                    text = "Cerrar Sesión",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = Inter,
                                    color = Color.DarkGray
                                )
                            }

                        }
                        if (showLogoutDialog) {
                            AlertDialog(
                                onDismissRequest = { showLogoutDialog = false },
                                title = { Text(text = "Cerrar sesión") },
                                text = { Text(text = "¿Estás seguro de que deseas cerrar tu sesión?") },
                                confirmButton = {
                                    TextButton(onClick = {
                                        showLogoutDialog = false
                                        viewModel.onLogout()
                                    }) {
                                        Text("Confirmar", color = Color.Red)
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { showLogoutDialog = false }) {
                                        Text("Cancelar")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}