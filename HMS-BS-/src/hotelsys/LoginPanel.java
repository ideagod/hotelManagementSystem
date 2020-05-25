package hotelsys;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 400;
	JLabel welcomeTips, userTips, paswdTips;
	JPanel panel1, panel2, panel3, panel4;
	JTextField username, passwd;
	JButton loginBtn;
	JFrame frameHosted;

	LoginPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();

		welcomeTips = new JLabel("欢迎使用阳光酒店管理系统");

		panel1.setPreferredSize(new Dimension(WIDTH, 100));
		welcomeTips.setFont(new Font("", Font.BOLD, 24));
		welcomeTips.setVerticalTextPosition(SwingConstants.CENTER);
		panel1.add(Box.createRigidArea(new Dimension(400, 30)));
		panel1.add(welcomeTips);

		userTips = new JLabel("用户：");
		username = new JTextField(6);
		panel2.add(userTips);
		panel2.add(username);

		paswdTips = new JLabel("密 码：");
		passwd = new JTextField(6);
		panel3.add(paswdTips);
		panel3.add(passwd);

		loginBtn = new JButton("          登   录           ");
		loginBtn.addActionListener(new ButtonListener());
		panel4.add(loginBtn);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
	}

	private void Hidden() {
		frameHosted.setVisible(false);
	}

	void setFrame(JFrame frame) {
		frameHosted = frame;
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AccountManage accountMan = new AccountManage();
			try {
				accountMan.LoadUser();
				boolean bPassed = accountMan.Check(username.getText(), passwd.getText());
				System.out.println(bPassed ? "Passed" : "Failed");
				if (bPassed) {
					Hidden();
					JFrame frame = new JFrame("阳光酒店管理系统");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					JTabbedPane tp = new JTabbedPane();
					tp.setPreferredSize(new Dimension(800, 500));
					tp.addTab("查询房间信息", new QueryPanel());
					tp.addTab("入住登记", new CheckinPanel());
					tp.addTab("退房", new CheckoutPanel());
					
					frame.getContentPane().add(tp);
					frame.pack();
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码不正确");
				}
				
				
					
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("阳光酒店管理系统");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LoginPanel panel = new LoginPanel();
		panel.setPreferredSize(new Dimension(WIDTH, 250));
		panel.setFrame(frame);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		//屏幕居中处理
		frame.setLocation((width-400)/2, (height-250)/2);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
