package com.example.composedojo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composedojo.domain.GiftCardModel
import com.example.composedojo.domain.mockedMarioKartGiftCard
import com.example.composedojo.ui.theme.ComposeDojoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDojoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    GiftCardScreen()
                }
            }
        }
    }
}

@Composable
fun GiftCardScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(0.dp))
        GiftCard(mockedMarioKartGiftCard)
        GiftCard(mockedMarioKartGiftCard)
        GiftCard(mockedMarioKartGiftCard)
        GiftCard(mockedMarioKartGiftCard)
        Spacer(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun GiftCard(giftCardModel: GiftCardModel, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = modifier.border(
            width = 2.dp,
            color = Color.Green,
            shape = RoundedCornerShape(8.dp)
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = "dropdowm arrow",
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "status: "
                )
                Text(
                    text = giftCardModel.status,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )

//                alternativa com só um Text
//                Text(buildAnnotatedString {
//                    append("status: ")
//                    withStyle(
//                        style = SpanStyle(
//                            color = Color.Green,
//                            fontWeight = FontWeight.Bold
//                        )
//                    ) {
//                        append(giftCardModel.status)
//                    }
//                })
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Pedido: ${giftCardModel.orderId}", fontSize = 12.sp)
//                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Cartão: ${giftCardModel.cardId}", fontSize = 12.sp)
            }
            Row {
                AsyncImage(
                    model = giftCardModel.image,
                    contentDescription = "fotinha do card",
                    modifier = Modifier.size(width = 120.dp, height = 80.dp)
                )
                Text(
                    text = giftCardModel.info,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Pin/Código:")
                Text(text = giftCardModel.pinCode)
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.content_copy),
                        contentDescription = "botão de copiar"
                    )
                }
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "ver instruções para resgate")
            }
            Text(
                text = "detalhes do pedido",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {

                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GiftCardScreenFinalPreview() {
    ComposeDojoTheme {
        GiftCardScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GiftCardFinalPreview() {
    ComposeDojoTheme {
        GiftCard(mockedMarioKartGiftCard)
    }
}