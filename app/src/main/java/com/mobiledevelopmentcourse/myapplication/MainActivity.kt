package com.mobiledevelopmentcourse.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobiledevelopmentcourse.myapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeApplicationTheme {
                MainUi()
            }
        }
    }
}

@Composable
fun MainUi() {
    var price by remember {
        mutableStateOf(0)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), containerColor = Color(0xFF546E7A)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$${price}",
                style = TextStyle(
                    color = Color(0xFFFFFFFF),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(price){increment -> price += increment}
        }
    }
}

@Composable
fun CreateCircle(price: Int, onIncrement: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(all = 3.dp)
            .size(100.dp)
            .clickable { onIncrement(100) },
        shape = CircleShape,
        elevation = CardDefaults.elevatedCardElevation(55.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap Me")
        }
    }
}

@Preview(showBackground = true, name = "GreetingPreview")
@Composable
fun GreetingPreview() {
    ComposeApplicationTheme {
        MainUi()
    }
}