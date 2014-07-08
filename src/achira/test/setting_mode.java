package achira.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class setting_mode extends Activity implements OnClickListener{
	Intent saveIntent;
	Intent homeIntent;
	Intent abortIntent;
	DatabaseHelper dbHelper;
	@Override
	 public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.setting);
	        
	        Button b1 = (Button) findViewById(R.id.abort);
	        Button b2 = (Button)findViewById(R.id.home);
	        Button b3 = (Button)findViewById(R.id.save);
	        b1.setOnClickListener(this);
	        b2.setOnClickListener(this);
	        b3.setOnClickListener(this);
	 }
	 public void onClick(final View v) {
         switch(v.getId()){
             case R.id.save:
            	saveIntent = new Intent(setting_mode.this,menuActivity.class);
		        startActivity(saveIntent);
               
             break;
             case R.id.abort:                	
            	 abortIntent = new Intent(setting_mode.this,test_me.class);
  		        startActivity(abortIntent);
             break;
             case R.id.home:
            	 homeIntent= new Intent(setting_mode.this,AchActivity.class);
 	           	startActivity(homeIntent);
 		        
             break;
         }}
	 public void btnTest_Click(View view)
		{
	    dbHelper = new DatabaseHelper(this);    
boolean ok=true;
		
}
}
