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
import tech.owly.owly.data.grades.Module

class GradesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val module = arguments!!.getSerializable("module") as Module
        module_name.text = module.name
        average.text = context!!.getString(R.string.average, module.average)

        grades_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = GradesRecyclerAdapter(module)
        }

        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
}
