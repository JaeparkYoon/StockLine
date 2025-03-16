package jpyoon.example.stocksample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jpyoon.example.stocksample.ui.theme.StockSampleTheme
import jpyoon.example.stocksample.laboratory.TopicBubbleView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StockSampleTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .navigationBarsPadding()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            modifier = Modifier.padding(horizontal = 26.dp),
                            text = "오늘의 IT과학 이슈!",
                            fontSize = 24.sp
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 26.dp),
                            text = "TOP.9",
                            fontSize = 40.sp
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        TopicBubbleView()
                    }
                }
            }
        }
    }
}