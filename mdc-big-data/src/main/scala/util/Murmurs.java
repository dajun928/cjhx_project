package util;

public class Murmurs {
    public static Long hash(String str){
        return str.hashCode() & 0x7FFFFFFFFFFFFFFFL;
    }
}
