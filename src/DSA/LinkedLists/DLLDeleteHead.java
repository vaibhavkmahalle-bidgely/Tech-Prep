package DSA.LinkedLists;
class ListNode3 {
    int data;
    ListNode3 next;
    ListNode3 previous;
    public ListNode3(){
        data = 0;
        next = null;
        previous = null;
    }

    public ListNode3(int data1){
        data = data1;
        previous = null;
        next = null;

    }

    public ListNode3(int data1, ListNode3 next1, ListNode3 previous1){
        data = data1;
        previous = previous1;
        next = next1;
    }
}
public class DLLDeleteHead {

    public static void main(String[] args) {
        //ListNode3 node2 = new ListNode3();
        ListNode3 node1 = new ListNode3(1);
        ListNode3 node2 =  new ListNode3(2);
        ListNode3 node3 = new ListNode3(3);

        node1.previous = null;
        node1.next = node2;
        node2.previous = node1;
        node2.next = node3;
        node3.previous = node2;
        node3.next = null;

        System.out.println("Printing the nodes in normal order using next - node1 :"+ node1.data + " ,node2 : "+ node1.next.data + " ,node3 : "+ node2.next.data);
        System.out.println("Printing the nodes in normal order using previous - node1 :"+ node2.previous.data + " ,node2 : "+ node3.previous.data + " ,node3 : "+ node3.data);
    }


}
