package com.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.test.MainViewModel.MainEvent.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SetupGraph(
                navController = navController,
                viewModel = viewModel
            )
        }

        lifecycleScope.launch {
            viewModel.events.collect {
                when (it) {
                    is OpenSecondScreen -> navController.navigate(Destinations.MiddleScreen.route)
                    is OpenThirdScreen -> navController.navigate(Destinations.ExitScreen.route)
                    is GoBack -> navController.popBackStack()
                }
            }
        }
    }
}