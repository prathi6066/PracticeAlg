package prathi.learn.practicealg.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(9);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(node1, node2);
        printLinkedList(result);
    }


    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;

        ListNode currentNode = result;
        while (l1 != null && l2 != null) {
            int num;
            if (l1.val <= l2.val) {
                num = l1.val;
                l1 = l1.next;
            } else {
                num = l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(num);
            if (result == null) {
                currentNode = newNode;
                result = newNode;
            } else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
        }

        if (l1 != null) {
            if (result == null) {
                result = l1;
            } else {
                currentNode.next = l1;
            }
        }

        if (l2 != null) {
            if (result == null) {
                result = l2;
            } else {
                currentNode.next = l2;
            }
        }

        return result;

    }

    private static void printLinkedList(ListNode currentHead) {

        while (currentHead != null) {
            System.out.println(currentHead.val);
            currentHead = currentHead.next;
        }
    }
}
