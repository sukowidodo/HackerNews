package id.bitecode.telkom.repository

import android.content.Context
import android.util.Log
import id.bitecode.coinapp.room.MyDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryRepository {
//    companion object {
//        fun getDataseClient(context: Context) : StoryRepository {
//
//        }
//    }
//    fun fetchNews(){
//        CoroutineScope(Dispatchers.IO).launch {
//            var story_dummy = myLocalDB.storyDao().getListTask()
//            _listTask.postValue(story_dummy)
//        }
//        api.run {
//            getNewsList().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ datum ->
//                    datum.forEach {
//                        getMyStory(it)
//                    }
//                },{
//                    Log.e("error", it.message.toString())
//                })
//        }
//    }
//
//    fun getMyStory(id:String){
//        api.run {
//            getStory(id).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ datum ->
//                    CoroutineScope(Dispatchers.IO).launch {
//                        myLocalDB.storyDao().InsertData(datum)
//                    }
//
//                },{
//                    Log.e("error", it.message.toString())
//                })
//        }
//    }
}