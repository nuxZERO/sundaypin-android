package me.cafecode.android.sundaypin.data;

import android.content.Context;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;

import java.util.ArrayList;
import java.util.List;

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
    public void login(final PDKCallback callback) {

        List<String> scopes = new ArrayList<>();
        scopes.add(PDKClient.PDKCLIENT_PERMISSION_READ_PUBLIC);
        scopes.add(PDKClient.PDKCLIENT_PERMISSION_WRITE_PUBLIC);

        PDKClient.getInstance().login(mContext, scopes, new PDKCallback() {

            @Override
            public void onSuccess(PDKResponse response) {
                super.onSuccess(response);

                callback.onSuccess(response);
            }

            @Override
            public void onFailure(PDKException exception) {
                super.onFailure(exception);

                callback.onFailure(exception);
            }
        });
    }

}
