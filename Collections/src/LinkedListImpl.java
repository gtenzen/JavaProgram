import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class LinkedListImpl {

	
	public static void main(String[] args) {
		List<String> names=new LinkedList<String>();
		names.add("Rams");
		names.add("Posa");
		names.add("Chinni");
		Iterator<String> it=names.iterator();
		ListIterator<String>lit=names.listIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		while(lit.hasNext()){
			System.out.println(lit.next());
			System.out.println(lit.previous());
		}
	}
}
