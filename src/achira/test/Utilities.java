package achira.test;


import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class Utilities {
static public void ManageDeptSpinner(Context context,Spinner view)
{
	DatabaseHelper dbHelper=new DatabaseHelper(context);
	Cursor c=dbHelper.getAllTests();
	//context.startManagingCursor(c);
	
	
	
	//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDeptName}, new int []{android.R.id.text1});
	SimpleCursorAdapter ca=new SimpleCursorAdapter(context,R.layout.spinnertest, c, new String [] {DatabaseHelper.TestName,"_id"}, new int []{R.id.txtDeptName});
	view.setAdapter(ca);
	
}
}
