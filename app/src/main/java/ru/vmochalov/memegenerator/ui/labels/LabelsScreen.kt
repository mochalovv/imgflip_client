package ru.vmochalov.memegenerator.ui.labels

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputLayout
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.view.visibility
import kotlinx.android.synthetic.main.screen_labels.*
import me.dmdev.rxpm.bindTo
import me.dmdev.rxpm.widget.bindTo
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.TheApplication
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.extension.hideKeyboard
import ru.vmochalov.memegenerator.ui.common.Screen
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class LabelsScreen : Screen<LabelsPm>() {

    @Inject
    protected lateinit var pm: LabelsPm

    override val screenLayout = R.layout.screen_labels

    private lateinit var labelInputs: List<TextInputLayout>

    override fun providePresentationModel() = pm

    override fun onCreate(savedInstanceState: Bundle?) {
        TheApplication
            .getInstance()
            .getMainActivityComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onInitView() {
        super.onInitView()

        labelInputs = listOf(
            firstLabelInput,
            secondLabelInput,
            thirdLabelInput,
            fourthLabelInput,
            fifthLabelInput
        )
    }

    override fun onBindPresentationModel(view: View, pm: LabelsPm) {
        pm.template bindTo this::bindTemplate

        pm.lastVisibleLabelIndex bindTo {
            labelInputs[it].editText?.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        pm.labels.forEachIndexed { index, inputControl ->
            inputControl bindTo labelInputs[index]
        }

        pm.labelsVisibilities.forEachIndexed { index, state ->
            state bindTo labelInputs[index].visibility()
        }

        pm.nextButtonAvailability bindTo nextButton::setEnabled

        nextButton.clicks() bindTo pm.nextClicks
    }

    private fun bindTemplate(template: MemeTemplate) {
        templateTitle.text = template.name

        Glide
            .with(templateImage.context)
            .load(template.url)
            .apply(
                RequestOptions().error(R.drawable.ic_template_placeholder)
            )
            .into(templateImage)
    }

    override fun onDestroyView() {
        nextButton.hideKeyboard()

        super.onDestroyView()
    }

}