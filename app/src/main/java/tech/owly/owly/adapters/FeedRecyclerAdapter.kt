package tech.owly.owly.adapters

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_feed_card.view.*
import kotlinx.android.synthetic.main.view_feed_lecture_card.view.*
import kotlinx.android.synthetic.main.view_feed_message_card.view.*
import tech.owly.owly.R
import tech.owly.owly.data.feed.Lecture
import tech.owly.owly.data.feed.Message


class FeedRecyclerAdapter(private val messages : Array<Message>) : RecyclerView.Adapter<FeedRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.view_feed_card, parent, false) as ConstraintLayout
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        if (message is Lecture) {
            setupLectureMessage(holder.layout, message)
        } else {
            setupMessageLines(holder.layout, message)
            setupMessageButtons(holder.layout, message)
        }
    }

    private fun setupMessageLines(layout: ConstraintLayout, message: Message) {
        layout.lecture_card.visibility = View.GONE
        layout.message_card.visibility = View.VISIBLE

        layout.line1.text = message.firstLine
        layout.line2.text = message.secondLine
        layout.line3.text = message.thirdLine
        layout.line3.visibility = if (message.thirdLine.isNotEmpty()) View.VISIBLE else View.GONE
    }

    private fun setupMessageButtons(layout: ConstraintLayout, message: Message) {
        layout.button1.text = message.firstButton
        layout.button2.text = message.secondButton
        layout.button2.visibility = if (message.secondButton.isNotEmpty()) View.VISIBLE else View.GONE
    }

    private fun setupLectureMessage(layout: ConstraintLayout, lecture: Lecture) {
        layout.lecture_card.visibility = View.VISIBLE
        layout.message_card.visibility = View.GONE

        layout.lecture_upcoming.text = lecture.title
        layout.lecture_module.text = lecture.module
        layout.lecture_time.text = lecture.time
        layout.lecture_room.text = lecture.room
        layout.lecture_location.text = lecture.address
    }

    override fun getItemCount() = messages.size
}