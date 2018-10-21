package tech.owly.owly.adapters

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_message.view.*
import tech.owly.owly.R

class AssistantRecyclerAdapter : RecyclerView.Adapter<AssistantRecyclerAdapter.ViewHolder>() {

    private val messages = mutableListOf<String>()

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.view_message, parent,false) as ConstraintLayout
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val botMessage = position % 2 == 0
        if (botMessage) {
            holder.layout.bot_message.visibility = View.VISIBLE
            holder.layout.user_message.visibility = View.GONE
            holder.layout.bot_message.text = messages[position]
        } else {
            holder.layout.bot_message.visibility = View.GONE
            holder.layout.user_message.visibility = View.VISIBLE
            holder.layout.user_message.text = messages[position]
        }
    }

    override fun getItemCount() = messages.size

    public fun addMessage(message: String) {
        messages.add(message)
        notifyItemInserted(messages.size)
    }
}