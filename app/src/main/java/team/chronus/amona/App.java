package team.chronus.amona;

import android.app.Application;

import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import team.chronus.amona.data.AppRepository;
import team.chronus.amona.di.component.ApplicationComponent;
import team.chronus.amona.di.component.DaggerApplicationComponent;
import team.chronus.amona.di.module.ApplicationModule;
import team.chronus.amona.utils.AppLogger;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ibrahimabdulkadir on 13/07/2017.
 */

public class App extends Application {

    @Inject
    AppRepository mAppRepository;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        if (BuildConfig.DEBUG) {
            AppLogger.init();
            Stetho.initializeWithDefaults(this);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}