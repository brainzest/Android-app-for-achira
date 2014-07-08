package achira.test;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;




public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String TAG = "DbAdapter" ;
	static final String dbName="achira";
	static final String patientTable="patient";
	static final String colID="UID";
	static final String colName="patientName";
	static final String colAge="Age";
	static final String colcntct="Contact";
	static final String coldoc="Referred";
	static final String colDept="Test";
	static final String progTable="Program";
	static final String deptTable="Test1";
	static final String colDeptID="TestID";
	static final String pid="Testid";
	static final String colDeptName="TesttName";
	static final String processA="A";
	static final String processF="F";
	static final String processT="T";
	static final String test="testTable";
	static final String sex="sex";
	static final String TestName="TestName";
	static final String TestId="TestId";
	static final String aftid="aftid";
	static final String seqvalues="seqvalues";
	static final String Sequence="Sequence";
	static final String seq1="seq1";
	static final String seq2="seq2";
	static final String repeat="repeat";
	static final String id_seq="id_seq";
	static final String aft="aft";
	static final String aft_id="aft_id";	
	static final String Amp="Amp";
	static final String Fre="Fre";
	static final String Time="Time";
	
	static final String viewTest="ViewTest";	
	static final String viewEmps="ViewPatient";
	private static final String CREATE_TABLE_TEST =	"CREATE TABLE test (TestName VARCHAR, TestId INTEGER NOT NULL, aftid INTEGER NOT NULL , seqvalues INTEGER PRIMARY KEY (TestId), FOREIGN KEY(aftid) REFERENCES aft(pid), FOREIGN KEY (seqvalues) REFERENCES Sequence(id_seq))";
	private static final String CREATE_TABLE_SEQ ="CREATE TABLE Sequence (seq1 INTEGER, seq2 INTEGER, repeat INTEGER, id_seq INTEGER PRIMARY KEY)";
	private static final String CREATE_TABLE_AFT ="CREATE TABLE aft (pid INTEGER PRIMARY KEY  AUTOINCREMENT , Amp INTEGER, Fre INTEGER, Time INTEGER)";
	public DatabaseHelper(Context context) {
		super(context, dbName, null,51);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+Sequence+" ("+seq1+" INTEGER, "+
		seq2+" INTEGER, "+repeat+" INTEGER, "+id_seq+" INTEGER PRIMARY KEY);");		
		db.execSQL("CREATE TABLE "+aft+" ("+aft_id+" INTEGER PRIMARY KEY  AUTOINCREMENT , "+
		Amp+" INTEGER, "+Fre+" INTEGER, "+Time+" INTEGER);");
		db.execSQL("CREATE TABLE "+test+" ("+TestName+" VARCHAR, "+
		TestId+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
		aftid+" INTEGER NOT NULL , "+
		seqvalues+" INTEGER, FOREIGN KEY ("+aftid+") REFERENCES "+aft+" ("+aft_id+"), FOREIGN KEY ("+seqvalues+") REFERENCES "+Sequence+" ("+id_seq+"));");
	//	db.execSQL("CREATE TABLE "+deptTable+" ("+colDeptID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
		//		colDeptName+ " TEXT   )");
		db.execSQL("CREATE TABLE "+progTable+" ("+pid+ " INTEGER PRIMARY KEY , "+
				processA+ " INTEGER ,"+processF+ " INTEGER,"+processT+ " INTEGER, FOREIGN KEY ("+pid+") REFERENCES "+deptTable+" ("+colDeptID+"));");
		
		
		db.execSQL("CREATE TABLE "+patientTable+" ("+colID+" INTEGER PRIMARY KEY , "+
				colName+" TEXT, "+colAge+" Integer,"+colcntct+" INTEGER ,"+coldoc+" TEXT,"+colDept+" INTEGER NOT NULL ,FOREIGN KEY ("+colDept+") REFERENCES "+test+" ("+TestId+"));");
		
		
	/*	db.execSQL("CREATE TRIGGER fk_empdept_deptid " +
				" BEFORE INSERT "+
				" ON "+patientTable+
				
				" FOR EACH ROW BEGIN"+
				" SELECT CASE WHEN ((SELECT "+TestId+" FROM "+test+" WHERE "+TestId+"=new."+colDept+" ) IS NULL)"+
				" THEN RAISE (ABORT,'Foreign Key Violation') END;"+
				"  END;");*/
		
		db.execSQL("CREATE VIEW "+viewEmps+
				" AS SELECT "+patientTable+"."+colID+" AS _id,"+
				" "+patientTable+"."+colName+","+
				" "+patientTable+"."+colAge+","+
				" "+patientTable+"."+colcntct+","+
				" "+patientTable+"."+coldoc+","+
			//	" "+patientTable+"."+sex+","+
				" "+test+"."+TestName+""+
				" FROM "+patientTable+" JOIN "+test+
				" ON "+patientTable+"."+colDept+" ="+test+"."+TestId
				);
		/*db.execSQL("CREATE VIEW "+viewTest+
				" AS SELECT "+aft+"."+"aft_id"+" AS tid,"+
				
				" "+aft+"."+Amp+","+
				" "+aft+"."+Fre+","+
				" "+aft+"."+Time+","+
				" "+test+"."+TestName+","+
				" FROM "+aft+" JOIN "+test+
				" ON "+aft+"."+aft_id+" ="+test+"."+aftid
				);
		//Inserts pre-defined departments
	//	InsertDepts(db);
		*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		            
        	Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+patientTable);
		//db.execSQL("DROP TABLE IF EXISTS "+deptTable);
		db.execSQL("DROP TABLE IF EXISTS "+progTable);
		db.execSQL("DROP TABLE IF EXISTS aft");
		db.execSQL("DROP TABLE IF EXISTS Sequence");
		db.execSQL("DROP TABLE IF EXISTS test");
		
		db.execSQL("DROP TRIGGER IF EXISTS dept_id_trigger");
		db.execSQL("DROP TRIGGER IF EXISTS dept_id_trigger22");
		db.execSQL("DROP TRIGGER IF EXISTS fk_empdept_deptid");
		db.execSQL("DROP VIEW IF EXISTS "+viewEmps);
		db.execSQL("DROP VIEW IF EXISTS "+viewTest);
		onCreate(db);	
		}
	
	 void patient(patient emp)
	{
		 
		 
		 SQLiteDatabase db= this.getWritableDatabase();
		 
		
		ContentValues cv=new ContentValues();
		
		cv.put(colName, emp.getName());
		cv.put(colAge, emp.getAge());
		cv.put(colDept, emp.getDept());
		cv.put(colcntct, emp.getCntct());
		cv.put(coldoc, emp.getDoc());
	//	cv.put(sex, emp.getsex());
		//cv.put(colDept,2);
		
		db.insert(patientTable, colName, cv);
		db.close();
		
		
	}
	 void process(process p)
		{
			 
			 
			 SQLiteDatabase db= this.getWritableDatabase();
			 
			
			ContentValues cv=new ContentValues();
			
			cv.put(aft_id,p.getID());
			cv.put(Amp, p.getA());
			cv.put(Fre,p.getF());
			cv.put(Time, p.getT());
		
			//cv.put(colDept,2);
			
			db.insert(aft, aft_id, cv);
			db.close();
			
			
		}
	 
	 int getEmployeeCount()
	 {
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cur= db.rawQuery("Select * from "+patientTable, null);
		int x= cur.getCount();
		cur.close();
		return x;
	 }
	 
	 Cursor getAllEmployees()
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 
		 
		 
		 //Cursor cur= db.rawQuery("Select "+colID+" as _id , "+colName+", "+colAge+" from "+patientTable, new String [] {});
		 Cursor cur= db.rawQuery("SELECT * FROM "+viewEmps,null);
		 return cur;
		 
	 }
	 Cursor getAllAFT()
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		
		 
			 Cursor cur= db.rawQuery("SELECT * FROM "+viewTest,null);
		 return cur;
		 
	 }
/*	 Cursor getAllDepts()
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 Cursor cur=db.rawQuery("SELECT "+colDeptID+" as _id, "+colDeptName+" from "+deptTable,new String [] {});
		 
		 return cur;
	 }*/
	 Cursor getAllTests()
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 Cursor cur=db.rawQuery("SELECT "+TestId+" as _id, "+TestName+" from "+test,new String [] {});
		 
		 return cur;
	 }
	 
	 void InsertDepts(SQLiteDatabase db)
	 {
		 ContentValues cv=new ContentValues();
			cv.put(colDeptID, 1);
			cv.put(colDeptName, "XYZ");
			db.insert(deptTable, colDeptID, cv);
			cv.put(colDeptID, 2);
			cv.put(colDeptName, "ABC");
			db.insert(deptTable, colDeptID, cv);
			cv.put(colDeptID, 3);
			cv.put(colDeptName, "HIV");
			db.insert(deptTable, colDeptID, cv);
			cv.put(colDeptID, 4);
			cv.put(colDeptName, "Blood");
			db.insert(deptTable, colDeptID, cv);
		    db.insert(deptTable, colDeptID, cv);
			
	 }
	 void testname(testname name)
		{
			 
			 
			 SQLiteDatabase db= this.getWritableDatabase();
			 
			
			ContentValues cv=new ContentValues();
			
			cv.put(TestName, name.gettest());
	
		//	cv.put(aft_id, name.getAFTID());
			db.insert(test, TestName, cv);
			db.insert(test, TestName, cv);	
		//	db.insert(deptTable, colDeptName, cv);
			
			
			
		}	 
	/*public String GetDept(int ID)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 
		 String[] params=new String[]{String.valueOf(ID)};
		 Cursor c=db.rawQuery("SELECT "+colDeptName+" FROM"+ deptTable+" WHERE "+colDeptID+"=?",params);
		 c.moveToFirst();
		 int index= c.getColumnIndex(colDeptName);
		 return c.getString(index);
	 }*/
	 public String GetTest(int ID)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 
		 String[] params=new String[]{String.valueOf(ID)};
		 Cursor c=db.rawQuery("SELECT "+TestName+" FROM"+ test+" WHERE "+TestId+"=?",params);
		 c.moveToFirst();
		 int index= c.getColumnIndex(TestName);
		 return c.getString(index);
	 }
	 public String GetAft(int ID)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 
		 String[] params=new String[]{String.valueOf(ID)};
		 Cursor c=db.rawQuery("SELECT "+Amp+", "+Fre+","+Time+" FROM "+aft+" WHERE "+aft_id+"=?",params);
		 c.moveToFirst();
		 int index= c.getColumnIndex(Amp);
		 return c.getString(index);
	 }
	 
	 /*public Cursor getEmpByDept(String Dept)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 String [] columns=new String[]{"_id",colName,colAge,colcntct,coldoc,colDeptName};
		 Cursor c=db.query(viewEmps, columns, colDeptName+"=?", new String[]{Dept}, null, null,null, null);
		 return c;
	 }*/
	 public Cursor getPatientByTest(String Dept)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 String [] columns=new String[]{"_id",colName,colAge,colcntct,coldoc,TestName};
		 Cursor c=db.query(viewEmps, columns, TestName+"=?", new String[]{Dept}, null, null,null, null);
		 return c;
	 }
	 public Cursor getAftByTest(String Dept)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 String [] columns=new String[]{aftid,Amp,Fre,Time};
		 Cursor c=db.query(viewTest, columns, aftid+"=?", new String[]{Dept}, null, null,null, null);
		 return c;
	 }
	 
	 public int GetDeptID(String Dept)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 Cursor c=db.query(deptTable, new String[]{colDeptID+" as _id",colDeptName},colDeptName+"=?", new String[]{Dept}, null, null, null,null);
		 //Cursor c=db.rawQuery("SELECT "+colDeptID+" as _id FROM "+deptTable+" WHERE "+colDeptName+"=?", new String []{Dept});
		 c.moveToFirst();
		 return c.getInt(c.getColumnIndex("_id"));
		 
		 }
	 
	 public int GetTestID(String Dept)
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 Cursor c=db.query(test, new String[]{TestId+" as _id",TestName},TestName+"=?", new String[]{Dept}, null, null, null,null);
		 //Cursor c=db.rawQuery("SELECT "+colDeptID+" as _id FROM "+deptTable+" WHERE "+colDeptName+"=?", new String []{Dept});
		 c.moveToFirst();
		 return c.getInt(c.getColumnIndex("_id"));
		 
		 }
	 public int UpdateEmp(patient emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 ContentValues cv=new ContentValues();
		 cv.put(colName, emp.getName());
		 cv.put(colAge, emp.getAge());
		 cv.put(colDept, emp.getDept());
		 cv.put(colcntct, emp.getCntct());
		 cv.put(coldoc, emp.getDoc());
		// cv.put(sex,emp.getsex());
			return db.update(patientTable, cv, colID+"=?", new String []{String.valueOf(emp.getID())});
		 
	 }
	 
	 public void DeleteEmp(patient emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 db.delete(patientTable,colID+"=?", new String [] {String.valueOf(emp.getID())});
		 db.close();
		 
		
		
	 }

}