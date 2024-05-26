/*
 *
 * Copyright (C) 2014  Antoine Vianey
 * Copyright (C) 2021- woheller69
 * Copyright 2024 The Old Autumn Project
 * An Android Bubble Level application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Level is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Level. If not, see <http://www.gnu.org/licenses/>
 *
 */
package me.greenrobot.apps.level.util

import me.greenrobot.apps.level.R

object PrefKeys {
    const val PREF_SHOW_ANGLE: Int = R.string.prefKey_showAngle

    const val PREF_DISPLAY_TYPE: Int = R.string.prefKey_displayType
    const val PREF_DISPLAY_TYPE_ANGLE: Int = R.string.prefKey_displayType_angle
    const val PREF_DISPLAY_TYPE_INCLINATION: Int = R.string.prefKey_displayType_inclination

    const val PREF_LOCK_ORIENTATION: Int = R.string.prefKey_lockOrientation

    const val PREF_VISCOSITY: Int = R.string.prefKey_viscosity
    const val PREF_VISCOSITY_LOW: Int = R.string.prefKey_viscosity_low
    const val PREF_VISCOSITY_MEDIUM: Int = R.string.prefKey_viscosity_medium
    const val PREF_VISCOSITY_HIGH: Int = R.string.prefKey_viscosity_high

    const val PREF_ENABLE_SOUND: Int = R.string.prefKey_enableSound
}
