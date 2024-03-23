package HashMap;

public interface Iterator<K, V> {
    boolean hasNext();
    V next();
    void remove(K key);
}
