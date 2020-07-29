package github.informramiz.circleimageview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.core.view.setMargins
import androidx.core.view.setPadding


/**
 * Created by Ramiz Raja on 28/07/2020.
 */
class BorderedCircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var borderSize = 0
    private var borderColor: Int = Color.GRAY
    private var imageDrawable: Drawable? = null
    private var circleImageView: CircleImageView

    init {
        //the outline (view edges) of the view should be derived from the background
        outlineProvider = ViewOutlineProvider.BACKGROUND
        //cut the view to match the view to the outline of the background
        clipToOutline = true

        //getting the custom attributes from the XML declaration
        context.withStyledAttributes(attrs, R.styleable.BorderedCircleImageView) {
            borderSize = getDimensionPixelSize(R.styleable.BorderedCircleImageView_bciv_border_size, 0)
            borderColor = getColor(R.styleable.BorderedCircleImageView_bciv_border_color, borderColor)
            imageDrawable = getDrawable(R.styleable.BorderedCircleImageView_bciv_src)
        }

        //use the following background to calculate the outline
        background = getBackgroundDrawable()
        //to achieve border we will set padding so that the background drawable is visible
        //from the edges and acts as a border
        setPadding(borderSize)

        //add the circle image as the child view
        circleImageView = getCircleImageView()
        //set the passed image src to the CircleImageView
        imageDrawable?.let { circleImageView.setImageDrawable(it) }
        addView(circleImageView)
    }

    private fun getBackgroundDrawable(): Drawable {
        //get the circle drawable, and we must call mutate() as otherwise all screens will
        //use the same instance of this drawable and changing it on one screen will
        // change it on all other screens which is not what we want. That's why we call mutate()
        // so that a mutable copy is created
        val drawable = context.getDrawable(R.drawable.bg_circle)!!.mutate()
        //these XML shapes are all GradientDrawables as they lets you set fill, stroke
        // and gradient colors so we can safely cast this drawable to GradientDrawable
        (drawable as GradientDrawable).setColor(borderColor)
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