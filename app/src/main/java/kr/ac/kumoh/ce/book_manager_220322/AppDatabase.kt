package kr.ac.kumoh.ce.book_manager_220322

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDao


}
