package com.example.multiplaformtemplate.common.device

import android.os.Build

import com.example.multiplaformtemplate.positivo.device.Mobile as PositivoMobile
import com.example.multiplaformtemplate.gertec.device.Mobile as GertecMobile
import com.example.multiplaformtemplate.common.device.impl.MobileImpl

class Mobile {
    companion object {
        lateinit var mobileObject: MobileImpl
    }

    init {
        val model = Build.MODEL

        when (model) {
            "GertecModel" -> {
                mobileObject = GertecMobile()
            }
            else -> {
                mobileObject = PositivoMobile()
            }
        }
    }
}