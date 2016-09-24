package guaidaodl.github.io.toolbarcoloranimate.matchers;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by Guaidaodl
 */
public class FloatingActionButtonMatchers {
    public static Matcher<View> withDefaultColor(String colorString) {
        int color = Color.parseColor(colorString);

        return withDefaultColor(color);
    }

    private static Matcher<View> withDefaultColor(final int color) {
        return new BoundedMatcher<View, FloatingActionButton>(FloatingActionButton.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("with default color : ")
                        .appendText(String.format("#%06X", 0xFFFFFF & color));
            }

            @Override
            protected boolean matchesSafely(FloatingActionButton item) {
                return item.getBackgroundTintList() != null
                        && item.getBackgroundTintList().getDefaultColor() == color;
            }
        };
    }
}
