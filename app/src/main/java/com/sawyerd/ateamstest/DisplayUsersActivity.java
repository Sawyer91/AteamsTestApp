package com.sawyerd.ateamstest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DisplayUsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter mAdapter;
    private ArrayList<Users> data_list;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_users);



        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int n = Integer.parseInt(message);

        init();


       load_data_from_server(n);


    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        data_list = new ArrayList<>();
        mAdapter = new CustomAdapter(data_list, this);
        recyclerView.setAdapter(mAdapter);
    }

    public void load_data_from_server(final int id) {

        String url = "https://jsonplaceholder.typicode.com/users/" + id;

            JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null,  new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("Post", "Response: " + response.toString());


                        try {

                            JSONObject object = response.getJSONObject("address");
                            Users user = new Users();
                            user.setName(response.get("name").toString());
                            user.setEmail(response.get("email").toString());
                            user.setStreet(object.get("street").toString());
                            user.setSuite(object.get("suite").toString());
                            user.setCity(object.get("city").toString());
                            user.setZipcode(object.get("zipcode").toString());
                            user.setPhone(response.get("phone").toString());
                            user.setWebsite(response.get("website").toString());
                            data_list.add(user);

                            //textview.setText(object.get("street").toString());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

                // Access the RequestQueue through your singleton class.

                RequestQueue queue = Volley.newRequestQueue(this);
                 queue.add(jsObjRequest);

            }
    }

