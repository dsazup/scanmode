package com.dsazup.scanmode.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil.copyBean
import org.jetbrains.annotations.Nullable
import com.intellij.openapi.components.ServiceManager.getService
import org.jetbrains.annotations.NotNull

@State(
    name = "org.intellij.sdk.settings.AppSettingsState",
    storages = [Storage("scanmode.xml")]
)
class AppSettingsState:PersistentStateComponent<AppSettingsState> {
    var fontSize = "13"
    var lineSpacing = "1"


    @Nullable
    override fun getState() = this

    override fun loadState(@NotNull state: AppSettingsState) {
        copyBean(state, this)
    }

    companion object {
        val instance: AppSettingsState
            get() = getService(AppSettingsState::class.java)
    }
}