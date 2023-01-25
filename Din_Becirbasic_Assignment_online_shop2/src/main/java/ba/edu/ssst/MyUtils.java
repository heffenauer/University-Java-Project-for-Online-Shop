package ba.edu.ssst;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyUtils
{
    public static <K, V extends Comparable<? super V>> List<Map.Entry<K,V>> getLargest(Map<K,V> map, int n)
    {
        List<Map.Entry<K,V>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list.subList(0, n);


    }




}
