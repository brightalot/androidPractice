package com.example.composepractice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice3.ui.theme.ComposePractice3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractice3Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    QuadrantGenerator()
                }
            }
        }
    }
}

@Composable
fun QuadrantGenerator() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            QuadrantText(title = stringResource(R.string.second_quadrant_title),
                body = stringResource(R.string.second_quadrant_body),
                color = androidx.compose.ui.graphics.Color.Green,
                modifier = Modifier.weight(1f))
            QuadrantText(title = stringResource(R.string.first_quadrant_title),
                body = stringResource(R.string.first_quadrant_body),
                color = androidx.compose.ui.graphics.Color.Yellow,
                modifier = Modifier.weight(1f))

        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            QuadrantText(title = stringResource(R.string.third_quadrant_title),
                body = stringResource(R.string.third_quadrant_body),
                color = androidx.compose.ui.graphics.Color.Cyan,
                modifier = Modifier.weight(1f))
            QuadrantText(title = stringResource(R.string.fourth_quadrant_title),
                body = stringResource(R.string.fourth_quadrant_body),
                color = androidx.compose.ui.graphics.Color.LightGray,
                modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun QuadrantText (title: String, body: String, color: Color, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )


    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePractice3Theme {
        QuadrantGenerator()
    }
}