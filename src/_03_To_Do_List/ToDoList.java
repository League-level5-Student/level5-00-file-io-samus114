package _03_To_Do_List;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getSource();
		if (arg0.getSource().equals(button1)) {
			addTask();
		} else if(arg0.getSource().equals(button2)) {
			viewTask();
		}
	}

	private void viewTask() {
		// TODO Auto-generated method stub
		
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