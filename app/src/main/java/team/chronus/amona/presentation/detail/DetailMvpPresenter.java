package team.chronus.amona.presentation.detail;

import team.chronus.amona.di.PerActivity;
import team.chronus.amona.presentation.base.MvpPresenter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@PerActivity
public interface DetailMvpPresenter <V extends DetailMvpView> extends MvpPresenter<V> {

}