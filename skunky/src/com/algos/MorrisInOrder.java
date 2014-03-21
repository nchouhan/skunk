package com.algos;

public class MorrisInOrder {
	private static Node node = new Node();
	public MorrisInOrder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildNode();
//		printInorder(node);
//		morrisInorder();
//		myPreorder();
		morrisPreorder();
	}
	private static void myPostorder(){
		while(node != null){
			System.out.println(node.getData());
			if (node.getLeftNode() == null){
				node = node.getRightNode();
			} else {
				Node rightnode = node.getRightNode();
				Node current = node.getLeftNode();
				while(current.getRightNode() != null && current.getRightNode().getData() != node.getData())
					current = current.getRightNode();
				if(current.getRightNode() == null){
					current.setRightNode(node.getRightNode());
					node = node.getLeftNode();
				} else {
					node = node.getRightNode();
				}
			}
		}
	}
	private static void morrisPreorder(){
		while(node != null){
			System.out.println(node.getData());
			if (node.getLeftNode() == null){
				node = node.getRightNode();
			} else {
				Node rightnode = node.getRightNode();
				Node current = node.getLeftNode();
				while(current.getRightNode() != null && current.getRightNode().getData() != node.getData())
					current = current.getRightNode();
				if(current.getRightNode() == null){
					current.setRightNode(node.getRightNode());
					node = node.getLeftNode();
				} else {
					node = node.getRightNode();
				}
			}
		}
	}
	private static void morrisInorder(){
		while(node != null){
			
			if(node.getLeftNode() == null){
				System.out.println(node.getData());
				node = node.getRightNode();
			} else {
				Node current = node.getLeftNode();
				while(current.getRightNode() != null && current.getRightNode().getData() != node.getData())
					current = current.getRightNode();
				
				
				if (current.getRightNode() == null) {
					current.setRightNode(node);
					node = node.getLeftNode();
				} else {
					System.out.println(node.getData());
					node = node.getRightNode();
					current.setRightNode(null);
				}
				
			}
		}
	}
	private static void buildNode(){
		Node node4 = new Node(4,null, null);
		Node node5 = new Node(5,null, null);
		Node node6 = new Node(6,null, null);
		Node node7 = new Node(7,null, null);
		Node node2 = new Node(2,node4, node5);
		Node node3 = new Node(3,node6, node7);
		node = new Node(1,node2, node3);
	}
	
	private static void printInorder(Node iNode){
		
		if (iNode.getLeftNode() != null){
			printInorder(iNode.getLeftNode());
		}
		System.out.println(iNode.getData());
		if (iNode.getRightNode() != null){
			printInorder(iNode.getRightNode());
		}
		
	}

}
