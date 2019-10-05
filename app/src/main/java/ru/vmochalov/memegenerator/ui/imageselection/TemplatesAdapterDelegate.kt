package ru.vmochalov.memegenerator.ui.imageselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_image.*
import ru.vmochalov.memegenerator.R

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
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(
        item: TemplateItem,
        viewHolder: ViewHolder,
        payload: MutableList<Any>
    ) {
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
                .apply(
                    RequestOptions()
                        .error(R.drawable.ic_template_placeholder)
                        .placeholder(R.drawable.ic_template_placeholder)
                )
                .into(containerView.findViewById(R.id.image))

            imageFrame.setBackgroundColor(
                imageFrame.resources.getColor(
                    if (item.selected) {
                        R.color.shadowed_background
                    } else {
                        R.color.template_background
                    }
                )
            )
        }
    }

}