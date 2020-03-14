package com.demo.navigation1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).disableMenu()
        activity?.setTitle("Second Fragment")
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val firstFragment = fragmentManager?.findFragmentByTag("first")
        (firstFragment as FirstFragment).printName("Korsós Richárd")
        fragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        return true
    }


}
