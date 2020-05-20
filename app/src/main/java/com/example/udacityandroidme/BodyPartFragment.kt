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
import kotlinx.android.synthetic.main.fragment_body_part.*


class BodyPartFragment : Fragment() {
    private lateinit var bImage: ImageView
    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_body_part, container, false)
        bImage = view.findViewById(R.id.body_image)
        bImage.setImageResource(AndroidImageAssets.getBody()[model.getBodyId()])

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.setOnClickListener(View.OnClickListener {
                model.setBodyId()
                bImage.setImageResource(AndroidImageAssets.getBody()[model.getBodyId()])
            })
        }else{
            model.bData.observe(viewLifecycleOwner, Observer {
                bImage.setImageResource(AndroidImageAssets.getBody()[model.getBodyId()])
            })
        }


        return view
    }

}

