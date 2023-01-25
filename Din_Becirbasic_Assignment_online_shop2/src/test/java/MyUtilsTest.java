import ba.edu.ssst.MyUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MyUtilsTest {
    @Test
    public void testgetLargest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        List<Map.Entry<String, Integer>> list = MyUtils.getLargest(map, 3);
        assertEquals(3, list.size());
        assertEquals("e", list.get(0).getKey());
        assertEquals(5, list.get(0).getValue().intValue());
        assertEquals("d", list.get(1).getKey());
        assertEquals(4, list.get(1).getValue().intValue());
        assertEquals("c", list.get(2).getKey());
        assertEquals(3, list.get(2).getValue().intValue());

    }
}
