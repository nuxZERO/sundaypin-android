package me.cafecode.android.sundaypin.login;

/**
 * Created by Natthawut Hemathulin on 4/23/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public interface LoginContract {

    interface View {

        void gotoBottomNavigationActivity();

        void showAuthenticationErrorView();

    }

    interface ActionsListener {

        void start();

        void stop();

        void login();

        boolean isLoggedIn();
    }

}
