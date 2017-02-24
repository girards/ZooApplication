package edu.csulb.android.zooapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ZooPresentationActivity extends AppCompatActivity {

    Button callButton;
    Intent callIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_presentation);

        callButton = (Button) findViewById(R.id.button_call);
        callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:888-8888"));

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(callIntent);
            }
        });
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
        Intent intent = new Intent(ZooPresentationActivity.this, ZooPresentationActivity.class);
        startActivity(intent);
    }
}
