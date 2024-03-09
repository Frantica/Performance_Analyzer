package com.bhavani.performanceanalyzer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.bhavani.performanceanalyzer.common.dimen30dpPx
import com.bhavani.performanceanalyzer.common.isEven
import com.bhavani.performanceanalyzer.common.isOdd
import com.bhavani.performanceanalyzer.data.Employee
import com.bhavani.performanceanalyzer.databinding.ItemEmployeeBinding

class EmployeesAdapter(private var dataset: List<Employee>) : RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder>() {

    //searchView set filtered list upon finding the employee name
    fun setFilteredList(dataset: List<Employee>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }

    //For searchView clearing list upon no data found
    fun clearList() {
        dataset = emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =
        EmployeeViewHolder(
            ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size

    class EmployeeViewHolder(private val viewBinding: ItemEmployeeBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        private val dimen30dpPx by lazy { itemView.context.dimen30dpPx }

        fun bind(employee: Employee) {
            with(viewBinding) {
                tvId.text = employee.id.toString()
                tvName.text = employee.name
                tvDob.text = employee.DOB
                tvRole.text = employee.role
                tvSerialNo.text = employee.serialNumber.toString()
                root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    val position = absoluteAdapterPosition
                    leftMargin = if (position.isOdd()) dimen30dpPx else 0
                    rightMargin = if (position.isEven()) dimen30dpPx else 0
                }
            }
        }

    }
}