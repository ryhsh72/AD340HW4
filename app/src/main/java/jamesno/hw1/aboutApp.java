package jamesno.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by jamesno on 5/3/17.
 */

public class aboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutlayout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aboutmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                // User chose the "Settings" item, show the app settings UI...
                Intent intentProfile = new Intent(this, JamesProfile.class);
                startActivity(intentProfile);
                return true;

            case R.id.cookbook:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intentCookbook = new Intent(this, CookbookInfo.class);
                startActivity(intentCookbook);
                return true;

            case R.id.songs:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intentSongs = new Intent(this, PostCar.class);
                startActivity(intentSongs);
                return true;

            case R.id.map:
                Intent intentMaps = new Intent(this, MapsActivity.class);
                startActivity(intentMaps);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
