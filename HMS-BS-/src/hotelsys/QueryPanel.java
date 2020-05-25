package hotelsys;

import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.event.*;

public class QueryPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblRoomId, lbsSize, lblPrice, lblCheckin, lblRoomType;
	private JTextField txtRoomId;
	private RoomManage roomManage;

	public QueryPanel() {
		roomManage = new RoomManage();
		try {
			roomManage.LoadRoom();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setLayout(new GridLayout(8, 1));
		JPanel panel = new JPanel();
		lblRoomId = new JLabel("房间编号：");
		txtRoomId = new JTextField(6);
		panel.add(lblRoomId);
		panel.add(txtRoomId);

		lbsSize = new JLabel("房间大小：");
		lblPrice = new JLabel("房间价格：");
		lblCheckin = new JLabel("入住情况：");
		lblRoomType = new JLabel("房间类型：");
		lbsSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckin.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomType.setHorizontalAlignment(SwingConstants.CENTER);

		txtRoomId.getDocument().addDocumentListener(new TextFieldListener());
		this.add(panel);
		this.add(lbsSize);
		this.add(lblPrice);
		this.add(lblCheckin);
		this.add(lblRoomType);
	}

	private class TextFieldListener implements DocumentListener {
		@Override
		public void insertUpdate(DocumentEvent e) {
			String roomId = txtRoomId.getText().trim();
			Room room = roomManage.QueryInfo(roomId);
			if (null == room) {
				// 房间编号不存在, 查询不到对应的信息, 更新界面信息为空
				lbsSize.setText("房间大小：");
				lblPrice.setText("房间价格：");
				lblCheckin.setText("入住情况：");
				lblRoomType.setText("房间类型：");
			} else {
				// 更新界面信息
				lbsSize.setText("房间大小：" + room.getSize());
				lblPrice.setText("房间价格：" + room.getPrice());
				lblCheckin.setText("入住情况：" + (0 == room.getCheckIn() ? "空闲" : "已入住"));
				lblRoomType.setText("房间类型：" + (0 == room.getRoomType() ? "单人房" : (1 == room.getRoomType() ? "双人房" : "豪华大床房")));
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// nothing to do
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// nothing to do
		}
	}
}
