package com.example.newsapp3.Presentation.Onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp3.Presentation.ImportedIcons.CircleFilled
import com.example.newsapp3.ui.theme.BlueGray


fun circleColor(circleNo:Int,selectedCircleNo:Int):Color
{
    return if(circleNo==selectedCircleNo) Color.Blue
    else BlueGray
}


fun nextClick(currentScreen:MutableState<Int>)
{
    if(currentScreen.value<2)
    {
        currentScreen.value++
    }
    else{
        currentScreen.value=0
    }
}

fun previousClick(currentScreen:MutableState<Int>)
{
    if(currentScreen.value>0)
    {
        currentScreen.value--
    }
}



@Composable
fun OnBoardingBottomRow(modifier: Modifier,currentScreen:MutableState<Int>)
{

    Row(modifier = modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(horizontal = 24.dp))
    {

        if(currentScreen.value > 0)
        {
            Row(modifier = Modifier.fillMaxHeight().fillMaxWidth(.3f), verticalAlignment = Alignment.CenterVertically)
            {
                Button(
                    onClick = { previousClick(currentScreen)},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                )
                {
                    Text(text="Back", color = Color.White)
                }

            }

            Row(modifier = Modifier.fillMaxHeight().fillMaxWidth(.5f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween)
            {
                Image(imageVector = CircleFilled, contentDescription = null,modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(
                    circleColor(0,currentScreen.value)))
                Image(imageVector = CircleFilled, contentDescription = null,modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(
                    circleColor(1,currentScreen.value)))
                Image(imageVector = CircleFilled, contentDescription = null,modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(circleColor(2,currentScreen.value)))

            }

            Row(modifier=Modifier.fillMaxHeight().fillMaxWidth(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End)
            {
                Button(onClick = { nextClick(currentScreen) },shape = MaterialTheme.shapes.small, colors =ButtonDefaults.buttonColors(containerColor = Color.Blue))
                {
                    Text(text="Next", color = Color.White)
                }
            }

        }


        else{
        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(.3f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween)
        {
            Image(imageVector = CircleFilled, contentDescription = null,modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(
                circleColor(0,currentScreen.value)))
            Image(imageVector = CircleFilled, contentDescription = null,modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(
                circleColor(1,currentScreen.value)))
            Image(imageVector = CircleFilled, contentDescription = null,modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(circleColor(2,currentScreen.value)))

        }
        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(1f), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically)
        {
            Button(onClick = { nextClick(currentScreen) },shape = MaterialTheme.shapes.small, colors =ButtonDefaults.buttonColors(containerColor = Color.Blue))
            {
                Text(text="Next", color = Color.White)
            }
        }
    }}

}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BottomRowPreview()
{
    val currentScreen= remember { mutableStateOf<Int>(0) }
    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .navigationBarsPadding()) {
        Spacer(modifier = Modifier.height(50.dp))

        OnBoardingBottomRow(modifier = Modifier,currentScreen)

    }
}
