package achira.test;
import android.content.Context;
public class testname {
	



		int _id;
		String _name;
		int _aftid;
		
		
		public testname(String Name)
		{
			this._name=Name;
	
			//this._aftid=aft_id;
		}
		public String gettest()
		{
			return this._name;
		}
		public void SetTest(String TestName)
		{
			this._name=TestName;
		}
		public int getID()
		{
			return this._id;
		}
		public void SetID(int ID)
		{
			this._id=ID;
		}
		public int getAFTID()
		{
			return this._aftid;
		}
		public void SetAFTID(int ID)
		{
			this._aftid=ID;
		}
}