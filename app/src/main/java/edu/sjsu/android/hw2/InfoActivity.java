package edu.sjsu.android.hw2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class InfoActivity extends Activity {

    private static final int INTENT_GET_MSG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_page);


    }

    public void onClick(View view)
    {
        switch(view.getId()) {
            case R.id.button:
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:1800PENGUIN"));
                startActivity(dial);
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_info: {
                //Perform your click operation
                break;
            }
            case R.id.menu_uninstall: {
                //Perform your click operation
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:edu.sjsu.android.hw2"));
                startActivity(uninstall);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
