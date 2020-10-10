package com.dsazup.scanmode.settings

import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class ScanModeConfigurable : Configurable {
    private var panel: JPanel? = null
    private var fontSizeField = JBTextField()
    private var lineSpacingField = JBTextField()

    init {
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Font size: "), fontSizeField, 1, false)
            .addLabeledComponent(JBLabel("Line spacing: "), lineSpacingField, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    override fun createComponent(): JComponent? = panel

    override fun isModified(): Boolean = with(ScanModeSettings.instance) {
        fontSizeField.text.toInt() != fontSize
                || lineSpacingField.text.toFloat() != lineSpacing
    }

    override fun reset() = with(ScanModeSettings.instance) {
        fontSizeField.text = fontSize.toString()
        lineSpacingField.text = lineSpacing.toString()
    }


    override fun apply() = with(ScanModeSettings.instance) {
        fontSize = fontSizeField.text.toInt()
        lineSpacing = lineSpacingField.text.toFloat()
    }

    override fun getDisplayName(): String {
        return "Scan Mode Settings"
    }
}
