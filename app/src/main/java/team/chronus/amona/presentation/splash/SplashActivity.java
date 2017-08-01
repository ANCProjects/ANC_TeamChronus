package team.chronus.amona.presentation.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.data.local.prefs.PreferencesHelper;
import team.chronus.amona.presentation.auth.AuthActivity;
import team.chronus.amona.presentation.base.BaseActivity;
import team.chronus.amona.presentation.master.MasterActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);

        check_status();
    }

    public void check_status(){
        PreferencesHelper mPref = new PreferencesHelper(getApplicationContext());
        if((mPref.getExpiresIn() != null) && (mPref.getAccesToken() != null) && (mPref.getRefreshToken() != null)){
            openMasterActivity();
        }
        else{
            openAuthActivity();
        }
    }

    @Override
    public void openMasterActivity() {
        startActivity(MasterActivity.getStartIntent(SplashActivity.this));
        finish();
    }

    @Override
    public void openAuthActivity(){
        startActivity(AuthActivity.getStartIntent(SplashActivity.this));
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
