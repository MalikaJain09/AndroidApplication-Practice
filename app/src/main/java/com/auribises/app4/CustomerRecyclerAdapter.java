package com.auribises.app4;

import android.content.Context;

import java.util.ArrayList;

public class CustomerRecyclerAdapter {
    Context context;
    int resource;
    ArrayList<Customer> objects;

    public CustomerRecyclerAdapter(Context context, int resource, ArrayList<Customer> objects) {


        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
}
