package com.example.apple.processfile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by apple on 15-01-07.
 */
public class ViewActivity extends ListActivity implements View.OnClickListener {
    Button back_in_view;
    ArrayList<String> item = new ArrayList();
    ArrayList<People> list = new ArrayList();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        back_in_view = (Button)findViewById(R.id.back_in_view);
        back_in_view.setOnClickListener(this);
        list = (ArrayList<People>)getIntent().getSerializableExtra("TEMPLIST");
        for(int i = 0 ; i < list.size();i++){
            item.add("Name: "+list.get(i).getName());
            item.add("Age: "+new Integer(list.get(i).getAge()).toString());
            item.add("Favourite Food: "+list.get(i).getFood());
            item.add(" ");
        }
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item));
    }
    public void onClick(View view){
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
    }
}
