import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

import javax.swing.*;

public class Read_Gui {
	
	MainGui form;
	
	public Read_Gui(String user_File) {
		File f = new File(user_File);
		boolean exists = f.exists();
		if(!exists) {
			System.out.println("File Doesn't Exist");
			return;
		}
		
		
		try {
				FileReader reader = new FileReader(user_File);
				BufferedReader br = new BufferedReader(reader);
				
				String r;
				int counter = 0;;
				
				while ((r = br.readLine()) != null) {
					checkLayout(r);
					if(r.indexOf("Window") > -1) {
						createWindow(r);
					}
					else if(r.indexOf("Button")>-1)
						createButton(r);
					else if(r.indexOf("Panel")>-1)
						createPanel(r, br);
					else if(r.indexOf("Label") > -1) {
						createLabel(r);
					}
					else if(r.indexOf("Textfield") > -1) {
						createTextfield(r);
					}
					else if(r.indexOf("Radio") > -1) {
						createRadio(r);
					}
					else if(r.indexOf("End.") > -1) {
						counter++;
						createEnd();
					}
				}
//				if(br.readLine() == null && counter==0) {
//					System.out.println("Please make sure the file has "
//							+ "'End.' as the last line of the file.");
//					System.exit(0);
//				}

		}catch(FileNotFoundException e) {
			System.out.println("Not Found");
		}catch(Exception e) {
			System.out.println("Exception");
		}
	}
	

	private void checkLayout(String r) {
		if(r.indexOf("Layout") == -1 && r.indexOf("Flow") > -1 || r.indexOf("Layout") == -1 && r.indexOf("Grid") > -1) {
			System.out.println("Make sure to include a the keyword 'Layout'");
		    System.exit(0);
		}
		
		if(r.indexOf("Layout") > -1 && r.indexOf("Grid") == -1 && r.indexOf("Flow") == -1) {
			System.out.println("Make sure to include a layout type");
		    System.exit(0);
		}
		if(r.indexOf("Grid") > -1 && r.indexOf("Flow") > -1) {
			System.out.println("Make sure to include only one layout type");
		    System.exit(0);
		}
	}
	
	private void createWindow(String l) {
		int width = 0;
		int height = 0;
		int rows=0; int columns=0;
		int rows1=0; int columns1=0;
		String layout_num1 = null;
		String layout_num2 = null;
		String layout_num3 = null;
		String layout_num4 = null;
		String[] ds = l.split(" ");
		
		if(ds.length == 6 || ds.length == 8 || ds.length == 10 ) {
			
		
		String title = ds[1];
		String widthsize = ds[2];
		String heightsize = ds[3];
		String layout = ds[5];
		
		if(ds.length == 8) {
			layout_num1 = ds[6];
			layout_num2 = ds[7];
		}
		
		if(ds.length==10) {
			layout_num1 = ds[6];
			layout_num2 = ds[7];
			layout_num3 = ds[8];
			layout_num4 = ds[9];
		}
		
		title = title.replace('\"', ' ');
		widthsize = widthsize.replace('(', ' ');
		widthsize = widthsize.replace(',', ' ');
		heightsize = heightsize.replace(',', ' ');
		heightsize = heightsize.replace(')', ' ');
		layout = layout.replace(')', ' ');
		layout = layout.replace(';', ' ');
		layout = layout.replace(':', ' ');

		if(layout_num1 != null && layout_num2 != null) {
			layout_num1 = layout_num1.replace('(', ' ');
			layout_num1 = layout_num1.replace(',', ' ');
			layout_num1 = layout_num1.trim();
			layout_num2 = layout_num2.replace(',', ' ');
			layout_num2 = layout_num2.replace(')', ' ');
			layout_num2 = layout_num2.replace(':', ' ');
			layout_num2 = layout_num2.trim();
		}
		if(layout_num3 != null && layout_num4 != null) {
			layout_num3 = layout_num3.replace('(', ' ');
			layout_num3 = layout_num3.replace(',', ' ');
			layout_num3 = layout_num3.trim();
			layout_num4 = layout_num4.replace(',', ' ');
			layout_num4 = layout_num4.replace(')', ' ');
			layout_num4 = layout_num4.replace(':', ' ');
			layout_num4 = layout_num4.trim();
		}
		
		title = title.trim();
		widthsize = widthsize.trim();
		heightsize = heightsize.trim();
		layout = layout.trim();

		try {
			width = Integer.parseInt(widthsize);
			height = Integer.parseInt(heightsize);
			if(layout_num1 != null && layout_num2 != null) {
				rows = Integer.parseInt(layout_num1);
				columns = Integer.parseInt(layout_num2);
			}
			if(layout_num3 != null && layout_num4 != null) {
				rows1 = Integer.parseInt(layout_num3);
				columns1 = Integer.parseInt(layout_num4);
			}
		}catch(Exception ex) {
			System.out.println("Error in parsing");
		}
		if(layout.equals("Grid") && layout_num3!= null && layout_num4 != null)
			form = new MainGui(width, height, layout, rows, columns, rows1, columns1);
		else if(layout.equals("Grid"))
			form = new MainGui(width, height, layout, rows, columns);
		else if(layout.equals("Flow"))
			form = new MainGui(width, height, layout);
		form.setTitle(title);
		}
		else {
		System.out.println("Please correct the starting line with this format: "
				+ "'Window STRING '(' NUMBER ',' NUMBER ')' layout: ' Must be either "
				+ "6, 9, or 11 words");
		System.exit(0);
		}

	}
	
	private void createButton(String l) {
		int firstQuote = l.indexOf("\"");
		String subs = l.substring(firstQuote);
		
		subs = subs.replace('\"', ' ');
		subs = subs.replace(';', ' ');
		
		subs = subs.trim();
		form.addButton(subs);
		
	}
	private void createLabel(String s) {
		int firstQuote = s.indexOf("\"");
		String subs = s.substring(firstQuote);
		
		subs = subs.replace('\"', ' ');
		subs = subs.replace(';', ' ');
		
		subs = subs.trim();
		form.addLabel(subs);
	}
	
	private void createTextfield(String t) {
		t = t.trim();
		int firstQuote = t.indexOf(" ");
		String subs = t.substring(firstQuote);
		subs = subs.replace(';', ' ');
		subs = subs.trim();
		int numOfRoles = 0;
		numOfRoles = Integer.parseInt(subs);
		form.addTextfield(numOfRoles);
	}
	
	private void createRadio(String s) {
		int firstQuote = s.indexOf("\"");
		String subs = s.substring(firstQuote);
		subs = subs.replace('\"', ' ');
		subs = subs.replace(';', ' ');
		subs = subs.trim();
		form.addRadio(subs);
	}
	
	private void createPanel(String r, BufferedReader b) {
		int counter = 0;
		r = r.trim();
		String[] ds = r.split(" ");
		String layout_num1 = null; String layout_num2 = null;
		int rows = 0; int columns = 0; int hgap = 0; int vgap = 0;
		String layout = ds[2];
		
		if(ds.length == 5) {
		layout_num1 = ds[3];
		layout_num2 = ds[4];
		}
		String layout_num3 = null;
		String layout_num4 = null;
		
		if(ds.length==7) {
			layout_num1 = ds[3];
			layout_num2 = ds[4];
			layout_num3 = ds[5];
			layout_num4 = ds[6];
		}
		
		layout = layout.replace(')', ' ');
		layout = layout.replace(';', ' ');
		layout = layout.replace(':', ' ');

		if(layout_num1 != null && layout_num2 != null) {
			layout_num1 = layout_num1.replace('(', ' ');
			layout_num1 = layout_num1.replace(',', ' ');
			layout_num1 = layout_num1.trim();
			layout_num2 = layout_num2.replace(',', ' ');
			layout_num2 = layout_num2.replace(')', ' ');
			layout_num2 = layout_num2.trim();
		}
		if(layout_num3 != null && layout_num4 != null) {
			layout_num3 = layout_num3.replace('(', ' ');
			layout_num3 = layout_num3.replace(',', ' ');
			layout_num3 = layout_num3.trim();
			layout_num4 = layout_num4.replace(',', ' ');
			layout_num4 = layout_num4.replace(')', ' ');
			layout_num4 = layout_num4.replace(':', ' ');
			layout_num4 = layout_num4.trim();
		}

		layout = layout.trim();
		try {
			if(layout_num1 != null && layout_num2 != null) {
				rows = Integer.parseInt(layout_num1);
				columns = Integer.parseInt(layout_num2);
			}
			if(layout_num3 != null && layout_num4 != null) {
				hgap = Integer.parseInt(layout_num3);
				vgap = Integer.parseInt(layout_num4);
			}}catch(Exception ex) {
				System.out.println("Error in parsing");
			}
		
		form.addPanel(layout, rows, columns, hgap, vgap);
		try {
		while ((r = b.readLine()) != null) {
			if(r.indexOf("Button")>-1){
				int firstQuote = r.indexOf("\"");
		String subs = r.substring(firstQuote);
		
		subs = subs.replace('\"', ' ');
		subs = subs.replace(';', ' ');
		
		subs = subs.trim();
		form.inner_panel.add(new JButton(subs));
				}
			else if(r.indexOf("Label") > -1) {
				int firstQuote = r.indexOf("\"");
		String subs = r.substring(firstQuote);
		
		subs = subs.replace('\"', ' ');
		subs = subs.replace(';', ' ');
		
		subs = subs.trim();
		form.inner_panel.add(new JLabel(subs));
		
			}
			else if(r.indexOf("Textfield") > -1) {
				r = r.trim();
		int firstQuote = r.indexOf(" ");
		String subs = r.substring(firstQuote);
		subs = subs.replace(';', ' ');
		subs = subs.trim();
		int numOfRoles = 0;
		numOfRoles = Integer.parseInt(subs);
		form.inner_panel.add(new JTextField(subs));
		
			}
			else if(r.indexOf("Radio") > -1) {
		int firstQuote = r.indexOf("\"");
		String subs = r.substring(firstQuote);
		subs = subs.replace('\"', ' ');
		subs = subs.replace(';', ' ');
		subs = subs.trim();
		form.inner_panel.add(new JRadioButton(subs));}
			else if(r.indexOf("End;") > -1) {
				counter++;
				return;
			}
//			if(b.readLine() == null && counter==0) {
//				System.out.println("Please make sure the panel portion has "
//						+ "'End;' as the last line of its section");
//				System.exit(0);
//			}
		}}catch(FileNotFoundException e) {
			System.out.println("Not Found");
		}catch(Exception e) {
			System.out.println("Exception");
		}
//		if(layout.equals("Grid") && layout_num3!= null && layout_num4 != null)
//			form = new MainGui(layout, rows, columns, hgap, vgap);
//		else if(layout.equals("Grid"))
//			form = new MainGui(layout, rows, columns);
//		else if(layout.equals("Flow"))
//			form = new MainGui(layout);
		
	}
	
	private void createEnd() {
		form.setVisible(true);
		
	}
	
	public static void main(String[] args) throws Exception
    {
		String lines = args[0];

		Read_Gui gui = new Read_Gui(lines);
    }
}
