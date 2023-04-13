package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.background(colorResource(R.color.teal_700)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BusinessCardCenter()
        BusinessCardBottom()
    }
}

@Composable
fun BusinessCardCenter() {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.padding(top = 200.dp, start = 150.dp, end = 150.dp),
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Hyunsu Kim",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
        )
        Text(
            text ="Android Developer Extraordinary",
            color= Color.Green,
            fontSize = 15.sp,

        )

    }
}

@Composable
fun BusinessCardBottom() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.Bottom,

    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.LightGray,
        )
        Row(
            modifier = Modifier.padding(top = 5.dp, start = 50.dp, bottom = 10.dp)
        ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = "phone number",
                tint = Color.Green,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = "+82 10 9151 0756",
                color = Color.White,
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.LightGray,
        )
        Row(
            modifier = Modifier.padding(top = 5.dp, start = 50.dp, bottom = 10.dp)
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "instagram address",
                tint = Color.Green,
                modifier = Modifier.padding(end = 20.dp)

            )
            Text(
                text = "@Hyunsu__00",
                color = Color.White,
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.LightGray,
        )
        Row(
            modifier = Modifier.padding(top = 5.dp, start = 50.dp, bottom = 10.dp)
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "Mail address",
                tint = Color.Green,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = "gamja9151@hanyang.ac.kr",
                color = Color.White,
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()

    }
}

