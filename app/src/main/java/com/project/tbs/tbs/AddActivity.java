package com.project.tbs.tbs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by home on 10-05-2015.
 */
public class AddActivity extends Activity {

    private EditText rValue;
    private EditText gValue;
    private EditText bValue;
    private EditText code;
    private EditText name;
    private Button addColour;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_color);

        context=AddActivity.this;

        rValue=(EditText)findViewById(R.id.r_value);
        gValue=(EditText)findViewById(R.id.g_value);
        bValue=(EditText)findViewById(R.id.b_value);
        code=(EditText)findViewById(R.id.code_value);
        name=(EditText)findViewById(R.id.code_name);
        addColour=(Button)findViewById(R.id.add_colour);


        addColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabase database = new MyDatabase(context);
                int r= Integer.valueOf(rValue.getText().toString());
                int g=Integer.valueOf(gValue.getText().toString());
                int b=Integer.valueOf(bValue.getText().toString());
                String hex=String.format("#%02x%02x%02x", r, g, b);

                ColourPOJO newColour=new ColourPOJO(code.getText().toString(),name.getText().toString(),
                        r+","+g+","+b,hex);
                boolean isAdded=database.addColour(newColour);

                if(isAdded)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddActivity.this);

                    // Setting Dialog Title
                    alertDialog.setTitle("Success");

                    // Setting Dialog Message
                    alertDialog.setMessage("Colour added successfully");


                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {

                            Intent l_intent=new Intent(AddActivity.this,ShowListActivity.class);
                            startActivity(l_intent);
                            AddActivity.this.finish();
                        }
                    });



                    // Showing Alert Message
                    alertDialog.show();

                    Toast.makeText(context,"Colour Successfully added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(context,"Colour Code already exists in database",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
