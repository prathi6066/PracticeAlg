package prathi.learn.practicealg.patterns.reversalLList;

class RotateList {

    /*
    Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
     */

    public static ListNode rotate(ListNode head, int rotations) {
        // TODO: Write your code here
        if (head == null || head.next == null)
            return head;

        // 1. find length of the linked list
        int len = 1;
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
            len++;
        }

        //2. Correct rotation if out of range
        rotations = rotations % len;

        //3. Find the no of nodes to skip
        int skipNodes = len - rotations;

        //4. Connect end to head to form a ciircular list
        current.next = head;

        ListNode lastNode = head;
        for (int i=0;i<skipNodes-1;i++) {
            lastNode = lastNode.next;
        }

        head = lastNode.next;
        lastNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
