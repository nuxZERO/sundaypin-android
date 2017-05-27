package me.cafecode.android.sundaypin.login;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;

import me.cafecode.android.sundaypin.data.PinterestRepository;
import me.cafecode.android.sundaypin.data.PreferenceManager;
import me.cafecode.android.sundaypin.data.PreferenceManagerInterface;

/**
 * Created by Natthawut Hemathulin on 4/23/2017 AD.
 * Email: natthawut1991@gmail.com
 */

class LoginPresenter implements LoginContract.ActionsListener {

    private PreferenceManagerInterface mPreferences;

    private PinterestRepository mRepository;

    private LoginContract.View mView;

    public LoginPresenter(PreferenceManagerInterface preferences, PinterestRepository repository, LoginContract.View view) {
        mPreferences = preferences;
        mRepository = repository;
        mView = view;
    }

    @Override
    public void start() {

        if (isLoggedIn()) {
            mView.gotoBottomNavigationActivity();
        }

    }

    @Override
    public void stop() {

    }

    @Override
    public void login() {
        mRepository.login(new PDKCallback() {
            @Override
            public void onSuccess(PDKResponse response) {
                super.onSuccess(response);

                mView.gotoBottomNavigationActivity();
            }

            @Override
            public void onFailure(PDKException exception) {
                super.onFailure(exception);

                mView.showAuthenticationErrorView();
            }
        });
    }

    @Override
    public boolean isLoggedIn() {

        return mPreferences.isLoggedIn();
    }

}
