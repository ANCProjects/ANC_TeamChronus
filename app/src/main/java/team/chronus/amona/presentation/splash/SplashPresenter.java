package team.chronus.amona.presentation.splash;

import android.os.SystemClock;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import team.chronus.amona.data.AppRepository;
import team.chronus.amona.presentation.base.BasePresenter;
import team.chronus.amona.utils.RxUtils;

/**
 * Created by ibrahimabdulkadir on 21/06/2017.
 */

public class SplashPresenter <V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    private static final String TAG = "SplashPresenter";

    // Splash screen timeout
    private static int SPLASH_TIME_OUT = 3000;

    @Inject
    public SplashPresenter(AppRepository appRepository,
                           CompositeDisposable compositeDisposable) {
        super(appRepository, compositeDisposable);
    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);


        getCompositeDisposable().add(Observable.create(emitter -> {
            SystemClock.sleep(SPLASH_TIME_OUT); // simulate delay
            emitter.onNext(5);
            emitter.onComplete();
        }).compose(RxUtils.applySchedulers()).subscribe(integer ->
                getMvpView().openMasterActivity()));

    }


}
