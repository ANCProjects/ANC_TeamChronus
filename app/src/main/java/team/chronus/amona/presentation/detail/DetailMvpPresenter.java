package team.chronus.amona.presentation.detail;

import android.location.Location;

import team.chronus.amona.di.PerActivity;
import team.chronus.amona.presentation.base.MvpPresenter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@PerActivity
public interface DetailMvpPresenter <V extends DetailMvpView> extends MvpPresenter<V> {
    void loadDistance(Location currentLocation, Location meetUpLocation);
}