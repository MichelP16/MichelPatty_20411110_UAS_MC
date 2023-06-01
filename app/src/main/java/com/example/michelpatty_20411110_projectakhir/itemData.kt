package com.example.michelpatty_20411110_projectakhir

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class itemData (
    val img : Int,
    val album : String,
    val artis : String,

    val img1 : Int,
    val judul1 : String,
    val artis1 : String,

    val img2 : Int,
    val judul2 : String,
    val artis2 : String,

    val img3 : Int,
    val judul3 : String,
    val artis3 : String,

    ) : Parcelable