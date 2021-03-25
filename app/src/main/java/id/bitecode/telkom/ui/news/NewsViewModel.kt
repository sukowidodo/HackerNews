package id.bitecode.telkom.ui.news

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartcybermedia.apps.panicbutton.network.ApiInterface
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import id.bitecode.coinapp.room.MyDatabase
import id.bitecode.telkom.model.story.Story
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    @ApplicationContext private val context:Context
) : ViewModel() {

    val api = ApiInterface.create()
    val _listTask = MutableLiveData<List<Story>>()
    val listTask : LiveData<List<Story>> = _listTask
    val myLocalDB = MyDatabase.getDataseClient(context);

    var count :Int = 0;
    var size :Int? = null;

    fun fetchNews(){
        count = 0
        CoroutineScope(Dispatchers.IO).launch {
            var story_dummy = myLocalDB.storyDao().getListTask()
            _listTask.postValue(story_dummy)
        }
        api.run {
            getNewsList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ datum ->
                    size = datum.size
                    datum.forEach {
                        getMyStory(it)
                    }
                },{
                    Log.e("error", it.message.toString())
                })
        }
    }

    fun getMyStory(id:String){
        api.run {
            getStory(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ datum ->
                    count += 1
                    CoroutineScope(Dispatchers.IO).launch {
                        myLocalDB.storyDao().InsertData(datum)
                    }
                    if (count == size){
                        CoroutineScope(Dispatchers.IO).launch {
                            var story_dummy = myLocalDB.storyDao().getListTask()
                            _listTask.postValue(story_dummy)
                        }
                    }

                },{
                    Log.e("error", it.message.toString())
                })
        }
    }
}