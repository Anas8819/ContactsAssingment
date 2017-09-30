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
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anas.contactsassingment1.adapters.ContactsAdapter;
import com.example.anas.contactsassingment1.models.Contacts;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.R.attr.button;
import static android.R.attr.publicKey;
import static com.example.anas.contactsassingment1.R.layout.contact_item_list;

public class MainActivity extends AppCompatActivity {

    private Button callButton;
    private int contact_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView listView = (ListView) findViewById(R.id.Contact_list);

        final ArrayList<Contacts> array = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            String gender;
            if (i % 2 == 0) {
                gender = "male";
            } else {
                gender = "female";
            }
            array.add(new Contacts(i, "This is name " + i, "030303303030" + i, gender));
        }

        ContactsAdapter contactsAdapter = new ContactsAdapter(this, array);

        listView.setAdapter(contactsAdapter);


        /*callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:03084367772"));
            }
        });
        startActivity(i);
*/


    }

    public void call(View view) {
        callButton = (Button) findViewById(R.id.Call);
        Intent i = new Intent(Intent.ACTION_CALL);
        String p = "tel: 03084367772";
        i.setData(Uri.parse(p));
        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(i);
    }
}
