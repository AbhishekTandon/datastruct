package com.tandon.datastruct.personal.list;

class Node<T> {
	public T data;
	public Node<T> next;

	Node(T c) {
		data = c;
		next = null;
	}
}

class LinkedListNode<T> {
	private T carryOver;
	private Node<T> l1, l2;
	
	public LinkedListNode (T  carryOver, Node<T> l1, Node<T> l2) {
		this.carryOver = carryOver;
		this.l1 = l1;
		this.l2 = l2;
	}

	public T getCarryOver() {
		return carryOver;
	}

	public Node<T> getL1() {
		return l1;
	}

	public Node<T> getL2() {
		return l2;
	}
}

public class LinkList {
	public static void main(String[] args) {
		final int len = 10;

		Node<Integer> head = null;
		Node<Integer> current;

		// Right way of inserting as 'head' points to the head of stack after insertion
		for (int i = len; i > 0; i--) {
			current = new Node(i);
			current.next = head;
			head = current;
		}

		System.out.println("Normal form:");
		printList(head);
		sort(head, len);
		printList(head);
//		reverse(head);
		head = delete2(head, 10);
		head = delete2(head, 5);
		printList(head);
		insert_in_sorted(head, 5);
		insert_in_sorted(head, -1);
		printList(head);

		int cnt = 4;
		System.out.println(String.format("the %s th node element is %s", cnt, get_nth_node(head, cnt).data));

		print_last_nth_nodes(head, cnt);
		Node ret = reverse_group(head, 3);
		System.out.println("printing in the reverse order...");
		printList(ret);
	}


	public static void addList(Node<Integer> l1, Node<Integer> l2, int carryOver) {

	}

	public static void printList(Node head) {
		StringBuilder buffer = new StringBuilder();
		while (head != null) {
			buffer.append(head.data).append("->");
			head = head.next;
		}
		System.out.println(buffer.toString());
	}

	/**
	 * reversing the link list
	 */
	public static void reverse(Node head) {
		Node<Integer> prev, curr, next;
		prev = null;
		curr = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		System.out.println("printing head2 data >> " + prev.data);

		head = prev;
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}


	public static void reverse(Node head, int k) {
		Node<Integer> curr, next, prev;
		prev = null;
		curr = head;
		next = curr.next;

		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;

		System.out.println("printing the list in reverse order...");
		printList(curr);
	}

	static Node reverse_group(Node<Integer> node, int k) {
		Node<Integer> current = node;
		Node<Integer> next = null;
		Node<Integer> prev = null;
		int count = 0;

        /*reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.next;
			current.next = prev; // reverse pointer
			prev = current;
			current = next;
			count++;
		}

		/** next is now a pointer to (k+1)th node
		 Recursively call for the list starting from current.
		 And make rest of the list as next of first node */
		if (next != null) {
			node.next = reverse_group(next, k);
		}

        /* prev is new head of the input list */
		return prev;
	}

	/**
	 * check for the scenario length = 0, 1 , 2 , 3
	 */
	public static Node<Integer> delete2(Node<Integer> head, Integer data) {
		System.out.println(String.format("deleting node with data (%s)", data));

		if (head.data == data) return head.next;
		else {
			Node<Integer> curr = head;
			Node<Integer> next;

			while (curr != null && (next = curr.next) != null) {
				if (next.data == data) {
					curr.next = next.next;
				}
				curr = curr.next;
			}

			return head;
		}
	}

	/**
	 * sort in descending order
	 */
	public static Node sort(Node<Integer> head, int count) {
		System.out.println(String.format("sorting the list in descending order"));
		if (head.next == null) return head;
		else {
			for (int i = 0; i < count; i++) {
				Node<Integer> curr = head;
				while (curr.next != null) {
					if (curr.data.compareTo(curr.next.data) == -1) {
						Integer tmp = curr.data;
						curr.data = curr.next.data;
						curr.next.data = tmp;
					}
					curr = curr.next;
				}
			}
		}

		return head;
	}

	/**
	 * inserting in sorted order
	 */
	public static Node<Integer> insert_in_sorted(Node<Integer> head, int num) {
		System.out.println(String.format("inserting (%s) in sorted order", num));
		Node<Integer> node = new Node(num);
		Node<Integer> curr = head;

		while (curr.next != null) {
			if (curr.next.data.compareTo(num) == -1) { // curr.data < num
				// insert the data
				node.next = curr.next;
				curr.next = node;
				break;
			}
			curr = curr.next;
		}

		if (curr.next == null) curr.next = node;

		return head;
	}


	public static Node<Integer> get_nth_node(Node<Integer> head, int n) {
		Node<Integer> curr = head;
		for (int i = 1; i < n; i++) {
			if (curr.next != null) curr = curr.next;
			else throw new RuntimeException("Insufficient list length");
		}

		return curr;
	}

	/**
	 * print last n elements of the list
	 */
	public static void print_last_nth_nodes(Node<Integer> head, int n) {
		Node<Integer> nth_node = get_nth_node(head, n);
		Node<Integer> curr = nth_node;
		while (curr.next != null) {
			head = head.next;
			curr = curr.next;
		}
		System.out.println(String.format("printing last %s elements of the string", n));
		printList(head);
	}
}