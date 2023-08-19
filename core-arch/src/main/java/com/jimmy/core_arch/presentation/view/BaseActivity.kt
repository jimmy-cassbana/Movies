package com.jimmy.core_arch.presentation.view

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * This base contains the common behavior related to any activity
 */
abstract class BaseActivity : AppCompatActivity() {
    val notNeededLayoutResId = -1

    abstract fun getLayoutResId(): Int
    abstract fun getToolBar(): Toolbar?
    open fun init() = Unit
    open fun subscribe() = Unit

    fun getRootView(): View {
        val viewGroup = this.findViewById(android.R.id.content) as ViewGroup
        return viewGroup.getChildAt(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutResId() != notNeededLayoutResId) {
            setContentView(getLayoutResId())
            handleToolBar()
            init()
            subscribe()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun AppCompatActivity.handleToolBar() {
        getToolBar()?.let { toolbar ->
            setSupportActionBar(toolbar)
        }
    }

    fun setScreenTitle(text: String) {
        supportActionBar?.title = text
    }


}