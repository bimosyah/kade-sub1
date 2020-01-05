package syahputro.bimo.kade

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<Item>("object")

        scrollView{
            verticalLayout{
                item.image?.let {
                    imageView(it).lparams(width= 300,height = 300) {
                        padding = dip(20)
                        margin = dip(15)
                    }
                }
                textView {
                    text = item.name
                    textSize = 15f
                    textColor = Color.BLACK
                }
                textView {
                    text = "Deskripsi  \n" + item.deskripsi
                    textSize = 15f
                    textColor = Color.BLACK
                }
            }
        }
    }
}
