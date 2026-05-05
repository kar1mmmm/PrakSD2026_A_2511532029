package Pekan5_2511532029;
public class TambahSLL_2511532029 {

    public static NodeSSL_2511532029 insertAtFront(NodeSSL_2511532029 head, int value) {
        NodeSSL_2511532029 new_node_2029 = new NodeSSL_2511532029(value);
        new_node_2029.next_2029 = head;
        return new_node_2029;
    }
    
    public static NodeSSL_2511532029 insertAtEnd(NodeSSL_2511532029 head, int value) {
        NodeSSL_2511532029 newNode_2029 = new NodeSSL_2511532029(value);
        if (head == null) {
            return newNode_2029;
        }
        NodeSSL_2511532029 last_2029 = head;
        while (last_2029.next_2029 != null) {
            last_2029 = last_2029.next_2029;
        }
        last_2029.next_2029 = newNode_2029;
        return head;
    }
    
    static NodeSSL_2511532029 GetNode_2029(int data) {
        return new NodeSSL_2511532029(data);
    }
    
    static NodeSSL_2511532029 insertPos(NodeSSL_2511532029 headNode_2029, int position, int value) {
        NodeSSL_2511532029 head = headNode_2029;
        if (position < 1)
            System.out.print("Invalid position");
        if (position == 1) {
            NodeSSL_2511532029 newNode_2029 = new NodeSSL_2511532029(value);
            newNode_2029.next_2029 = head;
            return newNode_2029;    
        } else {
            NodeSSL_2511532029 temp = head;
            int pos = position;
            while (--pos > 1) {
                if (temp == null) break;
                temp = temp.next_2029;
            }
            if (temp == null || temp.next_2029 == null && pos > 1) {
                System.out.print("Posisi di luar jangkauan");
                return head;
            }
            NodeSSL_2511532029 newNode = GetNode_2029(value);
            newNode.next_2029 = temp.next_2029;
            temp.next_2029 = newNode;
            return head;
        }
    }
    
    public static void printList(NodeSSL_2511532029 head) {
        NodeSSL_2511532029 curr_2029 = head;
        while (curr_2029 != null) {
            System.out.print(curr_2029.data_2029);
            if (curr_2029.next_2029 != null)
                System.out.print("-->");
            curr_2029 = curr_2029.next_2029;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        NodeSSL_2511532029 head = new NodeSSL_2511532029(2);
        head.next_2029 = new NodeSSL_2511532029(3);
        head.next_2029.next_2029 = new NodeSSL_2511532029(5);
        head.next_2029.next_2029.next_2029 = new NodeSSL_2511532029(6);
        
        System.out.println("Seranai berantai awal: ");
        printList(head);
        
        System.out.println("tambah 1 simpul di depan: ");
        int data = 1;
        head = insertAtFront(head, data);
        printList(head);
        
        System.out.print("tambah 1 simpul di belakang: ");
        int data2 = 7;
        head = insertAtEnd(head, data2);
        printList(head);
        
        System.out.print("tambah 1 simpul ke data 4: ");
        int data3 = 4;
        int pos = 4;
        head = insertPos(head, pos, data3);
        printList(head);
    }
}