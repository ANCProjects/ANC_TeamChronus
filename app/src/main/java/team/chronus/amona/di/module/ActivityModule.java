package team.chronus.amona.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import team.chronus.amona.di.ActivityContext;
import team.chronus.amona.di.PerActivity;
import team.chronus.amona.presentation.auth.AuthMvpPresenter;
import team.chronus.amona.presentation.auth.AuthMvpView;
import team.chronus.amona.presentation.auth.AuthPresenter;
import team.chronus.amona.presentation.detail.DetailMvpPresenter;
import team.chronus.amona.presentation.detail.DetailMvpView;
import team.chronus.amona.presentation.detail.DetailPresenter;
import team.chronus.amona.presentation.master.MasterMvpPresenter;
import team.chronus.amona.presentation.master.MasterMvpView;
import team.chronus.amona.presentation.master.MasterPresenter;
import team.chronus.amona.presentation.splash.SplashMvpPresenter;
import team.chronus.amona.presentation.splash.SplashMvpView;
import team.chronus.amona.presentation.splash.SplashPresenter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AuthMvpPresenter<AuthMvpView> provideAuthPresenter(
            AuthPresenter<AuthMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    MasterMvpPresenter<MasterMvpView> provideMasterPresenter(
            MasterPresenter<MasterMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    DetailMvpPresenter<DetailMvpView> provideDetailPresenter(
            DetailPresenter<DetailMvpView> presenter) {
        return presenter;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }


}