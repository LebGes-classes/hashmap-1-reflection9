package HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterator<K, V>, Comparable<HashMap<K, V>>{


    private static class Node<K, V> {
        // Поля класса
        final int hash;
        K key; // Ключ
        V value; // Значение
        Node<K, V> next; // Ссылка на следующий узел

        // Конструктор класса HashMap.Node, инициализирующий поля класса
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash; // Присваиваем значение поля hash переданному значению
            this.key = key; // Присваиваем значение поля key переданному ключу
            this.value = value; // Присваиваем значение поля value переданному значению
            this.next = next; // Присваиваем ссылку на следующий узел переданной ссылке
        }


    }
    private final List<Node<K, V>> list;
    private Node<K, V> currentNode;
    private int currentListIndex;

    HashMap(){
        int CAPACITY = 10;
        list = new ArrayList<>(CAPACITY);// список с начальной вместимостью
        for (int i = 0; i < CAPACITY; i ++){
            list.add(null);
        }
    }

    public V put(K key, V value){// Метод для добавления элемента по ключу
        int hash = key.hashCode();
        int index = Math.abs(hash % list.size());
        Node<K, V> current = list.get(index);
        while (current != null){
            if (current.key.equals(key)){
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> newNode = new Node<>(hash, key, value, list.get(index));
        list.set(index, newNode);
        return null;
    }
    public V get(K key){// Метод для получения значения по ключу
        int hash = key.hashCode();
        int index = Math.abs(hash % list.size());

        Node<K, V> current = list.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % list.size());
        Node<K, V> current = list.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsValue(V value){
        for (Node<K, V> node : list){
            Node<K, V> current = node;
            while (current != null){
                if (current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public int size() {
        int size = 0;
        for (Node<K, V> node : list) {
            Node<K, V> current = node;
            while (current != null) {
                size++;
                current = current.next;
            }
        }
        return size;
    }
    @Override
    public boolean hasNext() {//для проверки наличия след элемента
        while (currentNode == null && currentListIndex < list.size() - 1) {
            currentListIndex++;
            currentNode = list.get(currentListIndex);
        }
        return currentNode != null;
    }

    @Override
    public V next() {//для получения след элемента
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        V value = currentNode.value;
        currentNode = currentNode.next;
        return value;
    }

    @Override
    public void remove(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % list.size());
        Node<K, V> current = list.get(index);
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    list.set(index, current.next);
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    @Override
    public int compareTo(HashMap<K, V> otherMap) {
        return this.size() - otherMap.size();
    }
}