package team.chronus.amona.presentation.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.data.local.prefs.PreferencesHelper;
import team.chronus.amona.presentation.base.BaseActivity;
import team.chronus.amona.presentation.master.MasterActivity;

public class AuthActivity extends BaseActivity implements AuthMvpView {

    @Inject
    AuthMvpPresenter<AuthMvpView> mPresenter;

    PreferencesHelper mPref;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, AuthActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(AuthActivity.this);

        //Get the Meetup Tokens
        mPref = new PreferencesHelper(getApplicationContext());
        mPref.deleteAccesToken();
        mPref.deleteExpiresIn();
        mPref.deleteRefreshToken();

        LaunchIntent();
    }

    public void LaunchIntent() {
        Intent intent = new Intent(this, MeetupAuth.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK){
            if(data != null) {
                String access_token = data.getExtras().getString("access_token");
                String refresh_token = data.getExtras().getString("refresh_token");
                String expires_in = data.getExtras().getString("expires_in");

                mPref = new PreferencesHelper(getApplicationContext());
                mPref.deleteAccesToken();
                mPref.deleteExpiresIn();
                mPref.deleteRefreshToken();

                mPref.saveRefreshToken(access_token);
                mPref.saveRefreshToken(refresh_token);
                mPref.saveExpiresIn(expires_in);

                //mPref.saveAccesToken(access_token);
               // mPref.saveExpiresIn(expires_in);
               // mPref.saveRefreshToken(refresh_token);

                //Move to another Activity here

                Intent intent = new Intent(AuthActivity.this, MasterActivity.class);
                startActivity(intent);
            }
            else{
                Log.d("Amona: ","Data is null");
            }
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
