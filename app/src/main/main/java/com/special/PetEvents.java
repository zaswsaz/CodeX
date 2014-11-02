package com.special;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;

import com.special.R;
import com.special.menu.ResideMenu;
import com.special.utils.UISwipableList;
import android.app.ActionBar.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class PetEvents  extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        parentView = inflater.inflate(R.layout.activity_pet_events, container, false);
        MainActivity parentActivity = (MainActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();
        //View v = inflater.inflate(R.layout.activity_pet_events, null);
        final LinearLayout lm = (LinearLayout) parentView.findViewById(R.id.layoutEvents);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(parentView.getContext());

        int j = 10;

        if (sharedPrefs.contains("prefEvent1"))
        {

        String event1 = sharedPrefs.getString("prefEvent1", "NULL");

            // Create Button
            final Button btn = new Button(parentView.getContext(),null,R.style.UIButton);
            // Give button an ID
            btn.setId(j + 1);
            btn.setText(event1);
            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Toast.makeText(v.getContext(),
                            "Clicked Button:" + btn.getText(),
                            Toast.LENGTH_SHORT).show();

                }
            });

            //Add button to LinearLayout
            lm.addView(btn);
            j=j+1;
        }

        if (sharedPrefs.contains( "prefEvent2"))
        {

           String event2 = sharedPrefs.getString("prefEvent2", "NULL");

            // Create Button
            final Button btn = new Button(parentView.getContext(),null,R.style.UIButton);
            // Give button an ID
            btn.setId(j + 1);
            btn.setText(event2);
            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Toast.makeText(v.getContext(),
                            "Clicked Button :" + btn.getText(),
                            Toast.LENGTH_SHORT).show();

                }
            });

            //Add button to LinearLayout
            lm.addView(btn);
        }
        return parentView;
    }


    // @Override
    //public void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_pet_events);
   // }


   // @Override
   // public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    //    getMenuInflater().inflate(R.menu.pet_events, menu);
   //     return true;
   // }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AddButtonsBasedOnPreferences(View v)
    {
        final LinearLayout lm = (LinearLayout) v.findViewById(R.id.layoutEvents);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(v.getContext());

        String event1 = sharedPrefs.getString("prefEvent1", "NULL");
        String event2 = sharedPrefs.getString("prefEvent2", "NULL");
        int j = 10;
        if (event1 != null) {
            // Create Button
            final Button btn = new Button(v.getContext());
            // Give button an ID
            btn.setId(j + 1);
            btn.setText(event1);
            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Toast.makeText(v.getContext(),
                            "Clicked Button Index :" + btn.getText(),
                            Toast.LENGTH_LONG).show();

                }
            });

            //Add button to LinearLayout
            lm.addView(btn);
            j=j+1;
        }

        if (event2 != null) {
            // Create Button
            final Button btn = new Button(v.getContext());
            // Give button an ID
            btn.setId(j + 1);
            btn.setText(event2);
            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Toast.makeText(v.getContext(),
                            "Clicked Button Index :" + btn.getText(),
                            Toast.LENGTH_LONG).show();

                }
            });

            //Add button to LinearLayout
            lm.addView(btn);
        }
    }
}
