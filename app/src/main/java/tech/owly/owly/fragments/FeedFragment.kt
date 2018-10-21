package tech.owly.owly.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
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

        assistant_button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(context!!, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.RECORD_AUDIO), 1)
            } else {
                openAssistant()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openAssistant()
        }
    }

    private fun openAssistant() {
        fragmentManager!!.beginTransaction()
            .replace(R.id.fragment_container, AssistantFragment())
            .addToBackStack(null)
            .commit()
    }
}
