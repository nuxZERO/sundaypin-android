package me.cafecode.android.sundaypin.login;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKResponse;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import me.cafecode.android.sundaypin.data.PinterestRepository;

import static org.mockito.Mockito.verify;

/**
 * Created by Natthawut Hemathulin on 5/7/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Captor
    ArgumentCaptor<PDKCallback> mAuthenticationCallbackCaptor;
    private LoginPresenter mPresenter;
    @Mock
    private LoginContract.View mLoginView;

    @Mock
    private PinterestRepository mPinterestRepository;

    @Before
    public void setUp() {
        mPresenter = new LoginPresenter(mPinterestRepository, mLoginView);
    }

    @Test
    public void login_whenLoginSuccessThenGotoMainActivity() throws Exception {

        // Give
        PDKResponse response = new PDKResponse(new JSONObject("{\"data\":{\"url\":\"https:\\/\\/www.pinterest.com\\/nuxzero\\/\",\"first_name\":\"Natthawut\",\"last_name\":\"Hemathulin\",\"id\":\"563935321998234361\"}}"));

        // When
        mPresenter.login();

        // Capture
        verify(mPinterestRepository).login(mAuthenticationCallbackCaptor.capture());
        mAuthenticationCallbackCaptor.getValue().onSuccess(response);

        // Then
        verify(mLoginView).gotoMainActivity();
    }

}
