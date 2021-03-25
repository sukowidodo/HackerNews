package id.bitecode.coinapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.bitecode.telkom.model.story.Story

@Database(entities = [Story::class], version = 6, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun storyDao() : StoryDao

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDataseClient(context: Context) : MyDatabase {
            if (INSTANCE != null) return INSTANCE!!
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "Telkom").fallbackToDestructiveMigration().build()
                return INSTANCE!!

            }
        }

    }

}
