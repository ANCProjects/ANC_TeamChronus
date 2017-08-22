package team.chronus.amona.presentation.detail;

import android.location.Location;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import team.chronus.amona.data.AppRepository;
import team.chronus.amona.data.remote.DistanceService;
import team.chronus.amona.data.remote.ServiceFactory;
import team.chronus.amona.presentation.base.BasePresenter;
import team.chronus.amona.utils.AppConstants;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class DetailPresenter <V extends DetailMvpView> extends BasePresenter<V>
        implements DetailMvpPresenter<V> {

    private static final String TAG = "DetailPresenter";


    @Inject
    public DetailPresenter(AppRepository appRepository,
                           CompositeDisposable compositeDisposable) {
        super(appRepository, compositeDisposable);
    }


    @Override
    public void loadDistance(Location currentLocation, Location meetUpLocation) {
        //this method should call the fragment upon success
        DistanceService service = ServiceFactory.createFrom(DistanceService.class,
                AppConstants.DISTANCE_ENDPOINT);
        service.getDistance(currentLocation.getLatitude() + currentLocation.getLongitude() + "",
                meetUpLocation.getLatitude() + meetUpLocation.getLongitude() + "",
                AppConstants.API_KEY);
    }
}