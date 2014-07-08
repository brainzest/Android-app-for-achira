package achira.test;



import android.widget.GridView;
import android.widget.TabHost;
import android.widget.TextView;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.TabHost;



import android.widget.ImageButton;

public class menuActivity extends Activity implements OnClickListener {
	Intent testIntent;
	Intent resultIntent;
	Intent progIntent;
	Intent settingIntent;
	Intent backIntent;
	static final private int BACK = Menu.FIRST;
	DatabaseHelper dbHelper;
	GridView grid;
	TextView txtTest;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.menu);
     
        ImageButton a = (ImageButton) findViewById(R.id.b1);        
        ImageButton b = (ImageButton)findViewById(R.id.b2);
        ImageButton c = (ImageButton)findViewById(R.id.b3);
        ImageButton d = (ImageButton)findViewById(R.id.b4);
        Button bk = (Button)findViewById(R.id.back);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        bk.setOnClickListener(this);
       
        }
    public void onClick(View v) {



        switch (v.getId())
           {

            case R.id.b1:
		    testIntent = new Intent(menuActivity.this, test_me.class);
		        startActivity(testIntent);
		       break;
            case R.id.b4:
    		    progIntent = new Intent(menuActivity.this,prog1.class);
		        startActivity(progIntent);
		        break;
            case R.id.b2:
    		    settingIntent = new Intent(menuActivity.this,setting_mode.class);
		        startActivity(settingIntent);
		        break;
            case R.id.b3:
       		 resultIntent = new Intent(menuActivity.this,result_mode.class);
		        startActivity(resultIntent);
		        break;
            case R.id.back:
          		 backIntent = new Intent(menuActivity.this,AchActivity.class);
   		        startActivity(backIntent);
   		        break;
           }
    }

    
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    		super.onCreateOptionsMenu(menu);
    		
    		SubMenu sub1 = menu.addSubMenu(0, 0, Menu.NONE, "Back");
    	   sub1.setHeaderIcon(R.drawable.back);
    	  sub1.setIcon(R.drawable.back);   
    	  return true;
   	 } 
        public boolean onOptionsItemSelected(MenuItem item) {
		    switch(item.getItemId()) {
		    case BACK:
		    	backIntent = new Intent(menuActivity.this,AchActivity.class);
		        startActivity(backIntent);
		        break;
        
		    default:
		        return super.onOptionsItemSelected(item);
		    }

		    return true;
}
}