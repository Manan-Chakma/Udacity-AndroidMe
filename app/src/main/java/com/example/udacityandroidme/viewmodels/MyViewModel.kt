package com.example.udacityandroidme.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.udacityandroidme.data.AndroidImageAssets

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private var sSelect = 0
    private var bSelect = 0
    private var lSelect = 0
    val hData = MutableLiveData<Int>()
    val bData = MutableLiveData<Int>()
    val lData = MutableLiveData<Int>()


    fun getHeadId() = sSelect
    fun setHeadId() {
        if (sSelect >= 11) {
            sSelect = 0
        } else {
            sSelect++
        }
    }
    fun setSelectedHeadId(id:Int){
        sSelect = id
        hData.value = id
    }


    fun getBodyId() = bSelect
    fun setBodyId() {
        if(bSelect >=11){
            bSelect = 0
        }else{
            bSelect++
        }
    }
    fun setSelectedBodyId(id: Int) {
        bSelect = id
        bData.value = id
    }


    fun getLegId() = lSelect
    fun setLegId(){
        if(lSelect >=11){
            lSelect = 0
        }else{
            lSelect++
        }
    }
    fun setSelectedLegId(id:Int){
        lSelect = id
        lData.value = id
    }


}