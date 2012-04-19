package backtracking;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
 * 
 * @author Yao Chen
 * @version 2012-02-06
 *
 */
public class Backtracking {

	/**
	 * Takes an array of integers and returns one of the solutions for the puzzle
	 * @param puzzle an array of integers
	 * @return one of the solutions for the puzzle. top value on the stack is the first move.
	 *  a null value (instead of a Stack) to indicate that there is no solution.
	 */
	public static Stack<Character> solve(int[] puzzle){
		boolean[] isPassed = new boolean[puzzle.length];
		return find(puzzle, 0, isPassed);
	}

	/**
	 * Takes an array of integers and returns a set of all the solutions for the puzzle
	 * @param puzzle an array of integers
	 * @return a set of all the solutions
	 */
	public static Set<Stack<Character>> findAllSolutions(int[] puzzle){
		boolean[] isPassed = new boolean[puzzle.length];
		return findAll(puzzle, 0, isPassed);
	}

	/**
	 * takes puzzle, begin index and an array of boolean which record whether the integer have already been visited
	 * and recursively find all the solutions
	 * @param puzzle an array of integers
	 * @param begin the begin index
	 * @param isPassed whether the integer have already been visited
	 * @return a set of all solutions
	 */
	private static Set<Stack<Character>> findAll(int[] puzzle, int begin, boolean[] isPassed) {
		Set<Stack<Character>> all = new HashSet<>();
		if (begin == puzzle.length - 1) {
			all.add(new Stack<Character>());
			return all;
		}
		boolean[] isLPassed = isPassed.clone();
		if (isOkMove(puzzle,  begin,  1, isPassed)) {	
			isPassed[begin] = true;
			Set<Stack<Character>> allr = findAll(puzzle, begin + puzzle[begin], isPassed);
			for (Stack<Character> s : allr) {
				s.push(new Character('R'));
			}
			all.addAll(allr);
		}
		if (isOkMove(puzzle, begin, -1, isLPassed)) {
			isLPassed[begin] = true;
			Set<Stack<Character>> alll = findAll(puzzle, begin - puzzle[begin], isLPassed);
			for (Stack<Character> s : alll) {
				s.push(new Character('L'));
			}
			all.addAll(alll);
		}
		return all;
	}



	private static  Stack<Character> find (int[] puzzle, int begin, boolean[] isPassed) {
		Stack<Character> sl = new Stack<>();
		if (begin == puzzle.length - 1) return sl;
		if (isOkMove( puzzle,  begin,  1, isPassed)) {	
			isPassed[begin] = true;
			sl.addAll(find (puzzle, begin + puzzle[begin], isPassed));
			sl.push(new Character('R'));
		}else if (isOkMove( puzzle,  begin,  -1, isPassed)) {
			isPassed[begin] = true;
			sl.addAll(find (puzzle, begin - puzzle[begin], isPassed));
			sl.push(new Character('L'));
		}else {
			return null;
		}
		return sl;
	}


	private static boolean isOkMove(int[] puzzle, int begin,  int direction, boolean[] isPassed) {
		if (begin + direction * puzzle[begin] == puzzle.length - 1) {
			if (!isPassed[begin]) return true;
		}
		else if (begin + direction * puzzle[begin] < 0 || 
				begin+ direction * puzzle[begin] > puzzle.length - 1) return false;
		if (isPassed[begin +  direction * puzzle[begin]]) return false;
		boolean[] isLPassed = isPassed.clone();
		isLPassed[begin] = true;
		boolean[] isRPassed = isPassed.clone();
		isRPassed[begin] = true;
		return isOkMove (puzzle, begin + direction * puzzle[begin], 1, isRPassed) ||
				isOkMove (puzzle, begin + direction * puzzle[begin], -1, isLPassed);
	}

}
