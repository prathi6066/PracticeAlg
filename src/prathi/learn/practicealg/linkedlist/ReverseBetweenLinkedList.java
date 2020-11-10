package prathi.learn.practicealg.linkedlist;

public class ReverseBetweenLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);

        ListNode result = reverseBetween(node1, 2, 4);
        printLinkedList(result);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode currentNode = head;
        int count = 1;

        while (count < m-1) {
            currentNode = currentNode.next;
            count++;
        }
        return reverseList(currentNode, n-m);

    }

    public static ListNode reverseList(ListNode head, int count) {

        ListNode currentNode = head;
        ListNode tmpNode = head.next;
        ListNode nextNode = null, prevNode = null;
        int c = 1;

        while (currentNode != null && c <= count+1) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            c++;
        }

        currentNode = tmpNode;
        prevNode = (nextNode != null) ? nextNode.next : nextNode;
        if (currentNode != null)
            currentNode.next = prevNode;

        head.next = nextNode;

        return head;

    }

    private static void printLinkedList(ListNode currentHead) {

        while (currentHead != null) {
            System.out.println(currentHead.val);
            currentHead = currentHead.next;
        }
    }
}
