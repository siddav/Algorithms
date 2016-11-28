package geeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-
 * pointers/
 * 
 * @author vsidda
 *
 */
public class Linked_Lists_Flatten {
    public static void main(String[] args) {
        LLNode head = getAList();
        LLNode flattened = flattenList(head);
        System.out.println("--flattening list---");
        printFlattenedList(flattened);

        LLNode multiHead = getAMultiLevelList();
        LLNode multiFlattened = flattenMultiLevelList(multiHead);
        System.out.println("\n---multilevel flatten---");
        printFlattenedList(multiFlattened);
    }

    private static LLNode getAMultiLevelList() {
        LLNode five = new LLNode(5);
        LLNode ten = new LLNode(10);
        LLNode twelve = new LLNode(12);
        LLNode nineteen = new LLNode(19);
        LLNode eleven = new LLNode(11);
        LLNode seven = new LLNode(7);
        LLNode four = new LLNode(4);
        LLNode eight = new LLNode(8);
        LLNode six = new LLNode(6);
        LLNode three = new LLNode(3);
        LLNode twenty = new LLNode(20);
        LLNode twentyTwo = new LLNode(22);
        LLNode thirtyFive = new LLNode(35);
        LLNode thirteen = new LLNode(13);
        LLNode sixteen = new LLNode(16);
        LLNode fifteen = new LLNode(15);
        LLNode two = new LLNode(2);
        LLNode seventeen = new LLNode(17);
        LLNode nine = new LLNode(9);

        ten.right = five;
        five.right = twelve;
        twelve.right = seven;
        seven.right = eleven;

        ten.down = four;
        four.right = twenty;
        twenty.down = two;

        twenty.right = thirteen;
        twenty.down = two;
        thirteen.down = sixteen;
        sixteen.down = three;

        seven.down = seventeen;
        seventeen.down = nine;
        nine.down = nineteen;
        nineteen.right = fifteen;
        nine.right = eight;
        seventeen.right = six;
        return ten;
    }

    private static void printFlattenedList(LLNode head) {
        while (head != null) {
            System.out.print(head.data + "->");
            //System.out.println(head.down + " do");
            head = head.right;
        }
    }

    private static LLNode flattenList(LLNode node) {
        LLNode flattened = node;
        if (node == null) {
            return node;
        }
        Stack<LLNode> st = new Stack<>();
        while (node != null) {
            if (node.down != null) {
                if (node.right != null) {
                    st.push(node.right);
                }
                node.right = node.down;
                node.down = null;
            }
            if (node.right == null && node.down == null && !st.isEmpty()) {
                node.right = st.pop();
            }
            node = node.right;
        }
        return flattened;
    }

    private static LLNode flattenMultiLevelList(LLNode node) {
        if (node == null) {
            return node;
        }
        LLNode flattened = node;
        Queue<LLNode> q = new LinkedList<>();
        while (node != null) {
            if (node.down != null) {
                q.offer(node.down);
                node.down = null;
            }
            if (node.right == null && !q.isEmpty()) {
                node.right = q.poll();
            }
            node = node.right;
        }
        return flattened;
    }

    private static LLNode getAList() {
        LLNode head = new LLNode(5);
        LLNode ten = new LLNode(10);
        LLNode nineteen = new LLNode(19);
        LLNode twentyEight = new LLNode(28);
        LLNode seven = new LLNode(7);
        LLNode eight = new LLNode(8);
        LLNode thirty = new LLNode(30);
        LLNode twenty = new LLNode(20);
        LLNode twentyTwo = new LLNode(22);
        LLNode thirtyFive = new LLNode(35);
        LLNode forty = new LLNode(40);
        LLNode fortyFive = new LLNode(45);
        LLNode fifty = new LLNode(50);

        // associations
        head.right = ten;
        head.down = seven;
        seven.down = eight;
        eight.down = thirty;

        ten.right = nineteen;
        ten.down = twenty;

        nineteen.right = twentyEight;
        nineteen.down = twentyTwo;
        twentyTwo.down = fifty;

        twentyEight.down = thirtyFive;
        thirtyFive.down = forty;
        forty.down = fortyFive;

        return head;
    }
}

class LLNode {
    int data;
    LLNode right;
    LLNode down;

    LLNode(int data) {
        this.data = data;
    }

    LLNode(int data, LLNode right, LLNode down) {
        this.right = right;
        this.data = data;
        this.down = down;
    }

    public String toString() {
        return " " + data;
    }
}