package com.example.composedojo.domain

data class GiftCardModel(
    val status: String,
    val orderId: String,
    val cardId: String,
    val image: String,
    val info: String,
    val pinCode: String,
    val retrieveInstructions: String
)

val mockedMarioKartGiftCard = GiftCardModel(
    status = "Desbloqueado",
    orderId = "02-757368298",
    cardId = "3086559990549698671",
    image = "https://content.blackhawknetwork.com/gcmimages/product/icon/101769.jpg",
    info = "Mario Kart 8 eGift (GiftCard: aa2b)",
    pinCode = "b15b86h941bgx5xl",
    retrieveInstructions = "dialog com textos pegos sabe-se lá aonde"
)