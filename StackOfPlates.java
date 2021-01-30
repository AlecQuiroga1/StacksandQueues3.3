/**
 * Alec Quiroga
 * 1/29/21
 * Cracking the Coding Interview: 3.2
 * 
 * This program uses stacks and Arraylists to mimic real life of stacking plates. 
 * Once the stack gets too large it creates a new stack and moves the items over.
 */

import java.util.Stack;
import java.util.ArrayList;

public class StackOfPlates {

	private static class SetOfStacks {
		
		// creates an array list to store stacks.
		static ArrayList <Stack<Integer>> list = new ArrayList<Stack<Integer>>();
		
		// counts the amount of items being added so that creation 
		//and deletion of stacks is easily possible
		static int count = 0;
		
		// Sets the max stack size.
		int maxStackSize = 5;
		
		/**
		 * Checks if the current stacks are full or if there are no stacks.
		 * Will create one if 
		 * @param plate is the integer added to the stack.
		 */
		private void push(int plate) {
			if (count%maxStackSize == 0) {
				newStack();
			}
			Stack <Integer> currentStack = list.get(list.size()-1);
			currentStack.push(plate);
			count++;
		}
		
		/**
		 * This adds another stack that stores integers to the array list.
		 */
		
		private void newStack() {
			Stack <Integer> stack = new Stack<Integer>();
			list.add(stack);
		}
		
		/**
		 * Pop takes the last integer put into a stack and pulls it out.
		 */
		private void pop() {
			count--;
			Stack <Integer> currentStack = list.get(list.size()-1);
			System.out.println("The Number pulled out: " + currentStack.pop());
			list.remove(list.size()-1);
			
		}
		
		/**
		 * This takes in a integer and pops the integer at the top of the stack chosen.
		 * 
		 * @param index the integer for which stack the user would like to pull from.
		 */
		private void popAt(int index) {
			
			// Checks that the stack exist and if it does it then prints the integer.
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
