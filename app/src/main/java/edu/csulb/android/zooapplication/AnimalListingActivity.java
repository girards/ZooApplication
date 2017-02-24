package edu.csulb.android.zooapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.csulb.android.zooapplication.adapters.AnimalListViewAdapter;
import edu.csulb.android.zooapplication.objects.Animal;

public class  AnimalListingActivity extends AppCompatActivity {

    private ArrayList<Animal> mAnimals;
    private ListView mAnimalListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAnimals = new ArrayList<>();

        final AlertDialog dangerousAnimalDialog = new AlertDialog.Builder(this).setMessage(R.string.alert_confirm_view).setTitle(R.string.alert_title)
                .setPositiveButton(R.string.alert_positive_option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showAnimalActivity(mAnimals.get(mAnimals.size() - 1));
                    }
                })
                .setNegativeButton(R.string.alert_negative_option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
        mAnimals.add(new Animal(R.drawable.picture_sharkcat, getString(R.string.animal_name_sharkcat), getString(R.string.animal_description_sharkcat)));
        mAnimals.add(new Animal(R.drawable.picture_jellyfish, getString(R.string.animal_name_jellyfish), getString(R.string.animal_description_jellyfish)));
        mAnimals.add(new Animal(R.drawable.picture_dobby, getString(R.string.animal_name_dobby), getString(R.string.animal_description_dobby)));
        mAnimals.add(new Animal(R.drawable.picture_unicorn, getString(R.string.animal_name_unicorn), getString(R.string.animal_description_unicorn)));
        mAnimals.add(new Animal(R.drawable.picture_alien, getString(R.string.animal_name_secret), getString(R.string.animal_description_secret)));

        mAnimalListView = (ListView) findViewById(R.id.animal_listview);
        mAnimalListView.setAdapter(new AnimalListViewAdapter(this.getApplicationContext(), mAnimals));
        mAnimalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == mAnimals.size() - 1 )
                    dangerousAnimalDialog.show();
                else {
                    showAnimalActivity(mAnimals.get(position));
                }
            }
        });
    }

    private void showAnimalActivity(Animal animal) {
        Intent newActivity = new Intent(AnimalListingActivity.this, DetailedAnimalActivity.class);
        newActivity.putExtra("animal", animal);
        startActivity(newActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.call_zoo_menu_option:
                switchToCallActivity();
                break;
            case R.id.uninstall_menu_option:
                uninstallApp();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void uninstallApp() {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + this.getPackageName()));
        startActivity(intent);
    }

    private void switchToCallActivity() {
        Intent intent = new Intent(AnimalListingActivity.this, ZooPresentationActivity.class);
        startActivity(intent);
    }
}
