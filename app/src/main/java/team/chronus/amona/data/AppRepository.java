package team.chronus.amona.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import team.chronus.amona.data.local.prefs.PreferencesHelper;
import team.chronus.amona.data.model.Event;
import team.chronus.amona.di.ApplicationContext;
import team.chronus.amona.di.Local;
import team.chronus.amona.di.Remote;
import team.chronus.amona.utils.RxUtils;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Singleton
public class AppRepository implements AppDataSource {

    private final Context mContext;
    private final AppDataSource mAppRemoteDataSource;
    private final AppDataSource mAppLocalDataSource;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppRepository(
            @ApplicationContext Context context,
            @Remote AppDataSource appRemoteDataSource,
            @Local AppDataSource appLocalDataSource,
            PreferencesHelper preferencesHelper) {

        mContext = context;
        mAppRemoteDataSource = appRemoteDataSource;
        mAppLocalDataSource = appLocalDataSource;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public Observable<List<Event>> getRecommendedEvents() {

        if (!mPreferencesHelper.isRocommendedEventSynced()) {
            return mAppRemoteDataSource
                    .getRecommendedEvents()
                    .compose(RxUtils.applySchedulers())
                    .doOnNext(mAppLocalDataSource::saveRecommendedEvents);
        } else {
            return mAppLocalDataSource
                    .getRecommendedEvents()
                    .compose(RxUtils.applySchedulers());
        }
    }


    @Override
    public Observable<List<Event>> getSelfEvents() {

        if (!mPreferencesHelper.isSelfEventSynced()) {
            return mAppRemoteDataSource
                    .getSelfEvents()
                    .compose(RxUtils.applySchedulers())
                    .doOnNext(mAppLocalDataSource::saveSelfEvents);
        } else {
            return mAppLocalDataSource
                    .getSelfEvents()
                    .compose(RxUtils.applySchedulers());
        }
    }

    @Override
    public void saveRecommendedEvents(List<Event> events) {
        mAppLocalDataSource.saveRecommendedEvents(events);
    }

    @Override
    public void saveSelfEvents(List<Event> events) {
        mAppLocalDataSource.saveSelfEvents(events);
    }


    public boolean isAuth() {
        return mPreferencesHelper.isAuth();
    }

}
