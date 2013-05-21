package com.example.helloworld;

import com.androidquery.AQuery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;


/**
 * @author zhanglanyun
 *
 */
public class MainActivity extends Activity {

	private AQuery aquery;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        aquery = new AQuery(MainActivity.this);
        aquery.id(R.id.hello).text("Lanyun Zhang");
        
        Intent intent  = new Intent();
        intent.setClass(this, MActivity.class);
        startActivity(intent);
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}



