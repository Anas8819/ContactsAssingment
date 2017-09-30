package com.example.anas.contactsassingment1;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.constraint.solver.ArrayRow;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anas.contactsassingment1.adapters.ContactsAdapter;
import com.example.anas.contactsassingment1.models.Contacts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.zip.Inflater;

import static android.R.attr.button;
import static android.R.attr.id;
import static android.R.attr.max;
import static android.R.attr.name;
import static android.R.attr.publicKey;
import static android.provider.ContactsContract.*;
import static android.provider.ContactsContract.CommonDataKinds.*;
import static com.example.anas.contactsassingment1.R.layout.contact_item_list;

public class MainActivity extends AppCompatActivity {

    private Button callButton;
    private int contact_list;
    ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView recyclerView = (ListView) findViewById(R.id.Contact_list);



        for (int i = 1; i < 1000; i++) {
            String gender;
            if (i % 2 == 0) {
                gender = "male";
            } else {
                gender = "female";
            }
            contactList.add(new Contacts(i, "This is name " + i, "0308436777" + i, gender));
        }
        ContactsAdapter contactsAdapter = new ContactsAdapter(this, contactList);

        recyclerView.setAdapter(contactsAdapter);


    }

    public void call(View view) {
        callButton = (Button) findViewById(R.id.Call);
        TextView textView = (TextView)  ((View) view.getParent()).findViewById(R.id.Phone);
        String number = textView.getText().toString();
        Intent i = new Intent(Intent.ACTION_CALL);
        final String uriString = "tel: " + number;
        i.setData(Uri.parse(uriString));
        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(i);
    }
}
