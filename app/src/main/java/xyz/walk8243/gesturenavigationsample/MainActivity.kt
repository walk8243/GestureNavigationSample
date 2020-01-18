package xyz.walk8243.gesturenavigationsample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
        private const val LOGGING_TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultMode()

        val checkBox = findViewById<RadioGroup>(R.id.radioButtonGroup_navigation)
        checkBox.setOnCheckedChangeListener {group, checkedId ->
            Log.d(LOGGING_TAG, "RadioButtonGroup(" + group.id.toString() + ") is checked " + checkedId.toString())
            when (checkedId) {
                R.id.radioButton_navigation_displayMode -> defaultMode()
                R.id.radioButton_navigation_fullscreenMode -> hiddenNavigation()
                R.id.radioButton_navigation_appreciationMode -> setAppreciationMode()
                R.id.radioButton_navigation_immersionMode -> setImmersionMode()
                R.id.radioButton_navigation_applicationPriorityMode -> setApplicationPriorityMode()
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
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
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
