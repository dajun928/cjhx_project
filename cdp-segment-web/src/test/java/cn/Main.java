package cn;
public class Main {
    public static void main(String[] args) {
        String str = "YourStringHere";
        long hashedValue = generate19DigitLong(str);
        System.out.println("Generated 19-digit long value from \"" + str + "\": " + hashedValue);
    }

    public static long generate19DigitLong(String str) {
        long hash = str.hashCode() & 0xFFFFFFFFFFFFL; // 48 bits
        return (hash % 9000000000000000000L) + 1000000000000000000L; // Ensure 19 digits
    }
}
