package pekan9_2511532029;

public class BTreeDriver_2511532029 {
    public static void main(String[] args) {
        // Membuat pohon
    	BTree_2511532029 tree_2029 = new BTree_2511532029();
        System.out.print("Jumlah Simpul awal pohon: ");
        System.out.println(tree_2029.countNodes());

        // Menambahkan simpul data 1
        Node_2511532029 root_2029 = new Node_2511532029(1);

        // Menjadikan simpul 1 sebagai root
        tree_2029.setRoot(root_2029);
        System.out.print("Jumlah simpul jika hanya ada root: ");
        System.out.println(tree_2029.countNodes());
        
        Node_2511532029 node2 = new Node_2511532029(2);
        Node_2511532029 node3 = new Node_2511532029(3);
        Node_2511532029 node4 = new Node_2511532029(4);
        Node_2511532029 node5 = new Node_2511532029(5);
        Node_2511532029 node6 = new Node_2511532029(6);
        Node_2511532029 node7 = new Node_2511532029(7);
        Node_2511532029 node8 = new Node_2511532029(8);
        Node_2511532029 node9 = new Node_2511532029(9);
        
        root_2029.setleft_2029(node2);
        node2.setleft_2029(node4);
        node2.setRight_2029(node5);
        node4.setRight_2029(node8);
        root_2029.setRight_2029(node3);
        node3.setleft_2029(node6);
        node3.setRight_2029(node7);
        node6.setleft_2029(node9);
        
        // Set root ke currentNode
        tree_2029.setCurrent(tree_2029.getRoot());
        System.out.println("menampilkan simpul terakhir: ");
        System.out.println(tree_2029.getCurrent().getData_2029());
        
        System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
        System.out.println(tree_2029.countNodes());
        
        System.out.println("InOrder: ");
        tree_2029.printInorder_2029();
        
        System.out.println("\nPreorder: ");
        tree_2029.printPreorder_2029();
        
        System.out.println("\nPostorder : ");
        tree_2029.printPostorder_2029();
        
        System.out.println("\nMenampilkan simpul dalam bentuk pohon");
        tree_2029.print();
    }
}