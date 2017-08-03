package team.chronus.amona.data.remote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import team.chronus.amona.data.AppDataSource;
import team.chronus.amona.data.local.prefs.PreferencesHelper;
import team.chronus.amona.data.model.Event;
import team.chronus.amona.utils.AppLogger;
import team.chronus.amona.utils.RxUtils;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class AppRemoteDataSource implements AppDataSource {

    private final AppService mService;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppRemoteDataSource(AppService service, PreferencesHelper preferencesHelper) {
        mService = service;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Observable<List<Event>> getRecommendedEvents() {
        return mService
                .loadRecommendedEventsFromServer(mPreferencesHelper.getAccesToken())
                .compose(RxUtils.applySchedulers())
                .doOnSubscribe(disposable -> AppLogger.d("Sync started..."))
                .doOnError(throwable -> AppLogger.d("Sync failed!"))
                .doOnComplete(() -> AppLogger.d("Sync completed."));
    }


    @Override
    public Observable<List<Event>> getSelfEvents() {
        return mService
                .loadSelfEventsFromServer(mPreferencesHelper.getAccesToken())
                .compose(RxUtils.applySchedulers())
                .doOnSubscribe(disposable -> AppLogger.d("Sync started..."))
                .doOnError(throwable -> AppLogger.d("Sync failed!"))
                .doOnComplete(() -> AppLogger.d("Sync completed."));
    }



    @Override
    public void saveRecommendedEvents(List<Event> events) {
        throw new UnsupportedOperationException("saveRecommendedEvents in AppRemoteDataSource is not implemented!");
    }


    @Override
    public void saveSelfEvents(List<Event> events) {
        throw new UnsupportedOperationException("saveSelfEvents in AppRemoteDataSource is not implemented!");
    }


}
