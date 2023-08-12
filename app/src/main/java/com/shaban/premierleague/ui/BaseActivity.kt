package com.shaban.premierleague.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    abstract val LOG_TAG: String
    abstract val bindingInflater: (LayoutInflater) -> VB

    private var _binding: VB? = null
    protected val binding: VB
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(binding.root)

        setup()
        addCallBacks()
    }

    abstract fun setup()

    abstract fun addCallBacks()

    protected fun log(value: Any) = Log.i(LOG_TAG, value.toString())

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}