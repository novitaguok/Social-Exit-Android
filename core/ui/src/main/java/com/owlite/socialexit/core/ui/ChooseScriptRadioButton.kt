package com.owlite.socialexit.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.RadiusFull
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space4Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXs
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXxs
import com.owlite.socialexit.core.model.data.ScriptOption

@Composable
fun ChooseScriptRadioButton(
    isSelected: Boolean, // TODO: make sure not used
    onClick: () -> Unit,
    option: ScriptOption,
    modifier: Modifier = Modifier
) {
    val borderWidth = if (isSelected) SpaceXxs else 1.dp
    val borderColor =
        if (isSelected) SocialExitTheme.colors.primary
        else SocialExitTheme.colors.surfaceContainer

    ConstraintLayout(
        modifier = modifier
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(SpaceMd)
            )
            .background(
                color = SocialExitTheme.colors.surfaceContainer,
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
                    color = SocialExitTheme.colors.surfaceBright,
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
                tint = borderColor,
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
                style = SocialExitTheme.typography.bodyLarge,
                color = SocialExitTheme.colors.onSecondaryContainer
            )
            if (isSelected) {
                Text(
                    modifier = Modifier
                        .background(
                            color = SocialExitTheme.colors.primary,
                            shape = RoundedCornerShape(RadiusFull)
                        )
                        .padding(horizontal = SpaceSm, vertical = SpaceXxs),
                    text = stringResource(R.string.core_ui_active),
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
