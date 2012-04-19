package backtracking;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Yao Chen
 * @version 2012-02-06
 *
 */
public class BacktrackingTest {
	private int[] puzzle1 = { 3, 6, 4, 1, 3, 4, 2, 5, 3, 0 };
	private int[] puzzle2 = { 3, 6, 4, 1, 3, 4, 2, 5, 3, 1 };
	private int[] puzzle3 = { 0 };
	private int[] puzzle4 = { 3, 1, 2, 3, 0 };
	private int[] puzzle5 = { 3, 1, 0, 1, 0 };


	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSolve() {
		Stack<Character> result = new Stack<Character>();
		Stack<Character> result1 = new Stack<Character>();
		result.push('R');
		result.push('L');
		result.push('R');
		result.push('R');
		result.push('L');
		result.push('R');
		result.push('R');
		result.push('R');
		assertEquals(result, Backtracking.solve(puzzle1));
		assertEquals(result, Backtracking.solve(puzzle2));
		assertEquals(new Stack<Character>(), Backtracking.solve(puzzle3));
		assertEquals(null, Backtracking.solve(puzzle4));
		result1.push('R');
		result1.push('R');
		assertEquals(result1, Backtracking.solve(puzzle5));
		
	}


	@Test
	public void testFindAllSolutions() {
		Set<Stack<Character>> resultSet = new HashSet<Stack<Character>>();
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		Stack<Character> stack3 = new Stack<Character>();
		Stack<Character> result1 = new Stack<Character>();
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('R');
		stack.push('L');
		stack.push('R');
		resultSet.add(stack);
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('R');
		resultSet.add(stack2);
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		stack3.push('R');
		resultSet.add(stack3);
		assertEquals(resultSet, Backtracking.findAllSolutions(puzzle1));
		assertEquals(resultSet, Backtracking.findAllSolutions(puzzle2));
		Set<Stack<Character>> resultSet1 = new HashSet<Stack<Character>>();
		Set<Stack<Character>> resultSet2 = new HashSet<Stack<Character>>();
		resultSet1.add(new Stack<Character>());
		assertEquals(resultSet1, Backtracking.findAllSolutions(puzzle3));
		assertEquals(resultSet2, Backtracking.findAllSolutions(puzzle4));
		result1.push('R');
		result1.push('R');
		Set<Stack<Character>> resultSet3 = new HashSet<Stack<Character>>();
		resultSet3.add(result1);
		assertEquals(resultSet3, Backtracking.findAllSolutions(puzzle5));
	}


}
