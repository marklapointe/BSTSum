/**
 * 
 */
package com.demo.bstsum;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a Binary Search Tree and a target number, 
 * return true if there exist two elements in the BST 
 * such that their sum is equal to the given target
 * 
 * @author marklapointe
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start");
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(13);
		root.left.left = new Node(1);
		root.left.right = new Node(5);
		root.right.left = new Node(11);
		root.right.right = new Node(17);
		/**
					 10 
				   /   \
				  2      13
				/   \   /  \
			   1     5 11    17
		**/
		
		System.out.println("6 should be true: " + root.findTarget(6));
		System.out.println("23 should be true: " + root.findTarget(23));
		System.out.println("11 should be true: " + root.findTarget(11));
		System.out.println("30 should be true: " + root.findTarget(30));
		System.out.println("116 should be false: " + root.findTarget(116));
		System.out.println("33 should be false: " + root.findTarget(33));
		System.out.println("End");
	}
	
}


class Node {
	Integer data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}

	public Boolean hasValue(Integer value) {
		if (this.data == value) {
			return true;
		}
		if (this.data < value && this.right != null) return this.right.hasValue(value);
		if (this.data > value && this.left != null) return this.left.hasValue(value);
		return false;
	}
	
	public Boolean findTarget(Integer target) {
		Boolean retVal = false;
		List<Node> nodes = this.getInOrder();
		for (int i = 0; i <= (nodes.size()-1) && !retVal; i++) {
			Integer targetValue = target - nodes.get(i).data;
			retVal = this.hasValue(targetValue);
		}
		
		return retVal;
	}
	
	private List<Node> getInOrder() {
		List<Node> retVal = new ArrayList<Node>();
		if (this.left!= null) retVal.addAll(this.left.getInOrder());
		retVal.add(this);
		if (this.right!= null) retVal.addAll(this.right.getInOrder());
		return retVal;
	}

}
