import java.util.HashMap;
import java.util.function.BiFunction;

public class BiFunctionSample {
    public static void main(String []args){
        System.out.println(doSubString ("Hello World", 5 , (str , i) -> str.substring(i)));
        // This way a functional interface can even by called in one line w/o interface
        System.out.println(doSubString ("Hello World", 5 , String::substring));

        mapMergeExample();
    }
    private static String doSubString (String str , int i , BiFunction <String , Integer , String> processor) {
        return processor.apply(str , i);
    }
    // Another practical example of BiFunction is in map merge.
    //What merge does is basically replaces the value of the given key with the given value
    // if the value is null or the key does not have a value.
    // Otherwise, replace the value of the given key after applying the BiFunction.
    private static void mapMergeExample(){
        HashMap<String, String> map = new HashMap<>();
        map.put("1", null);
        map.put("2", "Hello");
        map.merge("1", "Hi", String::concat); //
        map.merge("2", "Hi", String::concat);
        System.out.println(map.get("1")); // Hi
        System.out.println(map.get("2")); // HelloHi
    }
}

