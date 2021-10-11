package com.GL.model;
import java.util.ArrayList;

class FindLongestPath {
	
	static class Node {
		int key;
		Node left, right;
	}
		
	static Node newNode(int key) {
		Node temp = new Node();
			
		temp.key = key;
		temp.left = null;
		temp.right = null;
		return temp;
	}
		
	public static ArrayList<Integer> findLongestPath(Node root){
		
		if(root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		
		ArrayList<Integer> rightNode = findLongestPath(root.right);
		ArrayList<Integer> leftNode = findLongestPath(root.left);
		
		if(rightNode.size() < leftNode.size()) {
			leftNode.add(root.key);
			}
		else {
			rightNode.add(root.key);
		}
		
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
				
	}
	
	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
		
		ArrayList<Integer> output = findLongestPath(root);
		int size = output.size();
		
		System.out.print(output.get(size - 1));
		for(int i = size - 2; i >= 0; i--) {
			System.out.print(" -> " + output.get(i));
		}
		
	}
		
}
