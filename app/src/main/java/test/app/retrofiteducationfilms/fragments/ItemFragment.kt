package test.app.retrofiteducationfilms.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import test.app.retrofiteducationfilms.R

class ItemFragment : Fragment() {

    companion object {
        fun newInstance(): ItemFragment {
            return ItemFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val mInflater = inflater.inflate(R.layout.fragment_item, container, false)

        return mInflater
    }

}