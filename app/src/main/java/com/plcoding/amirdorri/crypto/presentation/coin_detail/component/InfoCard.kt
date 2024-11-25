package com.plcoding.amirdorri.crypto.presentation.coin_detail.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.amirdorri.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.amirdorri.R

@Composable
fun InfoCard(
    title: String,
    formattedText: String,
    icon: ImageVector,
    contentColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.onSurface,
    modifier: Modifier = Modifier
) {
    val defaultTextStyle = LocalTextStyle.current.copy(
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = contentColor)

    Card(
        modifier = modifier
            .padding(8.dp)
            .shadow(
                elevation = 15.dp, shape = RectangleShape,
                ambientColor = MaterialTheme.colorScheme.primary,
                spotColor = MaterialTheme.colorScheme.primary
            ),
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = contentColor
        )
    ) {
        AnimatedContent(
            targetState = icon,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = ""
        ) { icon ->
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .size(75.dp)
                    .padding(top = 16.dp),
                tint = contentColor
            )
        }

        Spacer(Modifier.height(8.dp))

        AnimatedContent(
            targetState = formattedText,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = ""
        ) { formattedText ->
            Text(
                text = formattedText,
                style = defaultTextStyle,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = defaultTextStyle,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            color = contentColor

        )
    }

}


@Preview
@Composable
private fun Test() {
    CryptoTrackerTheme {
        InfoCard(
            title = "Price",
            formattedText = "$ 64,125.29",
            icon = ImageVector.vectorResource(R.drawable.dollar)
        )
    }
}