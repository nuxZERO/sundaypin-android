package me.cafecode.android.sundaypin.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import me.cafecode.android.sundaypin.R;

public class LoginFragment extends Fragment implements View.OnClickListener, LoginContract.View {

    private LoginPresenter mActionsLisnter;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionsLisnter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = (Button) rootView.findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login_button:
                mActionsLisnter.login();
                break;
        }
    }

    public static Fragment getInstance() {
        return new LoginFragment();
    }
}
