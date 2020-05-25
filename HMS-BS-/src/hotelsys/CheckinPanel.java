package hotelsys;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class CheckinPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblRoomType, lblRoomId, lblCustomerName, lblCustomerId;
	private JTextField txtCustomerName, txtCustomerId;
	private JComboBox<String> cbRoomType;
	private JButton btnConfirm;
	private String roomIdAlloc;
	private RoomManage roomManage;
	private CheckinRecordManage checkinRecordManage;

	public CheckinPanel() {
		roomManage = new RoomManage();
		checkinRecordManage = new CheckinRecordManage();
		try {
			roomManage.LoadRoom();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			checkinRecordManage.LoadRecords();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setLayout(new GridLayout(8, 1));
		JPanel panel1 = new JPanel();
		lblRoomType = new JLabel("请选择房间类型: ");
		cbRoomType = new JComboBox<String>();
		cbRoomType.addItem("请选择房间类型");
		cbRoomType.addItem("单人房");
		cbRoomType.addItem("双人房");
		cbRoomType.addItem("豪华大床房");
		cbRoomType.addActionListener(new ComboBoxActionListener());
		panel1.add(lblRoomType);
		panel1.add(cbRoomType);
		this.add(panel1);

		JPanel panel2 = new JPanel();
		lblCustomerName = new JLabel("请输入姓名: ");
		txtCustomerName = new JTextField(12);
		panel2.add(lblCustomerName);
		panel2.add(txtCustomerName);
		this.add(panel2);

		JPanel panel3 = new JPanel();
		lblCustomerId = new JLabel("请输入身份证号：");
		txtCustomerId = new JTextField(12);
		panel3.add(lblCustomerId);
		panel3.add(txtCustomerId);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		roomIdAlloc = "";
		lblRoomId = new JLabel("系统分配房号：" + roomIdAlloc);
		panel4.add(lblRoomId);
		this.add(panel4);

		btnConfirm = new JButton("确定");
		btnConfirm.addActionListener(new BtnActionListener());
		this.add(btnConfirm);
		this.add(Box.createRigidArea(new Dimension(400, 40)));
	}

	private class BtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 更新住房记录 和 房间信息
			String customerName = txtCustomerName.getText().trim();
			String customerId = txtCustomerId.getText().trim();
			checkinRecordManage.OpenRoom(customerName, customerId, roomIdAlloc);
			roomManage.DeactiveRoom(roomIdAlloc);
			JOptionPane.showMessageDialog(null, "开房成功，入住房号：" + roomIdAlloc);
		}
	}

	private class ComboBoxActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String selected = (String) cbRoomType.getSelectedItem();
			int roomType = -1;
			if (0 == selected.compareTo("单人房")) {
				roomType = 0;
			} else if (0 == selected.compareTo("双人房")) {
				roomType = 1;
			} else if (0 == selected.compareTo("豪华大床房")) {
				roomType = 2;
			}

			roomIdAlloc = roomManage.Allocate(roomType);
			lblRoomId.setText("系统分配房号：" + roomIdAlloc);
		}
	}

//	static public void main(String[] args) {
//		JFrame frame = new JFrame("阳光酒店管理系统");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		CheckinPanel panel = new CheckinPanel();
//		
//		frame.getContentPane().add(panel);
//		frame.pack();
//		frame.setVisible(true);
//	}

}
