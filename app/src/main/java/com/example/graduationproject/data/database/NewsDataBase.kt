package com.example.graduationproject.data.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.graduationproject.data.NewsEntity


@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDataBase: RoomDatabase() {

    abstract fun getNewsDao():NewsDao

    companion object {
        private const val DATABASE_NAME = "News_db"
        private var DATABASE_INSTANCE: NewsDataBase? = null

        fun getItemsDatabaseInstance(context: Context): NewsDataBase {
            return DATABASE_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    NewsDataBase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DATABASE_INSTANCE = it }
        }
    }
}