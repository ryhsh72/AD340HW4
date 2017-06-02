package jamesno.hw1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


public class JamesProfile extends AppCompatActivity {
    private static final String TAG = DisplayMessageActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_james_profile);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(JamesProfile.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMessage(R.string.cookies_cake);
                mBuilder.setPositiveButton(R.string.cookies, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "Clicked on positive button for dialog");
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNegativeButton(R.string.cake, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "Clicked on negative button for dialog");
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    cookbookList(v);
                } else if (position == 1) {
                    Toast.makeText(JamesProfile.this, "" + "This is toast!",
                            Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(JamesProfile.this, "" + "I love french toast hon hon!",
                            Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(JamesProfile.this, "" + "Cinnamon toast crunch!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cookbook:
                Intent intentCook = new Intent(this, CookbookInfo.class);
                startActivity(intentCook);
                return true;

            case R.id.about_app:
                Intent intentAbout = new Intent(this, aboutApp.class);
                startActivity(intentAbout);
                return true;

            case R.id.songs:
                Intent intentCars = new Intent(this, PostCar.class);
                startActivity(intentCars);
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

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void cookbookList(View view) {
        Intent intent = new Intent(this, CookbookInfo.class);
        startActivity(intent);
    }
}
