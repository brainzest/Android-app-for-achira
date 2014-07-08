package achira.test;

//import java.util.List;
//import java.util.Locale;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class result_mode extends Activity implements OnClickListener{
	EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11;
	 // DBAdapter db = new DBAdapter(this);
	Intent saveIntent;
	Intent homeIntent;
	Intent abortIntent;
	@Override
	 public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.res);
  // DBAdapter db = new DBAdapter(this);
      //getFullList();
	        DatabaseHelper db = new DatabaseHelper(this);
	        
	        
	        
      e2 = (EditText)findViewById(R.id.name);
	        e1=(EditText)findViewById(R.id.id);
	        e3=(EditText)findViewById(R.id.age);
	        e5=(EditText)findViewById(R.id.doc);
        e4=(EditText)findViewById(R.id.editText2);
	        Button b1 = (Button) findViewById(R.id.abort);
	        Button b2 = (Button)findViewById(R.id.home);
	        Button b3 = (Button)findViewById(R.id.save);
	        b1.setOnClickListener(this);
	        b2.setOnClickListener(this);
	        b3.setOnClickListener(this);
	  
	 
	   //     getFullList(); 	
	}
	 public void DisplayTitle(Cursor c)
	    {
	    Toast.makeText(this,
	    "UID: " + c.getString(0) + "\n" +
	    "NAME: " + c.getString(1) + "\n" +
	    "AGE: " + c.getString(2) + "\n" +
	    "CONTACT: " + c.getString(3)+ "\n" +
	    "Referred By: " + c.getString(4),
	    Toast.LENGTH_LONG).show();
	    
	    }	
	/* public void insert() {	    
	         
	        //insert
	    	db.open();
	    	db.insertPatient("456","abscd","45","9889778152");
	        long id;
	        id = db.insertPatient(e1.toString(), e2.toString(), e3.toString(), e4.toString());
	        db.close();
	       
	 }
	 
	 public void getFullList(){
			
		    
		        insert();
		        db.open();
		        Cursor c = db.getResult();
		        if (c.moveToFirst())
		        {
		        do {
		        DisplayTitle(c);
		        } while (c.moveToNext());
		        }
		        db.close();
		 
		 }
*/
	


	 public void onClick(final View v) {
         switch(v.getId()){
             case R.id.save:
            	saveIntent = new Intent(result_mode.this,menuActivity.class);
		        startActivity(saveIntent);
               
             break;
             case R.id.abort:                	
            	 abortIntent = new Intent(result_mode.this,test_me.class);
  		        startActivity(abortIntent);
             break;
             case R.id.home:
            	 homeIntent= new Intent(result_mode.this,AchActivity.class);
 	           	startActivity(homeIntent);
 		        
             break;
         }}
}
	