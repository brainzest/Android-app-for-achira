package achira.test;

//import android.R.menu;
import android.app.Activity;
import android.os.Bundle;


import android.content.Intent;

//import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem; 
import android.view.View;
import android.widget.Button;


public class AchActivity extends Activity {
	Intent menuIntent;
	Intent testIntent;
	Intent resultIntent;
	Intent progIntent;
	Intent settingIntent;
	static final private int TEST = Menu.FIRST;
	static final private int PROGMODE = Menu.FIRST+1;
	static final private int RESULTS = Menu.FIRST+2;
	static final private int SETTINGS = Menu.FIRST+3;
	@Override
	    
	   
	    public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.main);  
	        Button b1 = (Button)findViewById(R.id.button1);        
	        b1.setOnClickListener(new Button.OnClickListener(){
	        
	    public void onClick(View v) {
	        	  if(v.getId()==R.id.button1)
	        	  {	     
	                	 menuIntent = new Intent(AchActivity.this,menuActivity.class);
	      		        startActivity(menuIntent);
	                        
	        	  }
	    }}); 
	        
	    }

	        
 
	    
		//Context Menu
		//@Override
		public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		int groupId = 0;
		MenuItem menuItem1 = menu.add(groupId, TEST, Menu.NONE,"Test");
		menuItem1.setIcon(R.drawable.test);
		//	menuItem2.setIcon(R.drawable.prog);
		MenuItem menuItem3 = menu.add(groupId, SETTINGS, Menu.NONE,"Settings");
		menuItem3.setIcon(R.drawable.settings);
		MenuItem menuItem4 = menu.add(groupId, RESULTS, Menu.NONE, "Results");
		menuItem4.setIcon(R.drawable.result);
		return true;
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch(item.getItemId()) {
		    case TEST:
		    	testIntent = new Intent(AchActivity.this, test_me.class);
		        startActivity(testIntent);
		        break;
		    case PROGMODE:
		    	progIntent = new Intent(AchActivity.this,prog_mode.class);
		        startActivity(progIntent);
		        break;
		    case RESULTS:
		    	resultIntent = new Intent(AchActivity.this,result_mode.class);
		        startActivity(resultIntent);
		        break;
		    case SETTINGS:
		    	settingIntent = new Intent(AchActivity.this,setting_mode.class);
		        startActivity(settingIntent);
		        break;
		    default:
		        return super.onOptionsItemSelected(item);
		    }

		    return true;
		}
		
		

		
}	        