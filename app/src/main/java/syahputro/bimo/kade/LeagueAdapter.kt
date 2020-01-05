package syahputro.bimo.kade

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LeagueAdapter(val context: Context, val items: List<Item>) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    class ItemUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout() {
                    id = R.id.item_layout
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.gambar_League
                    }.lparams {
                        height = dip(75)
                        width = dip(75)
                    }

                    textView {
                        id = R.id.nama_League
                        textSize = 16f
                    }.lparams {
                        margin = dip(16)
                    }

                }
            }
        }
    }

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val LeagueFoto: ImageView = view.find(R.id.gambar_League)
        private val LeagueName: TextView = view.find(R.id.nama_League)
        private val layout: LinearLayout = view.find(R.id.item_layout)

        fun bindItem(items: Item) {
            Glide.with(itemView.context)
                .load(items.image)
                .into(LeagueFoto)

            LeagueName.text = items.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(ItemUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(items[position])
        holder.itemView.onClick {
            context.startActivity<DetailActivity>("object" to items[position])
        }
    }


}