package br.com.dnassuncao.pokedex.features.search.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.ui.theme.Grass
import br.com.dnassuncao.pokedex.ui.theme.Typography

@Composable
fun PokeType(
    type: String,
    icon: Int,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            modifier = Modifier
                .background(backgroundColor)
                .padding(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    modifier = Modifier
                        .size(10.dp)
                        .align(Alignment.Center),
                    contentDescription = ""
                )
            }
            Text(
                text = type,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp),
                style = Typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
private fun PokeTypePreview() {
    PokeType(
        type = "Grama",
        backgroundColor = Grass,
        icon = R.drawable.ic_grass
    )
}