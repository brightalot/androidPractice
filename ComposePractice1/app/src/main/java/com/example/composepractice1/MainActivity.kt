package com.example.composepractice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice1.ui.theme.ComposePractice1Theme
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import org.intellij.lang.annotations.JdkConstants.TitledBorderJustification


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractice1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TutorialGenerator()
                }
            }
        }
    }
}

@Composable
fun TutorialResource(
    title: String,
    body1: String,
    body2: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = body1,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = body2,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify


        )
    }
}
@Composable
fun TutorialGenerator() {
    TutorialResource(
        title = stringResource(R.string.Title_Text),
        body1 = stringResource(R.string.Body1_Text),
        body2 = stringResource(R.string.Body2_Text),
        image = painterResource(R.drawable.bg_compose_background)
    )
}
@Preview(showBackground = false)
@Composable
private fun TutorialPreview() {
    ComposePractice1Theme() {
        TutorialGenerator()
    }
}

