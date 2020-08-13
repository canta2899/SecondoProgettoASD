import java.util.Scanner;

public class BSCheck {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key;
        String value;
        RBNode root = null;
        while(true) {
            System.out.println("Type input");
            String inputLine = scan.nextLine();
            String els[] = inputLine.split("\\s+");

            if(els[0].equals("insert")){
                key = Integer.parseInt(els[1]);
                value = els[2];
                root = RBTree.insert(root, new RBNode(key, value));
            }else if(els[0].equals("find")){
                if (root != null) {
                    key = Integer.parseInt(els[1]);
                    System.out.println(RBTree.find(root, key).value);
                } else {
                    System.out.println("Tree is empty!");
                }
            }else if(els[0].equals("show")) {
                RBTree.show(root);
                System.out.println();
            }else if(els[0].equals("clear")) {
                root = null;
            }else if(els[0].equals("exit")) {
                break;
            }else {
                System.out.println("Unknown command");
            }
        }
    }

    /**
     * Insertion of a newNode in the BST maintaining BST properties
     * @param root the root node of the BST
     * @param newNode the new node to be inserted
     * @return the root node of the BST after the insertion
     */
    static BSNode insert(BSNode root, BSNode newNode){
        if(root == null){
            return newNode;
        }else if(root.key < newNode.key){
            root.right = insert(root.right, newNode);
        }else{
            root.left = insert(root.left, newNode);
        }
        return root;
    }


    /**
     * Visiting the BST in prefix notation printing each node as key:value
     * @param root the root node of the BST
     */
    static void show(BSNode root){
        // I could use a string builder but probably this is not gonna be used during time calculation
        // and, given that, i don't wanna decrease code's readability
        if(root != null){
            System.out.print(root.key+":"+root.value+" ");
            show(root.left);
            show(root.right);
        }else{
            System.out.print("NULL ");
        }
    }


    /**
     * Finding the node of the given key in the BST
     * @param root the root node of the BST
     * @param key the key of the node to be searched. REQUIRED as a key of an existent node
     * @return the node of the given key
     */
    static BSNode find(BSNode root, int key){
        if(root == null || root.key == key){
            return root;
        }else if(root.key < key){
            return find(root.right, key);
        }else{
            return find(root.left, key);
        }
    }
}
