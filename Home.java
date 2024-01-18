package HashCalculator;                                                                                // Vikas Shendge
                                                                                           
import hashing.HashingAlgorithms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Home extends JFrame implements ActionListener {
	static JFrame frame;
	static JTextArea textarea;
	static JSeparator sep, sep1;
	static StringBuilder fileData;
	static JFileChooser choosefile;
	static JTextField file_path_textField;
	static JComboBox dataformat_list, keyfomat_list;
	static JLabel textarea_label, dataformat_label, keyformat_label, key_label;
	static JButton file_open_button, calculate_button, close_button, clear_button;
	static JCheckBox md5_chechbox, sha1_chechbox, sha256_chechbox, sha512_chechbox, sha224_chechbox, md2_chechbox;
	static JTextField key_textfield, md5_textfiled, sha1_textfiled, sha256_textfiled, sha512_textfiled,
			sha224_textfiled, md2_textfiled;

	// empty constructor
	Home() {

	}

	public static void main(String[] args) {
		Home obj = new Home();
		HashingAlgorithms algorithm = new HashingAlgorithms();
		frame = new JFrame();
		frame.setTitle("HashCalc");

		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\logo1.jpg");
		frame.setIconImage(icon);

		dataformat_label = new JLabel();
		dataformat_label.setText("Data Format:");
		dataformat_label.setBounds(10, 10, 80, 40);
		dataformat_label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.add(dataformat_label);

		String dataformat_data[] = { "Text", "File" };
		dataformat_list = new JComboBox(dataformat_data);
		dataformat_list.setBounds(10, 40, 80, 20);
		dataformat_list.addActionListener(obj);
		frame.add(dataformat_list);

		file_path_textField = new JTextField("Please select a file");
		file_path_textField.setBounds(160, 40, 190, 23);
		file_path_textField.setVisible(false);
		frame.add(file_path_textField);

		file_open_button = new JButton("open");
		file_open_button.setBounds(370, 40, 80, 25);
		file_open_button.addActionListener(obj); // open button file open action listener
		file_open_button.setVisible(false);
		frame.add(file_open_button);

		textarea_label = new JLabel();
		textarea_label.setText("Enter Data:");
		textarea_label.setBounds(100, 10, 90, 40);
		textarea_label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.add(textarea_label);

		textarea = new JTextArea();
		textarea.setBounds(100, 40, 380, 70);
		textarea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(textarea);

		Border b = new LineBorder(Color.black, 1); // textarea border
		textarea.setBorder(b);

		sep = new JSeparator(); // horizontal line
		sep.setBounds(10, 125, 460, 5);
		frame.add(sep);

		keyformat_label = new JLabel();
		keyformat_label.setText("Key Format:");
		keyformat_label.setBounds(100, 140, 75, 30);
		keyformat_label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.add(keyformat_label);

		String keyformat_data[] = { "Text", "number" };
		keyfomat_list = new JComboBox(keyformat_data);
		keyfomat_list.setBounds(100, 170, 85, 20);
		frame.add(keyfomat_list);

		key_label = new JLabel();
		key_label.setText("Key:");
		key_label.setBounds(200, 140, 70, 30);
		key_label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.add(key_label);

		key_textfield = new JTextField();
		key_textfield.setBounds(200, 170, 200, 25);
		frame.add(key_textfield);

		sep = new JSeparator();
		sep.setBounds(10, 210, 460, 5);
		frame.add(sep);

		md5_chechbox = new JCheckBox("MD5");
		md5_chechbox.setBounds(5, 250, 70, 40);
		md5_chechbox.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		md5_textfiled = new JTextField();
		md5_textfiled.setBounds(100, 255, 300, 25);

		sha1_chechbox = new JCheckBox("SHA-1");
		sha1_chechbox.setBounds(5, 285, 90, 40);
		sha1_chechbox.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		sha1_textfiled = new JTextField();
		sha1_textfiled.setBounds(100, 290, 300, 25);

		sha256_chechbox = new JCheckBox("SHA-256");
		sha256_chechbox.setBounds(5, 315, 90, 40);
		sha256_chechbox.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		sha256_textfiled = new JTextField();
		sha256_textfiled.setBounds(100, 320, 300, 25);

		sha512_chechbox = new JCheckBox("SHA-512");
		sha512_chechbox.setBounds(5, 345, 90, 40);
		sha512_chechbox.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		sha512_textfiled = new JTextField();
		sha512_textfiled.setBounds(100, 350, 300, 25);

		sha224_chechbox = new JCheckBox("SHA-224");
		sha224_chechbox.setBounds(5, 375, 90, 40);
		sha224_chechbox.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		sha224_textfiled = new JTextField();
		sha224_textfiled.setBounds(100, 380, 300, 25);

		md2_chechbox = new JCheckBox("MD2");
		md2_chechbox.setBounds(5, 405, 70, 40);
		md2_chechbox.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		md2_textfiled = new JTextField();
		md2_textfiled.setBounds(100, 410, 300, 25);

		sep1 = new JSeparator();
		sep1.setBounds(10, 470, 460, 5);
		frame.add(sep1);

		calculate_button = new JButton("Calculate");
		calculate_button.setBounds(180, 500, 90, 25);
		calculate_button.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		clear_button = new JButton("Clear");
		clear_button.setBounds(280, 500, 80, 25);
		clear_button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		clear_button.addActionListener(obj); // clear action perform

		close_button = new JButton("Close");
		close_button.setBounds(380, 500, 80, 25);
		close_button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		close_button.addActionListener(obj); // close the application

		// getContentPane().setBackground(Color.blue); // change background color

		// add checkbox
		frame.add(md5_chechbox);
		frame.add(sha1_chechbox);
		frame.add(sha256_chechbox);
		frame.add(sha512_chechbox);
		frame.add(sha224_chechbox);
		frame.add(md2_chechbox);

		// add textfield
		frame.add(md5_textfiled);
		frame.add(sha1_textfiled);
		frame.add(sha256_textfiled);
		frame.add(sha512_textfiled);
		frame.add(sha224_textfiled);
		frame.add(md2_textfiled);

		// add button
		frame.add(calculate_button);
		frame.add(close_button);
		frame.add(clear_button);

		frame.setLayout(null);
		frame.setSize(500, 600);
		frame.show();
		frame.setVisible(true);

		// perform action on calculate button
		calculate_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (md5_chechbox.isSelected()) {
						if (textarea.isVisible()) {
							StringBuilder s = new StringBuilder();
							s.append(textarea.getText());
							String algo = algorithm.md5(s);
							md5_textfiled.setText(algo);
						} else if (file_path_textField.isVisible()) {
							String algo = algorithm.md5(fileData); // getting file data using Stringbuilder data
							md5_textfiled.setText(algo);
						}
					} else {
						md5_textfiled.setText("");
					}

					if (sha1_chechbox.isSelected()) {

						if (textarea.isVisible()) {
							StringBuilder s1 = new StringBuilder();
							s1.append(textarea.getText());
							String algo = algorithm.sha1(s1);
							sha1_textfiled.setText(algo);
						} else if (file_path_textField.isVisible()) {
							String algo = algorithm.sha1(fileData);
							sha1_textfiled.setText(algo);
						}
					} else {
						sha1_textfiled.setText("");
					}

					if (sha256_chechbox.isSelected()) {

						if (textarea.isVisible()) {
							StringBuilder s1 = new StringBuilder();
							s1.append(textarea.getText());
							String algo = algorithm.sha256(s1);
							sha256_textfiled.setText(algo);
						} else if (file_path_textField.isVisible()) {
							String algo = algorithm.sha256(fileData);
							sha256_textfiled.setText(algo);
						}
					} else {
						sha256_textfiled.setText("");
					}

					if (sha512_chechbox.isSelected()) {

						if (textarea.isVisible()) {
							StringBuilder s1 = new StringBuilder();
							s1.append(textarea.getText());
							String algo = algorithm.sha512(s1);
							sha512_textfiled.setText(algo);
						} else if (file_path_textField.isVisible()) {
							String algo = algorithm.sha512(fileData);
							sha512_textfiled.setText(algo);
						}
					} else {
						sha512_textfiled.setText("");
					}

					if (sha224_chechbox.isSelected()) {

						if (textarea.isVisible()) {
							StringBuilder s1 = new StringBuilder();
							s1.append(textarea.getText());
							String algo = algorithm.sha224(s1);
							sha224_textfiled.setText(algo);
						} else if (file_path_textField.isVisible()) {
							String algo = algorithm.sha224(fileData);
							sha224_textfiled.setText(algo);
						}
					} else {
						sha224_textfiled.setText("");
					}

					if (md2_chechbox.isSelected()) {

						if (textarea.isVisible()) {
							StringBuilder s1 = new StringBuilder();
							s1.append(textarea.getText());
							String algo = algorithm.md2(s1);
							md2_textfiled.setText(algo);
						} else if (file_path_textField.isVisible()) {
							String algo = algorithm.md2(fileData);
							md2_textfiled.setText(algo);
						}
					} else {
						md2_textfiled.setText("");
					}
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
	}

	// perfrom action on open_button,
	public void actionPerformed(ActionEvent e) {
		// open file button action
		String btn = e.getActionCommand();
		if (btn.equals("open")) {
			choosefile = new JFileChooser();
			choosefile.showSaveDialog(null);
			// set the file path in file textfield
			file_path_textField.setText(choosefile.getSelectedFile().getAbsolutePath());
			String path = file_path_textField.getText(); // get file path

			try {
				file_algorithm filealgorithm_obj = new file_algorithm();
				// put file path and getting the file data using stringbuilder
				fileData = filealgorithm_obj.getfile_algorithm(path);
			} catch (NoSuchAlgorithmException | IOException e1) {
				e1.printStackTrace();
			}

		}

		// data formate action for jcombobox select the file or text
		String format = (String) dataformat_list.getItemAt(dataformat_list.getSelectedIndex()); // select the data type
																								// file or text
		if (format.equals("Text")) {
			textarea.setVisible(true);
			textarea_label.setVisible(true);
			file_open_button.setVisible(false); // file_open_button file textfield hide
			file_path_textField.setVisible(false); // open button hide
		} else if (format.equals("File")) {
			file_path_textField.setVisible(true);
			file_open_button.setVisible(true);
			textarea.setVisible(false); // textarea hide
			textarea_label.setVisible(false); // label also hide
		}

		// clear all field
		if (e.getSource() == clear_button) {
			file_path_textField.setText("");
			textarea.setText("");

			md5_chechbox.setSelected(false);
			sha1_chechbox.setSelected(false);
			sha256_chechbox.setSelected(false);
			sha512_chechbox.setSelected(false);
			sha224_chechbox.setSelected(false);
			md2_chechbox.setSelected(false);

			md5_textfiled.setText("");
			sha1_textfiled.setText("");
			sha256_textfiled.setText("");
			sha512_textfiled.setText("");
			sha224_textfiled.setText("");
			md2_textfiled.setText("");
		}

		// close button action
		if (e.getSource() == close_button) // object event intially occure
		{
			String close = e.getActionCommand(); // get command associated with action
			if (close.equals("Close")) {
				System.exit(ABORT);
			}
		}
	}
}
