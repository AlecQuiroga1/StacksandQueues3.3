import java.util.Stack;
import java.util.ArrayList;

public class StackOfPlates {

	private static class SetOfStacks {
		
		static ArrayList <Stack<Integer>> list = new ArrayList<Stack<Integer>>();
		static int count = 0;
		int maxStackSize = 5;
		
		
		private void push(int plate) {
			if (count%maxStackSize == 0) {
				newStack();
			}
			Stack <Integer> currentStack = list.get(list.size()-1);
			currentStack.push(plate);
			count++;
		}
		
		private void newStack() {
			Stack <Integer> stack = new Stack<Integer>();
			list.add(stack);
		}
		
		private void pop() {
			count--;
			Stack <Integer> currentStack = list.get(list.size()-1);
			System.out.println("The Number pulled out: " + currentStack.pop());
			list.remove(list.size()-1);
			
		}
		
		private void popAt(int index) {
			
			if ((index - 1) < list.size() && index > 0) {
				Stack <Integer> currentStack = list.get(index-1);
				System.out.println("This number is from stack " + index + ": " +currentStack.pop());
			}else {
				System.out.println("That Stack does not exist.");
			}
			
		}
	}
	public static void main(String[] args) {
		SetOfStacks setOfStacks = new SetOfStacks();
		setOfStacks.push(1);
		setOfStacks.push(1);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);
		setOfStacks.push(2);
		setOfStacks.push(4);
		setOfStacks.push(3);
		setOfStacks.pop();
		
		
		setOfStacks.popAt(1);
		
		
	}

}
