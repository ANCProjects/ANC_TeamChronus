package team.chronus.amona.di.component;

import dagger.Component;
import team.chronus.amona.di.PerActivity;
import team.chronus.amona.di.module.ActivityModule;
import team.chronus.amona.presentation.splash.SplashActivity;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

}
