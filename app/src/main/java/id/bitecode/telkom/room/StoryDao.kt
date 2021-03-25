package id.bitecode.coinapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.bitecode.telkom.model.story.Story

@Dao
interface StoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(task: Story)

    @Query("DELETE FROM story")
    fun deleteAll(): Int

    @Query("SELECT * FROM story")
    fun getListTask() : List<Story>

    @Query("SELECT * FROM story where id=:id")
    fun getStory(id:Int) : Story
}