package guaidaodl.github.io.toolbarcoloranimate.matchers;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Create by Guaidaodl
 */
public class CustomViewMatchers {
    public static Matcher<View> withBackgroundColor(String colorString) {
        int color = Color.parseColor(colorString);

        return withBackgroundColor(color);
    }

    public static Matcher<View> withBackgroundColor(final int color) {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            protected boolean matchesSafely(View view) {
                try {
                    ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();
                    return color == colorDrawable.getColor();
                } catch(ClassCastException e) {
                    return false;
                }
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with color : ")
                        .appendText(String.format("#%06X", 0xFFFFFF & color));
            }
        };
    }
}


