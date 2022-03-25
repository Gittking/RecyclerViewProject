package com.ozproject.androidfactory


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_second.view.*
import kotlinx.android.synthetic.main.activity_second.view.ImageHeader
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*


class DetailFragment : ParentFragmentExtension(R.layout.fragment_detail) {

    val movie: MovieData by lazy {
        (activity as MainActivity).movieList.find {
            it.positionTracker == requireArguments().getInt("Movie")
        }!!

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Movie", movie.toString())
        setHasOptionsMenu(true)
         setToolbarMenu("Movie Details")

            val movieImage: ImageView = view.findViewById(R.id.ImageHeader)
            val movieTitle: TextView = view.findViewById(R.id.movieTitle)
            val movieDescription: TextView = view.findViewById(R.id.longMovieDes)
            movieImage.setImageResource(movie.imageResource)
            movieTitle.text = movie.title
            movieDescription.text = movie.longDescription



//         Picasso.get().isLoggingEnabled = true
//         Picasso.get().
//             load(movie.imageUrl).placeholder(R.drawable.ic_launcher_background).into(ImageHeader)

//            Log.i("Image Loading picasso","${movie.imageUrl }-> failed to load" )
        }


     override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){

        inflater.inflate(R.menu.second_acticity, menu)

        if(movie.isFavourite) {
            menu.findItem(R.id.unfavourite).setIcon(R.drawable.ic_facvourite)
        }
         SharedPrefernces.setMovieFavourite(movie.title,movie.isFavourite)

    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {

       return when (item.itemId) {

            R.id.backButton ->{
               mainActivity.supportFragmentManager.popBackStack()
                  true
             }
            R.id.web -> {

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.imageUrl))
                startActivity(intent)
                true
            }
            R.id.unfavourite ->{
               val favouriteChecker = movie.isFavourite

                if(favouriteChecker){
                    item.setIcon(R.drawable.ic_unfacvourite)
                }else{
                    item.setIcon(R.drawable.ic_facvourite)
                }
               movie.isFavourite = !favouriteChecker

                true
            }

           else -> super.onOptionsItemSelected(item)
        }

    }

}



