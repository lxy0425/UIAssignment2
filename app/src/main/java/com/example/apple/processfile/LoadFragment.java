package com.example.apple.processfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by apple on 15-01-08.
 */
public class LoadFragment extends ListFragment implements View.OnClickListener{
    Button load;
    Button back_in_load;
    StartFragment startFragment;
    LoadFragmentN loadFragmentN;
    ArrayList<String>list = new ArrayList<String>();
    public View onCreateView(LayoutInflater inflater , ViewGroup vp , Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.load,vp,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        load = (Button)getView().findViewById(R.id.load);
        back_in_load = (Button)getView().findViewById(R.id.back_in_load);
        load.setOnClickListener(this);
        back_in_load.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.load:
                ((MainActivity)getActivity()).readAllName();
                list.clear();
                list = ((MainActivity)getActivity()).getListName();
                setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list));
                break;
            case R.id.back_in_load:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                startFragment = new StartFragment();
                fragmentTransaction.replace(R.id.content,startFragment).commit();
                break;
        }
    }
    public void onListItemClick(ListView parent,View view,int position,long id){
        ((MainActivity)getActivity()).readPeople(list.get(position));
        loadFragmentN = new LoadFragmentN();
        FragmentManager fragmentManager2 = getFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.content,loadFragmentN).commit();
    }
}
