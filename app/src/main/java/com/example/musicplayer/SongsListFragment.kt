package com.example.musicplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SongsListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MusicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_songs_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.musicListId)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val musicList = ArrayList<Music>()
        musicList.add(Music(R.drawable.song1,"My Song", "Author A"))
        musicList.add(Music(R.drawable.song2,"Cool Song", "Author B"))
        musicList.add(Music(R.drawable.song3,"Just A Song", "Author C"))

        musicList.add(Music(R.drawable.song1,"My Song", "Author A"))
        musicList.add(Music(R.drawable.song2,"Cool Song", "Author B"))
        musicList.add(Music(R.drawable.song3,"Just A Song", "Author C"))

        musicList.add(Music(R.drawable.song1,"My Song", "Author A"))
        musicList.add(Music(R.drawable.song2,"Cool Song", "Author B"))
        musicList.add(Music(R.drawable.song3,"Just A Song", "Author C"))

        musicList.add(Music(R.drawable.song1,"My Song", "Author A"))
        musicList.add(Music(R.drawable.song2,"Cool Song", "Author B"))
        musicList.add(Music(R.drawable.song3,"Just A Song", "Author C"))

        musicList.add(Music(R.drawable.song1,"My Song", "Author A"))
        musicList.add(Music(R.drawable.song2,"Cool Song", "Author B"))
        musicList.add(Music(R.drawable.song3,"Just A Song", "Author C"))

        adapter = MusicAdapter()
        adapter.setList(musicList)

        adapter.setOnItemClickListener(object : MusicAdapter.OnItemClickListener {
            override fun onItemClick(music: Music) {
                findNavController().navigate((SongsListFragmentDirections.actionMusicListFragmentToMusicInfoFragment(music.icon, music.name, music.author)))
            }
        })

        recyclerView.adapter = adapter

        val itemDecoration = ItemDecoration(resources.getDimensionPixelSize(R.dimen.item_margin))
        recyclerView.addItemDecoration(itemDecoration)
    }
}

