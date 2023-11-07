import javax.crypto.*;

public class DES {
    public static void main(String[] argv) throws Exception {
        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
        SecretKey myDesKey = keygenerator.generateKey();
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
       
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] text = "Secret Information ".getBytes();
        byte[] textEncrypted = desCipher.doFinal(text);

        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] textDecrypted = desCipher.doFinal(textEncrypted);

        System.out.println("Encrypted Message: " + textEncrypted);
        System.out.println("Decrypted Message: " + new String(textDecrypted));
    }
}
