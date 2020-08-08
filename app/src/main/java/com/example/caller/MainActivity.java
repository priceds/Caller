package com.example.caller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText txt_phn;
 Button btn_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_phn=(EditText)findViewById(R.id.txt_phn);
        btn_call=(Button)findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                mck();
            }
        });


    }
    private void mck()
    {


        
        String number = "tel:" + txt_phn.getText().toString().trim();

        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));

        try {
            startActivity(callIntent);
            finish();
            Log.i("Finished making a call", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}