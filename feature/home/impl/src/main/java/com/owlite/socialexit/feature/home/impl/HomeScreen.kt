package com.owlite.socialexit.feature.home.impl

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardVoice
import androidx.compose.material.icons.filled.Pinch
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusFull
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space2Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space4Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXs
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXxs

@Composable
fun HomeScreen(
    state: ArmState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceLg),
        verticalArrangement = Arrangement.spacedBy(Space2Xl)
    ) {
        item {
            StatusCard(
                status = stringResource(state.status) // TODO: remove hardcode
            )
        }
        if (state.buttonLabel != null) {
            item {
                // TODO: remove hardcode
                ArmButton(
                    label = stringResource(state.buttonLabel),
                    onClick = {}
                )
            }
        }
        item {
            SectionTriggerMethod()
        }
        item {
            SectionChooseScript()
        }
    }
}

enum class ArmState(
    @StringRes val status: Int,
    @StringRes val buttonLabel: Int? = null,
    @Suppress("unused") val isButtonEnabled: Boolean? = null,
) {
    IDLE(
        status = R.string.feature_home_impl_status_idle,
        buttonLabel = R.string.feature_home_impl_button_general,
        isButtonEnabled = true
    ),
    ARMED(
        status = R.string.feature_home_impl_status_armed,
        buttonLabel = R.string.feature_home_impl_button_error,
        isButtonEnabled = true
    ),
    CALLING(status = R.string.feature_home_impl_status_calling),
    COOLDOWN(
        status = R.string.feature_home_impl_status_cooldown,
        buttonLabel = R.string.feature_home_impl_button_general,
        isButtonEnabled = false
    ),
    ERROR(
        status = R.string.feature_home_impl_status_error,
        buttonLabel = R.string.feature_home_impl_button_error,
        isButtonEnabled = true
    ),
}

@Composable
fun StatusCard(
    modifier: Modifier = Modifier,
    status: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SocialExitTheme.colors.secondaryContainer,
                shape = RoundedCornerShape(RadiusMd)
            ),
    ) {
        Row(
            modifier = Modifier.padding(vertical = SpaceMd, horizontal = SpaceLg),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Status Icon",
                tint = SocialExitTheme.colors.primary,
            )
            Text(
                text = stringResource(R.string.feature_home_impl_status),
                style = SocialExitTheme.typography.labelOverline,
                color = SocialExitTheme.colors.onSecondaryContainer
            )
            Text(
                text = status,
                style = SocialExitTheme.typography.bodyMedium,
                color = SocialExitTheme.colors.onSecondaryContainer
            )
        }
    }
}

@Composable
fun ArmButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = SocialExitTheme.colors.primary
        ),
        shape = RoundedCornerShape(RadiusLg),
        onClick = onClick
    ) {
        Text(
            text = label,
            style = SocialExitTheme.typography.bodyMedium,
            color = SocialExitTheme.colors.onPrimary
        )
    }
}

/**
 * Trigger Method Section
 */
enum class TriggerMethodOption(
    @Suppress("unused") val icon: ImageVector,
    @Suppress("unused") val label: String
) {
    TRIPLE_TAP(icon = Icons.Default.TouchApp, label = "Triple Tap"),
    VOICE(icon = Icons.Default.KeyboardVoice, label = "Voice"),
    WATCH(icon = Icons.Default.Watch, label = "Watch"),
    PINCH(icon = Icons.Default.Pinch, label = "Pinch")
}

@Composable
fun SectionTriggerMethod() {
    // TODO: later take from VM
    var selectedMethod by rememberSaveable { mutableStateOf(TriggerMethodOption.TRIPLE_TAP) }

    Column {
        Text(
            text = stringResource(R.string.feature_home_impl_trigger_method)
        )
        Spacer(modifier = Modifier.height(SpaceLg))
        TriggerMethodSelectionGroup(
            selectedMethod = selectedMethod,
            onMethodSelected = { selectedMethod = it }
        )
    }
}

@Composable
fun TriggerMethodSelectionGroup(
    selectedMethod: TriggerMethodOption,
    onMethodSelected: (TriggerMethodOption) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .selectableGroup(),
        horizontalArrangement = Arrangement.spacedBy(
            space = SpaceMd,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        TriggerMethodOption.entries.forEach { method ->
            TriggerMethodRadioButton(
                isSelected = (method == selectedMethod),
                onClick = { onMethodSelected(method) },
                option = method,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
fun TriggerMethodRadioButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    option: TriggerMethodOption,
    modifier: Modifier = Modifier
) {
    val borderWidth = if (isSelected) SpaceXxs else 1.dp
    val color =
        if (isSelected) SocialExitTheme.colors.primary
        else SocialExitTheme.colors.secondary

    Column(
        modifier = modifier
            .border(
                width = borderWidth,
                color = color,
                shape = RoundedCornerShape(SpaceMd)
            )
            .padding(SpaceMd)
            .selectable(
                selected = isSelected,
                role = Role.RadioButton,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = option.icon,
            tint = color,
            contentDescription = option.label
        )
        Spacer(modifier = Modifier.height(SpaceSm))
        Text(
            text = option.label,
            style = SocialExitTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            color = color
        )
    }
}

/**
 * Choose Script Section
 */
data class ScriptOption(
    @DrawableRes val icon: Int,
    val title: String,
    val desc: String,
    val category: String,
    val successRate: Float,
    val isActive: Boolean,
)

// TODO: move to data
val dummyScript = listOf(
    ScriptOption(
        icon = R.drawable.feature_home_impl_ic_android_black_24dp,
        title = "Dummy Title",
        desc = "Dummy desc",
        category = "Home",
        successRate = 87f,
        isActive = true
    ),
    ScriptOption(
        icon = R.drawable.feature_home_impl_ic_android_black_24dp,
        title = "Dummy Title 2",
        desc = "Dummy desc 2",
        category = "Family",
        successRate = 90f,
        isActive = false
    ),
    ScriptOption(
        icon = R.drawable.feature_home_impl_ic_android_black_24dp,
        title = "Dummy Title 3",
        desc = "Dummy desc 3",
        category = "Home",
        successRate = 98f,
        isActive = false
    ),
    ScriptOption(
        icon = R.drawable.feature_home_impl_ic_android_black_24dp,
        title = "Dummy Title 4",
        desc = "Dummy desc 4",
        category = "Family",
        successRate = 90f,
        isActive = false
    )
)

@Composable
fun SectionChooseScript() {
    // TODO: later take from VM
    var selectedScript by remember { mutableStateOf(dummyScript.first()) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.feature_home_impl_choose_script)
            )
            Text(
                modifier = Modifier
                    .clickable(
                        role = Role.Button,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { /* TODO: navigate to script tab */ }
                    ),
                text = stringResource(R.string.feature_home_impl_manage_all),
                style = SocialExitTheme.typography.labelMedium,
                color = SocialExitTheme.colors.primary
            )
        }

        Spacer(modifier = Modifier.height(SpaceLg))
        ChooseScriptSelectionGroup(
            selectedScript = selectedScript,
            onScriptSelected = { selectedScript = it }
        )
    }
}

@Composable
fun ChooseScriptSelectionGroup(
    selectedScript: ScriptOption,
    onScriptSelected: (ScriptOption) -> Unit
) {
    Column(
        modifier = Modifier.selectableGroup(),
        verticalArrangement = Arrangement.spacedBy(space = SpaceMd)
    ) {
        dummyScript.forEach { script ->
            ChooseScriptRadioButton(
                isSelected = (script == selectedScript),
                onClick = { onScriptSelected(script) },
                option = script,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
            )
        }
    }
}

@Composable
fun ChooseScriptRadioButton(
    isSelected: Boolean, // TODO: make sure not used
    onClick: () -> Unit,
    option: ScriptOption,
    modifier: Modifier = Modifier
) {
    val borderWidth = if (isSelected) SpaceXxs else 1.dp
    val color =
        if (isSelected) SocialExitTheme.colors.primary
        else SocialExitTheme.colors.secondary

    ConstraintLayout(
        modifier = modifier
            .border(
                width = borderWidth,
                color = color,
                shape = RoundedCornerShape(SpaceMd)
            )
            .height(108.dp)
            .padding(SpaceMd)
            .selectable(
                selected = isSelected,
                role = Role.RadioButton,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
    ) {
        val (icon, titleStatus, desc, category, successRate) = createRefs()

        Box(
            modifier = Modifier
                .size(Space4Xl)
                .background(
                    color = SocialExitTheme.colors.onBackground,
                    shape = RoundedCornerShape(SpaceMd)
                )
                .constrainAs(icon) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(SpaceXl),
                painter = painterResource(option.icon),
                tint = color,
                contentDescription = option.title
            )
        }

        Row(
            modifier = Modifier
                .constrainAs(titleStatus) {
                    top.linkTo(parent.top)
                    start.linkTo(icon.end, margin = SpaceLg)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = option.title,
                style = SocialExitTheme.typography.bodyLarge
            )
            if (isSelected) {
                Text(
                    modifier = Modifier
                        .background(
                            color = SocialExitTheme.colors.primary,
                            shape = RoundedCornerShape(RadiusFull)
                        )
                        .padding(horizontal = SpaceSm, vertical = SpaceXxs),
                    text = stringResource(R.string.feature_home_impl_active),
                    style = SocialExitTheme.typography.labelOverline,
                    color = SocialExitTheme.colors.onPrimary
                )
            }
        }

        Text(
            modifier = Modifier.constrainAs(desc) {
                top.linkTo(titleStatus.bottom, margin = SpaceXs)
                start.linkTo(titleStatus.start)
                width = Dimension.fillToConstraints
            },
            text = option.desc,
            style = SocialExitTheme.typography.bodyMedium,
            color = SocialExitTheme.colors.onPrimaryContainer
        )

        Row(
            modifier = Modifier.constrainAs(category) {
                linkTo(top = desc.bottom, bottom = parent.bottom, bias = 1f)
                start.linkTo(titleStatus.start)
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = option.category,
                style = SocialExitTheme.typography.bodySmall,
                color = SocialExitTheme.colors.onSurfaceVariant
            )
            Spacer(modifier = Modifier.width(SpaceSm))
            Box(
                modifier = Modifier
                    .size(SpaceXs)
                    .background(
                        color = SocialExitTheme.colors.onSurfaceVariant,
                        shape = CircleShape
                    )
            )
        }

        Text(
            modifier = Modifier.constrainAs(successRate) {
                bottom.linkTo(category.bottom)
                start.linkTo(category.end, margin = SpaceSm)
            },
            text = "${option.successRate}%",
            style = SocialExitTheme.typography.bodySmall,
            color = SocialExitTheme.colors.primary
        )
    }
}

/**
 * Previews
 */
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun HomeScreenDarkPreview() {
    SocialExitTheme {
        HomeScreen(state = ArmState.IDLE)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun HomeScreenLightPreview() {
    SocialExitTheme {
        HomeScreen(state = ArmState.IDLE)
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun HomeScreenNoButtonDarkPreview() {
    SocialExitTheme {
        HomeScreen(state = ArmState.CALLING)
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun HomeScreenNoButtonLightPreview() {
    SocialExitTheme {
        HomeScreen(state = ArmState.CALLING)
    }
}
