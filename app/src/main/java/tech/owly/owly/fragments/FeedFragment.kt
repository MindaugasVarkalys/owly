package tech.owly.owly.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_feed.*
import tech.owly.owly.R
import tech.owly.owly.adapters.FeedRecyclerAdapter
import tech.owly.owly.data.feed.Lecture
import tech.owly.owly.data.feed.Message

class FeedFragment : Fragment() {

    private val feedMessages = arrayOf(
            Lecture("Upcoming lecture - 15 min", "History of urban planning", "15:30", "311", "Students' str. 48, IX building"),
            Message("Labas", "Rytas", "Vakaras", "123", "4560252"),
            Message("Labas", "Rytas", "", "123", "4560252"),
            Message("Labas", "Rytas", "Vakaras", "123"),
            Message("Labas", "Rytas", "Vakaras", "123"),
            Message("Labas", "Rytas", "Vakaras", "123", "4560252"),
            Message("Labas", "Rytas", "", "123", "4560252"),
            Message("Labas", "Rytas", "Vakaras", "123"),
            Message("Labas", "Rytas", "Vakaras", "123"),
            Message("Labas", "Rytas", "Vakaras", "123", "4560252"),
            Message("Labas", "Rytas", "", "123", "4560252"),
            Message("Labas", "Rytas", "Vakaras", "123"),
            Message("Labas", "Rytas", "Vakaras", "123")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feed_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = FeedRecyclerAdapter(feedMessages)
        }
    }
}
