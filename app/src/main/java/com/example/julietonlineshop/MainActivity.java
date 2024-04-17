package com.example.julietonlineshop;

import static com.example.julietonlineshop.AllCategoriesDialog.ALL_CATEGORIES;
import static com.example.julietonlineshop.AllCategoriesDialog.CALLING_ACTIVITY;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id==R.id.search){
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else if (id==R.id.categories) {
                    AllCategoriesDialog dialog = new AllCategoriesDialog();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ALL_CATEGORIES, Utils.getCategories(MainActivity.this));
                    bundle.putString(CALLING_ACTIVITY, "main_activity");
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "all categories dialog");
                } else if (id==R.id.about) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("About Us")
                            .setMessage("Designed and Developed by JULIET " +
                                    "Visit for more")
                            .setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent websiteIntent = new Intent(MainActivity.this, SocialGroupActivity.class);
                                    startActivity(websiteIntent);
                                }
                            }).create().show();
                } else if (id==R.id.terms) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Terms")
                            .setMessage("There are no terms, Enjoy using the application :)")
                            .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                } else if (id ==R.id.licences) {
                    LicencesDialog licencesDialog = new LicencesDialog();
                    licencesDialog.show(getSupportFragmentManager(), "licences");
                }

                return false;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MainFragment());
        transaction.commit();
    }

    private void initViews() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
    }
}
