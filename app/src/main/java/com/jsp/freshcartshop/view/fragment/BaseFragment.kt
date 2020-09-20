package com.jsp.freshcartshop.view.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jsp.freshcartshop.R

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setFragmentLayout(inflater, container, savedInstanceState);
    }

    abstract fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

    fun getLoader(): Dialog {
        val loadingDialog = Dialog(requireContext())
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.setCancelable(false)
        loadingDialog.setContentView(R.layout.dialog_loader)
        loadingDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return loadingDialog
    }

    fun showError(message: String) {
        val errorDialog = Dialog(requireContext())
        errorDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        errorDialog.setCancelable(false)
        errorDialog.setContentView(R.layout.dialog_error)
        errorDialog.findViewById<TextView>(R.id.tvErrorDialog).text = message
        errorDialog.findViewById<Button>(R.id.btnErrorDialog).setOnClickListener{
            errorDialog.dismiss()
        }
        errorDialog.show()
    }
}