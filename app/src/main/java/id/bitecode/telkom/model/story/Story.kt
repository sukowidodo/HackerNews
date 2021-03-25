package id.bitecode.telkom.model.story

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "story")
data class Story (

	@PrimaryKey(autoGenerate = false)
	@ColumnInfo(name = "id")
	@SerializedName("id")
	val id : Int,

	@ColumnInfo(name = "by")
	@SerializedName("by")
	val by : String?,

	@ColumnInfo(name = "descendants")
	@SerializedName("descendants")
	val descendants : Int?,

//	@SerializedName("kids") val kids : List<Int>,

	@ColumnInfo(name = "score")
	@SerializedName("score")
	val score : Int?,

	@ColumnInfo(name = "time")
	@SerializedName("time")
	val time : Int?,

	@ColumnInfo(name = "title")
	@SerializedName("title")
	val title : String?,

	@ColumnInfo(name = "type")
	@SerializedName("type")
	val type : String?,

	@ColumnInfo(name = "url")
	@SerializedName("url")
	val url : String?
)