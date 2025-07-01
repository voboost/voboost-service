package ru.voboost.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

/**
 * Main Voboost background service for vehicle configuration management.
 *
 * This service monitors configuration files and applies changes to vehicle systems
 * for Voyah Free and Dreamer models running on Android 9 and 11.
 */
class VoboostService : LifecycleService() {
    companion object {
        const val SERVICE_ID = 1001
        const val CHANNEL_ID = "voboost_service_channel"
        const val CHANNEL_NAME = "Voboost Service"

        // Service actions
        const val ACTION_START_SERVICE = "ru.voboost.service.START_SERVICE"
        const val ACTION_STOP_SERVICE = "ru.voboost.service.STOP_SERVICE"
    }

    private val binder = VoboostServiceBinder()
    private val serviceScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    // Service components (to be implemented)
    // private lateinit var configurationMonitor: ConfigurationMonitor
    // private lateinit var vehicleIntegrator: VoyahIntegrator
    // private lateinit var serviceManager: ServiceManager

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        initializeComponents()
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {
        super.onStartCommand(intent, flags, startId)

        when (intent?.action) {
            ACTION_START_SERVICE -> startForegroundService()
            ACTION_STOP_SERVICE -> stopSelf()
        }

        return START_STICKY // Restart service if killed by system
    }

    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
        // Cleanup components
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_LOW
                ).apply {
                    description = getString(R.string.notification_channel_description)
                    setShowBadge(false)
                }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun startForegroundService() {
        val notification = createServiceNotification()
        startForeground(SERVICE_ID, notification)
    }

    private fun createServiceNotification(): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.service_running_title))
            .setContentText(getString(R.string.service_running_text))
            .setSmallIcon(android.R.drawable.ic_menu_manage) // Using system icon for now
            .setOngoing(true)
            .setAutoCancel(false)
            .build()
    }

    private fun initializeComponents() {
        // TODO: Initialize service components
        // configurationMonitor = ConfigurationMonitor(...)
        // vehicleIntegrator = VoyahIntegrator(...)
        // serviceManager = ServiceManager(...)
    }

    /**
     * Binder class for service communication
     */
    inner class VoboostServiceBinder : Binder() {
        fun getService(): VoboostService = this@VoboostService
    }
}
