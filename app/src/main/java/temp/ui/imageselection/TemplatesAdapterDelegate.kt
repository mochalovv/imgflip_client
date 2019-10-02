package temp.ui.imageselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_image.view.*
import ru.vmochalov.memegenerator.R
import timber.log.Timber

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class TemplatesAdapterDelegate(
    private val onItemClicked: (TemplateItem) -> Unit
) : AbsListItemAdapterDelegate<TemplateItem, TemplateItem, TemplatesAdapterDelegate.ViewHolder>() {

    override fun isForViewType(
        item: TemplateItem,
        items: MutableList<TemplateItem>,
        position: Int
    ): Boolean {
        Timber.d("!! isForViewType()")
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        Timber.d("!! onCreateViewHolder()")
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(
        item: TemplateItem,
        viewHolder: ViewHolder,
        payload: MutableList<Any>
    ) {
        Timber.d("!! onBindViewHolder()")
        viewHolder.bind(item)
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        private lateinit var item: TemplateItem

        init {
            containerView.setOnClickListener {
                onItemClicked.invoke(item)
            }
        }

        fun bind(item: TemplateItem) {
            this.item = item

            Glide
                .with(containerView.context)
                .load(item.template.url)
                .into(containerView.findViewById(R.id.image))

            containerView.imageFrame.setBackgroundColor(
                containerView.resources.getColor(
                    if (item.selected) {
                        R.color.selected_template_background
                    } else {
                        R.color.template_background
                    }

                )
            )
        }
    }

}