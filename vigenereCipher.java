public class vigenereCipher {
    static String encode(String text, String key) {
        String res = "";
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                res += (char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a');
                j = ++j % key.length();
            } else if (c == ' ') {
                res += ' ';
                j = ++j % key.length();
            } else {
                res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
                j = ++j % key.length();
            }
        }
        return res;
    }

    static String decode(String text, String key) {
        String res = "";
        /*
         * key=key.toUpperCase();
         * text=text.toUpperCase();
         */
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                res += (char) ((c - key.charAt(j) + 26) % 26 + 'a');
                j = ++j % key.length();
            } else if (c == ' ') {
                res += ' ';
                j = ++j % key.length();
            } else {
                res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
                j = ++j % key.length();
            }
        }
        return res;
    }

    public static void main(String args[]) throws java.lang.Exception {
        String key = "Information";
        String msg = "Technology";
        System.out.println("Mageshwaran - 20IT028");
        System.out.println("Simulating Vigenere Cipher\n-------------------");
        System.out.println("Input Message : " + msg);
        String enc = encode(msg, key);
        System.out.println("Encrypted Message : " + enc);
        System.out.println("Decrypted Message : " + decode(enc, key));
    }
}
