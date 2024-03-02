package com.bhavani.performanceanalyzer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhavani.performanceanalyzer.R

class ItemsAdapter(private var itemList: List<Items>): RecyclerView.Adapter<ItemsAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.employeeId.text = itemList[position].empId.toString()
        holder.employeeName.text = itemList[position].name
        holder.employeeDob.text = itemList[position].dob
        holder.empRole.text = itemList[position].role
        holder.empNum.text = itemList[position].num.toString()

        //Different right left margins for cardViews in recyclerView
        val params = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        val leftMargin = if (position % 2 == 1) {
            holder.itemView.context.resources.getDimensionPixelSize(R.dimen.item_margin)
        } else {
            0
        }
        val rightMargin = if (position % 2 == 0) {
            holder.itemView.context.resources.getDimensionPixelSize(R.dimen.item_margin)
        } else {
            0
        }
        params.setMargins(leftMargin, params.topMargin, rightMargin, params.bottomMargin)
        holder.itemView.layoutParams = params
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val employeeId: TextView = itemView.findViewById(R.id.empId)
        val employeeName: TextView = itemView.findViewById(R.id.empName)
        val employeeDob: TextView = itemView.findViewById(R.id.dob)
        val empRole: TextView = itemView.findViewById(R.id.role)
        val empNum: TextView = itemView.findViewById(R.id.tvNum)
    }

    //searchView set filtered list upon finding the employee name
    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(itemList: List<Items>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

    //For searchView clearing list upon no data found
    fun clearList() {
        itemList = emptyList()
        notifyDataSetChanged()
    }

}