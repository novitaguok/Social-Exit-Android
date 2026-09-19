package com.owlite.socialexit.feature.onboarding.impl

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space2Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space3Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXs
import com.owlite.socialexit.core.model.data.OnboardingStep
import com.owlite.socialexit.core.designsystem.R as designSystemR

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    OnboardingScreen(
        onCompleteOnboarding = viewModel::completeOnboarding
    )
}

@Composable
internal fun OnboardingScreen(
    onCompleteOnboarding: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceLg),
        verticalArrangement = Arrangement.spacedBy(Space2Xl)
    ) {
        OnboardingHeaderSection()
        OnboardingStepSection()
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onClick = onCompleteOnboarding
        ) {
            Text(
                text = stringResource(R.string.feature_onboarding_impl_get_started),
                style = SocialExitTheme.typography.bodyLarge,
                color = SocialExitTheme.colors.onPrimary
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space2Xl)
                .clickable(
                    role = Role.Button,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onCompleteOnboarding
                ),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.feature_onboarding_impl_figure_out_myself),
            style = SocialExitTheme.typography.bodyLarge,
            color = SocialExitTheme.colors.onSurface
        )
    }
}

/**
 * Header
 */
@Composable
fun OnboardingHeaderSection() {
    Column {
        Row {
            Icon(
                modifier = Modifier.size(Space3Xl),
                painter = painterResource(designSystemR.drawable.logo_se),
                tint = SocialExitTheme.colors.primary,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(SpaceSm))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = SocialExitTheme.colors.onSurface)) {
                        append("Social")
                    }
                    withStyle(style = SpanStyle(color = SocialExitTheme.colors.primary)) {
                        append("Exit")
                    }
                },
                style = SocialExitTheme.typography.displayLarge
            )
        }
        Spacer(Modifier.height(SpaceSm))
        Text(
            text = "Your silent guardian angel for every awkward conversation you need to escape.",
            style = SocialExitTheme.typography.bodyLarge,
            color = SocialExitTheme.colors.onPrimaryContainer
        )
    }
}

/**
 * Step Section
 */
// TODO: move to data
val onboardingSteps = listOf(
    OnboardingStep(
        stepNumber = 1,
        titleRes = R.string.feature_onboarding_impl_step_1_title,
        descRes = R.string.feature_onboarding_impl_step_1_desc,
        iconRes = R.drawable.ads_click_24
    ),
    OnboardingStep(
        stepNumber = 2,
        titleRes = R.string.feature_onboarding_impl_step_2_title,
        descRes = R.string.feature_onboarding_impl_step_2_desc,
        iconRes = R.drawable.text_snippet_24
    ),
    OnboardingStep(
        stepNumber = 3,
        titleRes = R.string.feature_onboarding_impl_step_3_title,
        descRes = R.string.feature_onboarding_impl_step_3_desc,
        iconRes = R.drawable.directions_walk_24
    ),
)

@Composable
fun OnboardingStepRow(
    item: OnboardingStep,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                color = SocialExitTheme.colors.surfaceContainer,
                shape = RoundedCornerShape(SpaceMd)
            )
            .border(
                width = 1.dp,
                color = SocialExitTheme.colors.outline,
                shape = RoundedCornerShape(SpaceMd)
            )
            .padding(SpaceLg),
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
                painter = painterResource(item.iconRes),
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
                text = stringResource(item.titleRes),
                style = SocialExitTheme.typography.labelLarge,
                color = SocialExitTheme.colors.onSecondaryContainer
            )
            Text(
                text = stringResource(item.descRes),
                style = SocialExitTheme.typography.bodyMedium,
                color = SocialExitTheme.colors.onPrimaryContainer
            )
        }
    }
}

@Composable
fun OnboardingStepSection() {
    Column(verticalArrangement = Arrangement.spacedBy(SpaceMd)) {
        onboardingSteps.forEach { step ->
            OnboardingStepRow(item = step)
        }
    }
}

/**
 * Previews
 */
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun OnboardingScreenDarkPreview() {
    SocialExitTheme {
        OnboardingScreen()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun OnboardingScreenLightPreview() {
    SocialExitTheme {
        OnboardingScreen()
    }
}
