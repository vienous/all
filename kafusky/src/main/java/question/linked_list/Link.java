package question.linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Link {
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new Node(i + 1));
		}
		for (int i = 0; i < 9; i++) {
			list.get(i).setNext(list.get(i + 1));
		}
		Node head = list.get(0);
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (head.getNext() != null) {
			stack.push(head.getNext());
			head = head.getNext();
		}
		while (!stack.empty()) {
			System.out.println(stack.pop().getData());
		}
	}
}

class Node {
	private Integer data;
	private Node next;

	Node(Integer data) {
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}