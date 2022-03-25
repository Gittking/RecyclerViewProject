package com.ozproject.androidfactory

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
     val movieList: List<MovieData>,
    private val movieDetail: MovieDetail

):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(parent)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.onBind(movieList[position],movieDetail )
    }

    inner class MovieHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_structure, parent, false)
    ){
        private val imageView : ImageView = itemView.findViewById(R.id.ImageView)
        private val titleHeader : TextView = itemView.findViewById(R.id.tvTitle)
        private val movieDescription: TextView = itemView.findViewById(R.id.tvDes)
        private val nextPageButton: Button = itemView.findViewById(R.id.btnDes)

        fun onBind(movieData: MovieData, movieDetail: MovieDetail){
            imageView.setImageResource(movieData.imageResource)
            titleHeader.text = movieData.title
            movieDescription.text = movieData.movieDescription
            nextPageButton.setOnClickListener {
                movieDetail.onLearnButtonClicked(adapterPosition)
            }

         }

    }


}