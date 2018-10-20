package tech.owly.owly.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_grades.*
import tech.owly.owly.R
import tech.owly.owly.adapters.GradesRecyclerAdapter
import tech.owly.owly.data.grades.Grade
import tech.owly.owly.data.grades.Module

class GradesFragment : Fragment() {

    private val modules = arrayOf(
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1", 9),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            )),
            Module("Architectural experiment", listOf(
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1"),
                    Grade("Test 1")
            ))
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        grades_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = GradesRecyclerAdapter(modules)
        }
    }
}
