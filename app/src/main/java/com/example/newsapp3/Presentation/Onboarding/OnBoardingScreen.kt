package com.example.newsapp3.Presentation.Onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp3.R


@Composable
fun OnBoardingScreen(
    modifier: Modifier,page: Page )
{
    val currentScreen= remember { mutableStateOf<Int>(0) }
    Column(modifier = Modifier
        .fillMaxSize().fillMaxHeight()
        .navigationBarsPadding().background(MaterialTheme.colorScheme.background)) {
        Column(modifier=Modifier.fillMaxWidth()) {

            Column(modifier=Modifier
                .fillMaxWidth()
                .fillMaxHeight(.6f)) {
                Image(
                    painter = painterResource(id = OnBoardingPageList[currentScreen.value].image),
                    contentDescription = "OnBoarding Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier=Modifier.height(Dimensions.mediumPadding1))

            Text(
                text = OnBoardingPageList[currentScreen.value].title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimensions.mediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.display_small)
            )

            Spacer(modifier=Modifier.height(Dimensions.mediumPadding2))

            Text(
                text = OnBoardingPageList[currentScreen.value].description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimensions.mediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_medium)
            )

            //OnBoardingBottomRow(modifier=Modifier,currentScreen)
        }

        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().height(150.dp))
        {
            OnBoardingBottomRow(modifier=Modifier,currentScreen)
        }


    }

}

@Composable
@Preview(showBackground = true)
fun OnBoardingScreenPreview()
{
    OnBoardingScreen(modifier = Modifier, page = OnBoardingPageList[0])
}


