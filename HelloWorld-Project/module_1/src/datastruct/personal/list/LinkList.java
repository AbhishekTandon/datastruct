package datastruct.personal.list;

class Node<T> {
	public T data;
	public Node<T> next;

	Node(T c) {
		data = c;
		next = null;
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
		head = delete(head, 1);
		head = delete(head, 5);
		printList(head);
		insert_in_sorted(head, 5);
		insert_in_sorted(head, -1);
		printList(head);

		int cnt = 4;
		System.out.println(String.format("the %s th node element is %s", cnt, get_nth_node(head, cnt).data));

		print_last_nth_nodes(head, cnt);
	}


	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
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

	/**
	 * check for the scenario length = 0, 1 , 2 , 3
	 */
	public static Node delete(Node<Integer> head, Integer data) {
		System.out.println(String.format("deleting node with data (%s)", data));

		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> next;
		Node<Integer> ret;

		if (curr.data == data) {
			ret = curr.next;
			return ret;
		} else {
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
		while(curr.next != null) {
			head = head.next;
			curr = curr.next;
		}
		System.out.println(String.format("printing last %s elements of the string", n));
		printList(head);
	}
}