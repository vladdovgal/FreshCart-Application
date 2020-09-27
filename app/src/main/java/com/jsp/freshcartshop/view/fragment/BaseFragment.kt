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
import androidx.lifecycle.Observer
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    protected abstract val viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setFragmentLayout(inflater, container, savedInstanceState);
    }

    abstract fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun getLoader(): Dialog {
        val loadingDialog = Dialog(requireContext())
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.setCancelable(false)
        loadingDialog.setContentView(R.layout.dialog_loader)
        loadingDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return loadingDialog
    }

    private fun showError(message: String) {
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

    private fun observeData() {
        val loader = getLoader()

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) {
                loader.show()
            } else {
                loader.dismiss()
            }
        })

        viewModel.errorMessageData.observe(viewLifecycleOwner, Observer { message ->
            if (message != null) {
                showError(message)
            }
        })
    }
}