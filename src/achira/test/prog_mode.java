package achira.test;

import android.os.Bundle;
//import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;


import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;

public class prog_mode extends Activity implements OnClickListener{
	DatabaseHelper dbHelper;
	Intent saveIntent;
	Intent homeIntent;
	Intent abortIntent;
	Spinner spinDept;
	TextView  txtEmps;
	 EditText  test, a,f,t, num;
	@Override
	public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.prog);
	        Button b1 = (Button) findViewById(R.id.result);
	        Button b2 = (Button)findViewById(R.id.home);
	        Button b3 = (Button)findViewById(R.id.back);
	        test= (EditText)findViewById(R.id.setTest);
	   //     num= (EditText)findViewById(R.id.testnum);
	    txtEmps=(TextView)findViewById(R.id.txtEmps);
	        a= (EditText)findViewById(R.id.t4);	      
	        f= (EditText)findViewById(R.id.t5);	      
	        t= (EditText)findViewById(R.id.t6);	      
	     		b1.setOnClickListener(this);
	        b2.setOnClickListener(this);
	        b3.setOnClickListener(this);
	      
}
	
	public void btnAddEmp_Click(View view)
	{
		
		
		
   dbHelper= new DatabaseHelper(this);    
  boolean ok=true;
		try
		{
			//Spannable spn=a.getText();
			//Spannable spn1=f.getText();
		//	Spannable spn2=t.getText();
			//Spannable testno=num.getText();
			String tname=test.getText().toString();
			
			//int avalue=Integer.valueOf(spn.toString());
		//	int fvalue=Integer.valueOf(spn1.toString());
	//int tvalue=Integer.valueOf(spn2.toString());
			
		//	int num1=Integer.valueOf(testno.toString());
		//	process p=new process(tname,avalue,fvalue,tvalue);
		//	testname t= new testname(tname);
			setTitle("Processing");
			//dbHelper.testname(t);
		}
		catch(Exception ex)
		{
			ok=false;
			CatchError(ex.toString());
		}
		finally
		{
			if(ok)
			{	//Log.d()
				 //Toast.makeText(getApplicationContext(), tname, Toast.LENGTH_SHORT).show();
//				NotifyEmpAdded();
		     class1.ShowAlert2(this);
				
			}
		}}
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				
			
			SQLiteCursor cr=(SQLiteCursor)parent.getItemAtPosition(position);
			String name=cr.getString(cr.getColumnIndex(DatabaseHelper.colDeptName));
			
	//	testname emp=new testname(name);
		//	emp.SetID((int)id);
		
			
		}
		
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Add new Test");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}

	public void onClick(final View v) {
         switch(v.getId()){
             case R.id.back:
            	saveIntent = new Intent(prog_mode.this,menuActivity.class);
		        startActivity(saveIntent);
               
             break;
             case R.id.result:                	
            	 abortIntent = new Intent(prog_mode.this,result_mode.class);
  		        startActivity(abortIntent);
             break;
             case R.id.home:
            	 homeIntent= new Intent(prog_mode.this,AchActivity.class);
 	           	startActivity(homeIntent);
 		        
             break;
         }}
	
}