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

        Bundle outerObject = getIntent().getExtras();
        Results result = null;

        if (outerObject != null) {
            result = (Results) outerObject.getSerializable("results");

            Picasso.with(getApplicationContext()).load(result.getPicture().getLarge())
                    .into(personImage);
            fullName.setText(result.getName().getTitle()+". "+result.getName().getFirst()+" "+result.getName().getLast());
            email.setText(result.getEmail());
            phoneNumber.setText(result.getCell());
            addressLine1.setText(result.getLocation().getStreet());
            addressLine2.setText(result.getLocation().getState()+", "+result.getLocation().getCity()+" "+result.getLocation().getPostcode());
            dob.setText(result.getDob());
        }

    }

    public void setViews() {

        personImage = findViewById(R.id.image);
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
