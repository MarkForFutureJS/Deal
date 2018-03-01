package com.money.lava.deal.logger;

import android.util.Log;

/**
 * Created by Mark on 9/16/15.
 */
public class Dump {
    public static String TAG = "CITI";

    public static void e(String message) {
        Log.e(TAG, message);
    }
}
