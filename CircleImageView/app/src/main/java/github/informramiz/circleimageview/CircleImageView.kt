package github.informramiz.circleimageview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView


/**
 * Created by Ramiz Raja on 28/07/2020.
 */
class CircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    init {
        //the outline (view edges) of the view should be derived from the background
        outlineProvider = ViewOutlineProvider.BACKGROUND
        //cut the view to match the view to the outline of the background
        clipToOutline = true
        //use the following background to calculate the outline
        setBackgroundResource(R.drawable.bg_circle)
    }
}