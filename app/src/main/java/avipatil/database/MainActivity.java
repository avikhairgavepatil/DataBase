package avipatil.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,number;
    Button add,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editTextName);
        number= (EditText) findViewById(R.id.editTextPhoneNumber);
        add = (Button) findViewById(R.id.buttonAdd);
        show = (Button) findViewById(R.id.buttonShow);
        final DB db = new DB(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String Number=number.getText().toString();
                ContactPojo contactPojo=new ContactPojo(Name,Number);

                db.insertDate(Name,Number);
                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowContact.class);
                startActivity(intent);
            }
        });

    }
}
