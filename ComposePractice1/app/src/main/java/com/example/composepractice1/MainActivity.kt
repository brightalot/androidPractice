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
                TutorialWithImage(stringResource(R.string.Title_Text), 
                    stringResource(R.string.Body1_Text), stringResource(R.string.Body2_Text))
                }
            }
        }
    }
}

@Composable
fun TutorialWithText( Title: String, Body1: String, Body2: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = Title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = Body1,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = Body2,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify


        )
    }
}
@Composable
fun TutorialWithImage(TItle: String, Body1: String, Body2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        TutorialWithText(Title = TItle, Body1 = Body1, Body2 = Body2, modifier = modifier)
    }
}
@Preview(showBackground = false)
@Composable
private fun TutorialPreview() {
    ComposePractice1Theme() {
        TutorialWithImage(stringResource(R.string.Title_Text), stringResource(R.string.Body1_Text),
        stringResource(R.string.Body2_Text))
    }
}

