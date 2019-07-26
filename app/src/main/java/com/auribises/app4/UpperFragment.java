package com.auribises.app4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class UpperFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;
    MyListner listner;    //Create Reference of My Listener
    public UpperFragment() {
        // Required empty public constructor
    }
    public void setMyListner(MyListner listner){
        this.listner=listner;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upper, container, false);
    }
    //onViewCreated is a overridded method and is solving the purpose of initialising the views
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //view is a reference variable which refers to the layout of the fragment
       listView=view.findViewById(R.id.listView);
       adapter= new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1);
       adapter.add("Zee News");
       adapter.add("CNN");
        adapter.add("ABP");
        adapter.add("IBN");
        adapter.add("AAJ TAK");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        String news=adapter.getItem(pos);
        Toast.makeText(getContext(), "You selected:"+news, Toast.LENGTH_SHORT).show();

        String url="";
        if (pos==0){
            url="https://zeenews.india.com/";
        }
        else if(pos==1)
        {
            url="https://edition.cnn.com/";
        }
        else if (pos==2){
            url="https://abpnews.abplive.in/";
        }
        else if (pos==3){
            url="https://www.news18.com/";
        }
        else {
            url="https://aajtak.intoday.in";
        }

        listner.onClick(pos,url);


    }
}
