package team.chronus.amona.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import team.chronus.amona.BuildConfig;
import team.chronus.amona.R;
import team.chronus.amona.data.AppDataSource;
import team.chronus.amona.data.local.AppLocalDataSource;
import team.chronus.amona.data.remote.AppRemoteDataSource;
import team.chronus.amona.data.remote.AppService;
import team.chronus.amona.data.remote.ServiceFactory;
import team.chronus.amona.di.ApplicationContext;
import team.chronus.amona.di.DatabaseInfo;
import team.chronus.amona.di.Local;
import team.chronus.amona.di.Remote;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    AppService provideAppService() {
        return ServiceFactory.createFrom(AppService.class, BuildConfig.BASE_URL);
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }



    @Singleton
    @Provides
    @Local
    AppDataSource provideAppLocalDataSource(BriteDatabase briteDatabase) {
        return new AppLocalDataSource(briteDatabase);
    }

    @Singleton
    @Provides
    @Remote
    AppDataSource provideAppRemoteDataSource(AppService service) {
        return new AppRemoteDataSource(service);
    }

    @Singleton
    @Provides
    @NonNull
    BriteDatabase provideBriteDatabase(SqlBrite sqlBrite, DbHelper dbHelper, Scheduler scheduler) {
        return sqlBrite.wrapDatabaseHelper(dbHelper, scheduler);
    }

    @Singleton
    @Provides
    @NonNull
    SqlBrite provideSqlBrite() {
        return new SqlBrite.Builder().build();
    }

    @Singleton
    @Provides
    @NonNull
    DbHelper provideDbHelper(@ApplicationContext Context context) {
        return new DbHelper(context);
    }

    @Provides
    @NonNull
    Scheduler provideScheduler() {
        return Schedulers.io();
    }

    @Singleton
    @Provides
    @NonNull
    PreferencesHelper providePreferencesHelper(@ApplicationContext Context context) {
        return new PreferencesHelper(context);
    }
}

