package ru.vmochalov.memegenerator.domain

import android.Manifest
import io.reactivex.Completable
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.ImageDownloadHelper
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 06.10.2019.
 */
@MainActivityScope
class SaveMemeToGalleryInteractor @Inject constructor(
    private val permissionsHelper: PermissionsHelper,
    private val imageDownloadHelper: ImageDownloadHelper,
    private val resourceHelper: ResourceHelper
) {

    fun execute(imageUrl: String): Completable {

        return permissionsHelper.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .flatMapCompletable { granted ->
                if (granted) {
                    imageDownloadHelper.saveToGallery(imageUrl)
                } else {
                    Completable.error(
                        Exception(resourceHelper.getString(R.string.result_permission_not_granted))
                    )
                }
            }
    }

}