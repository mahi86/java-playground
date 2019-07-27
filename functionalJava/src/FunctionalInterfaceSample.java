import java.util.function.Function;
public class FunctionalInterfaceSample {
    public static void main(String []args){
        // With anonymous classs
        System.out.println(process("Hello World" , new Processor() {
            public String process (String str) {
                return str.toUpperCase();
            }
        }));
        System.out.println(process("Hello World" , (str) -> {
            return str.toLowerCase();
        }));
        // Single line code doesnt need return and no curlys
        System.out.println(process ("Hello World", str -> str.toUpperCase()));
        // With simplified method reference
        System.out.println(process ("Hello World", String::toUpperCase));

    }

    private static String process (String str , Processor p) {
        return p.process(str);
    }
    @FunctionalInterface
    interface Processor {
        String process (String str);
    }
}

