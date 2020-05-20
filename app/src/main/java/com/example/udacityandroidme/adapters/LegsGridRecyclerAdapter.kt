package com.example.udacityandroidme.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.udacityandroidme.R
import com.example.udacityandroidme.data.AndroidImageAssets
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LegsGridRecyclerAdapter :
    RecyclerView.Adapter<LegsGridRecyclerAdapter.LegsGridViewHolder>() {

    private var mLegs = ArrayList<Int>()
    lateinit var listener: OnLegsItemClickListener
    private var mSelect = MutableLiveData<Int>()

    init {
        if (mLegs.isEmpty()) {
            mLegs = AndroidImageAssets.getLegs()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegsGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return LegsGridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mLegs.size
    }

    override fun onBindViewHolder(holder: LegsGridViewHolder, position: Int) {
        holder.mImageView.setImageResource(AndroidImageAssets.getLegs()[position])
        if(position == mSelect.value){
            holder.fabView.visibility = View.VISIBLE
        }else{
            holder.fabView.visibility = View.INVISIBLE
        }
        holder.itemView.setOnClickListener {
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    inner class LegsGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView = itemView.findViewById(R.id.unit_image)
        var fabView: FloatingActionButton = itemView.findViewById(R.id.floatingActionButton)
    }

    interface OnLegsItemClickListener {
        fun onItemClick(i: Int)
    }

    fun setOnLegItemClickListener(listener: OnLegsItemClickListener) {
        this.listener = listener
    }

    fun setSelection(id: Int) {
        mSelect.value = id
        notifyDataSetChanged()
    }
}