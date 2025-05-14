package com.itsaky.androidide.inflater.internal.adapters

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itsaky.androidide.annotations.inflater.ViewAdapter
import com.itsaky.androidide.annotations.uidesigner.IncludeInDesigner
import com.itsaky.androidide.annotations.uidesigner.IncludeInDesigner.Group.WIDGETS
import com.itsaky.androidide.inflater.AttributeHandlerScope
import com.itsaky.androidide.inflater.models.UiWidget
import com.itsaky.androidide.resources.R
import com.itsaky.androidide.inflater.internal.utils.*



@ViewAdapter(FloatingActionButton::class)
@IncludeInDesigner(group = WIDGETS)
open class FloatingActionButtonAdapter<T : FloatingActionButton> : ViewAdapter<T>() {

  override fun createAttrHandlers(create: (String, AttributeHandlerScope<T>.() -> Unit) -> Unit) {
    super.createAttrHandlers(create)

    create("fabSize") {
      view.size = when (value) {
        "normal" -> FloatingActionButton.SIZE_NORMAL
        "mini" -> FloatingActionButton.SIZE_MINI
        else -> FloatingActionButton.SIZE_AUTO
      }
    }

    create("fabCustomSize") {
  view.customSize = parseDimension(context, value, 0).toInt()
}
create("rippleColor") {
  view.rippleColor = parseColorStateList(context, value)
}


    create("backgroundTint") {
      view.backgroundTintList = parseColorStateList(context, value)
    }

    create("src") {
      view.setImageDrawable(parseDrawable(context, value))
    }

    create("elevation") {
      view.elevation = parseDimension(context, value, 0).toFloat()
    }

    create("pressedTranslationZ") {
      view.pressedTranslationZ = parseDimension(context, value, 0).toFloat()
    }

    create("hoveredFocusedTranslationZ") {
      view.hoveredFocusedTranslationZ = parseDimension(context, value, 0).toFloat()
    }

    create("useCompatPadding") {
      view.useCompatPadding = parseBoolean(value)
    }

    create("ensureMinTouchTargetSize") {
      view.setEnsureMinTouchTargetSize(parseBoolean(value))
    }
  }

  override fun createUiWidgets(): List<UiWidget> {
    return listOf(
      UiWidget(
        FloatingActionButton::class.java,
        R.string.widget_fab,
        R.drawable.ic_widget_button
      )
    )
  }

}
