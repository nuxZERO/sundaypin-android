package me.cafecode.android.sundaypin.login;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;

import me.cafecode.android.sundaypin.data.PinterestRepository;

/**
 * Created by Natthawut Hemathulin on 4/23/2017 AD.
 * Email: natthawut1991@gmail.com
 */

class LoginPresenter implements LoginContract.ActionsListener {

    private PinterestRepository mRepository;
    private LoginContract.View mView;

    public LoginPresenter(PinterestRepository repository, LoginContract.View view) {
        mRepository = repository;
        mView = view;
    }

    @Override
    public void login() {
        mRepository.login(new PDKCallback() {
            @Override
            public void onSuccess(PDKResponse response) {
                super.onSuccess(response);

                mView.gotoMainActivity();
            }

            @Override
            public void onFailure(PDKException exception) {
                super.onFailure(exception);
            }
        });
    }

}
