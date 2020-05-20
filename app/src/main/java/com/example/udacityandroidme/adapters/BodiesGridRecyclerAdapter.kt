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

class BodiesGridRecyclerAdapter :
    RecyclerView.Adapter<BodiesGridRecyclerAdapter.BodiesGridViewHolder>() {

    private var mBodies = ArrayList<Int>()
    private lateinit var listener: OnBodyItemClickListener
    private var mSelect = MutableLiveData<Int>()

    init {
        if (mBodies.isEmpty()) {
            mBodies = AndroidImageAssets.getBody()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodiesGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return BodiesGridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mBodies.size
    }

    override fun onBindViewHolder(holder: BodiesGridViewHolder, position: Int) {
        holder.mImageView.setImageResource(AndroidImageAssets.getBody()[position])
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

    inner class BodiesGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView = itemView.findViewById(R.id.unit_image)
        var fabView: FloatingActionButton = itemView.findViewById(R.id.floatingActionButton)
    }

    interface OnBodyItemClickListener {
        fun onItemClick(i: Int)
    }

    fun setOnItemClickListener(listener: OnBodyItemClickListener) {
        this.listener = listener
    }

    fun setSelection(id: Int) {
        mSelect.value = id
        notifyDataSetChanged()
    }
}