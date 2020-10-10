package com.dsazup.scanmode.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil.copyBean
import org.jetbrains.annotations.Nullable
import com.intellij.openapi.components.ServiceManager.getService
import org.jetbrains.annotations.NotNull

@State(name = "ScanModeSettings", storages = [Storage("scanmode.xml")])
class ScanModeSettings:PersistentStateComponent<ScanModeSettings> {
    var fontSize = 12
    var lineSpacing = 1.0f

    @Nullable
    override fun getState() = this

    override fun loadState(@NotNull state: ScanModeSettings) {
        copyBean(state, this)
    }

    companion object {
        val instance: ScanModeSettings
            get() = getService(ScanModeSettings::class.java)
    }
}