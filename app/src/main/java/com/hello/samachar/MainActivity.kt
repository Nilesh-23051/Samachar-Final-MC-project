package com.hello.samachar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hello.samachar.data.local.NewsDao
import com.hello.samachar.domain.model.Article
import com.hello.samachar.domain.model.Source
import com.hello.samachar.presentation.navgraph.NavGraph
import com.hello.samachar.presentation.onboarding.OnBoardingScreen
import com.hello.samachar.presentation.onboarding.OnBoardingViewModel
import com.hello.samachar.ui.theme.SamacharTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //For drawing screen behind the system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        //For launching the splash screen
        installSplashScreen().apply{
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }



        setContent {
            SamacharTheme {

                val isSystemInDarkMode= isSystemInDarkTheme()
                val systemController=rememberSystemUiController()
                SideEffect {
                    systemController.setSystemBarsColor(
                        color= Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }
                Box(
                    modifier=Modifier.background(color=MaterialTheme.colorScheme.background)
                ){
                    val startDestination=viewModel.startDestination
                    NavGraph(startDestination = startDestination)

                }

            }
        }
    }
}

