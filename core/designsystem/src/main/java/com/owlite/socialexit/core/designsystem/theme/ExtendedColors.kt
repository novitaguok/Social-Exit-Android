package com.owlite.socialexit.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class SocialExitExtendedColors(
    val tacticalSuccess: Color,
    val onTacticalSuccess: Color,
    val tacticalSuccessContainer: Color,
    val standbyWarning: Color,
    val onStandbyWarning: Color,
    val standbyWarningContainer: Color,
    val glowPrimary: Color,
    val ringTrack: Color,
    val stealthOverlay: Color,
)

val DarkExtendedColors = SocialExitExtendedColors(
    tacticalSuccess = PaletteTokens.SuccessTone80,
    onTacticalSuccess = PaletteTokens.SuccessTone20,
    tacticalSuccessContainer = PaletteTokens.SuccessTone20,
    standbyWarning = PaletteTokens.Tertiary80,
    onStandbyWarning = PaletteTokens.Tertiary20,
    standbyWarningContainer = PaletteTokens.Tertiary20,
    glowPrimary = Color(0x59D7FF31), // 35% neon glow
    ringTrack = PaletteTokens.Neutral22,
    stealthOverlay = Color(0xCC0E0E0E),
)

val LightExtendedColors = SocialExitExtendedColors(
    tacticalSuccess = PaletteTokens.SuccessTone40,
    onTacticalSuccess = Color(0xFFFFFFFF),
    tacticalSuccessContainer = PaletteTokens.SuccessTone90,
    standbyWarning = PaletteTokens.Tertiary40,
    onStandbyWarning = Color(0xFFFFFFFF),
    standbyWarningContainer = PaletteTokens.Tertiary95,
    glowPrimary = Color(0x263E5300), // Subtle daylight ring glow
    ringTrack = Color(0xFFE2E5E9),
    stealthOverlay = Color(0xB3FFFFFF),
)

val LocalSocialExitColors = staticCompositionLocalOf { DarkExtendedColors }
