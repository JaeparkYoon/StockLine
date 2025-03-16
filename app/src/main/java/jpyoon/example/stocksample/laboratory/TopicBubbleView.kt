package jpyoon.example.stocksample.laboratory

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun TopicBubbleView() {
    val configuration = LocalConfiguration.current
    val screenWidthDp = remember { configuration.screenWidthDp }
    val screenHeightDp = remember { configuration.screenHeightDp }
    val figmaWidthRate = remember { screenWidthDp / 412f }
    val figmaHeightRate = remember { screenHeightDp / 892f}
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        CircleText(
            modifier = Modifier.offset(17.dp * figmaWidthRate, 0.dp),
            rank = 2,
        )
        CircleText(
            modifier = Modifier.offset(179.dp * figmaWidthRate , 73.dp * figmaHeightRate),
            rank = 8,
        )
        CircleText(
            modifier = Modifier.offset(230.dp * figmaWidthRate, 0.dp * figmaHeightRate),
            rank = 6,
        )
        CircleText(
            modifier = Modifier.offset(14.dp * figmaWidthRate, 164.dp * figmaHeightRate),
            rank = 9,
        )
        CircleText(
            modifier = Modifier.offset(75.dp * figmaWidthRate, 147.dp * figmaHeightRate),
            rank = 1,
        )
        CircleText(
            modifier = Modifier.offset(254.dp * figmaWidthRate , 96.dp * figmaHeightRate),
            rank = 3,
        )
        CircleText(
            modifier = Modifier.offset(25.dp * figmaWidthRate, 321.dp * figmaHeightRate),
            rank = 4,
        )
        CircleText(
            modifier = Modifier.offset(268.dp * figmaWidthRate, 244.dp * figmaHeightRate),
            rank = 5,
        )
        CircleText(
            modifier = Modifier.offset(148.dp * figmaWidthRate, 359.dp * figmaHeightRate),
            rank = 7,
        )
    }
}
//453
@Composable
private fun CircleText(
    modifier: Modifier = Modifier,
    rank: Int = 1,
    text: String = "가나다라마바사아자차카타파하",
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = remember { configuration.screenWidthDp }
    val figmaWidthRate = remember { screenWidthDp / 412f }
    val bubbleData = remember {
        when (rank) {
            1 -> TopicBubbleData(
                size = 208.dp * figmaWidthRate,
                fontSize = 26.sp,
            )
            2 -> TopicBubbleData(
                size = 168.dp * figmaWidthRate,
                fontSize = 22.sp,
            )
            3 -> TopicBubbleData(
                size = 152.dp * figmaWidthRate,
                fontSize = 20.sp,
            )
            4 -> TopicBubbleData(
                size = 134.dp * figmaWidthRate,

                fontSize = 18.sp,
            )
            5 -> TopicBubbleData(
                size = 120.dp * figmaWidthRate,
                fontSize = 16.sp,
            )
            6 -> TopicBubbleData(
                size = 106.dp * figmaWidthRate,
                fontSize = 15.sp,
            )
            7 -> TopicBubbleData(
                size = 94.dp * figmaWidthRate,
                fontSize = 14.sp,
            )
            8 -> TopicBubbleData(
                size = 84.dp * figmaWidthRate,
                fontSize = 13.sp,
            )
            9 -> TopicBubbleData(
                size = 74.dp * figmaWidthRate,
                fontSize = 12.sp,
            )
            else -> TopicBubbleData(
                size = 74.dp * figmaWidthRate,
                fontSize = 12.sp,
            )
        }
    }
    val animationProgress = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(700)
        )
    }
    Box(
        modifier = modifier
            .scale(animationProgress.value)
            .size(bubbleData.size)
            .background(brush = scienceTopicColors[rank - 1], shape = CircleShape)
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
    val size: Dp,
    val fontSize: TextUnit,
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