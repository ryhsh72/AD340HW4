package jamesno.hw1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostCar extends AppCompatActivity {
    private static final String TAG = DisplayMessageActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private titleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(PostCar.this);
        recyclerView.setLayoutManager(layoutManager);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        requestJsonObject();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menusongs, menu);
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

            case R.id.about_app:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intentAbout = new Intent(this, aboutApp.class);
                startActivity(intentAbout);
                return true;

            case R.id.cookbook:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intentCookbook = new Intent(this, CookbookInfo.class);
                startActivity(intentCookbook);
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

    private void requestJsonObject() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://jno.icoolshow.net/json_data.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response " + response);
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                List<Post> posts = new ArrayList<Post>();
                posts = Arrays.asList(mGson.fromJson(response, Post[].class));
                adapter = new titleAdapter(PostCar.this, posts);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
