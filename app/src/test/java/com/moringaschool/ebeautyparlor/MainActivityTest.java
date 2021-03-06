package com.moringaschool.ebeautyparlor;

import android.content.Intent;
import android.widget.TextView;

import com.moringaschool.ebeautyparlor.ui.MainActivity;
import com.moringaschool.ebeautyparlor.ui.ParlorActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.TestCase.assertTrue;
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }
    @Test
    public void validateTextViewContent(){
        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
        assertTrue("eBeautyParlor".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findParlorButton).performClick();
        Intent expectedIntent = new Intent(activity, ParlorActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
