import java.util.*;
public class Lab {
	public static void main(String[] args) {
		 HashMap hs=new HashMap();
		 hs.put(1,"java");
		 hs.put(12,"c");
		 hs.put(0,"c++");
			 System.out.println(hs);  
		Set st=hs.entrySet();//to access key and value pair
		Iterator it=st.iterator();
		while(it.hasNext()){
		Map.Entry mp=(Map.Entry)it.next();
		System.out.println(mp.getKey()+"  "+mp.getValue());
		
		}
		
		
		
	}
}
