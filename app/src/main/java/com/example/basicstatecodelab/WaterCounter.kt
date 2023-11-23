package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WaterCounter(modifier: Modifier) {
    Column(modifier.padding(16.dp)) {
        var count by rememberSaveable {
            mutableStateOf(0)
        }
        if (count > 0) {
            Text(text = "You have had $count glasses.")
        }
        Row() {
            Button(
                onClick = { count++ },
                Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }
        }
    }
}

@Composable
fun StateLessCounter(count:Int, onIncrement:()->Unit, modifier: Modifier=Modifier){
    Column(modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You have had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier){
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StateLessCounter(count, { count++ }, modifier)
}

@Preview
@Composable
fun PreviewWaterContainer() {
    BasicStateCodelabTheme {
        WaterCounter(modifier = Modifier.padding(16.dp))
    }
}