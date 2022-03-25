package com.ozproject.androidfactory


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),MovieDetail {


    lateinit var movieList: List<MovieData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieList = getMovieList()


        supportFragmentManager.beginTransaction().apply {

            setReorderingAllowed(true)
            replace(R.id.fragment_container, ListFragment())
           // addToBackStack(null)
            commit()
        }

    }


    override fun onLearnButtonClicked(position: Int) {
        movieList = getMovieList()
        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            val bundle = Bundle().apply {
                putInt("Movie", movieList[position].positionTracker)
            }

            setCustomAnimations(
                R.anim.fragment_slide_in_right,
                R.anim.fragment_slide_out_left
               // R.anim.fragment_slide_in_left,
              //  R.anim.fragment_slide_out_right


            )


            replace(R.id.fragment_container, DetailFragment().apply {
                arguments = bundle
              addToBackStack(null)
                commit()
            })
        }
    }


        companion object {


            fun getMovieList(): ArrayList<MovieData> {
                val movieData = arrayListOf(

                    MovieData(
                        1,
                        "Euphoria is an English movie that targets a specific base audience due to" +
                                "heavyness of scenes in each episode" +
                                "click the link above to know more about the series",
                        "Euphoria",
                        "Movie Description Here",
                        "Learn More",
                        "https://www.hbo.com/euphoria",

                        R.drawable.euphoria,
                        SharedPrefernces.getMovieFavourite("Euphoria"),
                        "7.9"
                    ),

                    MovieData(

                        2,
                        "Korea",
                        "All Of Us Are Dead",
                        "Check Movie Description",
                        "Learn More",
                        "https://upload.wikimedia.org/wikipedia/en/2/24/all_of_us_are_dead.jpeg",
                        R.drawable.all_of_us_are_dead,
                        SharedPrefernces.getMovieFavourite("All Of Us Are Dead")
                    ),


                    MovieData(
                        3,
                        "Thief",
                        "Inventing Anna",
                        "Check Movie Description",
                        "Learn More",
                        "https://www.historyvshollywood.com/reelfaces/images/2022/01/inventing-anna/social.jpg",
                        R.drawable.inventing_anna,
                    SharedPrefernces.getMovieFavourite("Inventing Anna")
                    ),

                    MovieData(
                        4,
                        "Tommy Init",
                        "Peaky Blinders",
                        "Check Movie Description",
                        "Learn More",
                        "https://en.wikipedia.org/wiki/Peaky_Blinders_(TV_series)",
                        R.drawable.peaky_blinders,
                        SharedPrefernces.getMovieFavourite("Peaky Blinders")
                    )
                )
                return movieData
            }


        }
    }







































// Recycler_View.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
// peakybLINDER ->https://resizing.flixster.com/sLJfv9t7rN8pS2gvFvXyDzUYOsY=/300x300/v2/https://flxt.tmsimg.com/assets/p21680116_b_h9_aa.jpg
//inventing anna -> https://www.historyvshollywood.com/reelfaces/images/2022/01/inventing-anna/social.jpg
//vahalla ->https://pbs.twimg.com/media/FLu7tpWXEAE2UO2?format=jpg&name=360x360
//all of us are dead -> https://upload.wikimedia.org/wikipedia/en/2/24/All_of_Us_Are_Dead.jpeg
//chosen -> https://www.imdb.com/title/tt16492950/mediaviewer/rm269869825/
//euphoria ->https://static1.colliderimages.com/wordpress/wp-content/uploads/2022/02/euphoria-zendaya-emmy-worthy-performance.jpg?q=50&fit=contain&w=750&h=375&dpr=1.5



//        desButton.setOnClickListener {
//
//           val intent = Intent(this,SecondActivity::class.java)
//
//          // intent.putExtra("Title", "euphoria , the new HBO Tv series")
//            intent.putExtra("Title", titleTextView.text)
//            startActivity(intent)

