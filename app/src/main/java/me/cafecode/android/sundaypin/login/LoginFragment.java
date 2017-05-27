package me.cafecode.android.sundaypin.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.pinterest.android.pdk.PDKClient;

import me.cafecode.android.sundaypin.R;
import me.cafecode.android.sundaypin.data.PinterestRepository;
import me.cafecode.android.sundaypin.data.PinterestRepositoryImplement;
import me.cafecode.android.sundaypin.data.PreferenceManager;

public class LoginFragment extends Fragment implements View.OnClickListener, LoginContract.View {

    private LoginPresenter mActionsListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager preferences = new PreferenceManager(getContext().getSharedPreferences("sundaypin", Context.MODE_PRIVATE));
        PinterestRepository repository = new PinterestRepositoryImplement(getContext());

        mActionsListener = new LoginPresenter(preferences, repository, this);
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
    public void onResume() {
        super.onResume();

        mActionsListener.start();
    }

    @Override
    public void onPause() {
        super.onPause();

        mActionsListener.stop();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login_button:
                mActionsListener.login();
                break;
        }
    }

    public static Fragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public void gotoBottomNavigationActivity() {

    }

    @Override
    public void showAuthenticationErrorView() {
        Toast.makeText(getContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        PDKClient.getInstance().onOauthResponse(requestCode, resultCode, data);
    }
}
