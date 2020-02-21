package com.jonathandarwin.customspinner

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.jonathandarwin.customspinner.databinding.LayoutSpinnerSelectedBinding
import com.jonathandarwin.customspinner.databinding.ListSpinnerItemBinding

class SpinnerAdapter(
    private val activity : Activity,
    private val layout : Int,
    private val data : ArrayList<String>
) : ArrayAdapter<String>(activity, layout, data) {

    private var selected : Int = 0

    fun setSelectedIndex(idx : Int) {
        selected = idx
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding : LayoutSpinnerSelectedBinding = DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.layout_spinner_selected, parent, false)
        binding.tvText.text = data[position]
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, parent, 2)
    }

    private fun getCustomView(position : Int, parent : ViewGroup, type : Int) : View{
        val binding : ListSpinnerItemBinding = DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.list_spinner_item, parent, false)
        binding.tvText.text = data[position]
        if(position == selected){
            binding.icon.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_correct, null))
        }
        else{
            binding.icon.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_correct_2, null))
        }
        return binding.root
    }
}
