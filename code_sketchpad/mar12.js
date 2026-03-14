// Explained in comments with ChatGPT

// =======================
// Linked List - NODE
// =======================
// A Node is a single element in a linked list.
// Each node stores:
// 1. a value (data)
// 2. a pointer to the next node
class Node {
    constructor(value) {
        this.value = value      // the data stored in this node
        this.next = null        // pointer to the next node in the list
        // null means this node currently doesn't point to anything
    }
}
// =======================
// Linked List
// =======================

// The LinkedList class manages the nodes
class LinkedList {
    constructor() {
        this.head = null        // head = first node in the list
                                // null means the list is empty
    }

    // LinkedLists usually store logic inside methods
    // Nodes, head, tail etc are just ways to move around the list


    // =======================
    // Add a node to the FRONT
    // =======================
    addFirst(value) {

        // Create a new node containing the value
        const newNode = new Node(value)

        // If the list is empty
        if (this.head === null) {

            // make the new node the head
            // (it becomes the first and only element)
            this.head = newNode
            return;
        }

        // If the list already has elements:

        // Step 1:
        // Make the new node point to the current head
        newNode.next = this.head

        // Step 2:
        // Move the head pointer to the new node
        this.head = newNode

        // Now the new node is the first node in the list
    }

    // =======================
    // Add a node to the END
    // =======================
    addLast(value) {
        // Create the new node
        const newNode = new Node(value)
        // If list is empty
        if (this.head === null) {
            // new node becomes the head
            this.head = newNode
            return;
        }

        // Start at the head
        let current = this.head;

        // Traverse the list until we reach the last node
        // The last node is the one whose "next" is null
        while (current.next != null) {

            // move forward in the list
            current = current.next;
        }

        // Now "current" is the tail (last node)

        // Link the last node to the new node
        current.next = newNode;
    }
    // =======================
    // Remove the FIRST node
    // =======================
    removeHead() {

        // If the list is empty, there is nothing to remove
        if (this.head === null) {
            return;
        }

        // If there is only ONE node in the list
        if (this.head.next === null) {

            // Removing the head makes the list empty
            this.head = null;
            return;
        }

        // If there are multiple nodes in the list

        // Move the head pointer to the next node
        // The second node becomes the new head
        this.head = this.head.next;

        // The original first node is now disconnected
        // JavaScript garbage collection will clean it up
    }


    // =======================
    // Remove the LAST node
    // =======================
    removeTail() {

        // If the list is empty, nothing to remove
        if (this.head === null) {
            return;
        }

        // If the list only has ONE node
        if (this.head.next === null) {
            // removing the tail means the list becomes empty
            this.head = null;
            return;
        }

        // We need to find the SECOND TO LAST node
        let current = this.head;

        // Loop until current.next.next is null
        // That means current.next is the last node
        while (current.next.next !== null) {
            current = current.next;
        }
        // Disconnect the last node
        current.next = null;
    }

    printList() {
        let current = this.head;

        while (current !== null) {
            console.log(current.value);
            // move to the next node
            current = current.next;
        }
    }
}
/*
const linkedlist = new LinkedList();
linkedlist.addLast(1);
linkedlist.addLast(2);
linkedlist.addLast(3);

linkedlist.printList()
*/

class Playlist {
    constructor() {
        this.list = new LinkedList()
    }

    addSong(song) {
        this.list.addFirst(song)
    }

    showPlaylist() {
        this.list.printList()
    }
}

/*const pl = new Playlist();
pl.addSong("Human - Flavor Foley")
pl.addSong("Soldering - ES2 OST")
pl.addSong("Albedo - NR OST")
pl.addSong("Boss Fight - Rhythm Doctor")
pl.showPlaylist()
 */

class Stack {
    constructor() {
        this.list = new LinkedList()
    }
    push (value) {
        this.list.addFirst(value)
    }
    pop() {
        return this.list.removeHead()
    }
    peek() {
        return this.list.head ? this.head.value : null
    }
}

class UndoManager {
    constructor() {
        this.stack = new Stack()
    }
    perform(action){
        console.log("action:", action)
        this.stack.push(action)
    }
    undo(){
        const action = this.stack.pop()
        if(!action){
            console.log("Nothing to undo")
        }
        console.log("Undo: ", action)
    }
}

const editor = new UndoManager()
editor.perform("type Hello")
editor.perform("type World")
editor.perform("delete World")
editor.undo()
editor.undo()

class Queue{
    constructor(){
        this.list = new LinkedList()
    }
}