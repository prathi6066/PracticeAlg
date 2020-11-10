package prathi.learn.practicealg.patterns.reversalLList;

class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here
        ListNode current = head;
        ListNode prev = null;
        ListNode next = head;
        ListNode secondHalf = current;
        ListNode firstHalf = null;
        int count=1;
        while(true) {
            while(current != null && count <= k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if(firstHalf != null) {
                firstHalf.next = prev;
            } else {
                head =  prev;
            }
            secondHalf.next = current;
            count = 1;

            while(count<=k) {
                prev = current;
                current = current.next;
                count++;
            }
            secondHalf = current;
            firstHalf = prev;

            count = 1;

            if(current == null)
                break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
