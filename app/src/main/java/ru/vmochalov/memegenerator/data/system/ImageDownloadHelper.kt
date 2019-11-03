package ru.vmochalov.memegenerator.data.system

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import io.reactivex.Completable
import io.reactivex.Single
import ru.vmochalov.memegenerator.R
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 06.10.2019.
 */
@Singleton
class ImageDownloadHelper @Inject constructor(
    private val context: Context
) {

    fun saveToGallery(imageUrl: String): Completable {
        return loadBitmapFromUrl(imageUrl)
            .flatMap { bitmap ->
                saveToFile(
                    Uri.parse(imageUrl).lastPathSegment ?: "",
                    bitmap
                )
            }
            .doOnSuccess { file ->
                context.sendBroadcast(
                    Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).apply {
                        data = Uri.fromFile(file)
                    }
                )

                Toast
                    .makeText(
                        context,
                        context.getString(R.string.result_image_saved),
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
            .ignoreElement()
    }

    private fun loadBitmapFromUrl(imageUrl: String): Single<Bitmap> {
        return Single.create { singleEmitter ->
            Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .into(
                    object : SimpleTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            singleEmitter.onSuccess(resource)
                        }

                        override fun onLoadFailed(errorDrawable: Drawable?) {
                            super.onLoadFailed(errorDrawable)

                            singleEmitter.onError(Exception("Image loading failed"))
                        }
                    }
                )
        }
    }

    private fun saveToFile(filename: String, bitmap: Bitmap): Single<File> {
        return Single.fromCallable {
            val file = File.createTempFile(
                "meme_$filename",
                ".jpeg",
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            )

            if (file.exists() || file.createNewFile()) {
                val outputstream = file.outputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputstream)
                outputstream.close()
            }

            file
        }
    }

}