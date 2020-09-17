package _03_To_Do_List;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
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
		}
	}

	private void removeTask() {
		String str = JOptionPane.showInputDialog("what should I remove?");
		char ch = str.charAt(0);
		boolean bool = false;
		try {
			fr = new FileReader("src/_03_To_Do_List/tasks.txt");
			fw = new FileWriter("src/_03_To_Do_List/tasks.txt");
			int c = fr.read();
			while (c != -1) {
				if (c == ch) {
					for (int i = 1; i < str.length() - 2; i++) {
						if (c == str.charAt(i)) {
							bool = true;
						}
					}
				}
				if (bool) {
					
				}
				char hc = (char) c;
				reading += hc;
				c = fr.read();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void viewTasks() {
		// TODO Auto-generated method stub
		try {
			fr = new FileReader("src/_03_To_Do_List/tasks.txt");
			int c = fr.read();
			while (c != -1) {
				char hc = (char) c;
				reading += hc;
				c = fr.read();
			}
			JOptionPane.showMessageDialog(null, reading);
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void addTask() {
		// TODO Auto-generated method stub
		try {
			fw = new FileWriter("src/_03_To_Do_List/tasks.txt");
			fw.write(JOptionPane.showInputDialog("What task should be added?"));
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}