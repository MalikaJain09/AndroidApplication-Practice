package com.auribises.app4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.auribises.app4.R;
import com.auribises.app4.model.Customer;

import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter<Customer> {
    Context context;
    int resource;
    ArrayList<Customer> objects;

    public CustomerAdapter(Context context, int resource, ArrayList<Customer> objects) {
        super(context, resource,objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = LayoutInflater.from(context).inflate(resource,parent,false);
        ImageView image = view.findViewById(R.id.imageView);
        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtPhone = view.findViewById(R.id.textViewPhone);

        Customer customer = objects.get(position);
        txtName.setText(customer.name);
        txtPhone.setText(customer.phone);
        return view;
    }
}

