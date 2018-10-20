package tech.owly.owly.adapters

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_grade.view.*
import tech.owly.owly.R
import tech.owly.owly.data.grades.Module


class GradesRecyclerAdapter(private val module: Module) : RecyclerView.Adapter<GradesRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.view_grade, parent,false) as ConstraintLayout
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.layout.name.text = module.grades[position].name
        holder.layout.grade.text = if (module.grades[position].value != -1) module.grades[position].value.toString() else ""
    }

    override fun getItemCount() = module.grades.size
}