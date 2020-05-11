import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class P3WrapperTestStd2 {

	P3Wrapper2.BinarySearchTree<Integer, Integer> T1;
	P3Wrapper2.BinarySearchTree<Integer, Integer> T2;

	////
	/// Integer Comparator
	public static class IntegerComparator implements Comparator<Integer> {

		public IntegerComparator() {

		}

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}

	}

	public static void print(ArrayList<P3Wrapper2.KeyValuePair<Integer, Integer>> L, PrintStream P) {
		P.print("[ ");

		for (P3Wrapper2.KeyValuePair<Integer, Integer> o : L) {
			P.print(o.getValue() + " ");
		}

		P.println("]");

	}

	@Before
	public void setUp() throws Exception {
		T1 = new P3Wrapper2.BinarySearchTree<Integer, Integer>(new IntegerComparator());

		T2 = new P3Wrapper2.BinarySearchTree<Integer, Integer>(new IntegerComparator());

	}

	@Test
	public void test1() {

		boolean flag = T1.isRightLinear();
		assertEquals("ON empty Tree T1, fails T.isRightLinear(). Expected value: true", true, flag);

	}

	@Test
	public void test2() {
		T1.put(20, 20);
		boolean flag = T1.isRightLinear();
		assertEquals("ON  Tree T1 with one element {20}, fails T.isRightLinear(). Expected value: true", true, flag);

	}

	@Test
	public void test3() {
		T1.put(20, 20);
		T1.put(30, 30);
		boolean flag = T1.isRightLinear();
		assertEquals(
				"ON  Tree T1 with two elements {20, 30} and 20 as root, fails T.isRightLinear(). Expected value: true",
				true, flag);

	}

}