package com.project.tbs.tbs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by home on 24-05-2015.
 */
public class ShowActivity extends Activity {

    TextView colourCode;
    TextView colourName;
    ImageView showImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        colourCode =(TextView)findViewById(R.id.show_colourCode);
        colourName =(TextView)findViewById(R.id.show_colourName);
        showImage=(ImageView)findViewById(R.id.show_colourValue);

        Intent l_intent=getIntent();

        if(l_intent!=null) {
            colourCode.setText(colourCode.getText().toString() + "   " + l_intent.getStringExtra(ShowListActivity.KEY_COLOUR_CODE));
            colourName.setText(colourName.getText().toString() + "   " + l_intent.getStringExtra(ShowListActivity.KEY_COLOUR_NAME));
            showImage.setBackgroundColor(Color.parseColor(l_intent.getStringExtra(ShowListActivity.KEY_COLOUR_VALUE)));
        }
    }

    }
