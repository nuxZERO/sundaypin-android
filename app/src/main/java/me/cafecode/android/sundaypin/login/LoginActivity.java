package me.cafecode.android.sundaypin.login;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pinterest.android.pdk.PDKClient;

import me.cafecode.android.sundaypin.R;
import me.cafecode.android.sundaypin.configuration.Environment;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Log.i(TAG, "onCreate()");

        // Pinterest configure
        PDKClient.configureInstance(this, Environment.APP_ID);
        PDKClient.getInstance().onConnect(this);

        if (savedInstanceState == null) {
            initFragment(LoginFragment.getInstance());
        } else {
            Log.i(TAG, savedInstanceState.getString("state"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause()");

        super.onPause();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");

        outState.putString("state", "save stated");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i(TAG, "onRestoreInstanceState()");

    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop()");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy()");

        super.onDestroy();
    }

    private void initFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.login_content, fragment)
                .commit();
    }

}
