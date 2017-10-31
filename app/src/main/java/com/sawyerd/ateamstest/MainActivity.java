package com.sawyerd.ateamstest;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.sawyerd.ateamstest.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:

                        setTitle("Main");
                        Main fragment = new Main();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content, fragment, "FragmentName");
                        fragmentTransaction.commit();

                        return true;

                    case R.id.about_me:

                        setTitle("About Me");
                        About_me about_me = new About_me();
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.content, about_me, "FragmentName");
                        fragmentTransaction2.commit();

                        return true;
                }


                return false;
            }
        });

        setTitle("Main");
        Main fragment = new Main();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "FragmentName");
        fragmentTransaction.commit();
    }

    public void post(View view){
        Intent intent = new Intent(this, DisplayPostActivity.class);
        EditText editText = (EditText) findViewById(R.id.editPost);
        String message = editText.getText().toString();
        int n = Integer.parseInt(message);
        if (n <= 100 & n != 0) {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "n Больше 100", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void comments(View view){
        Intent intent = new Intent(this, DisplayCommentsActivity.class);
        EditText editText = (EditText) findViewById(R.id.editComment);
        String message = editText.getText().toString();
        int n = Integer.parseInt(message);
        if(n<=500) {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "n Больше 500", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void users(View view){
        Intent intent = new Intent(this, DisplayUsersActivity.class);
        EditText editText = (EditText) findViewById(R.id.editUser);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void photo(View view){
        Intent intent = new Intent(this, DisplayPhotoActivity.class);
        EditText editText = (EditText) findViewById(R.id.editPhoto);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void todo(View view){
        Intent intent = new Intent(this, DisplayTodoActivity.class);
        EditText editText = (EditText) findViewById(R.id.editToDo);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }


}
