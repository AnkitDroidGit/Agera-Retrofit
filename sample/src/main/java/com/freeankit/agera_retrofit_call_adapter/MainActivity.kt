package com.freeankit.agera_retrofit_call_adapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeankit.agera_retrofit_call_adapter.model.User
import com.freeankit.retro_agera.AgeraCallAdapterFactory
import com.freeankit.retro_agera.Ageras
import com.google.android.agera.Repository
import com.google.android.agera.Updatable
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/01/2018 (MM/DD/YYYY )
 */
class MainActivity : AppCompatActivity(), Updatable {
    private lateinit var repository1: Repository<User>
    //    private var repository2: Repository<Array<String>>? = null
    private val INITIAL_VALUE = User()

    override fun update() {
        text.append("* " + repository1.get().name + "\n")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(OkHttpClient())
                .addCallAdapterFactory(AgeraCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(IApi::class.java)

        repository1 = Ageras.goToNetworkExecutorWithInitialValue(INITIAL_VALUE)
                .attemptGetFrom(service.android())
                .orSkip()
                .thenGetFrom { User() }
                .compile()

//        repository2 = Ageras.goToNetworkExecutorWithInitialValue(INITIAL_VALUE)
//                .attemptGetFrom(service.android())
//                .orSkip()
//                .attemptTransform({ response ->
//                    val result: Result<User>
//                    if (response.isSuccessful()) {
//                        result = Result.success(response.body())
//                    } else {
//                        result = Result.failure(HttpException(response))
//                    }
//                    result
//                })
//                .orEnd({ input -> arrayOf("...") })
//                .thenTransform(gankToTitleArray)
//                .compile()

        repository1.addUpdatable(this)
//        repository2.addUpdatable(object : Updatable {
//            override fun update() {
//                for (s in repository2.get()) {
//                    textView.append("* " + s + "\n")
//                }
//                repository2.removeUpdatable(this)
//            }
//        })
    }


    override fun onDestroy() {
        super.onDestroy()
        repository1.removeUpdatable(this)
    }
}