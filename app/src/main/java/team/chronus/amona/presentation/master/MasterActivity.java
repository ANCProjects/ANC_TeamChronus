package team.chronus.amona.presentation.master;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.presentation.base.BaseActivity;

public class MasterActivity extends BaseActivity implements MasterMvpView {

    @Inject
    MasterMvpPresenter<MasterMvpView> mPresenter;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MasterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(MasterActivity.this);
        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
    //no call to setUp()?
    //should presenter be calling setUp() after the view has been attached
    @Override
    protected void setUp() {
        //check to see if activity is already hosting fragment
        Fragment masterFragment = new MasterFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.master_fragment_container, masterFragment)
                .commit();
    }

}
