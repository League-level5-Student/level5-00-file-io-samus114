package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	int key = 12;

	public static void main(String[] args) {
		FileEncryptor fe = new FileEncryptor();
		fe.encrypt();
	}

	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager. Use any key you want (1 - 25) to
	 * shift each letter in the users input and save the final result to a file.
	 */
	private void encrypt() {
		FileWriter fw;
		String str;
		try {
			fw = new FileWriter("src/_02_File_Encrypt_Decrypt/msg.txt");

			str = JOptionPane.showInputDialog("What to encrypt today?");
			char[] chars = str.toCharArray();
			str = "";
			for (int i = 0; i < chars.length; i++) {
				chars[i] = (char) (chars[i] + key);
			}
			for (int i = 0; i < chars.length; i++) {
				str += chars[i];
			}
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
}