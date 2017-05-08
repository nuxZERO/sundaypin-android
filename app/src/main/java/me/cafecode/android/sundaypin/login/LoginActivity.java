package me.cafecode.android.sundaypin.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.pinterest.android.pdk.PDKClient;

import me.cafecode.android.sundaypin.R;
import me.cafecode.android.sundaypin.configuration.Environment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Pinterest configure
        PDKClient.configureInstance(this, Environment.APP_ID);
        PDKClient.getInstance().onConnect(this);

        if (savedInstanceState == null) {
            initFragment(LoginFragment.getInstance());
        }
    }

    private void initFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.login_content, fragment)
                .commit();
    }

}
