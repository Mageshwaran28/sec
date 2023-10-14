import java.util.*;
class TransCipher {
 public static void main(String args[]) {
 System.out.println("Mageshwaran - 20IT028");
 System.out.println("Simulating Row Transposition cipher\n------------------");
 String pl="Security Lab";
 int col=4;
 System.out.println("Input : "+pl);
 String enc=encode(pl,col);
 System.out.println("Encrypted Message : "+enc);
 System.out.println("Decrypted Message : "+decode(enc,col));
}
 public static String encode(String s,int c)
 {
 int k = s.length();
 int l = 0;
 int col = c;
 int row = s.length() / col;
 char ch[][] = new char[row][col];
 for (int i = 0; i < row; i++) {
 for (int j = 0; j < col; j++) {
 if (l < k) {
 ch[i][j] = s.charAt(l);
 l++;
 } else {
 ch[i][j] = '#';
 }
 }
 }
 String dh="";
 char trans[][] = new char[col][row];
 for (int i = 0; i < row; i++) {
 for (int j = 0; j < col; j++) {
 trans[j][i] = ch[i][j];
 }
 }
 for (int i = 0; i < col; i++) {
 for (int j = 0; j < row; j++) {
 dh+=trans[i][j];
 }
 }
 return dh;
}
public static String decode(String s,int c)
 {
 int k = s.length();
 int l = 0;
 int row = c;
 int col = s.length() / row;
 char ch[][] = new char[row][col];
 for (int i = 0; i < row; i++) {
 for (int j = 0; j < col; j++) {
 if (l < k) {
 ch[i][j] = s.charAt(l);
 l++;
 } else {
 ch[i][j] = '#';
 }
 }
 }
 String m="";
 char trans[][] = new char[col][row];
 for (int i = 0; i < row; i++) {
 for (int j = 0; j < col; j++) {
 trans[j][i] = ch[i][j];
 }
 }
 for (int i = 0; i < col; i++) {
 for (int j = 0; j < row; j++) {
 m+=trans[i][j];
 }
 } 
 return m;
}
}
