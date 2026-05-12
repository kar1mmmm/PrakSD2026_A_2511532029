package Pekan6_2511532029;

public class InsertDLL_2511532029 {

    static NodeDLL_2511532029 insertBegin(NodeDLL_2511532029 head_2029, int data_2029) {
        NodeDLL_2511532029 new_node_2029 = new NodeDLL_2511532029(data_2029);
        new_node_2029.next_2029 = head_2029;
        if (head_2029 != null) {
            head_2029.prev_2029 = new_node_2029;
        }
        return new_node_2029;
    }

    public static NodeDLL_2511532029 insertEnd(NodeDLL_2511532029 head_2029, int newData_2029) {
        NodeDLL_2511532029 newNode_2029 = new NodeDLL_2511532029(newData_2029);
        if (head_2029 == null) {
            return newNode_2029;
        } else {
            NodeDLL_2511532029 curr_2029 = head_2029;
            while (curr_2029.next_2029 != null) {
                curr_2029 = curr_2029.next_2029;
            }
            curr_2029.next_2029 = newNode_2029;
            newNode_2029.prev_2029 = curr_2029;
        }
        return head_2029;
    }

    public static NodeDLL_2511532029 insertAtPosition(NodeDLL_2511532029 head_2029, int pos_2029, int new_data_2029) {
        // Case 1: Insert at the beginning (Position 1)
        if (pos_2029 <= 1) {
            return insertBegin(head_2029, new_data_2029);
        }

        NodeDLL_2511532029 new_node_2029 = new NodeDLL_2511532029(new_data_2029);
        NodeDLL_2511532029 curr_2029 = head_2029;

        // Traverse to the node before the insertion point
        for (int i_2029 = 1; i_2029 < pos_2029 - 1 && curr_2029 != null; i_2029++) {
            curr_2029 = curr_2029.next_2029;
        }

        // Case 2: Position is out of bounds
        if (curr_2029 == null) {
            System.out.println("Posisi tidak ada");
            return head_2029;
        }

        // Case 3: Insert in middle or at the very end
        new_node_2029.next_2029 = curr_2029.next_2029;
        new_node_2029.prev_2029 = curr_2029;

        if (curr_2029.next_2029 != null) {
            curr_2029.next_2029.prev_2029 = new_node_2029;
        }
        curr_2029.next_2029 = new_node_2029;

        return head_2029;
    }

    public static void PrintList_2511532029(NodeDLL_2511532029 head_2029) {
        NodeDLL_2511532029 curr_2029 = head_2029;
        while (curr_2029 != null) {
            System.out.print(curr_2029.data_2029 + (curr_2029.next_2029 != null ? " <-> " : ""));
            curr_2029 = curr_2029.next_2029;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Manual initialization
        NodeDLL_2511532029 head_2029 = new NodeDLL_2511532029(2);
        head_2029.next_2029 = new NodeDLL_2511532029(3);
        head_2029.next_2029.prev_2029 = head_2029;
        head_2029.next_2029.next_2029 = new NodeDLL_2511532029(5);
        head_2029.next_2029.next_2029.prev_2029 = head_2029.next_2029;

        System.out.print("DLL awal : ");
        PrintList_2511532029(head_2029);

        head_2029 = insertBegin(head_2029, 1);
        System.out.print("Simpul 1 ditambahkan di awal: ");
        PrintList_2511532029(head_2029);

        System.out.print("Simpul 6 ditambah diakhir: ");
        head_2029 = insertEnd(head_2029, 6);
        PrintList_2511532029(head_2029);

        System.out.print("Tambah node 4 di posisi 4: ");
        head_2029 = insertAtPosition(head_2029, 4, 4);
        PrintList_2511532029(head_2029);
    }
}