package github.informramiz.circleimageview

import android.content.Context
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
        setBackgroundResource(R.drawable.bg_circle)
        val drawable = background.mutate()
        (drawable as GradientDrawable).setColor(
            ContextCompat.getColor(
                context,
                android.R.color.darker_gray
            )
        )
        background = drawable

        addView(getCircleImageView())
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