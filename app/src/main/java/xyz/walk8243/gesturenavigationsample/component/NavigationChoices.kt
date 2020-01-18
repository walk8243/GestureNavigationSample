package xyz.walk8243.gesturenavigationsample.component

import android.content.Context
import android.util.AttributeSet
import android.widget.RadioButton

class NavigationChoices @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.radioButtonStyle,
    defStyleRes: Int = android.R.style.Widget_Material_CompoundButton_RadioButton
) : RadioButton(context, attrs, defStyleAttr, defStyleRes) {
}