package com.sawyerd.ateamstest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DisplayTodoActivity extends AppCompatActivity {

    TextView todoView;
    TextView stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_todo);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int n = Integer.parseInt(message);

        todoView =(TextView) findViewById(R.id.todoTitleView);
        stat = (TextView) findViewById(R.id.statusView);

        String url = "https://jsonplaceholder.typicode.com/todos/" + n;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Log.v("Post", "Response: " + response.toString());

                        try {
                            todoView.setText(response.get("title").toString());
                            String s = response.get("completed").toString();
                            if(s.equals("true")){
                                stat.setText("Выполнено");
                                stat.setTextColor(Color.parseColor("#00FF00"));
                            }else {
                                stat.setText("Не выполнено");
                                stat.setTextColor(Color.parseColor("#FF0000"));
                            }
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
