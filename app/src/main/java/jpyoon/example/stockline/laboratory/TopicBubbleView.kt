package jpyoon.example.stockline.laboratory

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed

@Composable
fun BubbleTopicContent(
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = remember { configuration.screenWidthDp }
    val screenHeightDp = remember { configuration.screenHeightDp }
    val figmaWidthRate = remember { screenWidthDp / 412f }
    val figmaHeightRate = remember { screenHeightDp / 892f }
    val bubbleDataList = remember { makeBubbleData(figmaWidthRate, figmaHeightRate) }
    Column(
        modifier = modifier
            .fillMaxSize(),
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
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "")
            bubbleDataList.shuffled().fastForEachIndexed { index, topicBubbleData ->
                CircleText(
                    drawIndex = index,
                    bubbleData = topicBubbleData,
                )
            }
        }
    }

}

@Composable
private fun CircleText(
    bubbleData: TopicBubbleData,
    modifier: Modifier = Modifier,
    drawIndex: Int = 1, // 그려지는 순서
    text: String = "가나다라마바사아자차카타파하",
) {
    val animationProgress = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(100 * drawIndex)
        )
    }
    Box(
        modifier = modifier
            .offset(x = bubbleData.offsetX, y = bubbleData.offsetY)
            .scale(animationProgress.value)
            .size(bubbleData.size)
            .background(brush = scienceTopicColors[bubbleData.rank - 1], shape = CircleShape)
            .clip(CircleShape)
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = bubbleData.fontSize,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
    }
}

data class TopicBubbleData(
    val rank: Int,
    val size: Dp,
    val fontSize: TextUnit,
    val offsetX: Dp,
    val offsetY: Dp,
)

private val scienceTopicColors = listOf(
    Brush.verticalGradient(
        colors = listOf(Color(0xFF00C3FF), Color(0xFF00FFFF))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0xF200A5CC), Color(0xF200A5CC))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0xF20A95B8), Color(0xF20A95B8))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0xF20E8BAA), Color(0xF20E8BAA))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0xF211809C), Color(0xF211809C))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0x3800CCFF), Color(0x3800CCFF))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0x3800CCFF), Color(0x3800CCFF))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0x3800CCFF), Color(0x3800CCFF))
    ),
    Brush.verticalGradient(
        colors = listOf(Color(0x3800CCFF), Color(0x3800CCFF))
    ),
)


private fun makeBubbleData(widthRate: Float, heightRate: Float): List<TopicBubbleData> {
    return listOf(
        TopicBubbleData(
            rank = 1,
            size = 208.dp * widthRate,
            fontSize = 26.sp,
            offsetX = 75.dp * widthRate,
            offsetY = 147.dp * heightRate
        ),
        TopicBubbleData(
            rank = 2,
            size = 168.dp * widthRate,
            fontSize = 22.sp,
            offsetX = 17.dp * widthRate,
            offsetY = 0.dp
        ),
        TopicBubbleData(
            rank = 3,
            size = 152.dp * widthRate,
            fontSize = 20.sp,
            offsetX = 254.dp * widthRate,
            offsetY = 96.dp * heightRate
        ),
        TopicBubbleData(
            rank = 4,
            size = 134.dp * widthRate,
            fontSize = 18.sp,
            offsetX = 25.dp * widthRate,
            offsetY = 321.dp * heightRate
        ),
        TopicBubbleData(
            rank = 5,
            size = 120.dp * widthRate,
            fontSize = 16.sp,
            offsetX = 268.dp * widthRate,
            offsetY = 244.dp * heightRate
        ),
        TopicBubbleData(
            rank = 6,
            size = 106.dp * widthRate,
            fontSize = 15.sp,
            offsetX = 230.dp * widthRate,
            offsetY = 0.dp
        ),
        TopicBubbleData(
            rank = 7,
            size = 94.dp * widthRate,
            fontSize = 14.sp,
            offsetX = 148.dp * widthRate,
            offsetY = 359.dp * heightRate,
        ),
        TopicBubbleData(
            rank = 8,
            size = 84.dp * widthRate,
            fontSize = 13.sp,
            offsetX = 179.dp * widthRate,
            offsetY = 73.dp * heightRate,
        ),
        TopicBubbleData(
            rank = 9,
            size = 74.dp * widthRate,
            fontSize = 12.sp,
            offsetX = 14.dp * widthRate,
            offsetY = 164.dp * heightRate
        )
    )
}