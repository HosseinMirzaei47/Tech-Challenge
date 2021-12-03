package com.example.app.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.app.AppMediaPlayer
import com.example.app.android.extentions.vibratePhone
import com.example.app.model.models.Card
import com.example.app.ui.theme.TextColor

@Composable
fun HomeScreen(
    navController: NavController,
    scaffoldState: ScaffoldState
) {
    val viewModel = hiltViewModel<HomeViewModel>()

    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            val cardState = viewModel.card

            cardState.value?.let { card ->
                CardItem(
                    modifier = Modifier.align(Alignment.Center),
                    card = card
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .align(Alignment.BottomCenter)
                        .background(Color.Red),
                    onClick = {
                        viewModel.onNextClicked(card.id)
                        AppMediaPlayer.INSTANCE.stopPlayer()
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.button_next),
                        color = MaterialTheme.colors.TextColor,
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    card: Card
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = card.title,
                color = MaterialTheme.colors.TextColor,
                style = MaterialTheme.typography.h3
            )

            Text(
                text = card.description,
                color = MaterialTheme.colors.TextColor,
                style = MaterialTheme.typography.h3
            )

            when (card) {
                is Card.PictureCard -> {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 100.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        painter = rememberImagePainter(
                            data = card.image,
                            /*builder = {
                                placeholder(R.drawable.ic_picture_it_placeholder)
                                crossfade(true)
                            }*/
                        ),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = null
                    )
                }
                is Card.VibratorCard -> vibratePhone(LocalContext.current)
                is Card.SoundCard -> AppMediaPlayer.INSTANCE.startPlayer(card.sound)
            }
        }
    }
}