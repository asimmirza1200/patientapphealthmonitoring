package com.f.healthmonitoring.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.f.healthmonitoring.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LoginActivity extends AppCompatActivity {
    EditText email, pass;
    Button signin;
    private TextView signup;
    ImageView top_curve;
    TextView email_text, password_text, login_title;
    ImageView logo;
    LinearLayout new_user_layout;
    CardView login_card;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        signin = findViewById(R.id.login_button);
        top_curve = findViewById(R.id.top_curve);
        email = findViewById(R.id.email);
//        email_text = findViewById(R.id.email_text);
        pass = findViewById(R.id.password);
//        password_text = findViewById(R.id.password_text);
        logo = findViewById(R.id.logo);
//        login_title = findViewById(R.id.login_text);
//        new_user_layout = findViewById(R.id.new_user_text);
        login_card = findViewById(R.id.login_card);


        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.edittext_anim);
        email.startAnimation(editText_anim);
        pass.startAnimation(editText_anim);

        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.field_name_anim);
//        email_text.startAnimation(field_name_anim);
//        password_text.startAnimation(field_name_anim);
        logo.startAnimation(field_name_anim);
//        login_title.startAnimation(field_name_anim);

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_top);
//        new_user_layout.startAnimation(new_user_anim);



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(mainIntent);
                LoginActivity.this.finish();

                if(email.getText().toString().isEmpty())
                {
                    email.setError("Please Enter phone");
                }
                else if(pass.getText().toString().isEmpty())
                {
                    pass.setError("Please Enter password");

                }
                else
                {


                }
            }

        });


    }

}