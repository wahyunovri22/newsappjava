package com.example.newsappjava.helper;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperClass {

    public void hideBar(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public String convertDate(String date){
        SimpleDateFormat dateFormatprev = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = dateFormatprev.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        String changedDate = dateFormat.format(d);
        return changedDate;
    }
}
