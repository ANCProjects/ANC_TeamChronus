package team.chronus.amona.presentation.auth;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import team.chronus.amona.data.AppRepository;
import team.chronus.amona.presentation.base.BasePresenter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class AuthPresenter <V extends AuthMvpView> extends BasePresenter<V>
        implements AuthMvpPresenter<V> {

    private static final String TAG = "AuthPresenter";


    @Inject
    public AuthPresenter(AppRepository appRepository,
                           CompositeDisposable compositeDisposable) {
        super(appRepository, compositeDisposable);
    }



}