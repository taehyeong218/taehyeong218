//package twooter;
import twooter.*;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TwooterFramePop extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private Object[] colName = {"Name", "Msg", "Id"};
	
	public TwooterFramePop(Object[][] obj) {
		// TODO Auto-generated constructor stub
		
		//setBounds(200, 200, 1500, 1200);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		makejTable(obj);
		setVisible(true);
		
	}
	
	public void makejTable(Object[][] obj){
		
		table = new JTable();
		table.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		
		DefaultTableModel model = new DefaultTableModel(obj, colName);
		 
		table.setModel(model);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		//setJTableColumnsWidth(table, tablePreferredWidth, percentages);
		//table.setBounds(19, 24, 960, 600);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setMinWidth(700);
		table.getColumnModel().getColumn(1).setMinWidth(450);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(700);
		table.getColumnModel().getColumn(1).setPreferredWidth(450);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		//table.setBounds(19, 24, 1170, 927);
		table.setBounds(19, 24, 972, 677);
		
		contentPane.add(table);
		
		//JScrollPane jsp = new JScrollPane(table);
		//contentPane.add(jsp);
	}

	
}
