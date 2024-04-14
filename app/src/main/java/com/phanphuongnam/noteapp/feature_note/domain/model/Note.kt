package com.phanphuongnam.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.phanphuongnam.noteapp.ui.theme.BabyBlue
import com.phanphuongnam.noteapp.ui.theme.LightGreen
import com.phanphuongnam.noteapp.ui.theme.RedOrange
import com.phanphuongnam.noteapp.ui.theme.RedPink
import com.phanphuongnam.noteapp.ui.theme.Violet
import androidx.appsearch.app.AppSearchSchema

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)