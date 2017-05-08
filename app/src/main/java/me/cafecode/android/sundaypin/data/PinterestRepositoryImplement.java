package me.cafecode.android.sundaypin.data;

import android.content.Context;
import android.util.Log;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Natthawut Hemathulin on 5/8/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class PinterestRepositoryImplement implements PinterestRepository {

    private Context mContext;

    public PinterestRepositoryImplement(Context context) {
        mContext = context;
    }

    @Override
    public void login(PDKCallback callback) {

        List<String> scopes = new ArrayList<>();
        scopes.add(PDKClient.PDKCLIENT_PERMISSION_READ_PUBLIC);
        scopes.add(PDKClient.PDKCLIENT_PERMISSION_WRITE_PUBLIC);

        PDKClient.getInstance().login(mContext, scopes, new PDKCallback() {

            @Override
            public void onSuccess(JSONObject response) {
                super.onSuccess(response);

                Log.i(TAG, response.toString());
            }

            @Override
            public void onFailure(PDKException exception) {
                super.onFailure(exception);

                Log.e(TAG, exception.getMessage());
            }

        });
    }

}
