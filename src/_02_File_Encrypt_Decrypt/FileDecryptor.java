package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FileDecryptor {
	int key = 12;

	public static void main(String[] args) {
		FileDecryptor fd = new FileDecryptor();
		fd.decrypt();
	}

	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	private void decrypt() {
		FileReader fr;
		String dec = "";
		try {
			fr = new FileReader("src/_02_File_Encrypt_Decrypt/msg.txt");
			int c = fr.read();
			while (c != -1) {
				dec += (char)(c - key);
				c = fr.read();
			}
			JOptionPane.showMessageDialog(null, "" + dec);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
	}
}
// c-12 or key