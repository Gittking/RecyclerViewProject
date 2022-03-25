package com.ozproject.androidfactory

import java.io.Serializable

data class MovieData(
    var positionTracker: Int = 0,
    var longDescription : String = "",
    var title : String ="",
    var movieDescription : String ="",
    var buttonText : String = "",
    var imageUrl : String = "",
    var imageResource : Int =0,
    var isFavourite: Boolean
)






