package com.sabithpkcmnr.changeapptheme;

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
    ThemeSharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Checking that state true or false from SharedPref
        sharedPref = new ThemeSharedPref(this);

        setTheme(sharedPref.isNightMode() ? R.style.ThemeNight : R.style.ThemeDay);
        super.onCreate(savedInstanceState);

        //Displaying the layout after setting the theme
        setContentView(R.layout.activity_home);

        mySwitch = findViewById(R.id.mySwitch);
        if (sharedPref.isNightMode()) {
            mySwitch.setChecked(true);
        }

        //Checking the toggle state and saving it to the SharedPref
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPref.setNightModeState(isChecked);
                //Reopen page with fade animation
                finish();
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
                startActivity(getIntent());

                //recreate();
            }
        });
    }

}