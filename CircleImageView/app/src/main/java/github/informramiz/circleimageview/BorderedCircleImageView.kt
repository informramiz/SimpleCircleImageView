package github.informramiz.circleimageview

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins


/**
 * Created by Ramiz Raja on 28/07/2020.
 */
class BorderedCircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        //the outline (view edges) of the view should be derived from the background
        outlineProvider = ViewOutlineProvider.BACKGROUND
        //cut the view to match the view to the outline of the background
        clipToOutline = true
        //use the following background to calculate the outline
        background = getBackgroundDrawable()

        //add the circle image as the child view
        addView(getCircleImageView())
    }

    private fun getBackgroundDrawable(): Drawable {
        //get the circle drawable, and we must call mutate() as otherwise all screens will
        //use the same instance of this drawable and changing it on one screen will
        // change it on all other screens which is not what we want. That's why we call mutate()
        // so that a mutable copy is created
        val drawable = context.getDrawable(R.drawable.bg_circle)!!.mutate()
        (drawable as GradientDrawable).setColor(
            ContextCompat.getColor(
                context,
                android.R.color.darker_gray
            )
        )
        return drawable
    }

    private fun getCircleImageView(): CircleImageView {
        return CircleImageView(context).apply {
            val newLayoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutParams = newLayoutParams
        }
    }
}