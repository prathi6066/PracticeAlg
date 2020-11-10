package prathi.learn.practicealg.linkedlist;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        //node1.next.next.next = new ListNode(4);

        ListNode result = swapPairs(node1);
        printLinkedList(result);

    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode currentNode = head;
        boolean isHead = true;

        while (currentNode != null) {
            ListNode prevNode = null;
            if (!isHead) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            ListNode tmpNode = currentNode;
            currentNode = currentNode.next;
            if (prevNode != null) {
                prevNode.next = currentNode;
            }
            if (isHead) {
                head = currentNode;
                isHead = false;
            }

            if (currentNode != null) {
                tmpNode.next = currentNode.next;
                currentNode.next = tmpNode;
                currentNode = currentNode.next;
            }
        }

        return head;

    }

    private static void printLinkedList(ListNode currentHead) {

        while (currentHead != null) {
            System.out.println(currentHead.val);
            currentHead = currentHead.next;
        }
    }
}
