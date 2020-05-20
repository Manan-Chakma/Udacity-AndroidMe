package com.example.udacityandroidme

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.udacityandroidme.adapters.BodiesGridRecyclerAdapter
import com.example.udacityandroidme.adapters.HeadsGridRecyclerAdapter
import com.example.udacityandroidme.adapters.HeadsGridRecyclerAdapter.OnItemClickListener
import com.example.udacityandroidme.adapters.LegsGridRecyclerAdapter.OnLegsItemClickListener
import com.example.udacityandroidme.adapters.BodiesGridRecyclerAdapter.OnBodyItemClickListener
import com.example.udacityandroidme.adapters.LegsGridRecyclerAdapter
import com.example.udacityandroidme.viewmodels.MyViewModel

class ChoosePartsFragment : Fragment() {

    private lateinit var hRecyclerView: RecyclerView
    private lateinit var bRecyclerView: RecyclerView
    private lateinit var lRecyclerView: RecyclerView

    private var hAdapter = HeadsGridRecyclerAdapter()
    private var bAdapter = BodiesGridRecyclerAdapter()
    private var lAdapter = LegsGridRecyclerAdapter()

    private lateinit var model: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_choose_parts, container, false)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            model = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
            hRecyclerView = view.findViewById(R.id.head_recycler_view)
            bRecyclerView = view.findViewById(R.id.bodies_recycler_view)
            lRecyclerView = view.findViewById(R.id.legs_recycler_view)

            hRecyclerView.layoutManager = GridLayoutManager(context, 3)
            bRecyclerView.layoutManager = GridLayoutManager(context, 3)
            lRecyclerView.layoutManager = GridLayoutManager(context, 3)

            hRecyclerView.adapter = hAdapter
            bRecyclerView.adapter = bAdapter
            lRecyclerView.adapter = lAdapter

            hAdapter.setSelection(model.getHeadId())
            bAdapter.setSelection(model.getBodyId())
            lAdapter.setSelection(model.getLegId())

            hAdapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick(i: Int) {
                    model.setSelectedHeadId(i)
                    hAdapter.setSelection(i)
                }
            })

            bAdapter.setOnItemClickListener(object : OnBodyItemClickListener {
                override fun onItemClick(i: Int) {
                    model.setSelectedBodyId(i)
                    bAdapter.setSelection(i)
                }
            })

            lAdapter.setOnLegItemClickListener(object : OnLegsItemClickListener {
                override fun onItemClick(i: Int) {
                    model.setSelectedLegId(i)
                    lAdapter.setSelection(i)
                }
            })

        }

        return view
    }

}
