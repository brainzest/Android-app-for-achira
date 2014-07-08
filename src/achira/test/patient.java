package achira.test;

import android.content.Context;

public class patient {
	
	int _id;
	String _name;
	int _age;
	int _dept;
	int _contct;
	String _doc;
	int _sex;
	
	public patient(String Name,int Age,int Contact, String doctor,int Dept)
	{
		this._contct= Contact;
		this._doc= doctor;
		this._name=Name;
		this._age=Age;
		this._dept=Dept;
	//	this._sex=sex;
	}
	
	public patient(String Name,int Age)
	{
		this._name=Name;
		this._age=Age;
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
	
	public String getName()
	{
		return this._name;
	}
	
	public int getAge()
	{
		return this._age;
	}
	
	public void setName(String Name)
	{
		this._name=Name;
	}
	public void setAge(int Age)
	{
		this._age=Age;
	}
	public void setcntct(int Contact)
	{
		this._age=Contact;
	}
	public void setDoc(String doctor)
	{
		this._doc=doctor;
	}
	
	public void setDept(int Dept)
	{
		this._dept=Dept;
	}
	public void setsex(int sex)
	{
		this._sex=sex;
	}
	public String getDeptName(Context con, int Dept)
	{
		return new DatabaseHelper(con).GetTest(Dept);
	}
	public int getDept()
	{
		return this._dept;
	}
	public int getsex()
	{
		return this._sex;
	}
	public String getDoc() {
		return this._doc;
		
	}

	public int getCntct() {
		// TODO Auto-generated method stub
		return this._contct;
	}
}
