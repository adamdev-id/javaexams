package backup;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class GUIServer extends JFrame
{
	
	private JPanel contentPane;
	private controller controller = new controller();
	DefaultTableModel table = new DefaultTableModel();
	private int index;
	private JFrame frame;
	UsertCart3 usc = new UsertCart3();
	public ArrayList serverType = new ArrayList();
	public ArrayList serverLocation = new ArrayList();
	public ArrayList serverSpec = new ArrayList();
	public ArrayList serverPrice = new ArrayList();
	public String space = "     ";
	int total = 0;
	int tax = 0;
	int finalPrice = 0;
	int couponUsed = 0;
	JLabel text_ShowItems;
	
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
					GUIServer frame = new GUIServer();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * 
	 * UTILS
	 * 
	 */
	int i = 0;
	private JTable tableComponents;
	private JTextField text_Coupon;
	private JTextField text_showTotal;
	private JTextField text_showTax;
	private JTextField text_showFinalPrice;
	
	public void setTotal()
	{
		text_showTotal.setText(String.valueOf(total));
	}
	
	public void setTax()
	{
		int formula = total * 8 / 100;
		text_showTax.setText(String.valueOf(formula));
	}
	
	public void setFinalPrice()
	{
		int finalPrice = 0;
		finalPrice = Integer.parseInt(text_showTotal.getText()) + Integer.parseInt(text_showTax.getText());
		text_showFinalPrice.setText(String.valueOf(finalPrice));
	}
	
	private void setTabel()
	{
		int temptotal = 0;
		int temptax = 0;
		int tempfinal = 0;
		//String taxprocessed = String.valueOf(text_showTotal);
		DefaultTableModel table = new DefaultTableModel()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table.addColumn("Server Type");
		table.addColumn("Location");
		table.addColumn("Spec");
		table.addColumn("Price");
		//		usc.tableTest.addColumn("Server Type"); 	export values to other JFrame ( disabled for future development )
		//		usc.tableTest.addColumn("Location");
		//		usc.tableTest.addColumn("Spec");
		//		usc.tableTest.addColumn("Price");
		//table.addColumn("Total");
		
		for (int i = 0; i < serverType.size(); i++)
		{
			temptotal = temptotal + Integer.parseInt(serverPrice.get(i).toString());
			temptax = temptax + (Integer.parseInt(serverPrice.get(i).toString()) * 8 / 100);
			tempfinal = (Integer.parseInt(text_showTotal.getText()) - (Integer.parseInt(serverPrice.get(i).toString())));
			table.addRow(new Object[] {
				serverType.get(i),
				serverLocation.get(i),
				serverSpec.get(i),
				serverPrice.get(i),
				//				usc.serverType.get(i),      export values to other JFrame ( disabled for future development )
				//				usc.serverLocation.get(i),
				//				usc.serverSpec.get(i),
				//				usc.serverPrice.get(i),
			});
		}
		//usc.table_Cart.setModel(table);
		tableComponents.setModel(table);
		text_showTotal.setText(String.valueOf(temptotal));
		text_showTax.setText(String.valueOf(temptax));
		int formulaf = tempfinal + Integer.parseInt(text_showTax.getText());
		text_showFinalPrice.setText(String.valueOf(formulaf));
	}
	
	public void printTotal()
	{
		if (couponUsed == 1)
		{
			for (int i = 0; i < serverType.size(); i++)
			{
				String receipt = "\n"
					+ "Server Type     : " + serverType.get(i) + "\n"
					+ "Server Loc      : " + serverLocation.get(i) + "\n"
					+ "Server Spec     : " + serverSpec.get(i) + "\n"
					//+ "Coupon Disc     : " + "Rp. " + finalPrice * 25 / 100 + "\n"
					+ "Server Price    : " + serverPrice.get(i) + "\n"
					+ "Total Payment   : " + text_showFinalPrice.getText();
				String border = "--------------------------";
				JOptionPane.showMessageDialog(frame, "               - = RECEIPT = -\n           " + border + receipt);
			}
		}
		else if (couponUsed == 0)
		{
			for (int i = 0; i < serverType.size(); i++)
			{
				String receipt = "\n"
					+ "Server Type     : " + serverType.get(i) + "\n"
					+ "Server Loc      : " + serverLocation.get(i) + "\n"
					+ "Server Spec     : " + serverSpec.get(i) + "\n"
					+ "Server Price    : " + serverPrice.get(i) + "\n"
					+ "Total Payment   : " + text_showFinalPrice.getText();
				String border = "--------------------------";
				JOptionPane.showMessageDialog(frame, "               - = RECEIPT = -\n           " + border + receipt);
			}
		}
		
	}
	
	private void removeRow()
	{
		DefaultTableModel table = (DefaultTableModel) tableComponents.getModel();
		int items = tableComponents.getSelectedRow();
		table.removeRow(items);
	}
	
	/**
	 * Create the frame.
	 */
	public GUIServer()
	{
		//getTotal();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] serverList = {
			"None",
			"Singapore",
			"Japan",
			"Australia",
		};
		setResizable(false);
		setTitle("                                              Adam's Host");
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(153, 180, 209), 6, true), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton button_VPS = new JToggleButton("");
		button_VPS.setSelectedIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\cloudfixed5.png"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\0b573712e694b223cb9b652611e96979-32bits-256.png"));
		lblNewLabel.setBounds(87, 5, 256, 41);
		contentPane.add(lblNewLabel);
		button_VPS.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\cloudfixed4.png"));
		button_VPS.setBackground(Color.BLACK);
		button_VPS.setBounds(97, 52, 66, 66);
		contentPane.add(button_VPS);
		
		JToggleButton button_Dedicated = new JToggleButton("");
		button_Dedicated.setSelectedIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\dedicatedfixed2.png"));
		button_Dedicated.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\dedicatedfixed.png"));
		button_Dedicated.setBackground(Color.BLACK);
		button_Dedicated.setBounds(180, 52, 66, 66);
		contentPane.add(button_Dedicated);
		
		JToggleButton button_webHost = new JToggleButton("");
		button_webHost.setSelectedIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\webfixed2.png"));
		button_webHost.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\webfixed.png"));
		button_webHost.setBackground(Color.BLACK);
		button_webHost.setBounds(264, 52, 66, 66);
		contentPane.add(button_webHost);
		
		JLabel lblServerLocation = new JLabel("Server Location");
		lblServerLocation.setBounds(169, 138, 105, 14);
		contentPane.add(lblServerLocation);
		
		JToggleButton button_Singapore = new JToggleButton("S i n g a p o r e");
		button_Singapore.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		button_Singapore.setBounds(49, 156, 105, 23);
		contentPane.add(button_Singapore);
		
		JToggleButton button_Australia = new JToggleButton("A u s t r a l i a");
		button_Australia.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		button_Australia.setBounds(161, 156, 105, 23);
		contentPane.add(button_Australia);
		
		JToggleButton button_Germany = new JToggleButton("G e r m a n y");
		button_Germany.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		button_Germany.setBounds(273, 156, 105, 23);
		contentPane.add(button_Germany);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\specets.png"));
		btnNewButton.setBounds(147, 192, 127, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		
		btnAddToCart.setBounds(161, 232, 105, 23);
		contentPane.add(btnAddToCart);
		
		JButton button_Cart = new JButton("Cart");
		button_Cart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UsertCart3 dialog = new UsertCart3();
				new UsertCart3().setVisible(true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				//dialog.setVisible(true);
				//button_Cart.setEnabled(false);
				//button_Cart.setEnabled(true);
			}
		});
		button_Cart.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\New folder (4)\\108fc39e82cab13ef3b581cddf182642-32bits-16.png"));
		button_Cart.setHorizontalAlignment(SwingConstants.LEFT);
		button_Cart.setBounds(9, 232, 79, 30);
		contentPane.add(button_Cart);
		
		JLabel text_ShowItems = new JLabel("0x Item");
		text_ShowItems.setBounds(95, 240, 74, 14);
		contentPane.add(text_ShowItems);
		
		tableComponents = new JTable();
		tableComponents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableComponents.setShowVerticalLines(false);
		tableComponents.setShowHorizontalLines(false);
		tableComponents.setShowGrid(false);
		tableComponents.setModel(new DefaultTableModel(
			new Object[][] {
				{ "", null, null, null },
				{ null, null, null, null },
				{ null, null, null, null },
				{ null, null, null, null },
			},
			new String[] {
				"Server Type", "Location", "Model", "Price"
			})
		{
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			
			@Override
			public Class getColumnClass(int columnIndex)
			{
				return columnTypes[columnIndex];
			}
		});
		tableComponents.getColumnModel().getColumn(0).setResizable(false);
		tableComponents.getColumnModel().getColumn(0).setPreferredWidth(148);
		tableComponents.getColumnModel().getColumn(1).setResizable(false);
		tableComponents.getColumnModel().getColumn(2).setResizable(false);
		tableComponents.getColumnModel().getColumn(3).setResizable(false);
		tableComponents.setBorder(new LineBorder(new Color(153, 180, 209), 3));
		tableComponents.setBounds(20, 285, 360, 80);
		contentPane.add(tableComponents);
		
		JLabel lblLocation = new JLabel("Server Type");
		lblLocation.setBounds(29, 267, 86, 14);
		contentPane.add(lblLocation);
		
		JLabel label = new JLabel("Location");
		label.setBounds(117, 267, 73, 14);
		contentPane.add(label);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(200, 267, 46, 14);
		contentPane.add(lblModel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(297, 267, 46, 14);
		contentPane.add(lblPrice);
		
		JButton button_Coupon = new JButton("");
		
		button_Coupon.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\$rendered\\clips\\checkmark-16.png"));
		button_Coupon.setBounds(116, 385, 21, 21);
		contentPane.add(button_Coupon);
		
		JLabel label_1 = new JLabel("Coupon Code :");
		label_1.setBounds(25, 368, 86, 14);
		contentPane.add(label_1);
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnRemoveSelected.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (tableComponents.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Mohon Pilih salah Satu");
				}
				else
				{
					int items = tableComponents.getSelectedRow();
					if (items >= 0)
					{
						i = i - 1;
						total = total - Integer.parseInt(serverPrice.get(i).toString());
						index = tableComponents.getSelectedRow();
						removeRow();
						serverType.remove(index);
						serverLocation.remove(index);
						serverSpec.remove(index);
						serverPrice.remove(index);
						setTabel();
						text_ShowItems.setText(String.valueOf(i + "x Items"));
					}
				}
				
			}
		});
		btnRemoveSelected.setBounds(272, 232, 120, 23);
		contentPane.add(btnRemoveSelected);
		
		text_Coupon = new JTextField();
		text_Coupon.setColumns(10);
		text_Coupon.setBounds(20, 386, 90, 20);
		contentPane.add(text_Coupon);
		
		JLabel text_CouponApplied = new JLabel("25% Discount Applied");
		text_CouponApplied.setVisible(false);
		text_CouponApplied.setBounds(20, 410, 121, 14);
		contentPane.add(text_CouponApplied);
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setBounds(250, 375, 46, 14);
		contentPane.add(lblTotal);
		
		text_showTotal = new JTextField();
		text_showTotal.setText("0");
		text_showTotal.setEditable(false);
		text_showTotal.setColumns(10);
		text_showTotal.setBounds(291, 373, 89, 20);
		contentPane.add(text_showTotal);
		
		JLabel lblTax = new JLabel("Tax 8%");
		lblTax.setBounds(250, 401, 59, 14);
		contentPane.add(lblTax);
		
		text_showTax = new JTextField();
		text_showTax.setText("0");
		text_showTax.setEditable(false);
		text_showTax.setColumns(10);
		text_showTax.setBounds(291, 398, 89, 20);
		contentPane.add(text_showTax);
		
		JLabel lblFinalPrice = new JLabel("F i n a l  P r i c e  :");
		lblFinalPrice.setBounds(250, 425, 112, 14);
		contentPane.add(lblFinalPrice);
		
		text_showFinalPrice = new JTextField();
		text_showFinalPrice.setText("0");
		text_showFinalPrice.setEditable(false);
		text_showFinalPrice.setColumns(10);
		text_showFinalPrice.setBounds(289, 440, 89, 20);
		contentPane.add(text_showFinalPrice);
		
		JLabel text_Discount = new JLabel("Rp. 0");
		text_Discount.setVisible(false);
		text_Discount.setBounds(52, 427, 102, 14);
		contentPane.add(text_Discount);
		
		JButton button_Bayar = new JButton("B a y a r");
		button_Bayar.setEnabled(false);
		button_Bayar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				printTotal();
			}
		});
		button_Bayar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		button_Bayar.setBounds(158, 488, 89, 23);
		contentPane.add(button_Bayar);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setBounds(108, 464, 55, 14);
		contentPane.add(lblMethod);
		
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setEnabled(false);
		rdbtnPaypal.setSelected(true);
		rdbtnPaypal.setForeground(Color.GRAY);
		rdbtnPaypal.setBounds(157, 460, 109, 23);
		contentPane.add(rdbtnPaypal);
		
		button_VPS.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (button_VPS.isSelected())
				{
					System.out.println("VPS Selected");
					button_VPS.setSelected(true);
					button_Dedicated.setSelected(false);
					button_webHost.setSelected(false);
				}
			}
		});
		
		button_Dedicated.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (button_Dedicated.isSelected())
				{
					System.out.println("Dedicated Selected");
					button_VPS.setSelected(false);
					button_Dedicated.setSelected(true);
					button_webHost.setSelected(false);
				}
			}
		});
		
		button_webHost.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (button_webHost.isSelected())
				{
					System.out.println("WebHost Selected");
					button_VPS.setSelected(false);
					button_Dedicated.setSelected(false);
					button_webHost.setSelected(true);
				}
			}
		});
		button_Singapore.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (button_Singapore.isSelected())
				{
					System.out.println("Singapore Selected");
					button_Singapore.setSelected(true);
					button_Australia.setSelected(false);
					button_Germany.setSelected(false);
				}
			}
		});
		button_Australia.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (button_Australia.isSelected())
				{
					System.out.println("Australia Selected");
					button_Singapore.setSelected(false);
					button_Australia.setSelected(true);
					button_Germany.setSelected(false);
				}
			}
		});
		button_Germany.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (button_Germany.isSelected())
				{
					System.out.println("Germany Selected");
					button_Singapore.setSelected(false);
					button_Australia.setSelected(false);
					button_Germany.setSelected(true);
				}
			}
		});
		
		btnAddToCart.addActionListener(new ActionListener()
		{
			//				serverType.add();
			//				serverLocation.add();
			//				serverSpec.add();
			//				serverPrice.add();
			//				total = total + 450000;
			//				JOptionPane.showMessageDialog(this, "Data Tersimpan.");
			//		        setTabel();
			//		        lebarKolom();
			//		        clear();
			
			//			private void save()
			//			{
			//				
			//			}
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//lebarKolom();
				//clear();
				if (i == 4)
				{
					JOptionPane.showMessageDialog(frame, "Cart anda Penuh!");
				}
				else
				{
					if (i == 0)
					{
						button_Bayar.setEnabled(false);
					}
					if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4)
					{
						if (button_VPS.isSelected())
						{
							if (button_Singapore.isSelected())
							{
								//							usc.serverTypes.add("VPS");
								//							usc.serverLocations.add("Singapore");
								//							usc.serverSpecs.add("Reguler");
								//							usc.serverPrices.add("50000");
								//							System.out.println("Server Type  : " + usc.serverTypes + " Added!");
								//							System.out.println("Server Loc   : " + usc.serverLocations + " Added!");
								//							System.out.println("Server Spec  : " + usc.serverSpecs + " Added!");
								//							System.out.println("Server Price : " + usc.serverPrices + " Added!");
								serverType.add(space + "VPS");
								serverLocation.add("Singapore");
								serverSpec.add("Reguler");
								serverPrice.add("50000");
								total = total + 50000;
								i = i + 1;
								//usc.setTabels();
								setTabel();
								//controller.insertData("VPS", "Singapore", "Reguler", "50000");
								//usc.tampilData();
							}
							if (button_Australia.isSelected())
							{
								serverType.add(space + "VPS");
								serverLocation.add("Australia");
								serverSpec.add("Reguler");
								serverPrice.add("45000");
								total = total + 45000;
								i = i + 1;
								setTabel();
								//controller.insertData("VPS", "Australia", "Reguler", "45000");
								//usc.tampilData();
							}
							if (button_Germany.isSelected())
							{
								serverType.add(space + "VPS");
								serverLocation.add("Germany");
								serverSpec.add("Reguler");
								serverPrice.add("40000");
								total = total + 40000;
								i = i + 1;
								setTabel();
								//controller.insertData("VPS", "Germany", "Reguler", "40000");
								//usc.tampilData();
							}
						}
						else if (button_Dedicated.isSelected())
						{
							if (button_Singapore.isSelected())
							{
								serverType.add(space + "Dedicated");
								serverLocation.add("Singapore");
								serverSpec.add("Reguler");
								serverPrice.add("500000");
								total = total + 500000;
								i = i + 1;
								setTabel();
								
								//controller.insertData("Dedicated", "Singapore", "Reguler", "500000");
								//usc.tampilData();
							}
							if (button_Australia.isSelected())
							{
								serverType.add(space + "Dedicated");
								serverLocation.add("Australia");
								serverSpec.add("Reguler");
								serverPrice.add("450000");
								total = total + 450000;
								i = i + 1;
								setTabel();
								//controller.insertData("Dedicated", "Australia", "Reguler", "450000");
								//usc.tampilData();
							}
							if (button_Germany.isSelected())
							{
								serverType.add(space + "Dedicated");
								serverLocation.add("Germany");
								serverSpec.add("Reguler");
								serverPrice.add("350000");
								total = total + 350000;
								i = i + 1;
								setTabel();
								//controller.insertData("Dedicated", "Germany", "Reguler", "350000");
								//usc.tampilData();
							}
						}
						else if (button_webHost.isSelected())
						{
							if (button_Singapore.isSelected())
							{
								serverType.add(space + "Web Host");
								serverLocation.add("Singapore");
								serverSpec.add("Reguler");
								serverPrice.add("80000");
								total = total + 80000;
								i = i + 1;
								setTabel();
								
								//controller.insertData("Webhost", "Singapore", "Reguler", "80000");
								//usc.tampilData();
							}
							if (button_Australia.isSelected())
							{
								serverType.add(space + "Web Host");
								serverLocation.add("Australia");
								serverSpec.add("Reguler");
								serverPrice.add("65000");
								total = total + 65000;
								i = i + 1;
								setTabel();
								//controller.insertData("Webhost", "Australia", "Reguler", "65000");
								//usc.tampilData();
							}
							if (button_Germany.isSelected())
							{
								serverType.add(space + "Web Host");
								serverLocation.add("Germany");
								serverSpec.add("Reguler");
								serverPrice.add("65000");
								total = total + 65000;
								i = i + 1;
								setTabel();
								//controller.insertData("Webhost", "Germany", "Reguler", "50000");
								//usc.tampilData();
							}
						}
						//server.add(selection_selectServer.getSelectedItem().toString());
						//amount.add(selection_selectAmount.getSelectedItem().toString());
						//price.add(text_showTotal.getText());
						//setTable();
						//i = i + 1;
						text_ShowItems.setText(String.valueOf(i + "x Item"));
						if (i == 2)
						{
							button_Bayar.setEnabled(true);
							text_ShowItems.setText(String.valueOf(i + "x Items"));
						}
						if (i == 3)
						{
							button_Bayar.setEnabled(true);
							text_ShowItems.setText(String.valueOf(i + "x Items"));
						}
						if (i == 4)
						{
							button_Bayar.setEnabled(true);
							text_ShowItems.setText(String.valueOf(i + "x Items"));
						}
						button_Bayar.setEnabled(true);
					}
					setTotal();
					setTax();
					setFinalPrice();
				}
				//				if (i == 4)
				//				{
				//					//						server.add(selection_selectServer.getSelectedItem().toString());
				//					//						amount.add(selection_selectAmount.getSelectedItem().toString());
				//					//						price.add(text_showTotal.getText());
				//					//						setTable();
				//					text_ShowItems.setText(String.valueOf(i + "x Items"));
				//				}
				//				if (i == 4)
				//				{
				//					JOptionPane.showMessageDialog(frame, "Cart anda Penuh!");
				//				}
			}
		});
		button_Coupon.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (text_Coupon.getText().equals("Corona"))
				{
					if (couponUsed == 0)
					{
						text_CouponApplied.setVisible(true);
						int getFinalPrice;
						int discount = 0;
						getFinalPrice = Integer.parseInt(text_showFinalPrice.getText());
						discount = getFinalPrice * 25 / 100;
						int formula = getFinalPrice - discount;
						text_showFinalPrice.setText(String.valueOf(formula));
						couponUsed = couponUsed + 1;
						text_Discount.setText("Rp. " + String.valueOf(discount));
						text_Discount.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Anda menggunakan Kupon '" + text_Coupon.getText() + "'");
						button_Coupon.setEnabled(false);
						text_Coupon.setEnabled(false);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Anda telah menggunakan Kupon");
					}
				}
				else
				{
					//					int formula = 0;
					//					formula = formula + (total + tax);
					//					text_CouponApplied.setVisible(false);
					//					text_Discount.setText("Rp. 0");
					//					text_Discount.setVisible(false);
					//					text_showFinalPrice.setText(String.valueOf(formula));
					JOptionPane.showMessageDialog(frame, "Kode Kupon Tidak Ditemukan.");
				}
			}
		});
	}
}
