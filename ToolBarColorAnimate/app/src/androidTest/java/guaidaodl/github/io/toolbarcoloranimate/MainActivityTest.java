package guaidaodl.github.io.toolbarcoloranimate;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import guaidaodl.github.io.toolbarcoloranimate.matchers.FloatingActionButtonMatchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static guaidaodl.github.io.toolbarcoloranimate.matchers.CustomViewMatchers.withBackgroundColor;

/**
 * Created by linyb on 24/09/2016.
 */

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testColorChange() throws Exception {
        Matcher<View> toolbar = withId(R.id.toolbar);
        Matcher<View> tab = withId(R.id.content_main_tab);
        Matcher<View> fab = withId(R.id.fab);

        String greenColor = "#00FF00";
        onView(withText("Green")).perform(click());
        onView(toolbar).check(matches(withBackgroundColor(greenColor)));
        onView(tab).check(matches(withBackgroundColor(greenColor)));
        onView(fab).check(matches(FloatingActionButtonMatchers.withDefaultColor(greenColor)));

        String blueColor = "#0000FF";
        onView(withText("Blue")).perform(click());
        onView(toolbar).check(matches(withBackgroundColor(blueColor)));
        onView(tab).check(matches(withBackgroundColor(blueColor)));
        onView(fab).check(matches(FloatingActionButtonMatchers.withDefaultColor(blueColor)));

        String redColor = "#FF0000";
        onView(withText("Red")).perform(click());
        onView(toolbar).check(matches(withBackgroundColor(redColor)));
        onView(tab).check(matches(withBackgroundColor(redColor)));
        onView(fab).check(matches(FloatingActionButtonMatchers.withDefaultColor(redColor)));
    }
}
