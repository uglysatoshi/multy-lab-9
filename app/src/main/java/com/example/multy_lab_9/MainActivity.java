package com.example.multy_lab_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TextView textView = findViewById(R.id.text);
        registerForContextMenu(textView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu, menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.color_red){
            TextView textView = findViewById(R.id.text);
            textView.setTextColor(Color.parseColor("red"));
        }
        if (id == R.id.color_black){
            TextView textView = findViewById(R.id.text);
            textView.setTextColor(Color.parseColor("black"));
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.show_text) {
            if (item.isChecked()) {
                TextView textView = findViewById(R.id.text);
                textView.setVisibility(TextView.VISIBLE);
                item.setChecked(false);
            }
            else {
                TextView textView = findViewById(R.id.text);
                textView.setVisibility(TextView.INVISIBLE);
                item.setChecked(true);
            }
        }
        if (id == R.id.show_student) {
            Toast.makeText(MainActivity.this, R.string.student, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}