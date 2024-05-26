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
package me.greenrobot.apps.level

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.Preference.SummaryProvider
import androidx.preference.PreferenceFragmentCompat
import me.greenrobot.apps.level.util.PrefKeys
import me.greenrobot.apps.level.util.PreferenceHelper

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(
        savedInstanceState: Bundle?,
        rootKey: String?,
    ) {
        addPreferencesFromResource(R.xml.preferences)

        val displayType = findPreference<ListPreference>(getString(PrefKeys.PREF_DISPLAY_TYPE))
        if (displayType != null) {
            displayType.summaryProvider =
                SummaryProvider<ListPreference> { preference: Preference? ->
                    if (PreferenceHelper.isDisplayTypeInclination) {
                        return@SummaryProvider getString(R.string.inclination_summary)
                    }
                    getString(R.string.angle_summary)
                }
        }

        val viscosity = findPreference<ListPreference>(getString(PrefKeys.PREF_VISCOSITY))
        if (viscosity != null) {
            viscosity.summaryProvider =
                SummaryProvider<ListPreference> { preference: Preference? ->
                    if (PreferenceHelper.isViscosityLow) {
                        return@SummaryProvider getString(R.string.viscosity_low_summary)
                    }
                    if (PreferenceHelper.isViscosityHigh) {
                        return@SummaryProvider getString(R.string.viscosity_high_summary)
                    }
                    getString(R.string.viscosity_medium_summary)
                }
        }
    }
}
