package achira.test;

import android.os.Bundle;
//import android.text.Spannable;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;


import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
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

public class prog1 extends Activity implements OnClickListener{
	DatabaseHelper dbHelper;
	Intent saveIntent;
	Intent homeIntent;
	Intent abortIntent;
	Spinner spinDept;
	TextView  txtEmps;
	TableLayout t1;
	 EditText  test, a,f,t,aftid, num;
	@Override
	public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.table1);
	        Button b1 = (Button) findViewById(R.id.start);
	        Button b2 = (Button)findViewById(R.id.button3);
	        Button b3 = (Button)findViewById(R.id.save);
	        test= (EditText)findViewById(R.id.EnterTest);
	         a=(EditText)findViewById(R.id.a1);
	         f=(EditText)findViewById(R.id.f1);
	         t=(EditText)findViewById(R.id.t1);
	         aftid=(EditText)findViewById(R.id.id1);
	         b1.setOnClickListener(this);
	        b2.setOnClickListener(this);
	        b3.setOnClickListener(this);
	        t1 = (TableLayout)findViewById(R.id.tableLayout1);
	       /* for(int i = 0; i
	        //Create a new row to be added.
	        TableRow tr = new TableRow(this);
	        //Create text views to be added to the row.
	        TextView tv1 = new TextView(this);
	        TextView tv2 = new TextView(this);
	        //Put the data into the text view by passing it to a user defined function createView()
	        createView(tr, tv1, Integer.toString(i+1));
	        createView(tr, tv2, names[i]);
	        //Add the new row to our tableLayout tl
	        tl.addView(tr);
	        */
	        
}
	
	public void btnAddTest(View view)
	{
		
		
		
   dbHelper= new DatabaseHelper(this);    
  boolean ok=true;
		try
		{ 	Spannable spn=a.getText();
		Spannable id=aftid.getText();
		Spannable spn1=f.getText();
		Spannable spn2=t.getText();
		String tname=test.getText().toString();
			int tid=Integer.valueOf(id.toString());
			int avalue=Integer.valueOf(spn.toString());
			int fvalue=Integer.valueOf(spn1.toString());
	       int tvalue=Integer.valueOf(spn2.toString());
			
		//	int num1=Integer.valueOf(testno.toString());
	//	process p=new process(tid,avalue,fvalue,tvalue);
			testname t= new testname(tname);
			setTitle("Processing");
			//dbHelper.process(p);
			dbHelper.testname(t);
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
				
			
			//SQLiteCursor cr=(SQLiteCursor)parent.getItemAtPosition(position);
			//String name=cr.getString(cr.getColumnIndex(DatabaseHelper.TestName));
			//int aftid=cr.getInt(cr.getColumnIndex(DatabaseHelper.aftid));
			
		//testname emp=new testname(name,aftid);
			//emp.SetID((int)id);
		
			
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
             case R.id.start:
            	saveIntent = new Intent(prog1.this,menuActivity.class);
		        startActivity(saveIntent);
               
             break;
             case R.id.save:                	
            	 abortIntent = new Intent(prog1.this,result_mode.class);
  		        startActivity(abortIntent);
             break;
             case R.id.button3:
            	 homeIntent= new Intent(prog1.this,AchActivity.class);
 	           	startActivity(homeIntent);
 		        
             break;
         }}
	
}