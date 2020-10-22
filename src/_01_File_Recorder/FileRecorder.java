package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		FileRecorder fr = new FileRecorder();
		fr.FileWriting();
		}
	public void FileWriting() {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt");
			fw.write(JOptionPane.showInputDialog("what should we put in your file?"));
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
 //Copyright © 2020 Samson Kempiak