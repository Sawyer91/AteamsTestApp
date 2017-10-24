package com.sawyerd.ateamstest;

import android.content.Intent;
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

public class DisplayCommentsActivity extends AppCompatActivity {

    TextView nameView;
    TextView emailView;
    TextView commentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_comments);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int n = Integer.parseInt(message);

        nameView = (TextView) findViewById(R.id.nameView);
        emailView = (TextView) findViewById(R.id.emailView);
        commentView = (TextView) findViewById(R.id.commentView);

        String url = "https://jsonplaceholder.typicode.com/comments/" + n;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null,  new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.v("Post", "Response: " + response.toString());

                try {
                    nameView.setText(response.get("name").toString());
                    emailView.setText(response.get("email").toString());
                    commentView.setText(response.get("body").toString());
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
