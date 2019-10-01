package temp.ui.imageselection

//import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import kotlinx.android.synthetic.main.screen_template_selection.view.*
import ru.mobileup.leenk.KoinHelper
import ru.mobileup.leenk.ui.common.Screen
import ru.vmochalov.memegenerator.R
import temp.domain.meme.MemeTemplate
import timber.log.Timber

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class ImageSelectionScreen : Screen<ImageSelectionPm>() {

    private val templatesAdapter = object : AsyncListDifferDelegationAdapter<TemplateItem>(object :
        DiffUtil.ItemCallback<TemplateItem>() {
        override fun areItemsTheSame(oldItem: TemplateItem, newItem: TemplateItem): Boolean {
            return oldItem.template.id == newItem.template.id
        }

        override fun areContentsTheSame(oldItem: TemplateItem, newItem: TemplateItem): Boolean {
            return oldItem.template.url == newItem.template.url && oldItem.selected == newItem.selected
        }
    }
    ) {
        init {
            delegatesManager.addDelegate(
                TemplatesAdapterDelegate {
                    presentationModel.templateSelectedClicks.consumer.accept(it)
                }
            )
        }
//        delegae
    }
//    TemplatesAdapter
//    {
//        presentationModel.templateSelectedClicks.consumer.accept(it)
//    }

    override val screenLayout = R.layout.screen_template_selection

    override fun providePresentationModel() = KoinHelper.get<ImageSelectionPm>()

    override fun onInitView(view: View, savedViewState: Bundle?) {
        super.onInitView(view, savedViewState)

        with(view.recyclerView) {

            Timber.d("!! init; recyclerview: $this")
            layoutManager = LinearLayoutManager(context) //, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = templatesAdapter
        }
//        kotlinx.andr  oid.synthetic.main.screen_template_selection.view
    }

    override fun onBindPresentationModel(view: View, pm: ImageSelectionPm) {
        pm.templateItems bindTo {
            templatesAdapter.items = it
            Timber.d("!! items bindto; size: ${it.size}")
        }

        pm.selectedTemplate bindTo {
            bindSelectedTemplate(it)

        }

//        pm.templateSelectedClicks
    }

    private fun bindSelectedTemplate(template: MemeTemplate) {
        view?.templateImage?.let {
            Glide
                .with(it.context)
                .load(template.url)
//                .apply(
//                    RequestOptions
////                        .circleCropTransform()
//                        .placeholder(R.drawable.avatar_placeholder_darker)
//                        .error(R.drawable.avatar_placeholder_darker)
//                )
                .into(it)

//            view.templateImage
        }
    }

}