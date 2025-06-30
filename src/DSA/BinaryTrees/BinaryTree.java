package DSA.BinaryTrees;

 public class BinaryTree {

   static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static public void preorderTraversal(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.data);
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

     static  public void inorderTraversal(Node node){
         if(node == null){
             return;
         }

         preorderTraversal(node.left);
         System.out.println(node.data);
         preorderTraversal(node.right);

    }

     static  public void postorderTraversal(Node node){
         if(node == null) {
             return;
         }
         inorderTraversal(node.left);
         inorderTraversal(node.right);
         System.out.println(node.data);
    }

     static  public void levelorderTraversal(Node node){

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);


        System.out.println("preorder traversal"); preorderTraversal(root);
        System.out.println("inorder traversal");inorderTraversal(root);
        System.out.println("postorder traversal");postorderTraversal(root);
        levelorderTraversal(root);




    }
}
