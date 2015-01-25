package com.example.apple.processfile;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by apple on 15-01-08.
 */
public class LoadFragmentN extends ListFragment implements View.OnClickListener{
    Button back_in_loadn;
    ArrayList<People>list = new ArrayList<>();
    ArrayList<String>item = new ArrayList<>();
    LoadFragment loadFragment;
    LoadFragmentN loadFragmentN;
    public View onCreateView(LayoutInflater inflater , ViewGroup vp , Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.loadn,vp,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        list.clear();
        list = ((MainActivity)getActivity()).getList();
        for(int i = 0; i < list.size(); i++){
            item.add("Name: "+ list.get(i).getName());
            item.add("Age: "+ new Integer(list.get(i).getAge()).toString());
            item.add("Favourite Food: "+list.get(i).getFood());
            item.add(" ");
        }
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,item));
        back_in_loadn = (Button)getView().findViewById(R.id.back_in_loadn);
        back_in_loadn.setOnClickListener(this);
    }
    public void onClick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        loadFragment = new LoadFragment();
        fragmentTransaction.replace(R.id.content,loadFragment).commit();
    }
}
