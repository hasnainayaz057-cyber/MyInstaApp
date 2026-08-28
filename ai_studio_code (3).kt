package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.model.InstagramAccount
import com.example.data.model.UserProfile
import com.example.ui.screens.InstaGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSwitcherBottomSheet(
    currentProfile: UserProfile,
    savedAccounts: List<InstagramAccount>,
    onSelectAccount: (username: String) -> Unit,
    onAddNewAccount: () -> Unit,
    onLogout: () -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .padding(bottom = 28.dp)
        ) {
            Text(
                text = "Switch Instagram Accounts",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 14.dp)
            )

            savedAccounts.forEach { account ->
                val isCurrent = account.username.equals(currentProfile.instagramHandle, ignoreCase = true)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .clickable { onSelectAccount(account.username) }
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(if (isCurrent) InstaGradient else SolidColor(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)))
                                .padding(2.dp)
                        ) {
                            Image(
                                painter = painterResource(id = account.avatarRes ?: R.drawable.img_creator_avatar),
                                contentDescription = account.displayName,
                                modifier = Modifier.fillMaxSize().clip(CircleShape)
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column {
                            Text(text = "@${account.username}", fontWeight = FontWeight.Bold)
                            Text(text = account.displayName, style = MaterialTheme.typography.bodySmall)
                        }
                    }

                    Icon(
                        imageVector = if (isCurrent) Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked,
                        contentDescription = null,
                        tint = if (isCurrent) Color(0xFF0095F6) else Color.Gray
                    )
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // Add Account
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onAddNewAccount() }
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
                Text("Add Instagram Account", fontWeight = FontWeight.SemiBold)
            }

            // Log Out
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLogout() }
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.ExitToApp, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                Spacer(modifier = Modifier.width(12.dp))
                Text("Log Out", color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}