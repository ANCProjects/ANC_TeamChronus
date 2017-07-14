package team.chronus.amona.data.local;

import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import team.chronus.amona.data.AppDataSource;
import team.chronus.amona.data.model.Event;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Singleton
public class AppLocalDataSource implements AppDataSource {

    private final BriteDatabase mDatabaseHelper;

    @Inject
    public AppLocalDataSource(BriteDatabase briteDatabase) {
        mDatabaseHelper = briteDatabase;
    }

    @Override
    public Observable<List<Event>> getRecommendedEvents() {
        throw new UnsupportedOperationException("getRecommendedEvents in AppLocalDataSource is not implemented!");
    }

    @Override
    public Observable<List<Event>> getSelfEvents() {
        throw new UnsupportedOperationException("getSelfEvents in AppLocalDataSource is not implemented!");
    }


    @Override
    public void saveRecommendedEvents(List<Event> events) {
        throw new UnsupportedOperationException("saveRecommendedEvents in AppLocalDataSource is not implemented!");
    }


    @Override
    public void saveSelfEvents(List<Event> events) {
        throw new UnsupportedOperationException("saveSelfEvents in AppLocalDataSource is not implemented!");
    }


}