package vn.hunghd.flutterdownloader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vn.hunghd.flutterdownloader.TaskContract.TaskEntry;

public class TaskDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "download_tasks.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TaskEntry.TABLE_NAME + " (" +
            TaskEntry._ID + " INTEGER PRIMARY KEY," +
            TaskEntry.COLUMN_NAME_TASK_ID + " VARCHAR(128), " +
            TaskEntry.COLUMN_NAME_URL + " TEXT, " +
            TaskEntry.COLUMN_NAME_STATUS + " INTEGER, " +
            TaskEntry.COLUMN_NAME_PROGRESS + " INTEGER, " +
            TaskEntry.COLUMN_NAME_FILE_NAME + " TEXT, " +
            TaskEntry.COLUMN_NAME_SAVED_DIR + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TaskEntry.TABLE_NAME;

    public TaskDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}