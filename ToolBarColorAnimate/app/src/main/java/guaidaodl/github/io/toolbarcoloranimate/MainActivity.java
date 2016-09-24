package guaidaodl.github.io.toolbarcoloranimate;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAB";
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setBackgroundColor(Color.parseColor("#FF0000"));

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF0000")));

        mTabLayout = (TabLayout) findViewById(R.id.content_main_tab);
        mTabLayout.addOnTabSelectedListener(new ColorChangeListener());
        mTabLayout.setBackgroundColor(Color.parseColor("#FF0000"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ColorChangeListener implements TabLayout.OnTabSelectedListener {
        private int lastPostion = 0;
        private int[] colors = {Color.parseColor("#FF0000"), Color.parseColor("#00FF00"),
                                Color.parseColor("#0000FF")};
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            changeColor(colors[lastPostion], colors[position]);
        }

        private void changeColor(int fromColor, int toColor) {
            ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), fromColor, toColor);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int color = (int)animation.getAnimatedValue();
                    mToolbar.setBackgroundColor(color);
                    mTabLayout.setBackgroundColor(color);
                    mFab.setBackgroundTintList(ColorStateList.valueOf(color));
                    getWindow().setStatusBarColor(color);
                }
            });
            animator.start();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            lastPostion = tab.getPosition();
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }

    }
}
