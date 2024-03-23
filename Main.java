package HashMap;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Собака", 1);
        hashMap.put("Кошка", 2);
        hashMap.put("Крокодил", 3);

        System.out.println("Размер: " + hashMap.size());
        System.out.println("Значение для ключа 'Крокодил': " + hashMap.get("Крокодил"));
        System.out.println("Значение для ключа 'Альберт': " + hashMap.get("Альберт"));

        System.out.println("Содержит ключ 'Кошка': " + hashMap.containsKey("Кошка"));
        System.out.println("Содержит значение 3: " + hashMap.containsValue(2));

        System.out.println("Удаляем ключ 'Крокодил'");
        hashMap.remove("Крокодил");
        System.out.println("Размер после удаления: " + hashMap.size());
        System.out.println(hashMap.hasNext());
        System.out.println(hashMap.next());

        HashMap<String, Integer> hashmap2 = new HashMap<>();

        hashmap2.put("Vertolet", 4);

        System.out.println(hashMap.compareTo(hashmap2));

        Comparator<HashMap<String, Integer>> c = new Comparator<>();

        System.out.println(c.compare(hashMap, hashmap2));

        System.out.println(hashMap.hashCode() + " " +  hashmap2.hashCode());
    }
}