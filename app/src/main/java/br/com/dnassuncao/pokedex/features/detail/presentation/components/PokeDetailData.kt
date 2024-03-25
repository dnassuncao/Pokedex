package br.com.dnassuncao.pokedex.features.detail.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.dnassuncao.pokedex.ui.theme.Title
import br.com.dnassuncao.pokedex.ui.theme.Typography

@Composable
fun PokeDetailData(
    name: String,
    number: String
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        Text(
            text = name,
            style = Typography.titleLarge,
            fontSize = 24.sp
        )
        Text(
            text = "N°${number}",
            style = Typography.bodyMedium,
            color = Title
        )
    }
}

@Preview
@Composable
private fun DetailHeaderPreview() {
    PokeDetailData(
        name = "Elva",
        number = "1"
    )
}