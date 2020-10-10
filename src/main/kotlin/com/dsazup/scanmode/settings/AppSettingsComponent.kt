package com.dsazup.scanmode.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel


class AppSettingsComponent {
    private var panel: JPanel? = null
    private var fontSizeField = JBTextField()
    private var lineSpacingField = JBTextField()

    private val settings: AppSettingsState = AppSettingsState.instance

    fun component(): JComponent? = panel

    fun fontSize() = fontSizeField.text
    fun lineSpacing() = lineSpacingField.text


    init {
        loadSettings()

        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Font size: "), fontSizeField, 1, false)
            .addLabeledComponent(JBLabel("Line spacing: "), lineSpacingField, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun loadSettings() {
        fontSizeField.text = settings.fontSize
        lineSpacingField.text = settings.lineSpacing
    }


    val isModified: Boolean
        get() = (fontSizeField.text != settings.fontSize
                || lineSpacingField.text != settings.lineSpacing)

}
