package ru.vmochalov.memegenerator.ui.labels

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.screen_labels.*
import ru.vmochalov.memegenerator.KoinHelper
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.ui.common.Screen

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class LabelsScreen : Screen<LabelsPm>() {

    override val screenLayout = R.layout.screen_labels

    override fun providePresentationModel() = KoinHelper.get<LabelsPm>()

    override fun onBindPresentationModel(view: View, pm: LabelsPm) {
        pm.template bindTo { bindTemplate(it) }

        pm.firstLabel bindTo firstLabelInput
        pm.secondLabel bindTo secondLabelInput

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

}