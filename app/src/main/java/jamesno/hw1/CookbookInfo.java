package jamesno.hw1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CookbookInfo extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    // 2D data array
    String[][] cookbooks =
            {
                    {"THE FRENCH LAUNDRY", "THOMAS KELLER"},
                    {"WD-40", "WYLIE DUFRESNE"},
                    {"MOMOFUKU", "DAVID CHANG"},
                    {"FLOUR", "JOANNE CHANG"},
                    {"ON FOOD AND COOKING", "HAROLD MCGEE"},
                    {"ELEVEN MADISON PARK", "DANIEL HUMM"},
                    {"IVAN RAMEN", "IVAN ORKIN"},
                    {"GRAMERCY TAVERN", "MICHAEL ANTHONY"},
                    {"LUCQUES", "SUZANNE GOIN"},
                    {"PRUNE", "GABRIELLE HAMILTON"},
                    {"DANIEL", "DANIEL BOULUD"},
                    {"VONG", "JEAN GEORGES VONGERITCHEN"},
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook_info);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(context);

        // use a linear layout manager
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new CustomAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menucookbook, menu);
        return true;
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTitle;
            public TextView mDetail;

            public ViewHolder(View v) {
                super(v);
                mTitle = (TextView) v.findViewById(R.id.subject_1);
                mDetail = (TextView) v.findViewById(R.id.subject_2);
            }
        }

        @Override
        public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            // Inflate the view for this view holder
            View item = getLayoutInflater().inflate(R.layout.list_item2, parent,
                    false);

            // Call the view holder's constructor, and pass the view to it;
            // return that new view holder
            ViewHolder vh = new ViewHolder(item);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTitle.setText(cookbooks[position][0]);
            holder.mDetail.setText(cookbooks[position][1]);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return cookbooks.length;
        }
    }
}