package com.owlite.socialexit.feature.settings.impl

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space2Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space3Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXs
import com.owlite.socialexit.core.model.data.SettingItem
import com.owlite.socialexit.core.model.data.SettingsGroup

@Composable
fun SettingsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceLg),
        verticalArrangement = Arrangement.spacedBy(Space2Xl)
    ) {
        items(items = settingsData, key = { item -> item.id }) { settingGroup ->
            SettingsGroupHeader(
                title = settingGroup.groupName
            )
            SettingsGroupCard {
                settingGroup.settingItem.forEachIndexed { index, item ->
                    when (item) {
                        is SettingItem.NavigationSetting -> {
                            NavigationSettingRow(
                                item = item,
                                onClick = { TODO() },
                            )
                        }

                        is SettingItem.ToggleSetting -> {
                            ToggleSettingRow(
                                item = item,
                                onClick = { TODO() },
                            )
                        }
                    }

                    if (index < settingGroup.settingItem.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = SpaceLg),
                            thickness = 1.dp,
                            color = SocialExitTheme.colors.outlineVariant
                        )
                    }
                }
            }
        }
    }
}

// TODO: later move to db module
val settingsData = listOf(
    SettingsGroup(
        id = "caller_identity",
        groupName = "CALLER IDENTITY",
        settingItem = listOf(
            SettingItem.NavigationSetting(
                id = "primary_caller",
                title = "Primary caller",
                icon = R.drawable.account_circle_24,
                detail = "Marcus Chen"
            ),
            SettingItem.NavigationSetting(
                id = "manage_callers",
                title = "Manage callers",
                icon = R.drawable.group_24,
                detail = "3 contacts saved"
            ),
            SettingItem.NavigationSetting(
                id = "contact_access",
                title = "Contact access",
                icon = R.drawable.contact_page_24,
            ),
        )
    ),
    SettingsGroup(
        id = "ai_voice_scripts",
        groupName = "AI VOICE & SCRIPTS",
        settingItem = listOf(
            SettingItem.ToggleSetting(
                id = "gemini_live_voice",
                title = "Gemini live voice",
                isEnabled = true,
                icon = R.drawable.mic_24,
                detail = "AI speaks during call"
            ),
            SettingItem.ToggleSetting(
                id = "context_aware_scripts",
                title = "Context-aware scripts",
                isEnabled = true,
                icon = R.drawable.map_24,
                detail = "Adapts to location"
            ),
            SettingItem.ToggleSetting(
                id = "ambient_audio",
                title = "Ambient audio",
                isEnabled = false,
                icon = R.drawable.graphic_eq_24,
                detail = "Street noise, office hum"
            ),
        )
    ),
    SettingsGroup(
        id = "privacy_stealth",
        groupName = "PRIVACY & STEALTH",
        settingItem = listOf(
            SettingItem.ToggleSetting(
                id = "stealth_mode",
                title = "Stealth mode",
                isEnabled = true,
                icon = R.drawable.visibility_off_24,
                detail = "No app UI during call"
            ),
            SettingItem.ToggleSetting(
                id = "auto_delete_logs",
                title = "Auto-delete logs",
                isEnabled = true,
                icon = R.drawable.auto_delete_24,
                detail = "After 24 hours"
            ),
        )
    ),
)

/**
 * Setting Group
 */
@Composable
fun SettingsGroupHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(bottom = SpaceSm),
        text = title,
        style = SocialExitTheme.typography.labelLarge,
        color = SocialExitTheme.colors.onPrimaryContainer
    )
}

@Composable
fun SettingsGroupCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(SpaceMd),
        colors = CardDefaults.cardColors(
            containerColor = SocialExitTheme.colors.surfaceContainer
        ),
    ) {
        Column {
            content()
        }
    }
}

@Composable
fun NavigationSettingRow(
    item: SettingItem.NavigationSetting,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(SpaceLg)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(SpaceLg)
    ) {
        Box(
            modifier = Modifier
                .size(Space3Xl)
                .background(
                    color = SocialExitTheme.colors.surfaceBright,
                    shape = RoundedCornerShape(SpaceMd)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(SpaceXl),
                painter = painterResource(item.icon),
                tint = SocialExitTheme.colors.primary,
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                SpaceXs,
                Alignment.CenterVertically
            )
        ) {
            Text(
                text = item.title,
                style = SocialExitTheme.typography.labelLarge,
                color = SocialExitTheme.colors.onSecondaryContainer
            )
            if (item.detail?.isNotEmpty() == true) {
                Text(
                    text = item.detail.orEmpty(),
                    style = SocialExitTheme.typography.bodyMedium,
                    color = SocialExitTheme.colors.onPrimaryContainer
                )
            }
        }
        Icon(
            modifier = Modifier.size(SpaceMd),
            painter = painterResource(R.drawable.chevron_right_24),
            tint = SocialExitTheme.colors.onSecondaryContainer,
            contentDescription = null
        )
    }
}

@Composable
fun ToggleSettingRow(
    item: SettingItem.ToggleSetting,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checked by remember { mutableStateOf(true) }

    Row(
        modifier = modifier
            .padding(SpaceLg)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(SpaceLg)
    ) {
        Box(
            modifier = Modifier
                .size(Space3Xl)
                .background(
                    color = SocialExitTheme.colors.surfaceBright,
                    shape = RoundedCornerShape(SpaceMd)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(SpaceXl),
                painter = painterResource(item.icon),
                tint = SocialExitTheme.colors.primary,
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(SpaceXs, Alignment.CenterVertically)
        ) {
            Text(
                text = item.title,
                style = SocialExitTheme.typography.labelLarge,
                color = SocialExitTheme.colors.onSecondaryContainer
            )
            if (item.detail?.isNotEmpty() == true) {
                Text(
                    text = item.detail.orEmpty(),
                    style = SocialExitTheme.typography.bodyMedium,
                    color = SocialExitTheme.colors.onPrimaryContainer
                )
            }
        }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun SettingsScreenDarkPreview() {
    SocialExitTheme {
        SettingsScreen()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SettingsScreenLightPreview() {
    SocialExitTheme {
        SettingsScreen()
    }
}
