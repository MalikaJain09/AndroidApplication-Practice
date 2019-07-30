package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
//    GridView listView;

    RecyclerView recyclerView;

    ArrayList<Customer> customers;
    CustomerAdapter adapter;
    CustomerRecyclerAdapter recyclerAdapter;


    void initViews(){
        listView = findViewById(R.id.listView);
        //dffghhuh
//        recyclerView = findViewById(R.id.recyclerView);

        Customer c1 = new Customer(R.drawable.person, "John", "+91 99999 88888");
        Customer c2 = new Customer(R.drawable.person1, "Jennie", "+91 89999 88888");
        Customer c3 = new Customer(R.drawable.person1, "Jim", "+91 78999 88888");
        Customer c4 = new Customer(R.drawable.person1, "Jack", "+91 95999 88888");
        Customer c5 = new Customer(R.drawable.person1, "Joe", "+91 98009 88888");
        Customer c6 = new Customer(R.drawable.person, "John", "+91 99999 88888");
        Customer c7 = new Customer(R.drawable.person1, "Jennie", "+91 89999 88888");
        Customer c8 = new Customer(R.drawable.person1, "Jim", "+91 78999 88888");
        Customer c9 = new Customer(R.drawable.person1, "Jack", "+91 95999 88888");
        Customer c10 = new Customer(R.drawable.person1, "Joe", "+91 98009 88888");
        Customer c11 = new Customer(R.drawable.person, "John", "+91 99999 88888");
        Customer c12 = new Customer(R.drawable.person1, "Jennie", "+91 89999 88888");
        Customer c13 = new Customer(R.drawable.person1, "Jim", "+91 78999 88888");
        Customer c14 = new Customer(R.drawable.person1, "Jack", "+91 95999 88888");
        Customer c15 = new Customer(R.drawable.person1, "Joe", "+91 98009 88888");
        //Customer c6 = new Customer(R.drawable.p6, "Jai", "+91 89991 88888");

        customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(new Customer(R.drawable.person1, "Jai", "+91 89991 88888")); // 5
        customers.add(c6);
        customers.add(c7);
        customers.add(c8);
        customers.add(c9);
        customers.add(c10);
        customers.add(c11);
        customers.add(c12);
        customers.add(c13);
        customers.add(c14);
        customers.add(c15);

        adapter = new CustomerAdapter(this, R.layout.list_item, customers);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        recyclerAdapter = new CustomerRecyclerAdapter(this, R.layout.list_item, customers);

//        // Recycler View should display the data as List View
////        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
//
//        // Recycler View should display the data as Grid View
//        GridLayoutManager layoutManager2 = new GridLayoutManager(this, 2);

//        recyclerView.setLayoutManager(layoutManager2);
//        recyclerView.setAdapter(recyclerAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Customer customer = customers.get(pos);
        Toast.makeText(this, "You Selected:"+customer, Toast.LENGTH_LONG).show();
    }
}
