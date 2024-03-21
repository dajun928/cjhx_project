package cn;
public class Main {
    public static void main(String[] args) {
        String str = "YourStringHere";
//        String str = "YourStr12121212121221ingHere";
        long hashedValue = generate19DigitLong(str);
        System.out.println("Generated 19-digit long value from \"" + str + "\": " + hashedValue);
    }

    public static long generate19DigitLong(String str) {
        long hash = str.hashCode() & 0x7FFFFFFFFFFFFFFFL; // 48 bits
//        return (hash % 9000000000000000000L) + 1000000000000000000L; // Ensure 19 digits
        return (hash); // Ensure 19 digits
    }
}
