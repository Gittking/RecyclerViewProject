package com.ozproject.androidfactory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class ParentFragmentExtension(layoutId:Int): Fragment(layoutId) {

   val mainActivity: MainActivity by lazy{ activity as MainActivity}

   fun setToolbarMenu(title: String){
    mainActivity.supportActionBar?.apply {
         this.title=title
    }

   }
}