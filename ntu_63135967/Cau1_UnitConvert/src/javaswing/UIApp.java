package javaswing;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UIApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtChuynT;
	private JTextField txtNhpSCn;
	private JTextField txtChnnV;
	private JTextField txtKtQua;
	private JTextField txtNhap;
	private JTextField txtKQ;
	private JComboBox<String> comboNhap;
    private JComboBox<String> comboXuat;

	public UIApp() {
		setTitle("Chuyển đổi đơn vị đo\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtChuynT = new JTextField();
		txtChuynT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtChuynT.setText("Chọn đơn vị nhập:");
		txtChuynT.setBounds(47, 50, 137, 33);
		contentPane.add(txtChuynT);
		txtChuynT.setColumns(10);
		
		txtNhpSCn = new JTextField();
		txtNhpSCn.setText("Nhập sô cần đổi:");
		txtNhpSCn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNhpSCn.setColumns(10);
		txtNhpSCn.setBounds(47, 109, 137, 33);
		contentPane.add(txtNhpSCn);
		
		txtChnnV = new JTextField();
		txtChnnV.setText("Chọn đơn vị xuất:");
		txtChnnV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtChnnV.setColumns(10);
		txtChnnV.setBounds(47, 168, 137, 33);
		contentPane.add(txtChnnV);
		
		JButton bntDOI = new JButton("ĐỔI");
		bntDOI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gọi hàm xử lý ĐỔI
				HamXuLyDoi();
			}
		});
		bntDOI.setBackground(new Color(255, 0, 0));
		bntDOI.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bntDOI.setBounds(233, 237, 121, 59);
		contentPane.add(bntDOI);
		
		txtKtQua = new JTextField();
		txtKtQua.setText("Kết quả:");
		txtKtQua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtKtQua.setColumns(10);
		txtKtQua.setBounds(47, 365, 137, 33);
		contentPane.add(txtKtQua);
		
		txtNhap = new JTextField();
		txtNhap.setBounds(246, 109, 251, 33);
		contentPane.add(txtNhap);
		txtNhap.setColumns(10);
		
		txtKQ = new JTextField();
		txtKQ.setEditable(false);
		txtKQ.setColumns(10);
		txtKQ.setBounds(246, 365, 251, 33);
		contentPane.add(txtKQ);
		
		comboNhap = new JComboBox<>();
        comboNhap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        comboNhap.setModel(new DefaultComboBoxModel<>(new String[] { "Kilometer", "Meter", "Centimeter", "Milimeter" }));
        comboNhap.setBounds(246, 51, 251, 33);
        contentPane.add(comboNhap);

        comboXuat = new JComboBox<>();
        comboXuat.setModel(new DefaultComboBoxModel<>(new String[] { "Kilometer", "Meter", "Centimeter", "Milimeter" }));
        comboXuat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        comboXuat.setBounds(246, 169, 251, 33);
        contentPane.add(comboXuat);
	}
	
	void HamXuLyDoi()
	{	
		//Lấy dữ liệu
	    String donViNhap = (String) comboNhap.getSelectedItem();
	    String donViXuat = (String) comboXuat.getSelectedItem();
	    double giaTriNhap = Double.parseDouble(txtNhap.getText());

	    double ketQua= 0;
	    //Chuyển dổi
	   
	    switch (donViNhap) {
        case "Kilometer":
            if (donViXuat.equals("Meter"))
                ketQua = giaTriNhap * 1000;
            else if (donViXuat.equals("Centimeter"))
                ketQua = giaTriNhap * 100000;
            else if (donViXuat.equals("Milimeter"))
                ketQua = giaTriNhap * 1000000;
            else
                ketQua = giaTriNhap;
            break;
        case "Meter":
            if (donViXuat.equals("Kilometer"))
                ketQua = giaTriNhap / 1000;
            else if (donViXuat.equals("Centimeter"))
                ketQua = giaTriNhap * 100;
            else if (donViXuat.equals("Milimeter"))
                ketQua = giaTriNhap * 1000;
            else
                ketQua = giaTriNhap;
            break;
        case "Centimeter":
            if (donViXuat.equals("Kilometer"))
                ketQua = giaTriNhap / 100000;
            else if (donViXuat.equals("Meter"))
                ketQua = giaTriNhap / 100;
            else if (donViXuat.equals("Milimeter"))
                ketQua = giaTriNhap * 10;
            else
                ketQua = giaTriNhap;
            break;
        case "Milimeter":
            if (donViXuat.equals("Kilometer"))
                ketQua = giaTriNhap / 1000000;
            else if (donViXuat.equals("Meter"))
                ketQua = giaTriNhap / 1000;
            else if (donViXuat.equals("Centimeter"))
                ketQua = giaTriNhap / 10;
            else
                ketQua = giaTriNhap;
            break;
    }
	    txtKQ.setText(Double.toString(ketQua));
	}
}
