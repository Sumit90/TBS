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
            + " text not null, " + COLUMN_RGB
            + " text not null, " + COLUMN_HEX
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

    public boolean addColour(ColourPOJO colour) {

        boolean succes=false;
        SQLiteDatabase db = this.getWritableDatabase();
        try {


            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, colour.getColourCode());
            values.put(COLUMN_NAME, colour.getColourName());
            values.put(COLUMN_RGB, colour.getColourRGB());
            values.put(COLUMN_HEX, colour.getColourHex());

            // Inserting Row
            long result=db.insert(TABLE_COLOURS, null, values);

            if(result>0)
                succes=true;
        }
        catch (Exception e)
        {
            succes=false;

        }
        finally {
            if(db.isOpen())
            {
                db.close();
            }
        }
        return succes;

    }

    public ColourPOJO getColour(String colourCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        ColourPOJO colour=null;
        Cursor cursor = db.query(TABLE_COLOURS, new String[] { COLUMN_CODE,
                 COLUMN_NAME,COLUMN_RGB,COLUMN_HEX }, COLUMN_CODE + "=?",
                new String[] { colourCode }, null, null, null, null);



        if (cursor != null) {

            if(cursor.moveToFirst()) {

                colour = new ColourPOJO(cursor.getString(0),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3));
            }
        }

        if(db.isOpen())
        {
            db.close();
        }

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
                colour.setColourHex(cursor.getString(3));
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
