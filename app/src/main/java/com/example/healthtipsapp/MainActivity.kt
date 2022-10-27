package com.example.healthtipsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthtipsapp.ui.theme.HealthTipsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthTipsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    HealthTipAppScreen()
                }
            }
        }
    }
}



@Composable
fun HealthTipAppScreen() {
    var result by remember {
        mutableStateOf(1)
    }
    val tips = when (result) {
        1 -> {
            HealthTipImageText(
                image = R.drawable.image1,
                caption = R.string.tip1,

            )
        }
        2 -> {
            HealthTipImageText(
                image = R.drawable.image2,
                caption = R.string.tip2,

            )
        }
        3 -> {
            HealthTipImageText(
                image = R.drawable.image3,
                caption = R.string.tip3,

            )
        }
        4 -> {
            HealthTipImageText(
                image = R.drawable.image4,
                caption = R.string.tip4,

            )
        }
        5 -> {
            HealthTipImageText(
                image = R.drawable.image5,
                caption = R.string.tip5,

            )
        }
        6 -> {
            HealthTipImageText(
                image = R.drawable.image6,
                caption = R.string.tip6,
            )
        }
        7 -> {
            HealthTipImageText(
                image = R.drawable.image7,
                caption = R.string.tip7,

            )
        }

        else -> println("Error")
    }
    ButtonTip(
        modifierButton = Modifier
            .height(30.dp)
            .width(150.dp),
        { if (result == 1) result = 7 else result-- },
        { if (result == 7) result = 1 else result++ }
    )
}

@Composable
fun HealthTipImageText(image: Int, caption: Int) {
    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome To Health Tips App",
            style = TextStyle(color = Color.Magenta,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W800),

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 40.dp, end = 40.dp)
        )
        Box(
            modifier = Modifier
                .heightIn(500.dp, 530.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(caption),
                modifier = Modifier
                    .border(3.dp, Color.Black, RectangleShape)
                    .padding(16.dp)
            )
            Text(
                text = stringResource(caption),
                style = TextStyle(color = Color.Magenta,
                    fontSize = 25.sp,
                    fontStyle = FontStyle.Italic,
                background = Color.White,
                fontWeight = FontWeight.W500),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 140.dp, start = 50.dp, end = 50.dp)
            )
        }
    }
}

@Composable
fun ButtonTip(
    modifierButton: Modifier,
    clickPrev: () -> Unit,
    clickNext: () -> Unit
) {
    Column(
        modifier = Modifier.padding(top = 300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 25.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = clickPrev, modifier = Modifier.size(100.dp)) {
                Text(text = "Previous", fontSize = 18.sp)
            }
            Button(onClick = clickNext, modifier = Modifier.size(100.dp)) {
                Text(text = "Next", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HealthTipPreview() {
    HealthTipsAppTheme {
        HealthTipAppScreen()
    }
}