package achira.test;

import android.content.Context;

public class process{
	
	int _a, _t;
	
	int _f;
	
	int _id;
	int _test;
	
	public process(int aftid, int A, int F, int T){
		this._a= A;
		this._test= aftid;
		this._f= F;
		this._t= T;
	}
	
	public int gettest()
	{
		return this._test;
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
	
	public int getA()
	{
		return this._a;
	}
	
	public int getF()
	{
		return this._f;
	}
	public int getT()
	{
		return this._t;
	}
	
	public void setA(int A)
	{
		this._a=A;
	}
	public void setF(int F)
	{
		this._f=F;
	}
	public void setT(int T)
	{
		this._t=T;
	}
	
	
	
}