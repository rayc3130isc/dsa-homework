package HW2_ArrayLists_Generics.code_sketchpad;

public class mar12 {
    public static void main(String [] args) {

    }

    /* (in js)
    //Linked List - NODE
    class Node {
        constructor(value) {
            this.value = value
            this.next = null
            // ^^ pointer to the next item
        }
    }

    //Linked List
    class LinkedList {
        constructor() {
            this.head = null
        }
    // ** LinkedLists are created with methods in them.
    // Nodes, heads, tails, etc. are just ways to navigate said Lists.

    // Add Elements to the list
    // 1. Old node points to new node
    // 2. New node becomes the TAIL
        addFirst(value) {
            const newNode = new Node(value)
            if(this.head === null) {
                this.head = newNode
                return
            }
            // we don't know how long the LinkedList will be

            let current = this.head
            while(current.next != null) {
                if(current === null){
                    current.next = newNode;
                }


             }
        }
    }
     */
}
