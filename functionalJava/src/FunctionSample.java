import java.util.function.Function;

public class FunctionSample {
    public static void main(String []args){
        System.out.println(processFunction ("Hello World", str -> str.toUpperCase()));
        // This way a functional interface can even by called in one line w/o interface
        System.out.println(processFunction ("Hello World", String::toUpperCase));

        String prefix = "Hi!!!";
        // If in lambda , make a note that prefix is of local scope and cant modify
        System.out.println(processFunction("Hello" , str -> {
            // but cant modify prefix here !! 
            return str.concat(prefix);
        }));
        System.out.println(processFunction("Hello" , prefix::concat));
    }
    // process as a function  Interface , this way need not even define the functional interface / the interface
    private static String processFunction (String str , Function<String , String> processor) {
        return processor.apply(str);
    }
}

