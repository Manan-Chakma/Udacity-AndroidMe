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
import androidx.lifecycle.ViewModelProvider
import com.example.udacityandroidme.data.AndroidImageAssets
import com.example.udacityandroidme.viewmodels.MyViewModel
import kotlinx.android.synthetic.main.fragment_head_part.*

// TODO: Rename parameter arguments, choose names that match


class HeadPartFragment : Fragment() {
    private lateinit var hImage: ImageView
    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_head_part, container, false)
        hImage = view.findViewById(R.id.head_image)
        hImage.setImageResource(AndroidImageAssets.getHeads()[model.getHeadId()])

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.setOnClickListener {
                model.setHeadId()
                hImage.setImageResource(AndroidImageAssets.getHeads()[model.getHeadId()])
            }

        }else{
            model.hData.observe(viewLifecycleOwner, Observer {
                hImage.setImageResource(AndroidImageAssets.getHeads()[model.getHeadId()])
            })
        }
        return view
    }

}
