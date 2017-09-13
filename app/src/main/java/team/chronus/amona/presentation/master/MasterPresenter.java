package team.chronus.amona.presentation.master;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import team.chronus.amona.data.AppRepository;
import team.chronus.amona.presentation.base.BasePresenter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */


public class MasterPresenter <V extends MasterMvpView> extends BasePresenter<V>
        implements MasterMvpPresenter<V> {

    private static final String TAG = "MasterPresenter";
    private MasterActivity activity;

    @Inject
    public MasterPresenter(AppRepository appRepository,
                           CompositeDisposable compositeDisposable) {
        super(appRepository, compositeDisposable);

        activity = (MasterActivity) getMvpView();
    }


    @Override
    public void loadEvents() {
        getAppRepository().getRecommendedEvents().subscribe(
                events -> {
                    activity.setEventList(events);
                    activity.update();
                    Log.d(TAG, "Events loaded successfully");
                },

                throwable -> Log.d(TAG, "Error Loading Events", throwable)
        );
    }
}