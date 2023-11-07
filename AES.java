import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class AES {
   private static SecretKeySpec secretKey;
   private static byte[] key;

   public static void setKey(String myKey) throws Exception {
      key = myKey.getBytes("UTF-8");
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      key = Arrays.copyOf(sha.digest(key), 16);
      secretKey = new SecretKeySpec(key, "AES");
   }

   public static String encrypt(String strToEncrypt, String secret) throws Exception {
      setKey(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
   }

   public static String decrypt(String strToDecrypt, String secret) throws Exception {
      setKey(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
   }

   public static void main(String[] args) throws Exception {
      final String secretKey = "annaUniversity";
      String originalString = "www.annauniv.edu";
      String encryptedString = AES.encrypt(originalString, secretKey);
      String decryptedString = AES.decrypt(encryptedString, secretKey);
      
      System.out.println("Original URL : " + originalString);
      System.out.println("Encrypted URL : " + encryptedString);
      System.out.println("Decrypted URL : " + decryptedString);
   }
}