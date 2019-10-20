package ru.vmochalov.memegenerator.data.system

import androidx.fragment.app.FragmentActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Single
import javax.inject.Inject

class PermissionsHelper @Inject constructor() {

    private var rxPermissions: RxPermissions? = null

    fun attach(activity: FragmentActivity) {
        rxPermissions = RxPermissions(activity)
    }

    fun requestPermission(vararg permissionName: String): Single<Boolean> {
        return rxPermissions?.request(*permissionName)?.firstOrError()
            ?: throw IllegalStateException("PermissionHelper not attached to Activity")
    }

    fun detach() {
        rxPermissions = null
    }

}