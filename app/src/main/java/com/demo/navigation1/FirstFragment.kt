package com.demo.navigation1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        (activity as MainActivity).enableMenu()
        activity?.setTitle("First Fragment")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_open.setOnClickListener {
            Toast.makeText(context, "Open Second Fragment", Toast.LENGTH_SHORT).show()

            /*fragmentManager?.beginTransaction()!!
                .add(EmptyFragment(), null)
                .addToBackStack("empty")
                .commit()

            fragmentManager?.beginTransaction()!!
                .replace(R.id.fragment, SimpleFragment())
                .addToBackStack("simple")
                .commit() */

            fragmentManager?.beginTransaction()!!
                .replace(R.id.fragment, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    fun printName(name: String){
        Toast.makeText(context, "Welcome To $name", Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_help, menu)
    }



}
