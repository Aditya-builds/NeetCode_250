
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map_Demo {
public static void main(String[] args){   

    LinkedHashMap<Integer,Integer> seen = new LinkedHashMap<>();

    seen.put(1, 1);
    seen.put(2, 2);

    int index = seen.get(1);
    System.out.println(index);

    System.out.println(seen);

}}

//     HashMap<Integer,Integer> seen = new HashMap<>();
//     //create a map with key-value pairs

//     seen.put(1, 1);
//     seen.put(2, 2);


//     int index = seen.get(1);
//     System.out.println(index);

//     Boolean doesExist = seen.containsKey(1);
//     System.out.println(doesExist);


//     seen.remove(1);

//     System.out.println(seen.containsKey(1));
  
