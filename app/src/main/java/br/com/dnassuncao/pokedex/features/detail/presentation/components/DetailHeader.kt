package br.com.dnassuncao.pokedex.features.detail.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.dnassuncao.pokedex.ui.theme.Title
import br.com.dnassuncao.pokedex.ui.theme.Typography

@Composable
fun DetailHeader() {
    Text(
        text = "N°2",
        style = Typography.titleMedium,
        color = Title
    )
}

@Preview
@Composable
private fun DetailHeaderPreview() {
    DetailHeader()
}