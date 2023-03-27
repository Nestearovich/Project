package com.example.graduationproject.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

object NavigateHalper {

    fun Fragment.replaceGraph(graphId: Int) {
        findNavController().setGraph(graphId)
    }
    fun Fragment.navigateWithBundle(destinationId: Int, bundle: Bundle){
        findNavController().navigate(destinationId, bundle)
    }
}