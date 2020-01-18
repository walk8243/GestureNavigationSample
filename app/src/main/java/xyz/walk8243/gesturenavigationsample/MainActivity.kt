package xyz.walk8243.gesturenavigationsample

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import xyz.walk8243.gesturenavigationsample.component.NavigationChoicesGroup

class MainActivity : AppCompatActivity() {
    companion object {
        private const val LOGGING_TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCheckBox()

        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val windowInsets = view.rootWindowInsets.mandatorySystemGestureInsets
            Log.d(LOGGING_TAG, "windowInsets => (" + windowInsets.left + ", " + windowInsets.top + ", " + windowInsets.right + ", " + windowInsets.bottom + ")")
            view.onApplyWindowInsets(view.rootWindowInsets)
            insets
        }
    }

    private fun setupCheckBox() {
        defaultMode()

        val checkBox = findViewById<NavigationChoicesGroup>(NavigationChoicesGroup.COMPONENT_ID)
        checkBox.setOnCheckedChangeListener {group, checkedId ->
            Log.d(LOGGING_TAG, "RadioButtonGroup(" + group.id.toString() + ") is checked " + checkedId.toString())
            when (checkedId) {
                checkBox.defaultModeChoice -> defaultMode()
                checkBox.fullscreenModeChoice -> hiddenNavigation()
                checkBox.appreciationModeChoice -> setAppreciationMode()
                checkBox.immersionModeChoice -> setImmersionMode()
                checkBox.applicationPriorityModeChoice -> setApplicationPriorityMode()
                else -> throw IllegalArgumentException("不適切な選択がされました。")
            }
        }
    }

    private fun setAppreciationMode() {
        window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )
    }

    private fun setImmersionMode() {
        window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE
                )
    }

    private fun setApplicationPriorityMode() {
        window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
    }

    private fun defaultMode() {
        window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_VISIBLE
                )
    }

    private fun hiddenNavigation() {
        window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )
    }

    private fun showNavigation() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    private fun resetSystemUIMode() {
        defaultMode()
    }
}
