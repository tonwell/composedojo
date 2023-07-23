package com.example.composedojo.domain

data class MediaCardModel(
    val title: String,
    val mediaType: String,
    val seasons: Int,
    val image: String,
    val genre: String,
    val whereToWatch: String? = null,
)

val mockedCardInfo = MediaCardModel(
    title = "Mairimashita Iruma-kun",
    mediaType = "Anime",
    seasons = 3,
    image = "https://i0.wp.com/www.otakupt.com/wp-content/uploads/2021/03/Mairimashita-Iruma-kun-2-visual.jpg",
    genre = "Shounen, Ação, Comédia",
    whereToWatch = "Crunchyroll"
)