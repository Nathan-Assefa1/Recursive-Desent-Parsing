import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class MainGui {
	JPanel mainPanel;
	JPanel inner_panel;
	JFrame frame = new JFrame();

	String title;
	
	public MainGui(int width, int height, String layout) {
		frame.setLayout(new FlowLayout());			
		Dimension d = new Dimension();
		d.setSize(width, height);
		frame.setPreferredSize(d);
	}
	
	public MainGui(int width2, int height2, String layout, int rows, int columns) {
		GridLayout g = new GridLayout();
		g.setRows(rows);
		g.setColumns(columns);
		frame.setLayout(g);
		Dimension d = new Dimension();
		d.setSize(width2, height2);
		frame.setPreferredSize(d);
		
	}
	
	public MainGui(int width, int height, String layout, int rows, int columns, int hgap, int vgap) {
		GridLayout g = new GridLayout();
		g.setRows(rows);
		g.setColumns(columns);
		g.setHgap(hgap);
		g.setVgap(vgap);
		frame.setLayout(g);
		Dimension d = new Dimension();
		d.setSize(width, height);
		frame.setPreferredSize(d);
	}

//	private void initializeComponent(int width, int height, String layout) {
//		
////		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
//	private void setSize(int width, int height) {
//		mainPanel.setSize(width, height);
//	}
//
//	private void setLayout(FlowLayout flowLayout) {
//		frame.setLayout(flowLayout);
//	}
//	
//	private void setGridLayout(GridLayout gridLayout) {
//		mainPanel.setLayout(gridLayout);
//	}

	public void addButton(String buttonString) {
		JButton button = new JButton(buttonString);
		frame.add(button);
	}
	
	public void addLabel(String labelString) {
		JLabel label = new JLabel(labelString);
		frame.add(label);
	}
	
	public void addTextfield(int number) {
		JTextField tf = new JTextField(number);
		frame.add(tf);
	}
	
	public void addRadio(String radioString) {
		JRadioButton r = new JRadioButton(radioString);
		frame.add(r);
	}
	
	public void addPanel(String layout, int rows, int columns, int hgap, int vgap) {
		inner_panel = new JPanel();
		if(layout.equals("Flow"))
			inner_panel.setLayout(new FlowLayout());
		else if(layout.equals("Grid") && hgap == 0 && vgap == 0) {
			GridLayout g = new GridLayout();
			g.setRows(rows);
			g.setColumns(columns);
			inner_panel.setLayout(g);
		}else if(layout.equals("Grid") && hgap != 0 && vgap != 0) {
			GridLayout g = new GridLayout();
			g.setRows(rows);
			g.setColumns(columns);
			g.setHgap(hgap);
			g.setVgap(vgap);
			inner_panel.setLayout(g);
		}
		
		frame.add(inner_panel);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	

	public void setVisible(boolean b) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.pack();
		frame.setVisible(true);
	}

	
}
