import java.util.HashMap;
import java.util.Map;

public class MapGetPut {

	
	public static void main(String[] args) {
		
		Map<String, Integer> map= new HashMap<>();
		
		map.put("BAC", 0);
		Integer in=map.get("BAC");
		
		if(in==null) {
			map.put("BAC", 0);
		}
		in =in+1;
		System.out.println(map);
		
		String s ="I work in Accenture";
		String arr[] = s.split(" ");
		
		System.out.println(arr);
		
		for (String string : arr) {
			System.out.println(string);
			
		}
	}
}
