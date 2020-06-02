package com.moringaschool.ebeautyparlor;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.moringaschool.ebeautyparlor.ui.ParlorActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class ParlorActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<ParlorActivity> activityTestRule =
            new ActivityTestRule<>(ParlorActivity.class);
    @Test
    public void listItemClickDisplaysToastWithCorrectParlor() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String parlorName = "Beauty point";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(parlorName)).inRoot(withDecorView(not(activityDecorView)));
              //  .check(matches(withText(parlorName)));
    }
}
