package tech.owly.owly.fragments

import android.annotation.TargetApi
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_assistant.*
import tech.owly.owly.R
import tech.owly.owly.adapters.AssistantRecyclerAdapter
import java.util.*


class AssistantFragment : Fragment(), TextToSpeech.OnInitListener {

    private val assistantAdapter = AssistantRecyclerAdapter()
    private lateinit var tts: TextToSpeech

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_assistant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messages_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = assistantAdapter
        }

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        speak.setOnClickListener {
            speak.visibility = View.GONE
            assistant_speaking.visibility = View.VISIBLE

            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US)
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.ask_assistant))
            startActivityForResult(intent, 1)
        }

        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        val message = getString(R.string.first_message)
        say(message)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun say(message: String) {
        assistantAdapter.addMessage(message)
        messages_list.scrollToPosition(assistantAdapter.itemCount - 1)
        tts.language = Locale.US
        tts.setOnUtteranceProgressListener(object: UtteranceProgressListener() {
            override fun onDone(utteranceId: String?) {
                activity?.runOnUiThread {
                    speak.visibility = View.VISIBLE
                    assistant_speaking.visibility = View.GONE
                }
            }

            override fun onError(utteranceId: String?) {
            }
            override fun onStart(utteranceId: String?) {
            }
        })
        tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, "1")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && data != null) {
            val userMessage = data.getStringExtra("query").capitalize()
            assistantAdapter.addMessage(userMessage)
            messages_list.scrollToPosition(assistantAdapter.itemCount - 1)

            val botMessage = getResponse(userMessage)
            say(botMessage)
        } else {
            speak.visibility = View.VISIBLE
            assistant_speaking.visibility = View.GONE
        }
    }

    private fun getResponse(message: String): String {
        val words = message.toLowerCase().split(' ', ignoreCase = true)
        return when {
            containsWords(words, "what", "lecture") -> "Your next lecture is History of urban planning."
            containsWords(words, "when", "lecture") -> "Your next lecture starts in 15 minutes. It's history of urban planning in Students' street 48, 9 building at room 311."
            containsWords(words,"where", "lecture") -> "Your lecture is in Students' street 48, 9 building at room 311."
            containsWords(words, "navigation") -> { startNavigation(); "Here you go!" }
            containsWords(words, "do", "have", "lectures") -> "Yes, you do."
            containsWords(words, "deadline") -> "The deadline was on 21st October 9 a.m. You are 3 hours late."
            containsWords(words, "average") -> "Your average grade is 9.2"
            containsWords(words, "unread", "emails") -> "You have 2 unread emails."
            containsWords(words, "canceled") -> "No, your professors did not report any canceled lectures so far."
            else -> "Don't ask difficult questions. I am just a chatbot."
        }
    }

    private fun containsWords(array: List<String>, vararg words: String): Boolean {
        for (word in words) {
            if (!array.contains(word)) {
                return false
            }
        }
        return true
    }

    private fun startNavigation() {
        val intent = Intent(
            android.content.Intent.ACTION_VIEW,
            Uri.parse("https://maps.google.com/maps?daddr=54.9059489,23.9539329")
        )
        startActivity(intent)
    }

}
