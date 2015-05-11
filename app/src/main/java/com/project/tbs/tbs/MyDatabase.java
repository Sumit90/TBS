package com.project.tbs.tbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 11-05-2015.
 */
public class MyDatabase extends SQLiteOpenHelper {

    public static final String TABLE_COLOURS = "myColours";
    public static final String COLUMN_CODE = "columnCode";
    public static final String COLUMN_NAME = "colourName";
    public static final String COLUMN_RGB = "colourRGB";
    public static final String COLUMN_HEX = "colourHex";

    private static final String DATABASE_NAME = "asianPaints.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COLOURS + "(" + COLUMN_CODE
            + " text primary key, " + COLUMN_NAME
            + " text, " + COLUMN_RGB
            + " text, " + COLUMN_HEX
            + " text not null);";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MyDatabase.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COLOURS);
        onCreate(db);
    }

    public void addColour(ColourPOJO colour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CODE, colour.getColourCode());
        values.put(COLUMN_NAME, colour.getColourName());
        values.put(COLUMN_RGB, colour.getColourRGB());
        values.put(COLUMN_HEX, colour.getColourHex());

        // Inserting Row
        db.insert(TABLE_COLOURS, null, values);
        db.close(); // Closing database connection
    }

    public ColourPOJO getColour(String colourCode) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_COLOURS, new String[] { COLUMN_CODE
                         }, COLUMN_CODE + "=?",
                new String[] { colourCode }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ColourPOJO colour = new ColourPOJO(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return colour;
    }


    public List<ColourPOJO> getAllColours() {
        List<ColourPOJO> colourList = new ArrayList<ColourPOJO>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COLOURS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ColourPOJO colour = new ColourPOJO();
                colour.setColourCode(cursor.getString(0));
                colour.setColourName(cursor.getString(1));
                colour.setColourRGB(cursor.getString(2));
                colour.setColourHex(cursor.getString(2));
                // Adding contact to list
                colourList.add(colour);
            } while (cursor.moveToNext());
        }

        if(db.isOpen())
        {
            db.close();
        }

        // return contact list
        return colourList;
    }
}
