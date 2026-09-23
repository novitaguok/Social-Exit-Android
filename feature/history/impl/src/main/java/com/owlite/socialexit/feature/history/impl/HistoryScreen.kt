package com.owlite.socialexit.feature.history.impl

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space2Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.Space4Xl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceLg
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceMd
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceSm
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXl
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXs
import com.owlite.socialexit.core.designsystem.theme.SpacingTokens.SpaceXxs

@Composable
fun HistoryScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceLg),
        verticalArrangement = Arrangement.spacedBy(Space2Xl)
    ) {
        item {
            MetricSection(23, 87.5f)
        }
        item {
            ProgressCard(successCount = 17, totalCount = 22)
        }
        item {
            SectionRecentActivity()
        }
    }
}

/**
 * Metric Section
 */
@Composable
fun MetricSection(
    totalExits: Int,
    successRate: Float,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(SpaceMd)
    ) {
        MetricCard(
            value = totalExits.toString(),
            label = stringResource(R.string.feature_history_impl_total_exits),
            icon = Icons.Default.Shield,
            valueColor = SocialExitTheme.colors.onSurface,
            modifier = Modifier.weight(1f)
        )
        MetricCard(
            value = "${successRate}%",
            label = stringResource(R.string.feature_history_impl_success_rate),
            icon = Icons.Default.AutoGraph,
            valueColor = SocialExitTheme.colors.primary,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun MetricCard(
    value: String,
    label: String,
    icon: ImageVector,
    valueColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = SocialExitTheme.colors.secondaryContainer,
                shape = RoundedCornerShape(SpaceMd)
            )
            .padding(SpaceLg)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = value,
                color = valueColor,
                style = SocialExitTheme.typography.displayLarge
                    .copy(fontWeight = FontWeight.ExtraBold)
            )
            Icon(
                imageVector = icon,
                tint = valueColor,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(SpaceXs))
        Text(
            text = label,
            color = SocialExitTheme.colors.onPrimaryContainer,
        )
    }
}

/**
 * Progress Card
 */
@Composable
fun ProgressCard(
    successCount: Int,
    totalCount: Int,
    modifier: Modifier = Modifier
) {
    val progress = if (totalCount > 0) successCount.toFloat() / totalCount else 0f

    Column(
        modifier = modifier
            .background(
                color = SocialExitTheme.colors.secondaryContainer,
                shape = RoundedCornerShape(SpaceMd)
            )
            .padding(SpaceLg),
        verticalArrangement = Arrangement.spacedBy(SpaceSm)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.feature_history_impl_progress_card_label),
                style = SocialExitTheme.typography.bodyMedium,
                color = SocialExitTheme.colors.onSurface
            )
            Text(
                text = stringResource(
                    R.string.feature_history_impl_progress_card_value,
                    successCount,
                    totalCount
                ),
                style = SocialExitTheme.typography.labelLarge,
                color = SocialExitTheme.colors.primary
            )
        }
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(SpaceSm)
                .clip(CircleShape),
            color = SocialExitTheme.colors.primary,
            trackColor = SocialExitTheme.colors.onSurfaceVariant
        )
    }
}

/**
 * Recent Activity Section
 */
@Composable
fun SectionRecentActivity() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(SpaceMd)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.feature_history_impl_recent_activity),
                style = SocialExitTheme.typography.labelLarge,
                color = SocialExitTheme.colors.onPrimaryContainer
            )
            Icon(
                modifier = Modifier.size(SpaceLg),
                imageVector = Icons.AutoMirrored.Filled.Sort,
                tint = SocialExitTheme.colors.onSecondaryContainer,
                contentDescription = null
            )
        }
        HistoryCard(
            title = "Babysitter SOS — Mom",
            desc = "Urgent reminder about pickup window long text long text",
            icon = R.drawable.outline_balance_24,
            dateTime = "Tue, 12:30",
            duration = "2m 14s",
        )
    }
}

@Composable
fun HistoryCard(
    @DrawableRes icon: Int,
    title: String,
    desc: String,
    dateTime: String,
    duration: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(
                color = SocialExitTheme.colors.secondaryContainer,
                shape = RoundedCornerShape(SpaceMd)
            )
            .padding(SpaceLg),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .weight(3f)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(SpaceLg)
        ) {
            Box(
                modifier = Modifier
                    .size(Space4Xl)
                    .background(
                        color = SocialExitTheme.colors.secondary,
                        shape = RoundedCornerShape(SpaceMd)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(SpaceXl),
                    painter = painterResource(icon),
                    tint = SocialExitTheme.colors.primary,
                    contentDescription = null
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(SpaceMd)
            ) {
                Text(
                    text = title,
                    style = SocialExitTheme.typography.labelLarge,
                    color = SocialExitTheme.colors.onSurface
                )
                Text(
                    text = desc,
                    style = SocialExitTheme.typography.labelMedium,
                    color = SocialExitTheme.colors.onPrimaryContainer
                )
            }
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(SpaceXxs),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = dateTime,
                style = SocialExitTheme.typography.labelMedium,
                color = SocialExitTheme.colors.onSurface
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(SpaceXs),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(SpaceMd),
                    imageVector = Icons.Default.AccessTime,
                    tint = SocialExitTheme.colors.onPrimaryContainer,
                    contentDescription = null
                )
                Text(
                    text = duration,
                    style = SocialExitTheme.typography.bodySmall,
                    color = SocialExitTheme.colors.onPrimaryContainer,
                )
            }
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
fun HistoryScreenDarkPreview() {
    SocialExitTheme {
        HistoryScreen()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun HistoryScreenLightPreview() {
    SocialExitTheme {
        HistoryScreen()
    }
}
