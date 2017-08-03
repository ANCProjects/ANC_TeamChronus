package team.chronus.amona.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import team.chronus.amona.App;
import team.chronus.amona.data.AppRepository;
import team.chronus.amona.di.ApplicationContext;
import team.chronus.amona.di.module.ApplicationModule;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    AppRepository getAppRepository();
}