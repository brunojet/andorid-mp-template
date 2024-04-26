package com.example.multiplaformtemplate.common.services

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInstaller
import com.example.multiplaformtemplate.common.services.impl.CommonAppInstallerImpl
import java.io.File
import java.io.FileInputStream

class CommonAppInstaller(private val context: Context): CommonAppInstallerImpl() {

    fun installApk(apkFilePath: String) {
        val packageInstaller = context.packageManager.packageInstaller
        val sessionId = packageInstaller.createSession(params)
        val params = PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL)

        val session = packageInstaller.openSession(sessionId)
        val outputStream = session.openWrite("package", 0, -1)
        val inputStream = FileInputStream(File(apkFilePath))

        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }

        session.fsync(outputStream)
        outputStream.close()

        val intent = Intent(context, InstallReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, sessionId,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)

        session.commit(pendingIntent.intentSender)
    }

    override fun install(packagePath: String) {
        TODO("Not yet implemented")
    }

    override fun uninstall(packageName: String) {
        TODO("Not yet implemented")
    }
}