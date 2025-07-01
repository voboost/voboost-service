package ru.voboost.service.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.voboost.service.VoboostService

/**
 * Boot receiver to automatically start Voboost service on device boot.
 *
 * This ensures the service starts automatically when the vehicle system boots up,
 * providing continuous configuration monitoring without user intervention.
 */
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(
        context: Context,
        intent: Intent
    ) {
        when (intent.action) {
            Intent.ACTION_BOOT_COMPLETED,
            Intent.ACTION_MY_PACKAGE_REPLACED,
            Intent.ACTION_PACKAGE_REPLACED -> {
                startVoboostService(context)
            }
        }
    }

    private fun startVoboostService(context: Context) {
        val serviceIntent =
            Intent(context, VoboostService::class.java).apply {
                action = VoboostService.ACTION_START_SERVICE
            }
        context.startForegroundService(serviceIntent)
    }
}
