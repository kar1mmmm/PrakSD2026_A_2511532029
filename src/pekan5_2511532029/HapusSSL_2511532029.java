package pekan5_2511532029;

public class HapusSSL_2511532029 {

    public static NodeSSL_2511532029 deleteHead(NodeSSL_2511532029 head) {
        if (head == null) return null;
        head = head.next_2029;
        return head;
    }

    public static NodeSSL_2511532029 removeLastNode(NodeSSL_2511532029 head) {
        if (head == null) {
            return null;
        }

        if (head.next_2029 == null) {
            return null;
        }

        NodeSSL_2511532029 secondLast_2029 = head;
        while (secondLast_2029.next_2029 != null) {
            secondLast_2029 = secondLast_2029.next_2029;
        }

        secondLast_2029.next_2029 = null;
        return head;
    }

    public static NodeSSL_2511532029 deleteNode(
        NodeSSL_2511532029 head,
        int position
    ) {
        NodeSSL_2511532029 temp_2029 = head;
        NodeSSL_2511532029 prev_2029 = null;

        if (temp_2029 == null) return head;

        if (position == 1) {
            head = temp_2029.next_2029;
            return head;
        }

        for (int i = 1; temp_2029 != null && i < position; i++) {
            prev_2029 = temp_2029;
            temp_2029 = temp_2029.next_2029;
        }

        if (temp_2029 != null) {
            prev_2029.next_2029 = temp_2029;
        } else {
            System.out.println("Data tidak ada");
        }
        return head;
    }

    public static void printList(NodeSSL_2511532029 head) {
        NodeSSL_2511532029 curr_2029 = head;
        while (curr_2029.next_2029 != null) {
            System.out.print(curr_2029.data_2029 + "-->");
            curr_2029 = curr_2029.next_2029;
        }
        if (curr_2029.next_2029 == null) {
            System.out.print(curr_2029.data_2029);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        NodeSSL_2511532029 head = new NodeSSL_2511532029(1);
        head.next_2029 = new NodeSSL_2511532029(2);
        head.next_2029.next_2029 = new NodeSSL_2511532029(3);
        head.next_2029.next_2029.next_2029 = new NodeSSL_2511532029(4);
        head.next_2029.next_2029.next_2029.next_2029 = new NodeSSL_2511532029(
            5
        );
        head.next_2029.next_2029.next_2029.next_2029.next_2029 =
            new NodeSSL_2511532029(6);

        System.out.print("List awal: ");
        printList(head);

        head = deleteHead(head);
        System.out.print("List setelah dihapus: ");
        printList(head);

        head = removeLastNode(head);
        System.out.print("List setelah simpul terakhir di hapus: ");
        printList(head);

        int position = 2;
        head = deleteNode(head, position);
        System.out.print("list setelah posisi 2 dihapus: ");
        printList(head);
    }
}
