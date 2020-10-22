package _03_To_Do_List;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	Button button1 = new Button("add task");
	Button button2 = new Button("view tasks");
	Button button3 = new Button("remove task");
	Button button4 = new Button("save list");
	Button button5 = new Button("load list");
	FileWriter fw;
	FileReader fr;
	String reading = "";
	ArrayList<String> tasks = new ArrayList<String>();
	String fp = "";
	String string = "";
	String dr = "";
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.start();
	}

	private void start() {
		try {
			fr = new FileReader("src/_03_To_Do_List/directory.txt");
			int c = fr.read();
			while (c != -1) {
				dr += "" + (char)c;
				c = fr.read();
				
			}
			if (!dr.equals("")) {
				addArr(dr);
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.setVisible(true);
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
	}

	private void addArr(String str) {
		// TODO Auto-generated method stub
		tasks.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(str));	
			String line = br.readLine();
			while(line != null){
				tasks.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getSource();
		if (arg0.getSource().equals(button1)) {
			addTask();
		} else if (arg0.getSource().equals(button2)) {
			viewTasks();
		} else if (arg0.getSource().equals(button3)) {
			removeTask();
		} else if (arg0.getSource().equals(button4)) {
			saveList();
		} else {
			loadList();
		}
	}

	private void loadList() {
		// TODO Auto-generated method stub
		fp = JOptionPane.showInputDialog("what is the file path?");
		try {
			fw = new FileWriter("src/_03_To_Do_List/directory.txt");
			fw.write(fp);
			fw.close();
			addArr(fp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void saveList() {
		// TODO Auto-generated method stub
		try {
			
			fw = new FileWriter(fp);
			for (int i = 0; i < tasks.size(); i++) {
				string += tasks.get(i) + "\n";
			}
			fw.write(string);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void removeTask() {
		String toRem = JOptionPane.showInputDialog("what task should be removed?");
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).equals(toRem)) {
				tasks.remove(i);
				break;
			}
		}
	}

	private void viewTasks() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, tasks);
	}

	private void addTask() {
		// TODO Auto-generated method stub
		tasks.add(JOptionPane.showInputDialog("what task should be added?"));
	}
	
}
 //Copyright © 2020 Samson Kempiak