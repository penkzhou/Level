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

import android.app.Application
import me.greenrobot.apps.level.util.PreferenceHelper

class LevelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPrefs(this)
    }
}
