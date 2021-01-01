import java.util.LinkedList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0)
			return 0;

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {

				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));

			}

		}

		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(2);
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new LinkedList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);

		List<Integer> l4 = new LinkedList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();

		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);

		Triangle tri = new Triangle();
		System.out.println(tri.minimumTotal(triangle));

	}

}
