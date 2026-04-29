package com.jetstream.app.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //This initializes Hilt DI for the whole app.
class MyApp: Application() {
}