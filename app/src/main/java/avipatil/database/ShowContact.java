package avipatil.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ShowContact extends AppCompatActivity {
    ListView listView;
    AdapterClass adapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        listView = (ListView) findViewById(R.id.listView);
        DB db =new DB(getApplicationContext());
        AdapterClass adapterClass= new AdapterClass(ShowContact.this,R.layout.row_item_list,db.getAllContacts());
        listView.setAdapter(adapterClass);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contex_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       // AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo  = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();
        switch (id)
        {
            case  R.id.delete:
                //adapterClass.remove(adapterContextMenuInfo.position);
               // AdapterClass adapterClass =new AdapterClass(getApplicationContext())
                //adapterClass.removeItem(id);
                //adapterClass.notifyDataSetChanged();
                break;
            case R.id.edit:
                Toast.makeText(ShowContact.this,"id"+adapterContextMenuInfo.position,Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
