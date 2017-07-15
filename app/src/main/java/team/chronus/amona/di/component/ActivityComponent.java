package team.chronus.amona.di.component;

import dagger.Component;
import team.chronus.amona.di.PerActivity;
import team.chronus.amona.di.module.ActivityModule;
import team.chronus.amona.presentation.auth.AuthActivity;
import team.chronus.amona.presentation.detail.DetailActivity;
import team.chronus.amona.presentation.detail.DetailFragment;
import team.chronus.amona.presentation.master.MasterActivity;
import team.chronus.amona.presentation.master.MasterFragment;
import team.chronus.amona.presentation.splash.SplashActivity;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(AuthActivity activity);

    void inject(MasterActivity activity);

    void inject(DetailActivity activity);

    void inject(MasterFragment fragment);

    void inject(DetailFragment fragment);

}
