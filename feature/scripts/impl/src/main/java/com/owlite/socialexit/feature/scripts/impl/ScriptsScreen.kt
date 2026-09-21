package com.owlite.socialexit.feature.scripts.impl

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusFull
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space2Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
import com.owlite.socialexit.core.model.data.ScriptOption
import com.owlite.socialexit.core.ui.ChooseScriptRadioButton

@Composable
fun ScriptsScreen() {
    // TODO: later take from VM
    var selectedScript by remember { mutableStateOf(dummyScript.first()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceLg),
        verticalArrangement = Arrangement.spacedBy(Space2Xl)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SpaceSm),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SpaceSm)
        ) {
            Row(
                modifier = Modifier.height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SpaceSm)
            ) {
                Text(
                    modifier = Modifier
                        .background(
                            color = SocialExitTheme.colors.primary,
                            shape = RoundedCornerShape(RadiusFull)
                        )
                        .padding(vertical = SpaceSm, horizontal = SpaceXl),
                    text = stringResource(R.string.feature_scripts_impl_all),
                    style = SocialExitTheme.typography.labelOverline,
                    color = SocialExitTheme.colors.onPrimary
                )
                VerticalDivider(
                    modifier = Modifier.fillMaxHeight(),
                    thickness = 1.dp,
                    color = SocialExitTheme.colors.onSurface
                )
            }
            LazyRow(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(SpaceSm)
            ) {
                items(10) {
                    ScriptCategoryChip("Cat 1")
                }
            }
        }
        LazyColumn {
            item {
                ChooseScriptSelectionGroup(
                    selectedScript = selectedScript,
                    onScriptSelected = { selectedScript = it }
                )
            }
        }
    }
}

/**
 * Category
 */
@Composable
fun ScriptCategoryChip(category: String) {
    Text(
        modifier = Modifier
            .background(
                color = SocialExitTheme.colors.secondary,
                shape = RoundedCornerShape(RadiusFull)
            )
            .padding(vertical = SpaceSm, horizontal = SpaceXl),
        text = category,
        style = SocialExitTheme.typography.labelOverline,
        color = SocialExitTheme.colors.onSecondary
    )
}

/**
 * Choose Script
 */
// TODO: move to data
val dummyScript = listOf(
    ScriptOption(
        icon = R.drawable.outline_360_24,
        title = "Dummy Title",
        desc = "Dummy desc",
        category = "Home",
        successRate = 87f,
        isActive = true
    ),
    ScriptOption(
        icon = R.drawable.outline_360_24,
        title = "Dummy Title 2",
        desc = "Dummy desc 2",
        category = "Family",
        successRate = 90f,
        isActive = false
    ),
    ScriptOption(
        icon = R.drawable.outline_360_24,
        title = "Dummy Title 3",
        desc = "Dummy desc 3",
        category = "Home",
        successRate = 98f,
        isActive = false
    ),
    ScriptOption(
        icon = R.drawable.outline_360_24,
        title = "Dummy Title 4",
        desc = "Dummy desc 4",
        category = "Family",
        successRate = 90f,
        isActive = false
    )
)

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

/**
 * Previews
 */
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ScriptsScreenDarkPreview() {
    SocialExitTheme {
        ScriptsScreen()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ScriptsScreenLightPreview() {
    SocialExitTheme {
        ScriptsScreen()
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun ScriptsScreenNoButtonDarkPreview() {
    SocialExitTheme {
        ScriptsScreen()
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun ScriptsScreenNoButtonLightPreview() {
    SocialExitTheme {
        ScriptsScreen()
    }
}
