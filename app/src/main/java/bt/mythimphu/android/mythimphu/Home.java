package bt.mythimphu.android.mythimphu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.roughike.bottombar.OnTabSelectedListener;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomBar bottomBar;

    private static final String NOTIFICATION_MSG = "NOTIFICATION MSG";

    private int selectedItem;
    //private CoordinatorLayout coordinatorLayout;

    public static Intent makeNotificationIntent(Context context, String msg) {
        Intent intent = new Intent( context, MainActivity.class );
        intent.putExtra( NOTIFICATION_MSG, msg );
        return intent;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();

        final ColorDrawable colorDrawableOne = new ColorDrawable(Color.parseColor("#3F51B5"));
        final ColorDrawable colorDrawableTwo = new ColorDrawable(Color.parseColor("#00796B"));
        final ColorDrawable colorDrawableThree = new ColorDrawable(Color.parseColor("#7B1FA2"));
        final ColorDrawable colorDrawableFour = new ColorDrawable(Color.parseColor("#FF5252"));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.noNavBarGoodness();
        bottomBar.setActiveTabColor("#3F51B5");


        bottomBar.setFragmentItems(getSupportFragmentManager(),R.id.fragmentContainer,
                new BottomBarFragment(new EventFragment(),R.drawable.ic_update_white_24dp,"Recents"),
                new BottomBarFragment(new PlacesFragment(), R.drawable.ic_local_dining_white_24dp, "Food"),
                new BottomBarFragment(new FavouritesFragment(), R.drawable.ic_favorite_white_24dp, "Favorites"),
                new BottomBarFragment(new ThimphuMapFragment(), R.drawable.ic_location_on_white_24dp, "Location"));

        bottomBar.mapColorForTab(0, "#3F51B5");
        bottomBar.mapColorForTab(1, "#00796B");
        bottomBar.mapColorForTab(2, "#7B1FA2");
        bottomBar.mapColorForTab(3, "#FF5252");

        getWindow().
                setStatusBarColor(Color.parseColor("#3F51B5"));


        bottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Tab 1 selected",Toast.LENGTH_SHORT).show();


                        ab.setBackgroundDrawable(colorDrawableOne);
                        getWindow().
                                setStatusBarColor(Color.parseColor("#3F51B5"));
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Tab 2 selected",Toast.LENGTH_SHORT).show();
                        getWindow().
                                setStatusBarColor(Color.parseColor("#00796B"));
                        ab.setBackgroundDrawable(colorDrawableTwo);
                        break;
                    case 2:
                        getWindow().
                                setStatusBarColor(Color.parseColor("#7B1FA2"));
                        ab.setBackgroundDrawable(colorDrawableThree);
                        break;
                    case 3:
                        getWindow().
                                setStatusBarColor(Color.parseColor("#FF5252"));
                        Toast.makeText(getApplicationContext(),"Tab4 selected",Toast.LENGTH_SHORT).show();
                        ab.setBackgroundDrawable(colorDrawableFour);
                        break;


                }
            }
        });

        // Make a Badge for the first tab, with red background color and a value of "4".
        BottomBarBadge unreadMessages = bottomBar.makeBadgeForTabAt(1, "#E91E63", 4);

        // Control the badge's visibility
        unreadMessages.show();
        //unreadMessages.hide();

        // Change the displayed count for this badge.
        //unreadMessages.setCount(4);

        // Change the show / hide animation duration.
        unreadMessages.setAnimationDuration(200);




    }


   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        item.setChecked(true);
        selectedItem = item.getItemId();

        switch (selectedItem) {
            case R.id.nav_item_1:
                Toast.makeText(this, "Android is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_2:
                Toast.makeText(this, "Gift is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_3:
                Toast.makeText(this, "Delete is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_5:
                Toast.makeText(this, "Favorite is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_6:
                Toast.makeText(this, "Settings is clicked !", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }*/

    /**
     * Override onBackPressed method so that when a user clicks on it, it closes
     * the NavigationDrawer if it's opened not the App.
     */
   /* @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt("selectedItem", selectedItem);
    }*/


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
