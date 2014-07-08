package achira.test;


//import com.menu.R;
//import com.menu.test_me;
//import com.menu.AchActivity;

//import android.app.TabActivity;
import java.util.List;

import achira.test.patient;
import achira.test.DatabaseHelper;
import achira.test.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
//import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
//import android.widget.Toast;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


	public class test_me extends Activity implements OnClickListener {
	    /** Called when the activity is first created. 
		TextView t1;
		TextView t2;
		TextView t3;
		TextView t4;
		TextView t5;*/
		Intent backIntent;
		Intent homeIntent;
		Spinner spinDept;
		TextView txtEmps;
		DatabaseHelper dbHelper;
		Intent startIntent;
		//SQLiteDatabase myDB = this.openOrCreateDatabase("trial.sqlite",
	      //        SQLiteDatabase.OPEN_READWRITE, null);
		GridView grid;
		String text;
		TextView txtTest;
		//dbHelper = new DatabaseHelper(this);
		static final private int BACK = Menu.FIRST;
		static final private int HOME = Menu.FIRST +1;
		static final private int START = Menu.FIRST +2;
		EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11;
		EditText txtName;
		EditText txtAge;
		 RadioGroup radioGroup ;
		
	    @Override
	    public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.test);
	        DatabaseHelper dbHelper = new DatabaseHelper(this);
	        txtName=(EditText)findViewById(R.id.txtName);
	        txtAge=(EditText)findViewById(R.id.txtAge);
	        txtEmps=(TextView)findViewById(R.id.txtEmps);
	        spinDept=(Spinner)findViewById(R.id.spinDept);
  setContentView(R.layout.test);
	        spinDept=(Spinner)findViewById(R.id.spinDept);
	        e2 = (EditText)findViewById(R.id.name);
	        e1=(EditText)findViewById(R.id.id);
	        e3=(EditText)findViewById(R.id.age);
	        e5=(EditText)findViewById(R.id.doc);
	        e4=(EditText)findViewById(R.id.editText2); 
	       
	        txtEmps=(TextView)findViewById(R.id.txtEmps);
	        Button b1 = (Button) findViewById(R.id.button1);
	        Button b2 = (Button)findViewById(R.id.button2);
	        Button b3 = (Button)findViewById(R.id.button3);
	        b1.setOnClickListener(this);
	        b2.setOnClickListener(this);
	        b3.setOnClickListener(this);
	        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
	        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	            public void onCheckedChanged(RadioGroup group, int checkedId) 
	            {
	                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
	                 text = checkedRadioButton.getText().toString();
	                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
	            }
	        });
	    
	        e1.setOnFocusChangeListener(new OnFocusChangeListener() {

	            public void onFocusChange(View v, boolean hasFocus) {
	                if (hasFocus)  
	                      e1.setBackgroundColor(Color.GRAY);           
	                  else
	                      e1.setBackgroundColor(Color.WHITE);             
	            }
	        });

	    
	       // Editable phn=e4.getText();
	        
//	        SetupTabs();
	    }
	    @SuppressWarnings("deprecation")
		@Override
		public void onStart()
		{
			try
			{
			super.onStart();
			dbHelper=new DatabaseHelper(this);
			txtEmps.setText(txtEmps.getText());
			
			Cursor c=dbHelper.getAllTests();
			startManagingCursor(c);
			
			
			
			//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDeptName}, new int []{android.R.id.text1});
			//@SuppressWarnings("deprecation")
			SimpleCursorAdapter ca=new SimpleCursorAdapter(this,R.layout.spinnertest, c, new String [] {DatabaseHelper.TestName,"_id"}, new int []{R.id.txtDeptName});
			//ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinDept.setAdapter(ca);
			spinDept.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> parent, View selectedView,
						int position, long id) {
					// TODO Auto-generated method stub
					
				} 

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			//never close cursor
			}
			catch(Exception ex)
			{
				CatchError(ex.toString());
			}
		}
		
	  
	    public void btnAddEmp_Click(View view)
		{
	       
        boolean ok=true;
		try
		{
			Spannable spn=e3.getText();
			Spannable spn1=e4.getText();
			String name=e2.getText().toString();
			 RadioGroup rG1 = (RadioGroup)findViewById(R.id.radiogroup);
			 int rid = rG1.getCheckedRadioButtonId();

		/*	for(int i=1;i<(c.getColumnCount());i++)
	    	{
	    		RadioGroup radiogroup = (RadioGroup)findViewById(R.id.radiogroup);
	    		RadioButton rdbtn = new RadioButton(this);
	    		rdbtn.setId(i);
	    		rdbtn.setText(c.getString(i));
	    		radiogroup.addView(rdbtn);}*/
			String doc=e5.getText().toString();
			int age=Integer.valueOf(spn.toString());
			int contact=Integer.valueOf(spn1.toString());
			int deptID=Integer.valueOf((int)spinDept.getSelectedItemId());
			patient emp=new patient(name,age,contact,doc,deptID);
			setTitle("im here");
			dbHelper.patient(emp);
			
		}
		catch(Exception ex)
		{
			ok=false;
			CatchError(ex.toString());
		}
		finally
		{
			if(ok)
			{
//				NotifyEmpAdded();
		     class1.ShowAlert(this);
				txtEmps.setText("Number of patients "+String.valueOf(dbHelper.getEmployeeCount()));
			}
		}}
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Add new Patient");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}

/*	void NotifyEmpAdded()
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Add new Patient");
		TextView txt=new TextView(this);
		txt.setText("Patient Added Successfully");
		diag.setContentView(txt);
		diag.show();
		try {
		diag.wait(1000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			CatchError(e.toString());
		}
		diag.notify();
		diag.dismiss();
	}}
		void CatchError(String Exception)
		{
			Dialog diag=new Dialog(this);
			diag.setTitle("Add new Patient");
			TextView txt=new TextView(this);
			txt.setText(Exception);
			diag.setContentView(txt);
			diag.show();
		}
	
		void NotifyEmpAdded()
		{
			Dialog diag=new Dialog(this);
			diag.setTitle("Add new Patient");
			TextView txt=new TextView(this);
			txt.setText("Patient Added Successfully");
			diag.setContentView(txt);
			diag.show();
			try {
			diag.wait(1000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				CatchError(e.toString());
			}
			diag.notify();
			diag.dismiss();
		}
	//	*/ //@Override
   public void onClick(final View v) {
    	
             switch(v.getId()){
                 case R.id.button1:
                	 backIntent = new Intent(test_me.this,menuActivity.class);
 		        startActivity(backIntent);
                   
                 break;
                 case R.id.button2:                	
                	 startIntent = new Intent(test_me.this,GridList.class);
      		        startActivity(startIntent);
                 break;
                 case R.id.button3:
                	 homeIntent= new Intent(test_me.this,AchActivity.class);
     	           	startActivity(homeIntent);
     		        
                 break;
             }
    }
    

	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		SubMenu sub1 = menu.addSubMenu(0, 0, Menu.NONE, "Back");
	   sub1.setHeaderIcon(R.drawable.back);
	  sub1.setIcon(R.drawable.back);   
	    SubMenu sub2 = menu.addSubMenu(0, 0, Menu.NONE, "Home");
	   sub2.setHeaderIcon(R.drawable.home);
	   sub2.setIcon(R.drawable.home);
		return true;
	 }
	 public boolean onOptionsItemSelected(MenuItem item) {
		    switch(item.getItemId()) {
		    case BACK:
		    	backIntent = new Intent(test_me.this,AchActivity.class);
		        startActivity(backIntent);
		        break;
		    case START:
		    	startIntent= new Intent(test_me.this,result_mode.class);
	           	startActivity(startIntent);
		        break;
		        
		    case HOME:
		    	homeIntent= new Intent(test_me.this,AchActivity.class);
	           	startActivity(homeIntent);
		        break;
		        
		    default:
		        return super.onOptionsItemSelected(item);
		    }

		    return true;
		}
	
		
	}
	
	