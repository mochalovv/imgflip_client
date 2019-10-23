package ru.vmochalov.memegenerator.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vmochalov.memegenerator.data.system.ClipboardHelper
import ru.vmochalov.memegenerator.data.system.ImageDownloadHelper
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import javax.inject.Singleton

@Module
class SystemModule {

    @Provides
    @Singleton
    fun providesResourceHelper(context: Context): ResourceHelper {
        return ResourceHelper(context)
    }

    @Provides
    @Singleton
    fun providesClipboardHelper(context: Context): ClipboardHelper {
        return ClipboardHelper(context)
    }

    @Provides
    @Singleton
    fun providesPermissionHelper(): PermissionsHelper {
        return PermissionsHelper()
    }

    @Provides
    @Singleton
    fun providesImageDownloadHelper(context: Context): ImageDownloadHelper {
        return ImageDownloadHelper(context)
    }
}