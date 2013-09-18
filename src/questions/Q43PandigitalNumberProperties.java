package questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class Q43PandigitalNumberProperties {
	private static boolean isValid(String x){
		if(Integer.valueOf(x.substring(1,4)) % 2 != 0)
			return false;
		if(Integer.valueOf(x.substring(2,5)) % 3 != 0)
			return false;
		if(Integer.valueOf(x.substring(3,6)) % 5 != 0)
			return false;
		if(Integer.valueOf(x.substring(4,7)) % 7 != 0)
			return false;
		if(Integer.valueOf(x.substring(5,8)) % 11 != 0)
			return false;
		if(Integer.valueOf(x.substring(6,9)) % 13 != 0)
			return false;
		if(Integer.valueOf(x.substring(7,10)) % 17 != 0)
			return false;
 
		return true;
	}
 
	//Concept from Steinhaus–Johnson–Trotter
	public static void permute(String obj, Vector<String> arr){
		if(arr.size() == 0){
			arr.add(obj); 
			return;
		}
		Vector<String> result = new Vector<String>();
 
		for(String str: arr){
			for(int i=0;i<str.length();i++){
				String pre = (i==0) ? "" : str.substring(0,i);
				String x = pre+obj+str.substring(i);
				if(x.length() != 10 || isValid(x))
					result.add(x);
			}
			String x = str.substring(0,str.length())+obj;
			if(x.length() != 10 || isValid(x))
				result.add(x);
		}
 
		arr.clear();
		arr.addAll(result);
	}
 
	public static void main (String[] args) throws java.lang.Exception
	{
		long time = System.currentTimeMillis();
 
		Vector<String> vector = new Vector<String>();
		for(int i=0;i<10;i++){
			permute(String.valueOf(i),vector);
		}
 
		BigInteger sum = new BigInteger("0");
		for(String str : vector){
			//System.out.println(str);
			sum = sum.add(new BigInteger(str));
		}
 
		System.out.println("S:"+sum);
 
		System.out.println("time: "+(System.currentTimeMillis() - time));
	}
}
