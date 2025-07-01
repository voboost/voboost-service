package ru.voboost.service.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import ru.voboost.service.VoboostService

/**
 * Minimal activity for service management.
 *
 * This activity provides basic service control functionality.
 * In a production environment, this would typically be integrated
 * with the main Voboost application.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start the service and finish the activity
        // This is a background service, no UI needed
        startVoboostService()
        finish()
    }

    private fun startVoboostService() {
        val serviceIntent =
            Intent(this, VoboostService::class.java).apply {
                action = VoboostService.ACTION_START_SERVICE
            }
        startForegroundService(serviceIntent)
    }
}
