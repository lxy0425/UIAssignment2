package com.example.apple.processfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by apple on 15-01-07.
 */
public class StoreFragment extends Fragment implements View.OnClickListener{
    Button save;
    Button back_in_store;
    EditText editText;
    StartFragment startFragment;
    public View onCreateView(LayoutInflater inflater , ViewGroup vp , Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.store,vp,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        save = (Button)getView().findViewById(R.id.save);
        back_in_store = (Button)getView().findViewById(R.id.back_in_store);
        save.setOnClickListener(this);
        back_in_store.setOnClickListener(this);
        editText = (EditText)getView().findViewById(R.id.text_store);
    }
    public void onClick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        switch (view.getId()){
            case R.id.save:
                ((MainActivity)getActivity()).writePeople(((MainActivity)(getActivity())).getTempList(),editText.getText().toString());
                ((MainActivity)getActivity()).setIfSaved(true);
                break;
            case R.id.back_in_store:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                startFragment = new StartFragment();
                fragmentTransaction.replace(R.id.content,startFragment).commit();
                break;
        }
    }

}
