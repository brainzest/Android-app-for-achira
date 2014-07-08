package achira.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class GridList extends Activity implements OnClickListener{
	DatabaseHelper dbHelper;
	static public GridView grid;
	TextView txtTest;
	Spinner spinDept1;
	Intent saveIntent;
	Intent homeIntent;
	Intent abortIntent;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.gridview);
        grid=(GridView)findViewById(R.id.grid);
        txtTest=(TextView)findViewById(R.id.txtTest);
        spinDept1=(Spinner)findViewById(R.id.spinDept1);
        Button b1 = (Button) findViewById(R.id.menutest);
        Button b2 = (Button)findViewById(R.id.backtest);
        Button b3 = (Button)findViewById(R.id.hometest);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        Utilities.ManageDeptSpinner(this,spinDept1);
        final DatabaseHelper db=new DatabaseHelper(this);
        try
        {
         
         spinDept1.setOnItemSelectedListener(new OnItemSelectedListener() {
        	 
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				LoadGrid();
	    		//sca.notifyDataSetChanged();
	    		
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
       
        }
        catch(Exception ex)
        {
        	txtTest.setText(ex.toString());
        }
        
        
       
        try
        {
        grid.setOnItemClickListener(new OnItemClickListener()
        {

        	public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				try
				{
			
				SQLiteCursor cr=(SQLiteCursor)parent.getItemAtPosition(position);
				String name=cr.getString(cr.getColumnIndex(DatabaseHelper.colName));
				String doctor=cr.getString(cr.getColumnIndex(DatabaseHelper.coldoc));
				int age=cr.getInt(cr.getColumnIndex(DatabaseHelper.colAge));
				int contact=cr.getInt(cr.getColumnIndex(DatabaseHelper.colcntct));
				String Dept=cr.getString(cr.getColumnIndex(DatabaseHelper.TestName));
		//		int sex=cr.getInt(cr.getColumnIndex(DatabaseHelper.sex));
			patient emp=new patient(name,age,contact,doctor,db.GetTestID(Dept));
				emp.SetID((int)id);
				AlertDialog diag= class1.ShowEditDialog(GridList.this,emp);
				diag.setOnDismissListener(new OnDismissListener() {
					
					public void onDismiss(DialogInterface dialog) {
						txtTest.setText("dismissed");
						//((SimpleCursorAdapter)grid.getAdapter()).notifyDataSetChanged();
						LoadGrid();
					}
				});
				diag.show();
				}
				catch(Exception ex)
				{
					class1.CatchError(GridList.this, ex.toString());
				}
			}

			
        }
        );
        }
        catch(Exception ex)
        {
        	
        }

    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	//LoadGrid();
    }
    
    public void LoadGrid()
    {
    	dbHelper=new DatabaseHelper(this);
    	try
    	{
    		//Cursor c=dbHelper.getAllEmployees();
    		View v=spinDept1.getSelectedView();
			TextView txt=(TextView)v.findViewById(R.id.txtDeptName);
			String Dept=String.valueOf(txt.getText());
    		Cursor c=dbHelper.getPatientByTest(Dept);
    		startManagingCursor(c);
    		
    		String [] from=new String []{DatabaseHelper.colName,DatabaseHelper.colAge,DatabaseHelper.colcntct,DatabaseHelper.coldoc,DatabaseHelper.TestName,};
    		int [] to=new int [] {R.id.colName,R.id.colAge,R.id.colcntct,R.id.coldoc,R.id.colDept};
    		SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.gridrow,c,from,to);
    		grid.setAdapter(sca);
    		
    		
    		
    	}
    	catch(Exception ex)
    	{
    		AlertDialog.Builder b=new AlertDialog.Builder(this);
    		b.setMessage(ex.toString());
    		b.show();
    	}
    }
	
    public void onClick(final View v) {
        switch(v.getId()){
            case R.id.menutest:
           	saveIntent = new Intent(this,menuActivity.class);
		        startActivity(saveIntent);
              
            break;
            case R.id.backtest:                	
           	 abortIntent = new Intent(this,test_me.class);
 		        startActivity(abortIntent);
            break;
            case R.id.hometest:
           	 homeIntent= new Intent(this,AchActivity.class);
	           	startActivity(homeIntent);
		        
            break;
        }}
}
