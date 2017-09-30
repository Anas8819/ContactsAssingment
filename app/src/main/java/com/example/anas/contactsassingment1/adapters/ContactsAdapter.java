package com.example.anas.contactsassingment1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anas.contactsassingment1.R;
import com.example.anas.contactsassingment1.models.Contacts;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Anas on 29/09/2017.
 */

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    public ContactsAdapter(@NonNull Context context, @NonNull List<Contacts> objects) {

        super(context,0,objects);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View view = LayoutInflater.from(getContext()).inflate(R.layout.contact_item_list,parent,false);

        Contacts u = getItem(position);
        TextView Name = (TextView) view.findViewById(R.id.Name);
        TextView Phone = (TextView) view.findViewById(R.id.Phone);
        TextView Gender = (TextView) view.findViewById(R.id.Gender);

        Name.setText(u.getName());
        Phone.setText(u.getPhone());
        Gender.setText(u.getGender());


        return view;



    }



}
