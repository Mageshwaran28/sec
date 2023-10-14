import java.util.*;

class caeserCipher {
    public static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static String decode(String enc, int offset) {
        return encode(enc, 26 - offset);
    }

    public static void main(String args[]) throws java.lang.Exception {
        System.out.println("Mageshwaran - 20IT028");
        System.out.println("Simulating caeser cipher\n---------------------");
        String msg = "Mageshwaran";
        System.out.println("Input : " + msg);
        System.out.printf("Encrypted Message :");
        System.out.println(caeserCipher.encode(msg, 3));
        System.out.printf("Decrypted Message :");
        System.out.println(caeserCipher.decode(caeserCipher.encode(msg, 3), 3));
    }
}