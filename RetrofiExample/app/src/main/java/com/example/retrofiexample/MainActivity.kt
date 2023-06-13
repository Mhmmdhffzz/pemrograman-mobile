package com.example.retrofiexample

import android.os.Build.VERSION_CODES.S
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofiexample.network.ApiClient
import com.example.retrofiexample.network.CharacterResponse
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
S
        val client= ApiClient.apiService.fetchCharacter("1")

        client.enqueue(object : retrofit2.Callback<CharacterResponse> {


            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if(response.isSuccessful){
                    Log.d("characters", ""+response.body())

                    val result = response.body()?.result
                    result?.let {
                        val adapter = MainAdapter(result)
                        val recyclerView = findViewById<RecyclerView>(R.id.charactersRv)
                        recyclerView?.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
                        recyclerView?.adapter= adapter

                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {

                Log.e("failed", ""+t.message)
            }
        })
    }
}
