package com.example.composedojo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
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
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composedojo.domain.MediaCardModel
import com.example.composedojo.domain.mockedCardInfo
import com.example.composedojo.ui.theme.ComposeDojoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDojoTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    MediaCardListScreen()
                }
            }
        }
    }
}

@Composable
fun MediaCardListScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(0.dp))
        MediaCard(mockedCardInfo)
        MediaCard(mockedCardInfo)
        MediaCard(mockedCardInfo)
        MediaCard(mockedCardInfo)
        Spacer(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun MediaCard(mediaCardModel: MediaCardModel, modifier: Modifier = Modifier) {
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
                    text = mediaCardModel.title,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )

//                uma forma de aplicar mais de um estilo num só Text
//                Text(buildAnnotatedString {
//                    append("title: ")
//                    withStyle(
//                        style = SpanStyle(
//                            color = Color.Green,
//                            fontWeight = FontWeight.Bold
//                        )
//                    ) {
//                        append(mediaCardModel.title)
//                    }
//                })
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Mídia: ${mediaCardModel.mediaType}", fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Temporadas: ${mediaCardModel.seasons}", fontSize = 12.sp)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = mediaCardModel.image,
                    contentDescription = "fotinha do card",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(width = 120.dp, height = 80.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Gênero:")
                    Text(
                        text = mediaCardModel.genre,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            mediaCardModel.whereToWatch?.let {
                Text(text = "Onde assistir: $it")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaCardPreview() {
    ComposeDojoTheme {
        MediaCard(mockedCardInfo)
    }
}

@Preview(showBackground = true)
@Composable
fun MediaCardListScreenPreview() {
    ComposeDojoTheme {
        MediaCardListScreen()
    }
}
