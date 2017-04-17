package avipatil.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by avipatil on 4/17/2017.
 */

public class DB extends SQLiteOpenHelper
{
    static String DATA_BASE_NAME="contact.db";
    static String Table_Name="contacts";
    Context context;

    public DB(Context contex) {
        super(contex,DATA_BASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Table_Name+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONENUMBER TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  boolean insertDate(String name,String number)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("PHONENUMBER",number);
        sqLiteDatabase.insert(Table_Name,null,contentValues);

        return true;

    }
    public ArrayList<ContactPojo> getAllContacts()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<ContactPojo> contactArrayList = new ArrayList<>();
        String query = "select * from " +Table_Name;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();

        //to move to next we need a loop
        while(cursor.isAfterLast()==false){

            Long id = cursor.getLong(cursor.getColumnIndex("ID"));
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String number = cursor.getString(cursor.getColumnIndex("PHONENUMBER")); //We can implement this if we are not sure about column number or else we can directly enter column number 1, 2 , 3 etc
           // String emailid = cursor.getString(cursor.getColumnIndex("email"));

            ContactPojo contact = new ContactPojo(name,number); // if we have 10 or more objects use an ArrayList
            contactArrayList.add(contact);

            cursor.moveToNext();
        }
        cursor.close();
        return contactArrayList;
    }
    public void removeItem(int id){

        SQLiteDatabase database = getWritableDatabase();
        database.delete(Table_Name,"id = ' "+id + "'",null);
    }
}
