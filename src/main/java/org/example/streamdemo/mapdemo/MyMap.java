package org.example.streamdemo.mapdemo;

import java.util.HashSet;

@SuppressWarnings("unchecked")
public class MyMap<K, V> {

    public static class MyNode<K, V>{
        K key;
        V value;
        MyNode<K, V> next;

        public MyNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || !obj.getClass().equals(this.getClass())){
                return false;
            }
            MyNode<K, V> node = (MyNode<K, V>) obj;
            return node.getKey().equals(this.getKey());
        }
    }

    private Integer SIZE = 16;
    private Integer COUNTER = 0;

    private MyNode<K, V>[] nodeArr;

    public MyMap(){
        nodeArr = (MyNode<K, V>[])new MyNode[SIZE];
    }

    public void inject(K key, V value){
        MyNode<K, V> node = new MyNode<>(key, value);
        ensureSize();
        int index = getIndex(key);
        if(nodeArr[index] == null){
            nodeArr[index] = node;
            COUNTER ++;
        } else {
            System.out.println("Collision occurred : " + key);
            MyNode<K, V> root = nodeArr[index];
            if(root.getKey().equals(key)){
                root.value = value;
                return;
            }
            while(root.next != null){
                root = root.next;
                if(root.getKey().equals(key)){
                    root.value = value;
                    return;
                }
            }
            root.next = node;
        }
    }

    public V extract(K key){
        int index = getIndex(key);
        MyNode<K, V> root = nodeArr[index];
        if(root == null){
            return null;
        }
        do{
            if(root.getKey().equals(key)){
                return root.getValue();
            }
            root = root.next;
        } while (root != null);
        return null;
    }

    public int getIndex(K key){
        int hasCode = key.hashCode();
        return hasCode % SIZE;
    }

    public void ensureSize(){
        if(SIZE * 0.75 <= COUNTER){
            int oldSize = SIZE;
            SIZE = SIZE + (int)(SIZE * 0.25);
            MyNode<K, V>[] newArr = (MyNode<K, V>[]) new MyNode[SIZE];
            if (oldSize >= 0) System.arraycopy(nodeArr, 0, newArr, 0, oldSize);
            nodeArr = newArr;
        }
    }

    public HashSet<MyNode<K, V>> getNodeSet(){
        HashSet<MyNode<K, V>> set = new HashSet<>();
        for(int i = 0; i < SIZE; i++){
            if(nodeArr[i] != null){
                MyNode<K, V> node = nodeArr[i];
                do{
                    set.add(node);
                    node = node.next;
                } while (node != null);
            }
        }
        return set;
    }
}
