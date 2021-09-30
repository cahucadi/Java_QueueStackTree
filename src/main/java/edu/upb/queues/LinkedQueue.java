/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.queues;

import edu.upb.models.IQueue;
import edu.upb.models.MyException;
import edu.upb.models.Node;

/**
 *
 * @author cahuc
 */
public class LinkedQueue implements IQueue {

    private Node head = null;
    private Node tail = null;


    public void enqueue(Object item) {
        Node newNode = new Node(item, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new MyException("Cannot dequeue on empty queue");
        }
        Object item = head.data;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        return item;
    }

    public Object peek() {
        if (head == null) {
            throw new MyException("Cannot peek on empty queue");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        for (Node node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

}
