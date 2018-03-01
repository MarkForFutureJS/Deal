package com.money.lava.deal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.money.lava.deal.model.Login.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitake on 2018/3/1.
 */

public class UserTable extends BaseTable {

    public static final String TABLE_NAME = "UserTable";
    public static final String USER_NAME = "username";
    public static final String TYPE = "type";
    public static final int TYPE_LENDER = 0;
    public static final int TYPE_BORROWER = 1;
    public static final String CREATE_USER_TABLE = new StringBuilder().append("CREATE TABLE IF NOT EXISTS ")
            .append(TABLE_NAME)
            .append(" (")
            .append(_ID)
            .append(" INTEGER PRIMARY KEY,")
            .append(USER_NAME)
            .append(" VARCHAR,")
            .append(TYPE)
            .append(" INTEGER")
            .append(")")
            .toString();

    public UserTable(Context context) {
        super(context);
    }

    public void insert(User user) {
        ContentValues cv = new ContentValues();

        cv.put(USER_NAME, user.getUsername());
        cv.put(TYPE, user.getType());

        long id = db.insert(TABLE_NAME, null, cv);
    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }
        cursor.close();
        return result;
    }

    private User getRecord(Cursor cursor) {
        User result = new User(cursor.getString(1), cursor.getInt(2));

        return result;
    }
}
