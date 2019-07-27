import java.util.function.Function;
public class FnInterface{
    public static void main(String []args){
            System.out.println(process("Hello World" , new Processor() {
            public String process (String str) {
                return str.toUpperCase();
            }
        }));
        System.out.println(process("Hello World" , (str) -> {
            return str.toLowerCase();
        }));
        // SIngle line code doesnt need return and no curlys
        System.out.println(process ("Hello World", str -> str.toUpperCase()));
        System.out.println(processFunction ("Hello World", str -> str.toUpperCase()));
    }

    // process as a function  Interface , this way need not even define the functional interface / the interface
    private static String processFunction (String str , Function<String , String> processor) {
        return processor.apply(str);
    }
    private static String process (String str , Processor p) {
        return p.process(str);
    }
    @FunctionalInterface
    interface Processor {
        String process (String str);
    }
}

