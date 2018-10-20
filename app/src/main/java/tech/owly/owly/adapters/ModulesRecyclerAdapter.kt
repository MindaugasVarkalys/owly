package tech.owly.owly.adapters

import android.support.constraint.ConstraintLayout
import android.support.v4.text.HtmlCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_module_card.view.*
import tech.owly.owly.R
import tech.owly.owly.data.grades.Module


class ModulesRecyclerAdapter(private val modules: Array<Module>) : RecyclerView.Adapter<ModulesRecyclerAdapter.ViewHolder>() {

    var onModuleClicked: ((module: Module) -> Unit)? = null

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.view_module_card, parent,false) as ConstraintLayout
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = modules[position]
        val context = holder.layout.context
        holder.layout.module.text = module.name
        if (module.lastGrade != null) {
            holder.layout.latest_grade.text = HtmlCompat.fromHtml(
                context.getString(R.string.latest_grade, module.lastGrade),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        } else {
            holder.layout.latest_grade.text = context.getString(R.string.no_grades)
            holder.layout.view_all_grades.isEnabled = false
        }

        holder.layout.view_all_grades.setOnClickListener {
            onModuleClicked?.invoke(module)
        }
    }

    override fun getItemCount() = modules.size
}