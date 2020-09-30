package edu.sjsu.android.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final int INTENT_GET_MSG = 1;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final List<String> input = new ArrayList<>();
        final List<Integer> inputImageNames = new ArrayList<>();
            input.add("Emperor Penguin");
            input.add("King Penguin");
            input.add("Gentoo Penguin");
            input.add("Chinstrap Penguin");
            input.add("Fairy Penguin");
            inputImageNames.add(R.mipmap.emperor_penguin);
            inputImageNames.add(R.mipmap.king_penguin);
            inputImageNames.add(R.mipmap.gentoo_penguin);
            inputImageNames.add(R.mipmap.chinstrap_penguin);
            inputImageNames.add(R.mipmap.fairy_penguin);

        mAdapter = new MyAdapter(input, inputImageNames);
        recyclerView.setAdapter(mAdapter);

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
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
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