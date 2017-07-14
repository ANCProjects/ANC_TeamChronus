package team.chronus.amona.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import team.chronus.amona.di.ApplicationContext;

import static team.chronus.amona.utils.AppConstants.PREFS_FILE_NAME;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Singleton
public class PreferencesHelper {


    private static final String PREFERENCE_IS_AUTH = "isAuth";
    private static final String PREFERENCE_ACCESS_TOKEN = "accessToken";
    private static final String PREFERENCE_EXPIRES_IN = "expiresIn";
    private static final String PREFERENCE_REFRESH_TOKEN = "refreshToken";

    private static final String PREFERENCE_IS_RECOMMENDED_EVENT_SYNCED = "isRecommendedEventSynced";
    private static final String PREFERENCE_IS_SELF_EVENT_SYNCED = "isSelfEventSynced";

    private final SharedPreferences mSharedPreferences;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }


    public void setIsAuth(boolean flag) {
        mSharedPreferences.edit().putBoolean(PREFERENCE_IS_AUTH, flag).apply();
    }

    public boolean isAuth() {
        return mSharedPreferences.getBoolean(PREFERENCE_IS_AUTH, false);
    }


    public void saveAccesToken(String accessToken) {
        mSharedPreferences.edit().putString(PREFERENCE_ACCESS_TOKEN, accessToken).apply();
    }

    public String getAccesToken() {
        return mSharedPreferences.getString(PREFERENCE_ACCESS_TOKEN, null);
    }

    public void deleteAccesToken() {
        mSharedPreferences.edit().remove(PREFERENCE_ACCESS_TOKEN).apply();
    }


    public void saveExpiresIn(String expiresIn) {
        mSharedPreferences.edit().putString(PREFERENCE_EXPIRES_IN, expiresIn).apply();
    }

    public String getExpiresIn() {
        return mSharedPreferences.getString(PREFERENCE_EXPIRES_IN, null);
    }

    public void deleteExpiresIn() {
        mSharedPreferences.edit().remove(PREFERENCE_EXPIRES_IN).apply();
    }


    public void saveRefreshToken(String refreshToken) {
        mSharedPreferences.edit().putString(PREFERENCE_REFRESH_TOKEN, refreshToken).apply();
    }

    public String getRefreshToken() {
        return mSharedPreferences.getString(PREFERENCE_REFRESH_TOKEN, null);
    }

    public void deleteRefreshToken() {
        mSharedPreferences.edit().remove(PREFERENCE_REFRESH_TOKEN).apply();
    }


    public void setIsRecommendedEventSynced(boolean flag) {
        mSharedPreferences.edit().putBoolean(PREFERENCE_IS_RECOMMENDED_EVENT_SYNCED, flag).apply();
    }

    public boolean isRocommendedEventSynced() {
        return mSharedPreferences.getBoolean(PREFERENCE_IS_RECOMMENDED_EVENT_SYNCED, false);
    }


    public void setIsSelfEventSynced(boolean flag) {
        mSharedPreferences.edit().putBoolean(PREFERENCE_IS_SELF_EVENT_SYNCED, flag).apply();
    }

    public boolean isSelfEventSynced() {
        return mSharedPreferences.getBoolean(PREFERENCE_IS_SELF_EVENT_SYNCED, false);
    }


}
