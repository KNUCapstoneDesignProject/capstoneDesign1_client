package com.example.petsitter.petsitterList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


class petsitterBookmark {
    @Composable
    fun FilterText(text: String, selected: Boolean, onClick: () -> Unit) {
        Row(
            modifier = Modifier
                .clip(shape = CircleShape)
                .clickable(enabled = !selected, onClick = onClick)
                .background(color = if (selected) androidx.compose.ui.graphics.Color.LightGray
                                    else androidx.compose.ui.graphics.Color.Transparent)
                .padding(horizontal = 20.dp, vertical = 2.dp)
        ) {
            Text(text, style = MaterialTheme.typography.body1, fontWeight = FontWeight.ExtraBold)
        }
    }

    @Composable
    fun FilterSection(selectedFilterIndex: Int, setIndex: (Int) -> Unit) {
        Row {
            FilterText("All", selectedFilterIndex == 0) { setIndex(0) }
            Spacer(modifier = Modifier.width(8.dp))
            FilterText("Bookmarks", selectedFilterIndex == 1) { setIndex(1) }
            Spacer(modifier = Modifier.width(8.dp))
            FilterText("Created", selectedFilterIndex == 2) { setIndex(2) }
        }
    }
}