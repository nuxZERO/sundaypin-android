package me.cafecode.android.sundaypin;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.cafecode.android.sundaypin.login.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Natthawut Hemathulin on 5/8/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(AndroidJUnit4.class)
public class LoginScreenTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() {

    }

    @Test
    public void login_whenPressLoginThenOpenAuthenticationOnBrowser() {
        // Give

        // When
        onView(withId(R.id.login_button)).perform(click());

        // Then

    }

}
