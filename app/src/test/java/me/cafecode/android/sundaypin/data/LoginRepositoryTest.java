package me.cafecode.android.sundaypin.data;

import android.content.Context;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKResponse;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.verify;

/**
 * Created by Natthawut Hemathulin on 5/9/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class LoginRepositoryTest {

    private PinterestRepositoryImplement mRepository;

    @Mock
    PinterestRepository mRepositoryDataSource;

    @Mock
    PDKCallback mLoginCallback;

    private Context mContext = RuntimeEnvironment.application;

    @Before
    public void setUp() {
        if (mRepository == null) {
            mRepository = new PinterestRepositoryImplement(mContext);
        }
    }

    @After
    public void tearDown() {
        mRepository = null;
    }

    @Test
    public void isAuthenticated_whenLoginSuccessThenReturnTrue() throws Exception {

        // Give
        PDKResponse response = new PDKResponse(new JSONObject("{\"data\":{\"url\":\"https:\\/\\/www.pinterest.com\\/nuxzero\\/\",\"first_name\":\"Natthawut\",\"last_name\":\"Hemathulin\",\"id\":\"563935321998234361\"}}"));

        // When
        mRepository.login(mLoginCallback);

        // Then
        verify(mRepositoryDataSource).login(mLoginCallback);
    }

}
