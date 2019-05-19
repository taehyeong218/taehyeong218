//package twooter;

import twooter.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TwooterFrame extends JFrame {
	
	TwooterConnector tc;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JList list;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private Object[] colName = {"Name", "Msg", "Id"};
	
	private String fileName = "users.txt";
	
	public TwooterFrame(TwooterConnector tc) {
		// TODO Auto-generated constructor stub
		
		this.tc = tc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1500, 1200);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		//table.setBounds(19, 24, 1170, 927);
		table.setBounds(19, 24, 972, 677);
		contentPane.add(table);
		
		list = new JList();
		//list.setBounds(1255, 18, 175, 933);
		list.setBounds(1010, 18, 136, 683);
		contentPane.add(list);
		
		textField = new JTextField();
		//textField.setBounds(19, 996, 1170, 82);
		textField.setBounds(29, 723, 933, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("SEND");
		//btnNewButton.setBounds(1247, 995, 183, 82);
		btnNewButton.setBounds(983, 719, 163, 51);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg = textField.getText();
				if(msg != null && !msg.trim().equals("")){
					
					try {
						tc.getClient().postMessage(tc.getToken(), tc.getName(), msg);
						makejTable(tc.getTwooterMessage());
						repaint();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				textField.setText("");
			}
		});
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		//textField_1.setBounds(676, 1096, 246, 31);
		textField_1.setBounds(516, 781, 246, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("FIND");
		//btnNewButton_1.setBounds(941, 1096, 129, 33);
		btnNewButton_1.setBounds(781, 781, 87, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String hashTag = textField_1.getText();
				String[] msgId = null;
				if(hashTag != null && !hashTag.trim().equals("")){
					
					try {
						msgId = tc.getClient().getTagged(hashTag);
						new TwooterFramePop(tc.getTwooterTagMessage(msgId));
					
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				textField_1.setText("");
				
			}
		});
		
		contentPane.add(btnNewButton_1);
		
		
		textField_2 = new JTextField();
		//textField_2.setBounds(1119, 1096, 156, 31);
		textField_2.setBounds(887, 781, 156, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton_2 = new JButton("ADD");
		//btnNewButton_2.setBounds(1294, 1095, 129, 33);
		btnNewButton_2.setBounds(1054, 780, 95, 31);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userName = textField_2.getText();
				if(userName != null && !userName.trim().equals("")){
					
					try {
						if(tc.getClient().isActiveName(userName)){
							 File file = new File(fileName);
				        	 
				        	 FileWriter fw = new FileWriter(file, true);
				        	 fw.write(System.lineSeparator());
				        	 fw.write(userName);
				        	 fw.flush();
				        	 fw.close();
						}
					
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				textField_2.setText("");
				getList();
			}
		});
		contentPane.add(btnNewButton_2);
		
		getList();
	}
	
	public void makejTable(Object[][] obj){
		
		DefaultTableModel model = new DefaultTableModel(obj, colName){
			public boolean isCellEditable(int rowIndex, int mColIndex){
				return false;
			}
		};
		
		model.fireTableDataChanged();

		table.setModel(model);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setMinWidth(700);
		table.getColumnModel().getColumn(1).setMinWidth(450);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(700);
		table.getColumnModel().getColumn(1).setPreferredWidth(450);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				if(arg0.getClickCount() > 1){
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					
					if(column == 1){
						String name = ((String) table.getValueAt(row, column)).substring(1);
						new TwooterFramePop(tc.getTwooterMessage(name));
					}
				}
				
			}
		});
		
		//JScrollPane jsp = new JScrollPane(table);
		//contentPane.add(jsp);
	}
	
	public void getList(){
		
		List<String> userList = new ArrayList<>();	
		 
		try {
			File file = new File(fileName);
			if(file.exists()){
				FileReader fileReader = new FileReader(file);
				
				 BufferedReader bufReader = new BufferedReader(fileReader);
		    	 
		    	 String line = "";
		    	 while((line = bufReader.readLine()) != null){
		    		userList.add(line);
		    	 }
		    	 bufReader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.setModel(new AbstractListModel() {
			String[] values = userList.toArray(new String[userList.size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
    	 
	}


	
}
