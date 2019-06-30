package ru.itis.kpfu.scbtest.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import ru.itis.kpfu.scbtest.model.dao.ArticleDao
import ru.itis.kpfu.scbtest.model.dao.SourceDao
import ru.itis.kpfu.scbtest.model.entity.room.ArticlePojo
import ru.itis.kpfu.scbtest.model.entity.room.SourcePojo

@Database(entities = [ArticlePojo::class, SourcePojo::class], version = 1, exportSchema = false)
abstract class FavoritesRoomDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    abstract fun sourceDao(): SourceDao

    companion object {
        @Volatile
        private var INSTANCE: FavoritesRoomDatabase? = null

        fun getDatabase(context: Context): FavoritesRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        FavoritesRoomDatabase::class.java,
                        "Favorites_database"
                    )
                    .allowMainThreadQueries() //TODO убрать, сделать AsyncTask'и
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}