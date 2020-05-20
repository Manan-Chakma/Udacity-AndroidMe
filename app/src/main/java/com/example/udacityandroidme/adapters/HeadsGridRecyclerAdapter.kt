package com.example.udacityandroidme.adapters


import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.udacityandroidme.R
import com.example.udacityandroidme.data.AndroidImageAssets
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HeadsGridRecyclerAdapter():
    RecyclerView.Adapter<HeadsGridRecyclerAdapter.HeadsGridViewHolder>() {

    private var mHeads = ArrayList<Int>()
    private lateinit var listener:OnItemClickListener
    private var mSelect = MutableLiveData<Int>()

    init {
        if(mHeads.isEmpty()){
            mHeads = AndroidImageAssets.getHeads()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadsGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return HeadsGridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mHeads.size
    }



    override fun onBindViewHolder(holder: HeadsGridViewHolder, position: Int) {
        holder.mImageView.setImageResource(AndroidImageAssets.getHeads()[position])
        if(position == mSelect.value){
            holder.fabView.visibility = View.VISIBLE
        }else{
            holder.fabView.visibility = View.INVISIBLE
        }

        holder.itemView.setOnClickListener {
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }


    inner class HeadsGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mImageView: ImageView = itemView.findViewById(R.id.unit_image)
        var fabView: FloatingActionButton = itemView.findViewById(R.id.floatingActionButton)
    }

    interface OnItemClickListener{
        fun onItemClick(i: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    fun setSelection(id: Int) {
        mSelect.value = id
        notifyDataSetChanged()
    }


}