package team.chronus.amona.presentation.master;

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


    @Inject
    public MasterPresenter(AppRepository appRepository,
                           CompositeDisposable compositeDisposable) {
        super(appRepository, compositeDisposable);
    }


}