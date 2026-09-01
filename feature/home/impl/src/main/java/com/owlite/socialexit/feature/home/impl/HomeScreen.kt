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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
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
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space2Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space4Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
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
    val successRate: Int,
    val isActive: Boolean,
)

// TODO: move to data
val dummyScript = listOf(
    ScriptOption(
        icon = com.google.android.material.R.drawable.abc_ic_star_black_16dp,
        title = "Dummy Title",
        desc = "Dummy desc",
        category = "Home",
        successRate = 87,
        isActive = true
    )
)

@Composable
fun SectionChooseScript() {
    // TODO: later take from VM
    var selectedScript by rememberSaveable { mutableStateOf(dummyScript.first()) }

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
        modifier = Modifier
            .fillMaxWidth()
            .height(108.dp)
            .selectableGroup(),
        verticalArrangement = Arrangement.spacedBy(space = SpaceMd)
    ) {
        dummyScript.forEach { script ->
            ChooseScriptRadioButton(
                isSelected = (script == selectedScript),
                onClick = { onScriptSelected(script) },
                option = script,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun ChooseScriptRadioButton(
    isSelected: Boolean,
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
            .padding(SpaceMd)
            .selectable(
                selected = isSelected,
                role = Role.RadioButton,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
    ) {
        val (icon, title, desc, category, successRate, activeStatus) = createRefs()

        Box(
            modifier = Modifier
                .size(Space4Xl)
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
    }

//    Column(
//        modifier = modifier
//            .border(
//                width = borderWidth,
//                color = color,
//                shape = RoundedCornerShape(SpaceMd)
//            )
//            .padding(SpaceMd)
//            .selectable(
//                selected = isSelected,
//                role = Role.RadioButton,
//                onClick = onClick,
//                interactionSource = remember { MutableInteractionSource() },
//                indication = null
//            ),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Icon(
//            painter = painterResource(option.icon),
//            tint = color,
//            contentDescription = option.title
//        )
//        Spacer(modifier = Modifier.height(SpaceSm))
//        Text(
//            text = option.title,
//            style = SocialExitTheme.typography.labelMedium,
//            textAlign = TextAlign.Center,
//            color = color
//        )
//    }
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

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun HomeScreenNoButtonDarkPreview() {
    SocialExitTheme {
        HomeScreen(state = ArmState.CALLING)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun HomeScreenNoButtonLightPreview() {
    SocialExitTheme {
        HomeScreen(state = ArmState.CALLING)
    }
}
