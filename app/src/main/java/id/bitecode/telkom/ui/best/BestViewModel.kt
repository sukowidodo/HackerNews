package id.bitecode.telkom.ui.best

import android.content.Context
import androidx.lifecycle.ViewModel
import com.smartcybermedia.apps.panicbutton.network.ApiInterface
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class BestViewModel @Inject constructor(
    @ApplicationContext private val context:Context
) : ViewModel() {

    val api = ApiInterface.create()

    fun fetchNews(){

    }

}