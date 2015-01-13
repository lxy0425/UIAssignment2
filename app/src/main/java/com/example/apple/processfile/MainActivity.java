package com.example.apple.processfile;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class MainActivity extends FragmentActivity{
    public static final String NOTES = "notes.txt";
    StartFragment startFragment;
    public static ArrayList<String> list_name = new ArrayList<String>();
    public static ArrayList<People> tempList = new ArrayList();
    public static ArrayList<People> list = new ArrayList();
    public static boolean ifSaved = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment = new StartFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,startFragment).commit();
    }


    public void writePeople(ArrayList<People> list,String s){
        try {
            String path = s+".txt";
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(path, 0));
            for(int i = 0 ; i < list.size(); i++) {
                out.write(list.get(i).getName() + "\n");
                out.write(new Integer(list.get(i).getAge()).toString() + "\n");
                out.write(list.get(i).getFood() + "\n");
            }
            out.close();
            OutputStreamWriter outPath = new OutputStreamWriter(openFileOutput(NOTES, MODE_APPEND));
            outPath.write(path + "\n");
            outPath.close();
        }
        catch(Throwable t){
            Toast.makeText(this,"Exception: "+t.toString(),Toast.LENGTH_LONG).show();
        }
    }

//    public void readAllPeople(){
//        try {
//            InputStream inPath = openFileInput(NOTES);
//            if(inPath != null) {
//                InputStreamReader buffer = new InputStreamReader(inPath);
//                BufferedReader reader  = new BufferedReader(buffer);
//                String s;
//                list.clear();
//                while((s = reader.readLine())!= null){
//                    try {
//                        InputStream in = openFileInput(s);
//                        if(in != null) {
//                            InputStreamReader buffer2 = new InputStreamReader(in);
//                            BufferedReader reader2  = new BufferedReader(buffer2);
//                            String s2;
//                            int count = 0;
//                            String name = "";
//                            int age = 0;
//                            String food = "";
//                            while((s2 = reader2.readLine())!= null){
//                                if(count % 3 == 0){
//                                    name = s2;
//                                }
//                                else if(count % 3 ==1){
//                                    age = new Integer(s2);
//                                }
//                                else{
//                                    food = s2;
//                                    list.add(new People(name,age,food));
//                                }
//                                count++;
//                            }
//                        }
//                    }
//                    catch(FileNotFoundException e){
//                    }
//                    catch(Throwable t){
//                        Toast.makeText(this,"Exception: "+t.toString(),Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        }
//        catch(FileNotFoundException e){
//        }
//        catch(Throwable t){
//            Toast.makeText(this,"Exception: "+t.toString(),Toast.LENGTH_LONG).show();
//        }
//    }

        public void readPeople(String path){
        try {
            InputStream inputStream = openFileInput(path);
            if(inputStream != null) {
                InputStreamReader buffer = new InputStreamReader(inputStream);
                BufferedReader reader  = new BufferedReader(buffer);
                String s;
                int count = 0;
                String name = "";
                int age = 0;
                String food = "";
                list.clear();
                while((s = reader.readLine())!= null){
                    if(count % 3 == 0){
                        name = s;
                    }
                    else if(count % 3 ==1){
                        age = new Integer(s);
                    }
                    else{
                        food = s;
                        list.add(new People(name,age,food));
                    }
                    count++;
                }
            }
        }
        catch(FileNotFoundException e){
        }
        catch(Throwable t){
            Toast.makeText(this,"Exception: "+t.toString(),Toast.LENGTH_LONG).show();
        }
                }

        public void readAllName(){
        try {
            InputStream inPath = openFileInput(NOTES);
            if(inPath != null) {
                InputStreamReader buffer = new InputStreamReader(inPath);
                BufferedReader reader  = new BufferedReader(buffer);
                String s;
                list_name.clear();
                while((s = reader.readLine())!= null){
                    list_name.add(s);
                }
                buffer.close();
                reader.close();
            }
        }
        catch(FileNotFoundException e){
        }
        catch(Throwable t){
            Toast.makeText(this,"Exception: "+t.toString(),Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList getListName(){
        return this.list_name;
    }
    public ArrayList getTempList(){
        return this.tempList;
    }
    public ArrayList getList(){
        return this.list;
    }

    public void setTempList(ArrayList<People>list){
        (this.tempList).clear();
        (this.tempList) = list;
    }

    public boolean getIfSaved(){
        return this.ifSaved;
    }
    public void setIfSaved(boolean x){
        this.ifSaved = x;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
