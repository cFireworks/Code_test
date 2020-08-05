package com.template.cache;

import java.util.HashMap;

public class LRU {
    class DLinkedList{
        DLinkedList prev;
        DLinkedList next;
        int key;
        int val;
        public DLinkedList(){}
        public DLinkedList(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    HashMap<Integer, DLinkedList> cache;
    DLinkedList head, tail;
    int size;
    int capicity;

    public LRU(int capcity){
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;
        this.capicity = capcity;
        cache = new HashMap();
    }
    public void put(int k, int v){
        if(cache.containsKey(k)){
            DLinkedList node = cache.get(k);
            node.val = v;
            moveToHead(node);
        }else{
            DLinkedList node = new DLinkedList(k, v);
            addToHead(node);
            size++;
            if(size > capicity){
                cache.remove(tail.prev);
                removeNode(tail.prev);
                size--;
            }
        }
    }
    public int get(int k){
        DLinkedList node = cache.get(k);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }
    public void addToHead(DLinkedList node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void addToTail(DLinkedList node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    public void removeNode(DLinkedList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToHead(DLinkedList node){
        removeNode(node);
        addToHead(node);
    }

}
