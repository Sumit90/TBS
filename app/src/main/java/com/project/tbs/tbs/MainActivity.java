package com.project.tbs.tbs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by home on 19-04-2015.
 */
public class MainActivity extends Activity {

   Button addColour;
   Button selectColour;
   Button searchColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addColour=(Button)findViewById(R.id.add_button);
        selectColour=(Button)findViewById(R.id.select_button);
        searchColour=(Button)findViewById(R.id.search_button);

        addColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent l_intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(l_intent);

            }
        });

        selectColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l_intent=new Intent(MainActivity.this,ShowListActivity.class);
                startActivity(l_intent);

            }
        });

        searchColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l_intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(l_intent);

            }
        });

    }
}
