package ru.vmochalov.memegenerator.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import ru.vmochalov.memegenerator.extension.setRoot

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val activityLayout: Int
    protected abstract val containerId: Int

    protected lateinit var router: Router

    protected abstract val rootScreen: Controller?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityLayout)
        router = Conductor.attachRouter(this, findViewById(containerId), savedInstanceState)

        rootScreen?.let { root ->
            if (!router.hasRootController()) {
                router.setRoot(root)
            }
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}