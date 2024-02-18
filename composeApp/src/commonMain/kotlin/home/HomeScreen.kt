package home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR
import components.buttons.TestButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.test.Test

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Screen()
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun Screen() {
        val screenModel = getScreenModel<HomeScreenModel>()
        var uiState by screenModel.uiState

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    uiState = uiState.copy(showContent = !uiState.showContent)
                }
            ) {
                Text(stringResource(MR.strings.click_me))
            }

            TestButton {
                println("Button clicked!")
            }

            AnimatedVisibility(uiState.showContent) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource("compose-multiplatform.xml"), null)
                    Text("Compose: ${uiState.message}")
                }
            }
        }
    }
}