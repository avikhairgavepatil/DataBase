package avipatil.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by avipatil on 4/17/2017.
 */

public class AdapterClass extends ArrayAdapter {
    private Context context;
    private int resources;
    private  List<ContactPojo>contactPojoList;
    public AdapterClass(Context context, int resource, List<ContactPojo> contactPojoList) {
        super(context, resource, contactPojoList);
        this.context=context;
        this.contactPojoList=contactPojoList;
        this.resources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ContactPojo contactPojo=contactPojoList.get(position);
        View view = LayoutInflater.from(context).inflate(resources,parent,false);
        TextView textViewName= (TextView) view.findViewById(R.id.textViewName);
        TextView textViewNumber= (TextView) view.findViewById(R.id.textViewNumber);
        textViewName.setText("Name:"+contactPojo.getName());
        textViewNumber.setText("Number:"+contactPojo.getNumber());

        return view;
    }
    public void removeItem(int i) {
        //Contact contact = new Contact()
        ContactPojo contact = (ContactPojo) getItem(i);
        DB contactDB = new DB(context);
        contactDB.removeItem(i);
        contactPojoList.remove(contact);
    }
}
