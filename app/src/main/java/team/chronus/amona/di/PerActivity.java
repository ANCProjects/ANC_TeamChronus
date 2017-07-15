package team.chronus.amona.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}

