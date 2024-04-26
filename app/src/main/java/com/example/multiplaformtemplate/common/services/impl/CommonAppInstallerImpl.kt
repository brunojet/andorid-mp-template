package com.example.multiplaformtemplate.common.services.impl

abstract class CommonAppInstallerImpl {
    abstract fun install(packagePath: String)
    abstract fun uninstall(packageName: String)
}