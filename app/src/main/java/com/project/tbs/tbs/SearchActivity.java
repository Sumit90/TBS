package com.project.tbs.tbs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by home on 24-05-2015.
 */
public class SearchActivity extends Activity{

    TextView colourCode;
    Button searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        colourCode=(TextView)findViewById(R.id.search_code);
        searchButton=(Button)findViewById(R.id.search_colour);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabase database=new MyDatabase(SearchActivity.this);
                ColourPOJO colourPOJO = database.getColour(colourCode.getText().toString());

                if(colourPOJO!=null)
                {
                    Intent l_intent=new Intent(SearchActivity.this,ShowActivity.class);
                    l_intent.putExtra(ShowListActivity.KEY_COLOUR_CODE,colourPOJO.getColourCode());
                    l_intent.putExtra(ShowListActivity.KEY_COLOUR_NAME,colourPOJO.getColourName());
                    l_intent.putExtra(ShowListActivity.KEY_COLOUR_VALUE,colourPOJO.getColourHex());

                    startActivity(l_intent);
                    SearchActivity.this.finish();

                }
                else
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SearchActivity.this);

                    // Setting Dialog Title
                    alertDialog.setTitle("Please make a choice");

                    // Setting Dialog Message
                    alertDialog.setMessage("No colour found. Would you like to select it from list?");


                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {

                            Intent l_intent=new Intent(SearchActivity.this,ShowListActivity.class);
                            startActivity(l_intent);
                            SearchActivity.this.finish();
                        }
                    });

                    // Setting Negative "NO" Button
                    alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();

                }



            }
        });

    }

    }
