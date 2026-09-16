package com.owlite.socialexit.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val SocialExitDarkColorScheme: ColorScheme = darkColorScheme(
    primary = PaletteTokens.Primary90, // Tone 90, 14.2:1 AAA
    onPrimary = PaletteTokens.Neutral10,
    primaryContainer = PaletteTokens.Primary20,
    onPrimaryContainer = PaletteTokens.Primary95,
    inversePrimary = PaletteTokens.Primary40,

    secondary = PaletteTokens.Secondary60,
    onSecondary = PaletteTokens.Neutral12,
    secondaryContainer = PaletteTokens.Secondary20,
    onSecondaryContainer = PaletteTokens.Secondary90,

    tertiary = PaletteTokens.Tertiary80, // Standby / Delay
    onTertiary = PaletteTokens.Tertiary20,
    tertiaryContainer = PaletteTokens.Tertiary20,
    onTertiaryContainer = PaletteTokens.Tertiary90,

    error = PaletteTokens.ErrorTone60, // Abort / Disarm
    onError = Color(0xFF3E0004),
    errorContainer = PaletteTokens.ErrorTone20,
    onErrorContainer = PaletteTokens.ErrorTone90,

    background = PaletteTokens.Neutral6, // OLED Zero Glare
    onBackground = PaletteTokens.Neutral95,
    surface = PaletteTokens.Neutral10,
    onSurface = PaletteTokens.Neutral95,
    surfaceVariant = PaletteTokens.Neutral17,
    onSurfaceVariant = PaletteTokens.Secondary70,

    surfaceDim = PaletteTokens.Neutral6,
    surfaceBright = PaletteTokens.Neutral30,
    surfaceContainerLowest = Color(0xFF080808),
    surfaceContainerLow = PaletteTokens.Neutral10,
    surfaceContainer = PaletteTokens.Neutral12, // Standard Cards
    surfaceContainerHigh = PaletteTokens.Neutral17, // Elevated Sheets
    surfaceContainerHighest = PaletteTokens.Neutral22,

    outline = Color(0xFF3A3939),
    outlineVariant = Color(0xFF282828),
    scrim = Color(0xFF000000)
)

val SocialExitLightColorScheme: ColorScheme = lightColorScheme(
    primary = PaletteTokens.Primary40, // Daylight Tactical Olive - 8.5:1 AAA
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = PaletteTokens.Primary90, // Brand Accent Container
    onPrimaryContainer = PaletteTokens.Primary10,
    inversePrimary = PaletteTokens.Primary80,

    secondary = PaletteTokens.Secondary40,
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = PaletteTokens.Secondary90,
    onSecondaryContainer = PaletteTokens.Secondary10,

    tertiary = PaletteTokens.Tertiary40, // Standby / Delay
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = PaletteTokens.Tertiary90,
    onTertiaryContainer = PaletteTokens.Tertiary10,

    error = PaletteTokens.ErrorTone40,
    onError = Color(0xFFFFFFFF),
    errorContainer = PaletteTokens.ErrorTone90,
    onErrorContainer = PaletteTokens.ErrorTone10,

    background = PaletteTokens.Neutral98, // Daylight Neutral Canvas
    onBackground = PaletteTokens.Neutral10,
    surface = Color(0xFFFFFFFF),
    onSurface = PaletteTokens.Neutral10,
    surfaceVariant = PaletteTokens.Neutral95,
    onSurfaceVariant = PaletteTokens.Secondary40,

    surfaceDim = PaletteTokens.Neutral90,
    surfaceBright = Color(0xFFFFFFFF),
    surfaceContainerLowest = Color(0xFFFFFFFF), // Pure white base cards
    surfaceContainerLow = Color(0xFFF6F7F9),
    surfaceContainer = Color(0xFFEEF0F4), // Daylight Standard Container
    surfaceContainerHigh = Color(0xFFE7EAEF), // Elevated Dialog / Action Sheets
    surfaceContainerHighest = Color(0xFFE0E3E8),

    outline = Color(0xFF74777F),
    outlineVariant = Color(0xFFC4C7D0),
    scrim = Color(0xFF000000)
)
