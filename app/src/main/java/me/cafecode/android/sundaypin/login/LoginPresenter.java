package me.cafecode.android.sundaypin.login;

/**
 * Created by Natthawut Hemathulin on 4/23/2017 AD.
 * Email: natthawut1991@gmail.com
 */

class LoginPresenter implements LoginContract.ActionsListener {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void login() {

    }

}
