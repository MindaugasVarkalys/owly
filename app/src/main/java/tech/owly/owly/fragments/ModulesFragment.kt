package tech.owly.owly.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_modules.*
import tech.owly.owly.R
import tech.owly.owly.adapters.ModulesRecyclerAdapter
import tech.owly.owly.data.grades.Grade
import tech.owly.owly.data.grades.Module

class ModulesFragment : Fragment() {

    private val modules = arrayOf(
            Module("Architectural experiment", listOf(
                    Grade("Test 1", 9),
                    Grade("Test 2", 10),
                    Grade("Assignment 1", 9),
                    Grade("Test 3"),
                    Grade("Assignment 2"),
                    Grade("Exam")
            )),
            Module("History of urban planning", listOf(
                Grade("Test 1"),
                Grade("Test 2"),
                Grade("Assignment 1"),
                Grade("Test 3"),
                Grade("Assignment 2"),
                Grade("Exam")
            )),
            Module("Space syntax", listOf(
                Grade("Test 1", 9),
                Grade("Test 2", 10),
                Grade("Assignment"),
                Grade("Exam")
            )),
            Module("Dendrology", listOf(
                Grade("Test 1", 9),
                Grade("Test 2", 10),
                Grade("Assignment", 7),
                Grade("Exam", 8)
            )),
            Module("Building constructions", listOf(
                Grade("Test 1", 9),
                Grade("Test 2"),
                Grade("Assignment"),
                Grade("Exam")
            ))

    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_modules, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerAdapter = ModulesRecyclerAdapter(modules)
        recyclerAdapter.onModuleClicked = {
            val bundle = Bundle()
            bundle.putSerializable("module", it)
            val fragment = GradesFragment()
            fragment.arguments = bundle
            fragmentManager!!.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        modules_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }
    }


}
