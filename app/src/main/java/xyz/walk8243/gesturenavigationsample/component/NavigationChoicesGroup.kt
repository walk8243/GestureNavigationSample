package xyz.walk8243.gesturenavigationsample.component

import android.content.Context
import android.util.AttributeSet
import android.widget.RadioGroup
import xyz.walk8243.gesturenavigationsample.R

class NavigationChoicesGroup @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null
) : RadioGroup(context, attrs) {
    val defaultModeChoice: Int = R.id.radioButton_navigation_displayMode
    val fullscreenModeChoice: Int = R.id.radioButton_navigation_fullscreenMode
    val appreciationModeChoice: Int = R.id.radioButton_navigation_appreciationMode
    val immersionModeChoice: Int = R.id.radioButton_navigation_immersionMode
    val applicationPriorityModeChoice: Int = R.id.radioButton_navigation_applicationPriorityMode

    companion object {
        private const val LOGGING_TAG = "NavigationChoicesGroup"
        const val COMPONENT_ID = R.id.radioButtonGroup_navigation
    }
}
