package com.auribises.app4.viewcontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.auribises.app4.R;
import com.auribises.app4.model.Customer;

public class AddCustomerActivity extends AppCompatActivity implements View.OnClickListener {
    EditText eTxtName,eTxtPhone,eTxtEmail;
    Button btnAdd;
    Customer customer;
    ContentResolver resolver;
    boolean updateMode;

    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone=findViewById(R.id.editTextPhone);
        eTxtEmail = findViewById(R.id.editTextEmail);
        btnAdd= findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(this);

        customer = new Customer();
        resolver =getContentResolver();
        Intent rcv = getIntent();
        updateMode = rcv.hasExtra("keyCustomer");
        if(updateMode){
            customer = (Customer) rcv.getSerializableExtra("keyCustomer");
            eTxtName.setText(customer.name);
            eTxtPhone.setText(customer.phone);
            eTxtEmail.setText(customer.email);
            btnAdd.setText("Update Customer");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        initViews();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.buttonAdd) {
            customer.name = eTxtName.getText().toString();
            customer.phone = eTxtPhone.getText().toString();
            customer.email = eTxtEmail.getText().toString();
            Toast.makeText(this, customer.toString(), Toast.LENGTH_LONG).show();
            String tabName = "Customer";
            Uri uri = Uri.parse("content://com.auribises.app4.mycp/" + tabName);
            ContentValues values = new ContentValues();
            values.put("name", customer.name);
            values.put("phone", customer.phone);
            values.put("email", customer.email);

            if (!updateMode) {

                Uri dummyUri = resolver.insert(uri, values);
                Toast.makeText(this, customer.name + " Added at " + dummyUri.getLastPathSegment(), Toast.LENGTH_LONG).show();

                eTxtName.setText("");
                eTxtPhone.setText("");
                eTxtEmail.setText("");
            } else {

                String where = "_ID = " + customer.id;
                int i = resolver.update(uri, values, where, null);
                if (i > 0) {
                    Toast.makeText(this, customer.name + " Updated", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(this, customer.name + " Not Updated", Toast.LENGTH_LONG).show();
                }

            }
        }

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        if(!updateMode) {
            menu.add(1, 101, 1, "Customers").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == 101){
            //Toast.makeText(this, "You Selected Customers", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(AddCustomerActivity.this, AllCustomersActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}


