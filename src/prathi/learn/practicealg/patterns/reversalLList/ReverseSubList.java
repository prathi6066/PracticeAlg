package prathi.learn.practicealg.patterns.reversalLList;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        // TODO: Write your code here
        ListNode prevNode = head;
        ListNode current = head;
        int count = 1;
        while(current != null && count < p) {
            prevNode = current;
            current = current.next;
            count++;
        }
        prevNode.next = reverseNode(current, p, q);

        return head;
    }
    private static ListNode reverseNode(ListNode head, int p, int q) {
        int count = p;

        ListNode prev = head;
        ListNode current = head;
        ListNode next = head;

        while(current != null && count <= q) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        head.next = current;

        return prev;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}