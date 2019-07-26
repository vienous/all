import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCut {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("a");
		list.add("a");
		list.add("1");
		list.add("a");
		list.add("a");
		list.add("1");
		list.add("a");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals("1")) {
				iterator.remove();
			}
		}
		System.out.println(list.size());


	}
}
