package com.blundell.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;

/**
 * https://code.google.com/p/android-test-kit/wiki/EspressoStartGuide
 * http://developer.android.com/reference/android/test/ActivityInstrumentationTestCase2.html
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 * <p/>
 * Below I have purposefully not included static imports so you can see exactly what classes are in use.
 * For readability once the below is understood I would use static imports
 */
public class EspressoTest extends ActivityInstrumentationTestCase2<MyActivity> {
    public EspressoTest() {
        super(MyActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testEspressoClickingListViewPopulatesTextView() {
        //Given the ListView is populated
        Espresso.onView(ViewMatchers.withId(R.id.my_button)).perform(ViewActions.click());

        // When I click on the an item in the ListView
        Espresso.onData(Matchers.allOf(Matchers.is(
                Matchers.instanceOf(String.class)), Matchers.is("Grape")))
                .perform(ViewActions.click());

        // Then the TextView shows the correct text
        Espresso.onView(ViewMatchers.withId(R.id.my_hello_text_view))
                .check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Grape"))));
    }
}
