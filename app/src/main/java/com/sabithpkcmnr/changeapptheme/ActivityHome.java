package com.sabithpkcmnr.changeapptheme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

/*
* Code by Sabith Pkc Mnr
* Visit: https://www.youtube.com/SabithPkcMnr
* Visit: https://www.SabithPkcMnr.com
*/

public class ActivityHome extends AppCompatActivity {

    //Variables
    SwitchMaterial mySwitch;
    ThemeSharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Checking that state true or false from SharedPref
        sharedpref = new ThemeSharedPref(this);

        setTheme(sharedpref.isNightMode()? R.style.ThemeNight : R.style.ThemeDay);
        super.onCreate(savedInstanceState);

        //Displaying the layout after setting the theme
        setContentView(R.layout.activity_home);

        mySwitch= findViewById(R.id.mySwitch);
        if (sharedpref.isNightMode()) {
            mySwitch.setChecked(true);
        }

        //Checking the toggle state and saving it to the SharedPref
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedpref.setNightModeState(true);
                    restartApp();
                }
                else {
                    sharedpref.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }

    //Method to restart the app
    public void restartApp () {
        Intent restartApp = new Intent(getApplicationContext(), ActivityHome.class);
        startActivity(restartApp);
        finish();
    }
}