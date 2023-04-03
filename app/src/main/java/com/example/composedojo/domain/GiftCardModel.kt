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
    orderId = "12-123456789",
    cardId = "1234567890987654321",
    image = "https://content.blackhawknetwork.com/gcmimages/product/icon/101769.jpg",
    info = "Mario Kart 8 eGift (GiftCard: aabc)",
    pinCode = "ab12cd34ef56gh78ij9",
    retrieveInstructions = "dialog com textos pegos sabe-se lá aonde"
)