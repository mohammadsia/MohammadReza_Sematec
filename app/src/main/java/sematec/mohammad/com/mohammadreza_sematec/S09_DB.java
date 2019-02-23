package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.support.annotation.Nullable;


public class S09_DB extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "tblme";
    public static final String TABLE_CITY_NAME = "city_name";
    public static final String TABLE_FAJR = "fajr";
    public static final String TABLE_DHUHR = "dhuhr";
    public static final String TABLE_SUNRISR = "sunrise";
    public static final String TABLE_ASR = "asr";
    public static final String TABLE_SUNSET = "sunset";
    public static final String TABLE_MAGHRIB = "maghrib";
    public static final String TABLE_ISHA = "isha";
    public static final String TABLE_IMSAK = "imsak";
    public static final String TABLE_MIDNIGHT = "midnight";

    String create_db_query =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TABLE_CITY_NAME + " TEXT," +
                    TABLE_FAJR + " TEXT," +
                    TABLE_SUNRISR + " TEXT," +
                    TABLE_DHUHR + " TEXT," +
                    TABLE_ASR + " TEXT," +
                    TABLE_SUNSET + " TEXT," +
                    TABLE_MAGHRIB + " TEXT," +
                    TABLE_ISHA + " TEXT," +
                    TABLE_ISHA + " TEXT," +
                    TABLE_IMSAK + " TEXT," +
                    TABLE_MIDNIGHT + " TEXT" +
                    ")";

    public S09_DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_db_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void inserToTiming(String cityName, String fajr, String sunrise, String dhuhr, String asr, String sunset, String maghrib, String isha, String imsak, String midnight) {
        String insertQuery = "INSERT INTO " + TABLE_NAME +
        (TABLE_CITY_NAME+","+TABLE_FAJR+","+TABLE_SUNRISR+","+TABLE_DHUHR+","+TABLE_ASR+","+TABLE_SUNSET+","+TABLE_MAGHRIB+","+TABLE_ISHA+","+TABLE_IMSAK+","+TABLE_MIDNIGHT) +
                "VALUES( '" + cityName + "' " +
                ", '" + fajr + " ' " +
                ", '" + sunrise + "' " +
                ", '" + dhuhr + "' " +
                ", '" + asr + "' " +
                ", '" + sunset + "' " +
                ", '" + maghrib + "' " +
                ", '" + isha + "' " +
                ", '" + imsak + "' " +
                ", '" + midnight + "')";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
        db.close();
    }

    public String getPrayTime() {
        String test = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT fajr from " + TABLE_NAME, null);
        while (cursor.moveToNext()) {
            test += cursor.getString(0) ;
        }
        db.close();
        return test;
    }

}