package app.healthunbox.com.shared;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

/*
* Code by Sabith Pkc Mnr
* Visit: https://www.youtube.com/SabithPkcMnr
* Visit: https://www.SabithPkcMnr.com
*/

public class MainActivity extends AppCompatActivity {

    //Variables
    private Switch myswitch;
    ThemeSharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Checking that state true or false from SharedPref
        sharedpref = new ThemeSharedPref(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.darktheme);
        }
        else  setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        //Displaying the layout after setting the theme
        setContentView(R.layout.activity_main);

        myswitch= findViewById(R.id.switch1);
        if (sharedpref.loadNightModeState()==true) {
            myswitch.setChecked(true);
        }

        //Checking the toggle state and saving it to the SharedPref
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}