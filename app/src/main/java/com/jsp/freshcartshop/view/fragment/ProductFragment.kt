package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.FragmentProductBinding
import com.jsp.freshcartshop.view.MainActivity
import com.jsp.freshcartshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ProductFragment : BaseFragment() {
    val mainViewModel by sharedViewModel<MainViewModel>()

    //    private val mainViewModel : MainViewModel = get()
    private lateinit var binding : FragmentProductBinding
    private var isToolbarBackgroundWhite = false


    override fun setFragmentLayout(inflater: LayoutInflater,
                                   container: ViewGroup?,
                                   savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        observeData()
        binding.product = mainViewModel.product.value
        binding.lifecycleOwner = this


        Log.d("myLogs", "Prodid ${arguments?.getInt("productId")}")
        // change toolbar background color
        switchToolbarBackgroundColor()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeData() {
        mainViewModel.loadProduct(arguments?.getInt("productId") ?: -1)
    }



    override fun onStop() {
        super.onStop()
        // switch back silver as Toolbar background color
        switchToolbarBackgroundColor()
    }


    private fun switchToolbarBackgroundColor() {
        if (!isToolbarBackgroundWhite) {
            context?.let { ContextCompat.getColor(it, R.color.colorWhite) }?.let {
                (activity as MainActivity).toolbar_wrapper.setCardBackgroundColor(
                    it
                )
            }
        } else {
            context?.let { ContextCompat.getColor(it, R.color.colorBackground) }?.let {
                (activity as MainActivity).toolbar_wrapper.setCardBackgroundColor(
                    it
                )
            }
        }
        isToolbarBackgroundWhite = !isToolbarBackgroundWhite
    }

}