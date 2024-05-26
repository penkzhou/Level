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

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.preference.PreferenceManager

object PreferenceHelper {
    private var sharedPrefs: SharedPreferences? = null
    private var mRes: Resources? = null

    fun initPrefs(context: Context) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        mRes = context.resources
    }

    private fun getPrefKey(
        @StringRes prefKey: Int,
    ): String {
        return mRes!!.getString(prefKey)
    }

    private fun getHelperBoolean(
        @StringRes prefKey: Int,
        defValue: Boolean,
    ): Boolean {
        return sharedPrefs!!.getBoolean(getPrefKey(prefKey), defValue)
    }

    private fun getHelperString(
        @StringRes prefKey: Int,
        defValue: Int,
    ): String? {
        return sharedPrefs!!.getString(getPrefKey(prefKey), getPrefKey(defValue))
    }

    /**
     * Compares the preference's current value to the called prefKey.
     *
     * @param currentKeyValue the current key string value of a prefKey
     * @param prefKey         a passed prefKey
     * @return true if the prefKey's current value is equal to the passed prefKey, false otherwise
     */
    private fun getEquals(
        currentKeyValue: String?,
        @StringRes prefKey: Int,
    ): Boolean {
        return currentKeyValue == getPrefKey(prefKey)
    }

    @JvmStatic
    val showAngle: Boolean
        get() = getHelperBoolean(PrefKeys.PREF_SHOW_ANGLE, true)

    val displayType: String?
        get() = getHelperString(PrefKeys.PREF_DISPLAY_TYPE, PrefKeys.PREF_DISPLAY_TYPE_ANGLE)

    @JvmStatic
    val isDisplayTypeInclination: Boolean
        get() = getEquals(displayType, PrefKeys.PREF_DISPLAY_TYPE_INCLINATION)

    @JvmStatic
    val displayTypeFormat: String
        get() {
            // format of default display type (angle)
            var format = "00.0\u2009°"
            if (isDisplayTypeInclination) {
                format = "000.0\u2009'%'"
            }
            return format
        }

    @JvmStatic
    val displayTypeBackgroundText: String
        get() {
            // background text of default display type (angle)
            var backgroundText = "88.8\u2009°"
            if (isDisplayTypeInclination) {
                backgroundText = "888.8\u2009%"
            }
            return backgroundText
        }

    @JvmStatic
    val displayTypeMax: Float
        get() {
            // max of default display type (angle)
            var max = 99.9f
            if (isDisplayTypeInclination) {
                max = 999.9f
            }
            return max
        }

    @JvmStatic
    val orientationLocked: Boolean
        get() = getHelperBoolean(PrefKeys.PREF_LOCK_ORIENTATION, false)

    private val viscosity: String?
        get() = getHelperString(PrefKeys.PREF_VISCOSITY, PrefKeys.PREF_VISCOSITY_MEDIUM)

    val isViscosityLow: Boolean
        get() = getEquals(viscosity, PrefKeys.PREF_VISCOSITY_LOW)

    val isViscosityHigh: Boolean
        get() = getEquals(viscosity, PrefKeys.PREF_VISCOSITY_HIGH)

    @JvmStatic
    val viscosityCoefficient: Double
        get() {
            // coefficient of default viscosity (medium)
            var coeff = 0.4
            if (isViscosityLow) {
                coeff = 0.6
            } else if (isViscosityHigh) {
                coeff = 0.2
            }
            return coeff
        }

    val soundEnabled: Boolean
        get() = getHelperBoolean(PrefKeys.PREF_ENABLE_SOUND, false)
}
