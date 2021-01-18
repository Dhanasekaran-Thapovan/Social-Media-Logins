package com.ds.thapovan.dateutils;

import android.app.DatePickerDialog;
import android.content.Context;
import java.util.Calendar;
public class DateSetter {

    public static void selectDate(Context context, DatePickerDialog.OnDateSetListener listner, Boolean limit, String minDate) {
        Calendar c = Calendar.getInstance();
        Integer year = c.get(Calendar.YEAR);
        Integer month = c.get(Calendar.MONTH);
        Integer day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog = new DatePickerDialog(context, listner, year, month, day);
        if (limit) {
            String[] seledtDateArray = minDate.split("/");
            Calendar cMin = Calendar.getInstance();
            cMin.set(Calendar.YEAR, Integer.parseInt(seledtDateArray[2]));
            cMin.set(Calendar.MONTH, Integer.parseInt(seledtDateArray[1])-1);
            cMin.set(Calendar.DAY_OF_MONTH, Integer.parseInt(seledtDateArray[0]));
            dialog.getDatePicker().setMinDate(cMin.getTimeInMillis());

        }
        dialog.show();
    }

}
