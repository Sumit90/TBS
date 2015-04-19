package com.project.tbs.tbs;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

/**
 * Created by home on 19-04-2015.
 */
public class SignUp extends Activity {

    TextView alreadyAcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        alreadyAcc=(TextView)findViewById(R.id.already_account);

        String myString=new String("Already have an account?Login");
        SpannableString content = new SpannableString(myString);
        content.setSpan(new UnderlineSpan(), 0, myString.length(), 0);
        alreadyAcc.setText(content);

        alreadyAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignUp.this.finish();
            }
        });

    }
}
