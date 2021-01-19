package com.ds.thapovan.Commonutils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class CommonUtils {
    public static void openPopupDialog(Context context, TextView textview, Integer menu){
        PopupMenu popup=new PopupMenu(context,textview);
        popup.getMenuInflater().inflate(menu,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                textview.setText(menuItem.getTitle());
                return true;
            }
        });
        popup.show();
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
