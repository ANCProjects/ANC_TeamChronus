package team.chronus.amona.presentation.detail;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import team.chronus.amona.data.AppRepository;
import team.chronus.amona.presentation.base.BasePresenter;

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


}