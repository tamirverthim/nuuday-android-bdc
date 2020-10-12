package music.core.composition.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nuuday.android.bcc.fragments.behavior.FragmentBehaviour

interface IBehaviorDrivenFragment {

    val behaviours: MutableList<FragmentBehaviour>

    fun sendOnCreate(savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.onCreate(savedInstanceState)
        }
    }

    fun tryView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        behaviours.forEach {
            val view = it.onCreateViewBehavior(inflater, container, savedInstanceState)
            if (view != null) {
                return view
            }
        }
        return null
    }

    fun sendOnViewStateRestored(savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.onViewStateRestored(savedInstanceState)
        }
    }

    fun sendOnViewCreated(view: View, savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.sendOnViewCreated(view, savedInstanceState)
        }
    }

    fun sendOnResume() {
        behaviours.forEach {
            it.onResume()
        }
    }

    fun sendOnPause() {
        behaviours.forEach {
            it.onPause()
        }
    }

    fun sendOnDestroyAndTerminateBehaviors() {
        behaviours.forEach {
            it.onDestroy()
        }
    }

    fun sendOnStart() {
        behaviours.forEach {
            it.onStart()
        }
    }

    fun sendOnStop() {
        behaviours.forEach {
            it.onStop()
        }
    }
}