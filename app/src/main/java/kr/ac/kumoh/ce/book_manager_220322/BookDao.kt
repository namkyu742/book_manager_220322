package kr.ac.kumoh.ce.book_manager_220322

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAll(): List<Book>

    @Insert
    fun insertBook(book: Book)
}