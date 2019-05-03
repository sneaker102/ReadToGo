package elliajah.ro.readtogo.elliajah.ro.readtogo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SqliteBookHelper extends SQLiteOpenHelper {


    public static int DB_VERSION = 1;
    public static final String mDbName = "books_app_db";
    private Context mCtx;


    public SqliteBookHelper(Context mCtx) {
        super(mCtx, mDbName, null, DB_VERSION);
        this.mCtx = mCtx;


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(BookModel.CREATE_TABLE);
        } catch (Exception e) {
            Toast.makeText(mCtx, e.toString(), Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(mCtx, "upgrading table : " + BookModel.TABLE_NAME + " from " + oldVersion + "to " + newVersion, Toast.LENGTH_SHORT);
            db.execSQL("DROP TABLE IF EXISTS " + BookModel.TABLE_NAME);
            onCreate(db);
            DB_VERSION += DB_VERSION + 1;
        } catch (Exception e) {
            Toast.makeText(mCtx, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public long saveBookSimple(String bookName, String author, String editura) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(BookModel.COLUMN_NAME, bookName);
        values.put(BookModel.COLUMN_AUTHOR, author);
        values.put(BookModel.COLUMN_EDITURA, editura);

        // insert row
        long id = db.insert(BookModel.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;

    }

    public List<BookModel> getBooks() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(BookModel.SELECT_ALL_QUERY, null);
        List<BookModel> books = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {


                // prepare note object
                books.add(new BookModel(
                        cursor.getInt(cursor.getColumnIndex(BookModel.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_AUTHOR)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_GENRE)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_GRADE)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_PERSONAL_NOTES)),
                        cursor.getInt(cursor.getColumnIndex(BookModel.COLUMN_IS_FINISHED)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_TIMESTAMP)),
                        cursor.getString(cursor.getColumnIndex(BookModel.COLUMN_EDITURA))
                ));
            }
        }


        // close the db connection
        cursor.close();
        return books;
    }
}
