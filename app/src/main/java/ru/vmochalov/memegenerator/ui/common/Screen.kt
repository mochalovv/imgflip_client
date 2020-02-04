package ru.vmochalov.memegenerator.ui.common

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import me.dmdev.rxpm.Action
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.passTo
import ru.vmochalov.memegenerator.R


abstract class Screen<PM : ScreenPm> : PmFragment<PM>() {

    protected abstract val screenLayout: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedViewState: Bundle?
    ): View? {
        return inflater.inflate(screenLayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onInitView()

        super.onViewCreated(view, savedInstanceState)
    }

    protected open fun onInitView() {}

    final override fun onBindPresentationModel(pm: PM) {
        onBindPresentationModel(view!!, pm)
    }

    abstract fun onBindPresentationModel(view: View, pm: PM)

    protected fun createErrorDialog(
        message: String,
        retryAction: Action<Unit>? = null
    ): Dialog {
        return AlertDialog.Builder(view!!.context)
            .setMessage(message)
            .setNegativeButton(R.string.error_dialog_close, null)
            .apply {
                if (retryAction != null) {
                    setPositiveButton(R.string.error_dialog_retry) { _, _ ->
                        Unit passTo (retryAction)
                    }
                }
            }
            .create()
    }
}