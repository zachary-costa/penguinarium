package edu.sjsu.android.hw2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends Activity {

    private static final int INTENT_GET_MSG = 1;
    private TextView pt;
    private TextView desc;
    private ImageView pp;
    final List<Integer> inputDescriptions = new ArrayList<>();
    final List<Integer> inputPictures = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penguin_details);
        inputDescriptions.add(R.string.emperor_desc);
        inputDescriptions.add(R.string.king_desc);
        inputDescriptions.add(R.string.gentoo_desc);
        inputDescriptions.add(R.string.chinstrap_desc);
        inputDescriptions.add(R.string.fairy_desc);
        inputPictures.add(R.drawable.emperor_bg);
        inputPictures.add(R.drawable.king_bg);
        inputPictures.add(R.drawable.gentoo_bg);
        inputPictures.add(R.drawable.chinstrap_bg);
        inputPictures.add(R.drawable.fairy_bg);


        pt = (TextView) findViewById(R.id.penguinTitle);
        desc = (TextView) findViewById(R.id.penguinDescription);
        pp = (ImageView) findViewById(R.id.penguinPicture);
        Bundle extra = getIntent().getExtras();
        String theName = extra.getString("name");
        int thePic = extra.getInt("picture");
        int theDesc = extra.getInt("desc");
        pt.setText(theName);
        pp.setImageResource(inputPictures.get(theDesc));
        desc.setText(inputDescriptions.get(theDesc));
    }

    public void penguinDetailsSet(String name, String d, int pic) {
        pt.setText(name);
        desc.setText(d);
        pp.setImageResource(pic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_info: {
                //Perform your click operation
                Intent intent = new Intent(DetailActivity.this, InfoActivity.class);
                startActivityForResult(intent, INTENT_GET_MSG);
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
