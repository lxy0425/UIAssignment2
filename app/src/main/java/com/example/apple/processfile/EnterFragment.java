package com.example.apple.processfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 15-01-07.
 */
public class EnterFragment extends Fragment implements View.OnClickListener{
    EditText textName;
    EditText textAge;
    Spinner textFood;
    Button write_button;
    Button done_button;
    StartFragment startFragment;
    ArrayList<People> list = new ArrayList<People>();
    private ArrayAdapter<String> adapter;
    String tempFood;
    String[] food = {"apple","banana","orange","vegetable","chicken","meat","pork"};
    public View onCreateView(LayoutInflater inflater , ViewGroup vp , Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.enter,vp,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        textName = (EditText)getView().findViewById(R.id.name);
        textAge = (EditText)getView().findViewById(R.id.age);
        textFood = (Spinner)getView().findViewById(R.id.food);
        write_button = (Button)getView().findViewById(R.id.write_button);
        write_button.setOnClickListener(this);
        done_button = (Button)getView().findViewById(R.id.done_button);
        done_button.setOnClickListener(this);
        list.clear();
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,food);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        textFood.setAdapter(adapter);
        textFood.setOnItemSelectedListener(new SpinnerSelectedListener());

    }

    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int p,
                                   long id) {
            tempFood = food[p];
        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.write_button:
               // ((MainActivity)getActivity()).writePeople(new People(textName.getText().toString(),new Integer(textAge.getText().toString()),textFood.getText().toString()));
                list.add(new People(textName.getText().toString(), new Integer(textAge.getText().toString()), tempFood.toString()));
                textName.setText("");
                textAge.setText("");
//                textFood.setText("");
                if(!list.isEmpty())
                    ((MainActivity)getActivity()).setIfSaved(false);
                break;
            case R.id.done_button:
                ((MainActivity)(getActivity())).setTempList(list);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                startFragment = new StartFragment();
                fragmentTransaction.replace(R.id.content,startFragment).commit();
                break;
        }
    }
}
