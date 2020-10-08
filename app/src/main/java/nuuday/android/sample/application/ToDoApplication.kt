package nuuday.android.sample.application

import music.core.composition.application.BehaviorDrivenApplication
import nuuday.android.sample.application.behavior.StartDebugStrictModeApplicationBehavior
import nuuday.android.sample.application.behavior.StartTimberApplicationBehavior
import nuuday.android.sample.applications.behavior.addAll

/**
 * Has your application class grown into a long and strange list of copy-pasted initializations
 * of strange sdks and libraries?
 *
 * Isolate your initializations into behaviors and use the power of composition
 */
class ToDoApplication : BehaviorDrivenApplication() {

    init {
        behaviours.addAll(
            StartTimberApplicationBehavior(),
            StartDebugStrictModeApplicationBehavior()
        )
    }

}
