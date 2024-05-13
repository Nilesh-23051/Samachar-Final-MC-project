//Contains UI components for the onBoarding Page

package com.hello.samachar.presentation.onboarding.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.hello.samachar.R
import com.hello.samachar.presentation.Dimens.MediumPadding1
import com.hello.samachar.presentation.Dimens.MediumPadding2
import com.hello.samachar.presentation.onboarding.Page
import com.hello.samachar.presentation.onboarding.pages
import com.hello.samachar.ui.theme.SamacharTheme


@Composable
fun onBoardingPage(
    modifier : Modifier = Modifier,
    page: Page,

    ) {
    Column(modifier=modifier){
        Image( painterResource(id = page.image), contentDescription =null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            contentScale= ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(text=page.title,modifier = Modifier.padding(horizontal=MediumPadding2),
            style= MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color= colorResource(id = R.color.display_small)
        )
        Text(text=page.description,modifier = Modifier.padding(horizontal=MediumPadding2),
            style= MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
            color= colorResource(id = R.color.text_medium)
        )
    }

}
@Preview(showBackground = true)
@Preview(uiMode =UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnboardingPagePreview() {
    SamacharTheme{
        onBoardingPage(
            page =pages[0]
            )

    }
}