package com.example.project_3.iu

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.project_3.data.PlaylistModel
import com.example.project_3.repository.Repository

class YouTubeViewModel: ViewModel() {

    private val repository = Repository()

    fun getPlaylist():LiveData<PlaylistModel>{
        return repository.getPlaylist()
    }
}