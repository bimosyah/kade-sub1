package syahputro.bimo.kade

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.ctx
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        verticalLayout {
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = LeagueAdapter(ctx, items)
            }
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.league_name)
        val id = resources.getStringArray(R.array.id_league)
        val image = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_desc)

        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    id[i],
                    name[i],
                    image.getResourceId(i, 0),
                    desc[i]
                )
            )
        }
        image.recycle()
    }
}
