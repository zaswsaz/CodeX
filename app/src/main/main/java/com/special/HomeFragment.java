package com.special;

import com.special.R;
import com.special.menu.ResideMenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_home, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        MainActivity parentActivity = (MainActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();

        parentView.findViewById(R.id.btn_open_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //resideMenu.openMenu();
                //Intent i = new Intent(view.getContext(), PetEvents.class);
                //startActivity(i);
            }
        });
        
        parentView.findViewById(R.id.btn_pet2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	//String url = "http://codecanyon.net/user/sherdleapps/portfolio?ref=sherdleapps";
            	//Intent i = new Intent(Intent.ACTION_VIEW);
            	//i.setData(Uri.parse(url));
                //Intent i = new Intent(view.getContext(), AddEvent.class);
                //startActivity(i);
            }
        });
    }

}
