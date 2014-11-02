package com.special;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UserSettingsActivity extends PreferenceActivity implements DatePickerDialog.OnDateSetListener {

    private static final int RESULT_SETTINGS = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Preference btnDateFilter = (Preference) findPreference("prefDateOfBirth");
        btnDateFilter.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public boolean onPreferenceClick(Preference preference) {
                showDateDialog();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SETTINGS:
                break;

        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        //Log.i("dasd", "year " + i + " month " + i2 + " day " + i3);
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor1  = sharedPrefs.edit();
        Date d = new Date(i, i2, i3);
        editor1.putLong("prefDateOfBirth", d.getTime());

    }

    private void showDateDialog() {
        // Use the current date as the default date in the picker
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        Long x=sharedPrefs.getLong("prefDateOfBirth", 0L);
        Date d=new Date(x);
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        if (d.getYear() != 1900) {
            year = d.getYear();
            month = d.getMonth();
            day = d.getDay();
        }
        new DatePickerDialog(this, this, year, month, day).show();

    }
}