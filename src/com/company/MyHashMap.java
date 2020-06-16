package com.company;

import java.util.Objects;

/**
 * @description: 手动实现hashmap
 * @author: cfireworks
 * @create: 2020-03-18 18:51
 **/
public class MyHashMap {

    static class Node<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey(){return key;}
        public final V getValue(){return value;}
        public final String toString(){return key + "=" + value;}

        public final int hashCode(){
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
        public final V setValue(V newValue){
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        public final boolean equals(Object o){
            if(o==this) return true;
            if(o instanceof Node){
                Node<?,?> e = (Node<?,?>)o;
                if(Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()));
                return true;
            }
            return false;
        }
    }
}
