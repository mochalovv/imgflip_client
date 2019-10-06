package ru.vmochalov.memegenerator.data.system

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import ru.vmochalov.memegenerator.R

class ClipboardHelper(private val context: Context) {

    private val clipboardManager by lazy {
        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    fun copyToClipboard(label: String, text: String) {
        clipboardManager.setPrimaryClip(
            ClipData.newPlainText(label, text)
        )

        Toast
            .makeText(
                context,
                context.getString(R.string.result_clipboard_confirmation_template, label),
                Toast.LENGTH_SHORT
            )
            .show()
    }

}