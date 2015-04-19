package com.project.tbs.tbs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

/**
 * Created by home on 19-04-2015.
 */
public class MainActivity extends Activity {

    TextView signUp;
    TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (TextView)findViewById(R.id.signup);
        skip = (TextView)findViewById(R.id.skip);

        String myString=new String("Sign Up");
        SpannableString content = new SpannableString(myString);
        content.setSpan(new UnderlineSpan(), 0, myString.length(), 0);
        signUp.setText(content);

        String myString1=new String("Skip");
        SpannableString content1 = new SpannableString(myString1);
        content1.setSpan(new UnderlineSpan(), 0, myString1.length(), 0);
        skip.setText(content1);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent l_intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(l_intent);

            }
        });


    }
}
