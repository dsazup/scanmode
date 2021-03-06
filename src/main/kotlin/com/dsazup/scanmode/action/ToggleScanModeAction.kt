package com.dsazup.scanmode.action

import com.dsazup.scanmode.settings.ScanModeSettings
import com.intellij.application.options.EditorFontsConstants
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.Nullable

class ToggleScanModeAction: AnAction() {
    private val settings: ScanModeSettings = ScanModeSettings.instance
    private var scanMode = false
    private var defaultFontSize: Int = EditorFontsConstants.getDefaultEditorFontSize()
    private var defaultLineSpacing: Float = EditorFontsConstants.getDefaultEditorLineSpacing()

    override fun update(e: AnActionEvent) {
        val project: @Nullable Project? = e.project
        e.presentation.isEnabledAndVisible = project != null;

        if (scanMode) {
            e.presentation.text = "Exit Scan Mode"
        }
    }

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)

        if (scanMode) {
            editor.colorsScheme.editorFontSize = defaultFontSize
            editor.colorsScheme.lineSpacing = defaultLineSpacing

            scanMode = false
        } else {
            defaultFontSize = editor.colorsScheme.editorFontSize
            defaultLineSpacing = editor.colorsScheme.lineSpacing

            editor.colorsScheme.editorFontSize = settings.fontSize
            editor.colorsScheme.lineSpacing = settings.lineSpacing

            scanMode = true
        }
    }
}