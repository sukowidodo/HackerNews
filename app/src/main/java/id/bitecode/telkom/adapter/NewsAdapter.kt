package id.bitecode.telkom.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import id.bitecode.coinapp.room.MyDatabase
import id.bitecode.telkom.R
import id.bitecode.telkom.model.story.Story
import id.bitecode.telkom.ui.news.NewsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewsAdapter(
    private val context: Context,
    private val mutableList : List<Story>
): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvBy = itemView.findViewById<TextView>(R.id.tvBy)
        val tvScore = itemView.findViewById<TextView>(R.id.tvScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = mutableList[position].title
        holder.tvBy.text = mutableList[position].by
        holder.tvScore.text = "${mutableList[position].score}"
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }


}