package com.example.project_3.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.project_3.data.PlaylistModel
import com.example.project_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { PlayAdapter() }
    private val viewModels by lazy {ViewModelProvider(this)[YouTubeViewModel::class.java]  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewListVideo.adapter = adapter
        viewModels.getPlaylist().observe(this){
            adapter.addData(it.items as MutableList<PlaylistModel.Item>)
        }
    }
}