package github.informramiz.circleimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import github.informramiz.circleimageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }
}