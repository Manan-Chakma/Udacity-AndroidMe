package com.example.udacityandroidme

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.udacityandroidme.data.AndroidImageAssets
import com.example.udacityandroidme.viewmodels.MyViewModel


class LegsPartFragment : Fragment() {
    private lateinit var legImage: ImageView
    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_legs_part, container, false)
        legImage = view.findViewById(R.id.legs_image)
        legImage.setImageResource(AndroidImageAssets.getLegs()[model.getLegId()])

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.setOnClickListener {
                model.setLegId()
                legImage.setImageResource(AndroidImageAssets.getLegs()[model.getLegId()])
            }
        }else{
            model.lData.observe(viewLifecycleOwner, Observer {
                legImage.setImageResource(AndroidImageAssets.getLegs()[model.getLegId()])
            })
        }

        return view
    }

}
