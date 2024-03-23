package HashMap;

public class Comparator<E> implements Comparable<E>{
    @Override
    public int compareTo(E e) {
        return 0;
    }
    public int compare(E e1, E e2){
        return Integer.compare(e1.hashCode(), e2.hashCode());
    }
}
