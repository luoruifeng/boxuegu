package cn.edu.gamec.android.boxuegu.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 17/12/27.
 */

public class SQLiteHelper extends SQLiteOpenHelper{
    private static  final int DB_VERSION = 1;
    public static String DB_NAME = "bxg.db";
    public static final String U_USERINFO = "userinfo";
    public static final String U_VIDEO_PLAY_LISY = "videoplaylist";
    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_USERINFO + "("
                 + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + "uaerName VARCHAR,"
                 + "nickName VARCHAR,"
                 + "sex VARCHAR,"
                 + "signature VARCHAR,"
                 + ")");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_VIDEO_PLAY_LISY + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "uaerName VARCHAR,"
                + "chapterId INT"
                + "videoId INT,"
                + "videoPath VARCHAR,"
                + "title VARCHAR,"
                + "secondTitle VARCHAR,"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int NewVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + U_USERINFO);
        db.execSQL("DROP TABLE IF EXISTS" + U_VIDEO_PLAY_LISY);
        onCreate(db);
    }
}
