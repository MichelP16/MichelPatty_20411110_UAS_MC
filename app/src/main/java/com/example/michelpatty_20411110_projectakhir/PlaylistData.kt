package com.example.michelpatty_20411110_projectakhir

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class PlaylistData (
    val imgPlaylist : Int,
    val judulPlaylist : String,
    val artisPlaylist : String,

) : Parcelable