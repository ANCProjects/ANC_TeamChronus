package team.chronus.amona.data.local.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import team.chronus.amona.utils.AppConstants;


/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

  private static final int DATABASE_VERSION = 1;

  public DbHelper(Context context) {
    super(context, AppConstants.DB_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    onCreate(db);
  }
}
