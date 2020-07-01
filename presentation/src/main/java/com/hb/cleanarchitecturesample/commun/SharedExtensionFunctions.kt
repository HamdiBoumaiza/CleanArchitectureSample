package com.hb.cleanarchitecturesample.commun

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.hb.cleanarchitecturesample.baseui.BaseFragment
import kotlin.reflect.KClass


/**
 * extension function to hide keyboard in activity
 */
fun Activity.hideKeyboard() {
    if (currentFocus != null) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}

/**
 * extension function to hide keyboard in fragment
 */
fun Fragment.hideKeyboard() {
    if (activity?.currentFocus != null) {
        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus!!.windowToken, 0)
    }
}

/**
 * extension function to show keyboard in activity
 */
fun Activity.showKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

/**
 * extension function that creates an instance of a view model with viewModel factory
 */
fun <VM : ViewModel> FragmentActivity.viewModelProvider(
    provider: ViewModelProvider.Factory, model: KClass<VM>
) = ViewModelProvider(this, provider).get(model.java)

/**
 * extension function that creates an instance of a view model with viewModel factory from a fragment
 */
fun <VM : ViewModel> Fragment.viewModelProvider(
    provider: ViewModelProvider.Factory, model: KClass<VM>
) = ViewModelProvider(this, provider).get(model.java)

/**
 * extension function that listen to edit text changes and take a function as an action
 */
fun EditText.onChange(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            cb(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //TODO
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //TODO
        }
    })
}

/**
 * extension function that returns a view pager position and take a unit as a param
 */
fun ViewPager.addPageChangeListener(position: (Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            pos: Int, positionOffset: Float, positionOffsetPixels: Int
        ) {
            position(pos)
        }

        override fun onPageSelected(position: Int) {
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    })
}

/**
 * extension function for the Toast class that takes a string
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * extension function that make any view visible
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * extension function that make any view invisible
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}


/**
 * extension function that hide any view (gone)
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * extension function to replace fragment
 */
fun AppCompatActivity.replaceFragment(
    fragment: BaseFragment,
    container: Int,
    addToBackStack: Boolean = false
) {
    fragment.activity?.hideKeyboard()
    val className = fragment.javaClass.name
    val fragmentTransaction = supportFragmentManager
        .beginTransaction()
        .replace(container, fragment, className)
    if (addToBackStack) {
        fragmentTransaction.addToBackStack(className)
    }
    fragmentTransaction.commit()
}

/**
 * extension function to add fragment
 */
fun AppCompatActivity.addFragment(fragment: BaseFragment, container: Int) {
    fragment.activity?.hideKeyboard()
    val className = fragment.javaClass.name
    supportFragmentManager
        .beginTransaction()
        .add(container, fragment, className)
        .commit()
}