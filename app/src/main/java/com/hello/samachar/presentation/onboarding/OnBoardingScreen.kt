//Screen For onBoarding Screen
package com.hello.samachar.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hello.samachar.presentation.Dimens.MediumPadding2
import com.hello.samachar.presentation.Dimens.PageIndicatorWidth
import com.hello.samachar.presentation.common.NewsTextButton
import com.hello.samachar.presentation.common.SamacharButton
import com.hello.samachar.presentation.onboarding.components.PageIndicator
import com.hello.samachar.presentation.onboarding.components.onBoardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event:(OnBoardingEvent)->Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        //To flip through content in a left and right or up and down manner
        val pagerState = rememberPagerState(initialPage = 0) {
            //Size of list we have created
            pages.size
        }
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "GetStarted")
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            //Calling onBoardingPage File we have created
            onBoardingPage(page = pages[index])

        }
        //For creating the Bottom section
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Calling PageIndicator File we have created
            PageIndicator(
                modifier = Modifier.width(PageIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            //Text Buttons
            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }

                        }
                    )
                    SamacharButton(text = buttonState.value[1], onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                //TODO:Navigate to Home Screen
                                event(OnBoardingEvent.SaveAppEntry)
                            } else {
                                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                            }
                        }
                    })


                }
            }

        }
        Spacer(modifier=Modifier.weight(0.5f))
        }
    }




