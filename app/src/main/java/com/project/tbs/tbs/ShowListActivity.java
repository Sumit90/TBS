package com.project.tbs.tbs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by home on 24-05-2015.
 */
public class ShowListActivity extends Activity {

    private Context context;
    private ListView listView;
    public static final String KEY_COLOUR_CODE="colourCode";
    public static final String KEY_COLOUR_NAME="colourName";
    public static final String KEY_COLOUR_VALUE="colourValue";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        context= ShowListActivity.this;
        listView=(ListView)findViewById(R.id.listview);

        MyDatabase myDatabase = new MyDatabase(context);
        final List<ColourPOJO> colourPOJOList = myDatabase.getAllColours();

        if(colourPOJOList.size()>0)
        {

          final MyArrayAdapter adapter = new MyArrayAdapter(this,
                  colourPOJOList);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, final View view,
                                        int position, long id) {

                    ColourPOJO colourPOJO = colourPOJOList.get(position);

                    Intent l_intent=new Intent(context,ShowActivity.class);
                    l_intent.putExtra(KEY_COLOUR_CODE,colourPOJO.getColourCode());
                    l_intent.putExtra(KEY_COLOUR_NAME,colourPOJO.getColourName());
                    l_intent.putExtra(KEY_COLOUR_VALUE,colourPOJO.getColourHex());

                    startActivity(l_intent);
                }

            });

        }
        else
        {
            Toast.makeText(context, "No colours found in the database", Toast.LENGTH_LONG).show();
        }



    }


    }
