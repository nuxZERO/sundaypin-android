package me.cafecode.android.sundaypin.data;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by Natthawut Hemathulin on 5/9/2017 AD.
 * Email: natthawut1991@gmail.com
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class PreferenceManagerTest {

    private PreferenceManager mPreferenceManager;

    private SharedPreferences sharedPreferences;

    @Before
    public void setUp() throws Exception {
        sharedPreferences = RuntimeEnvironment.application.getSharedPreferences(anyString(), anyInt());
        mPreferenceManager = new PreferenceManager(sharedPreferences);
        assertNotNull(mPreferenceManager);
    }

    @Test
    public void setLoggedIn_canSetLoggedInToTrue() throws Exception {
        mPreferenceManager.setLoggedIn(true);
        assertTrue(sharedPreferences.getBoolean(PreferenceManager.LOGGED_IN, false));
    }

}
