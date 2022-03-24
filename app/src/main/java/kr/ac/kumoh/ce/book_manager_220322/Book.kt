package kr.ac.kumoh.ce.book_manager_220322

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey val id: Int?,
    @ColumnInfo val name: String?
)
