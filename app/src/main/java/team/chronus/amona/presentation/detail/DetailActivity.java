package team.chronus.amona.presentation.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.presentation.base.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailMvpView {

    @Inject
    DetailMvpPresenter<DetailMvpView> mPresenter;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(DetailActivity.this);
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
