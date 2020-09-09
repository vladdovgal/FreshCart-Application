package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jsp.freshcartshop.R

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setFragmentLayout(inflater, container, savedInstanceState);
    }

    abstract fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

}