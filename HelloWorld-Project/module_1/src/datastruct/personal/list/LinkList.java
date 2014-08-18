package datastruct.personal.list;

class Node<T> {
	public T data;
	public Node next;

	Node(T c) {
		data = c;
		next = null;
	}
}

public class LinkList {
	public static void main(String[] args) {
		int c = 10, d = -1;
		if (args.length > 0) c = Integer.valueOf(args[0]);
		if (args.length > 1) d = Integer.valueOf(args[1]);

		Node<Integer> head = null;
		Node<Integer> current;

		// Right way of inserting as 'head' points to the head of stack after insertion
		for (int i = c; i > 0; i--) {
			current = new Node(i);
			current.next = head;
			head = current;
		}

		System.out.println("Normal form:");
		printList(head);
//		reverse(head);
		Node curr = delete(head, 1);
		printList(curr);

		return;

	}


	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}


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

	/**
	 * check for the scenario length = 0, 1 , 2 , 3
	 */
	public static Node delete(Node<Integer> head, Integer data) {
		System.out.println(String.format("deleting node with data (%s)", data));

		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> next;
		Node<Integer> ret;

		if (curr.data == data)  {
			ret = curr.next;
			return ret;
		}
		else {
			while (curr != null) {
				next = curr.next;
				Integer tmp = curr.data;
				if (tmp == data) { // if there is data match to delete
					if (prev != null) prev.next = curr.next;
					break;
				}
				prev = curr;
				curr = next;
			}
			return head;
		}
	}
}