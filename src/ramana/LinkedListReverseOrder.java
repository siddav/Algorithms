package ramana;

import java.util.Iterator;

public class LinkedListReverseOrder implements Iterable<LNode> {
	
	LNode head;
	LNode tail;	
	
	void insert(int data) {
		LNode n = new LNode(data);
		if(head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
	}
	// purposefully not implemented as this is not asked
	int remove(LNode node) {
		return 0;
	}
	public static void main(String[] args) {
		LinkedListReverseOrder list = new LinkedListReverseOrder();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		Iterator<LNode> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next().data+ " ");
		}
	}

	@Override
	public Iterator<LNode> iterator() {
		Iterator<LNode> it = new Iterator<LNode>(){
        LNode current = tail;
			@Override
			public boolean hasNext() {
				if(current != null) {
					return true;
				}
				return false;
			}

			@Override
			public LNode next() {
				LNode temp = current;
				current = current.prev;
				return temp;
			}
			
		};
		return it;		
	}
}
class LNode {
  int data;
  LNode prev;
  LNode next;
  LNode(int data) {
	  this.data = data;
  }
}
