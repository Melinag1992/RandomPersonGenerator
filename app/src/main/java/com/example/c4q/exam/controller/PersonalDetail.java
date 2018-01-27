package com.example.c4q.exam.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.exam.R;
import com.example.c4q.exam.model.Results;
import com.squareup.picasso.Picasso;

/**
 * Created by c4q on 1/24/18.
 */

public class PersonalDetail extends AppCompatActivity {
    private ImageView personImage;
    private TextView fullName;
    private TextView email;
    private TextView phoneNumber;
    private TextView addressLine1;
    private TextView addressLine2;
    private TextView dob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_person_layout);

        setViews();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Bundle outerObject = getIntent().getExtras();
        Results result = null;



    }

    public void setViews() {

        personImage = findViewById(R.id.image_view);
        fullName = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone_number);
        addressLine1 = findViewById(R.id.address_line1);
        addressLine2 = findViewById(R.id.address_line2);
        dob = findViewById(R.id.dob);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
