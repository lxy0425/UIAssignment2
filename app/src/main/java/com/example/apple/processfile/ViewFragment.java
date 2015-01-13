package com.example.apple.processfile;

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

import java.util.ArrayList;

/**
 * Created by apple on 15-01-07.
 */
public class ViewFragment extends ListFragment implements View.OnClickListener{
    Button back_in_view;
    Button view_in_view;
    StartFragment startFragment;
    ArrayList<String> item = new ArrayList();
    ArrayList<People> list = new ArrayList();
    public View onCreateView(LayoutInflater inflater, ViewGroup vp, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.view,vp,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        back_in_view = (Button)getView().findViewById(R.id.back_in_view);
        view_in_view = (Button)getView().findViewById(R.id.view_in_view);
        back_in_view.setOnClickListener(this);
        view_in_view.setOnClickListener(this);
//        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1));
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.view_in_view:
                list = ((MainActivity)getActivity()).getTempList();
                for(int i = 0 ; i < list.size();i++){
                    item.add(list.get(i).getName());
                    item.add(new Integer(list.get(i).getAge()).toString());
                    item.add(list.get(i).getFood());
            }
                setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,item));
                break;
            case R.id.back_in_view:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                startFragment = new StartFragment();
                fragmentTransaction.replace(R.id.content,startFragment).commit();
                break;
        }
    }
}
