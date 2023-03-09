package com.example.graduationproject.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Section


@Database(entities = [Section::class, Article::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getSectionsDao(): SectionsDao
    abstract fun getArticlesDao(): ArticlesDao

    companion object {
        private const val DATABASE_NAME = "app_db"
        private var DATABASE_INSTANCE: AppDataBase? = null

        fun getItemsDatabaseInstance(context: Context): AppDataBase {
            return DATABASE_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DATABASE_NAME
                )
                .fallbackToDestructiveMigration()
                .build()
                .also { DATABASE_INSTANCE = it }
        }
    }
}