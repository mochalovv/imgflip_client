package ru.vmochalov.memegenerator.ui.imageselection

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.view.visibility
import kotlinx.android.synthetic.main.screen_template_selection.*
import me.dmdev.rxpm.bindTo
import me.dmdev.rxpm.widget.bindTo
import org.koin.android.ext.android.get
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.ui.common.Screen

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class ImageSelectionScreen : Screen<ImageSelectionPm>() {

    private val templatesAdapter =
        object : AsyncListDifferDelegationAdapter<TemplateItem>(TemplateItemDiffUtilCallback()) {
            init {
                delegatesManager.addDelegate(
                    TemplatesAdapterDelegate {
                        presentationModel.templateSelectedClicks.consumer.accept(it)
                    }
                )
            }
        }

    override val screenLayout = R.layout.screen_template_selection

    override fun providePresentationModel() = get<ImageSelectionPm>()

    override fun onInitView() {
        super.onInitView()

        with(recyclerView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = templatesAdapter
        }
    }

    override fun onBindPresentationModel(view: View, pm: ImageSelectionPm) {
        pm.templateItems bindTo templatesAdapter::setItems
        pm.selectedTemplate bindTo this::bindSelectedTemplate
        pm.progressVisible bindTo progress.visibility()

        nextButton.clicks() bindTo pm.nextClicks

        pm.errorDialog bindTo { message, _ ->
            createErrorDialog(
                message,
                presentationModel.retryClicks
            )
        }
    }

    private fun bindSelectedTemplate(template: MemeTemplate) {
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