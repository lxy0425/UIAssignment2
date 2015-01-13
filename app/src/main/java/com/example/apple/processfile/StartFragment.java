package com.example.apple.processfile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by apple on 15-01-07.
 */
public class StartFragment extends Fragment implements View.OnClickListener{
    Button enter_button;
    Button load_button;
    Button view_button;
    Button store_button;
    Button exit_button;
    EnterFragment enterFragment;
    ViewFragment viewFragment;
    StoreFragment storeFragment;
    LoadFragment loadFragment;
//    ExitFragment exitFragment;
    public View onCreateView(LayoutInflater inflater , ViewGroup vp , Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.start,vp,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        enter_button = (Button)getView().findViewById(R.id.enter_button);
        load_button = (Button)getView().findViewById(R.id.load_button);
        view_button = (Button)getView().findViewById(R.id.view_button);
        store_button = (Button)getView().findViewById(R.id.store_button);
        exit_button = (Button)getView().findViewById(R.id.exit_button);
        enter_button.setOnClickListener(this);
        load_button.setOnClickListener(this);
        view_button.setOnClickListener(this);
        store_button.setOnClickListener(this);
        exit_button.setOnClickListener(this);
    }
    public void onClick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.enter_button:
                enterFragment = new EnterFragment();
                fragmentTransaction.replace(R.id.content, enterFragment).commit();
                break;
            case R.id.load_button:
                loadFragment = new LoadFragment();
                fragmentTransaction.replace(R.id.content,loadFragment).commit();
                break;
            case R.id.view_button:
                viewFragment = new ViewFragment();
                fragmentTransaction.replace(R.id.content,viewFragment).commit();
                break;
            case R.id.store_button:
                storeFragment = new StoreFragment();
                fragmentTransaction.replace(R.id.content,storeFragment).commit();
                break;
            case R.id.exit_button:
                    if((((MainActivity)getActivity()).getIfSaved())){
                        System.exit(0);
                }
                    else{
                        final EditText edit = new EditText(getActivity());
                        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                        dialog.setTitle("Exit");
                        dialog.setMessage("You have not stored your file,please create a name for the file you'd like to save first.");
                        dialog.setView(edit);
                        dialog.setPositiveButton("Confirm",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(!edit.getText().toString().isEmpty()) {
                                    ((MainActivity) getActivity()).writePeople(((MainActivity) (getActivity())).getTempList(), edit.getText().toString());
                                    System.exit(0);
                                }
                            }
                        });
                        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                    }
                    break;
                }

            }
    }
