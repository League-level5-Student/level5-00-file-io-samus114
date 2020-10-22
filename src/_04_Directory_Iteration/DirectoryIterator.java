package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		File directory = new File("./src");
		fileDirectory(directory);
		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
	}

	static void fileDirectory(File directory) {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
			fileDirectory(f);
			}
		} else if(directory.getName().contains(".java")) {
			writeToFile(directory);
		}
	}
	static void writeToFile(File file) {
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write("\n //Copyright © 2020 Samson Kempiak");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 //Copyright © 2020 Samson Kempiak