package team.chronus.amona.presentation.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.data.model.Event;
import team.chronus.amona.presentation.base.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailMvpView {

    @Inject
    DetailMvpPresenter<DetailMvpView> mPresenter;

    private static final String EVENT_EXTRA = "Event_To_Open";

    @BindView(R.id.meet_up_name)
    TextView meetUpName;

    @BindView(R.id.meet_up_address)
    TextView meetUpAddress;

    @BindView(R.id.long_event_desc)
    TextView longDescription;

    public static Intent getStartIntent(Context context, Event event) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EVENT_EXTRA, event);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(DetailActivity.this);
        setUp();
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        Event event = (Event) getIntent().getSerializableExtra(EVENT_EXTRA);

        double lat = event.venue().lat();
        double lon = event.venue().lon();

        Fragment mapFragment = DetailFragment.newInstance(lat, lon);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.map_container, mapFragment)
                .commit();

        meetUpName.setText(event.name());

        meetUpAddress.setText(event.how_to_find_us());

        longDescription.setText(event.description());
    }
}
