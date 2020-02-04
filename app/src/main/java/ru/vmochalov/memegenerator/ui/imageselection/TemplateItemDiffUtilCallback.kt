package ru.vmochalov.memegenerator.ui.imageselection

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Vladimir Mochalov on 04.02.2020.
 */
class TemplateItemDiffUtilCallback : DiffUtil.ItemCallback<TemplateItem>() {
    override fun areItemsTheSame(oldItem: TemplateItem, newItem: TemplateItem): Boolean {
        return oldItem.template.id == newItem.template.id
    }

    override fun areContentsTheSame(oldItem: TemplateItem, newItem: TemplateItem): Boolean {
        return oldItem.template.url == newItem.template.url && oldItem.selected == newItem.selected
    }
}