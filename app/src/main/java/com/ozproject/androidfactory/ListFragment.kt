package com.ozproject.androidfactory

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : ParentFragmentExtension(R.layout.fragment_list){


    private val movieList2 = MainActivity.getMovieList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter(movieList2,activity as MainActivity)
        val recyclerView = view.findViewById<RecyclerView>(R.id.Recycler_View)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        setToolbarMenu("Latest Movies In 2022")
    }

}
