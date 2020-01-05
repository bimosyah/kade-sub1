package syahputro.bimo.kade

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val id: String?, val name: String?, val image: Int?, val deskripsi: String?) :
    Parcelable
