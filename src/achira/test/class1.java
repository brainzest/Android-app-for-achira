package achira.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import achira.test.patient;
import achira.test.DatabaseHelper;

public class class1 {

public static void ShowAlert(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Add new Patient");
	//builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Test patient Added successfully");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowAlert2(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Add new Test");
	//builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Test Added successfully");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}
public static AlertDialog ShowEditDialog(final Context con,final patient emp)
{
	AlertDialog.Builder b=new AlertDialog.Builder(con);
	b.setTitle("Patient Details");
	LayoutInflater li=LayoutInflater.from(con);
   View v=li.inflate(R.layout.editdialog, null);
	
	//b.setIcon(android.R.drawable.ic_input_get);
	
	b.setView(v);
	final TextView txtName=(TextView)v.findViewById(R.id.txtDelName);
	final TextView txtAge=(TextView)v.findViewById(R.id.txtDelAge);
	final Spinner spin=(Spinner)v.findViewById(R.id.spinDiagDept);
	//Utilities.ManageDeptSpinner(con, spin);
	for(int i=0;i<spin.getCount();i++)
	{
		long id=spin.getItemIdAtPosition(i);
		if(id==emp.getDept())
		{
			spin.setSelection(i, true);
			break;
		}
	}
	
	
	txtName.setText(emp.getName());
	txtAge.setText(String.valueOf(emp.getAge()));
	
	b.setPositiveButton("Modify", new OnClickListener() {
		
		//@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			emp.setName(txtName.getText().toString());
			emp.setAge(Integer.valueOf(txtAge.getText().toString()));
			emp.setDept((int)spin.getItemIdAtPosition(spin.getSelectedItemPosition()));
			
			try
			{
			DatabaseHelper db=new DatabaseHelper(con);
			db.UpdateEmp(emp);
			
			}
			catch(Exception ex)
			{
				CatchError(con, ex.toString());
			}
		}
	});
	
	b.setNeutralButton("Delete", new OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			DatabaseHelper db=new DatabaseHelper(con);
			db.DeleteEmp(emp);
		}
	});
	b.setNegativeButton("Cancel", null);
	
	return b.create();
	//diag.show();
	
}

static public void CatchError(Context con, String Exception)
{
	Dialog diag=new Dialog(con);
	diag.setTitle("Error");
	TextView txt=new TextView(con);
	txt.setText(Exception);
	diag.setContentView(txt);
	diag.show();
}


}


