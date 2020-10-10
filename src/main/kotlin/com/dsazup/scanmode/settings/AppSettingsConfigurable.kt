package com.dsazup.scanmode.settings

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import javax.swing.JComponent


class AppSettingsConfigurable : Configurable {
    var settingsForm: AppSettingsComponent? = null

    override fun createComponent(): JComponent? {
        settingsForm = settingsForm ?: AppSettingsComponent()
        return settingsForm?.component()
    }

    override fun isModified(): Boolean {
        return settingsForm?.isModified ?: return false
    }

    override fun apply() {
        val settings = AppSettingsState.instance
        settings.fontSize = settingsForm?.fontSize().toString()
        settings.lineSpacing = settingsForm?.lineSpacing().toString()
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String {
        return "SDK: Application Settings Example"
    }

    override fun disposeUIResources() {
        settingsForm = null
    }
}
