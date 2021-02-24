package backup;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class UsertCart3 extends JFrame
{
	//MainApplication mainApp = new MainApplication();
	private final JPanel contentPanel = new JPanel();
	private controller controller = new controller();
	private JButton btnPay;
	private int index;
	private JLabel lblTotal;
	private JTextField textField;
	private JLabel text_ServerName;
	private JLabel text_Location;
	private JLabel text_Price;
	private JLabel lblNewLabel;
	private JLabel text_Model;
	private JTextField text_Coupon;
	private JLabel text_CouponApplied;
	private JFrame frame;
	//DefaultTableModel tabelModel;
	public DefaultTableModel tableTest = new DefaultTableModel();
	private JButton btnTest;
	public ArrayList serverTypes = new ArrayList();
	public ArrayList serverLocations = new ArrayList();
	public ArrayList serverSpecs = new ArrayList();
	public ArrayList serverPrices = new ArrayList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					UsertCart3 usercart = new UsertCart3();
					//usercart.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					usercart.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	int i = 0;
	public JTable table_Cart;
	
	public void setTabels()
	{
		int totaal = 0;
		DefaultTableModel tableTest = new DefaultTableModel()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		tableTest.addColumn("Server Type");
		tableTest.addColumn("Location");
		tableTest.addColumn("Spec");
		tableTest.addColumn("Price");
		//table.addColumn("Total");
		
		for (int i = 0; i < serverTypes.size(); i++)
		{
			//totaal = totaal + Integer.parseInt(total.get(i).toString());
			tableTest.addRow(new Object[] {
				serverTypes.get(i),
				serverLocations.get(i),
				serverSpecs.get(i),
				serverPrices.get(i),
			});
			System.out.println("Server Type  : " + serverTypes.get(i));
			System.out.println("Server Locs  : " + serverLocations.get(i));
			System.out.println("Server Spec  : " + serverSpecs.get(i));
			System.out.println("Server Price : " + serverPrices.get(i));
		}
		table_Cart.setModel(tableTest);
		//		System.out.println("Server Type  : " + serverTypes + " Added!");
		//		System.out.println("Server Loc   : " + serverLocations + " Added!");
		//		System.out.println("Server Spec  : " + serverSpecs + " Added!");
		//		System.out.println("Server Price : " + serverPrices + " Added!");
		String receipt = "\n"
			+ "Server Type     : " + serverTypes + "\n"
			+ "Server Location : " + serverLocations + "\n"
			+ "Server Specs    : " + serverSpecs + "\n"
			+ "Server Price    : " + serverPrices;
		JOptionPane.showMessageDialog(frame, "Data Berhasil DiSimpan" + receipt);
		table_Cart.repaint();
	}
	
	public UsertCart3()
	{
		setTitle("User Cart");
		setResizable(false);
		setBounds(100, 100, 410, 285);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTotal = new JLabel("Total :");
		lblTotal.setBounds(268, 136, 46, 14);
		contentPanel.add(lblTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(305, 133, 89, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getTable();
			}
		});
		btnPay.setBounds(160, 180, 89, 23);
		contentPanel.add(btnPay);
		
		text_ServerName = new JLabel("Server Type");
		text_ServerName.setBounds(35, 42, 71, 14);
		contentPanel.add(text_ServerName);
		
		text_Location = new JLabel("Location");
		text_Location.setBounds(142, 42, 55, 14);
		contentPanel.add(text_Location);
		
		text_Price = new JLabel("Price");
		text_Price.setBounds(332, 42, 30, 14);
		contentPanel.add(text_Price);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\usrcrt.png"));
		lblNewLabel.setBounds(73, -25, 230, 91);
		contentPanel.add(lblNewLabel);
		
		text_Model = new JLabel("Model");
		text_Model.setBounds(234, 42, 46, 14);
		contentPanel.add(text_Model);
		
		JLabel lblCouponCode = new JLabel("Coupon Code :");
		lblCouponCode.setBounds(33, 138, 86, 14);
		contentPanel.add(lblCouponCode);
		
		text_Coupon = new JTextField();
		text_Coupon.setBounds(26, 157, 86, 20);
		contentPanel.add(text_Coupon);
		text_Coupon.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (text_Coupon.getText().equals("Corona"))
				{
					text_CouponApplied.setVisible(true);
				}
				else
				{
					text_CouponApplied.setVisible(false);
					JOptionPane.showMessageDialog(frame, "Kode Kupon Tidak Ditemukan.");
				}
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\checkmark-16.png"));
		button.setBounds(117, 156, 21, 21);
		contentPanel.add(button);
		
		text_CouponApplied = new JLabel("25% Discount Applied");
		text_CouponApplied.setBounds(27, 182, 136, 14);
		text_CouponApplied.setVisible(false);
		contentPanel.add(text_CouponApplied);
		
		btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				serverTypes.add("VPS");
				serverLocations.add("Singapore");
				serverSpecs.add("Reguler");
				serverPrices.add("45000");
				setTabels();
			}
		});
		btnTest.setBounds(35, 209, 89, 23);
		contentPanel.add(btnTest);
		
		table_Cart = new JTable();
		table_Cart.setModel(new DefaultTableModel(
			new Object[][] {
				{ "", serverTypes, serverLocations, serverSpecs, serverPrices },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
			},
			new String[] {
				"", "Server Type", "Location", "Model", "Price"
			})
		{
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class
			};
			
			@Override
			public Class getColumnClass(int columnIndex)
			{
				return columnTypes[columnIndex];
			}
		});
		table_Cart.setRowSelectionAllowed(false);
		table_Cart.getColumnModel().getColumn(0).setPreferredWidth(27);
		table_Cart.getColumnModel().getColumn(1).setResizable(false);
		table_Cart.getColumnModel().getColumn(1).setPreferredWidth(148);
		table_Cart.getColumnModel().getColumn(2).setResizable(false);
		table_Cart.getColumnModel().getColumn(3).setResizable(false);
		table_Cart.getColumnModel().getColumn(4).setResizable(false);
		
		table_Cart.setBorder(new LineBorder(Color.GRAY, 3));
		table_Cart.setBounds(22, 55, 359, 64);
		contentPanel.add(table_Cart);
	}
	
	public JTable getTable()
	{
		return table_Cart;
	}
	
	//	public void setTable(JTable table)
	//	{
	//		this.table_Cart = table;
	//	}
}
