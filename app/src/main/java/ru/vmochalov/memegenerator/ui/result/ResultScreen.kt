package ru.vmochalov.memegenerator.ui.result

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.view.visibility
import kotlinx.android.synthetic.main.screen_result.*
import me.dmdev.rxpm.bindTo
import me.dmdev.rxpm.widget.bindTo
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.extension.visible
import ru.vmochalov.memegenerator.ui.common.Screen
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class ResultScreen : Screen<ResultPm>() {

    @Inject
    protected lateinit var pm: ResultPm

    override val screenLayout = R.layout.screen_result

    override fun providePresentationModel() = pm

    override fun onBindPresentationModel(view: View, pm: ResultPm) {
        pm.meme bindTo this::bindMeme
        pm.progressVisible bindTo progress.visibility()

        link.clicks() bindTo pm.urlClicks
        copyButton.clicks() bindTo pm.copyUrlClicks
        newMemeButton.clicks() bindTo pm.newMemeClicks
        saveToGalleryButton.clicks() bindTo pm.saveToGalleryClicks

        pm.loadingErrorDialog bindTo { message, _ ->
            createErrorDialog(
                message,
                pm.retryClicks
            )
        }

        pm.galleryErrorDialog bindTo { message, _ ->
            createErrorDialog(message)
        }
    }

    private fun bindMeme(meme: GeneratedMeme) {
        link.text = meme.url

        Glide
            .with(templateImage.context)
            .load(meme.url)
            .apply(
                RequestOptions().error(R.drawable.ic_template_placeholder)
            )
            .into(templateImage)

        resultGroup.visible(true)
    }

}