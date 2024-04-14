import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JCheckBox boldJCheckBox;
	private JCheckBox italicJCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxFrame frame = new CheckBoxFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckBoxFrame() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		textField = new JTextField("Veja a fonte mudar");
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField);
		
		boldJCheckBox = new JCheckBox("Negrito");
		italicJCheckBox = new JCheckBox("Italico");
		add(boldJCheckBox);
		add(italicJCheckBox);
		
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);
		
	}
	
	private class CheckBoxHandler implements ItemListener{
		private int valBold = Font.PLAIN;
		private int valItalic = Font.ITALIC;
	
		@Override
		public void itemStateChanged(ItemEvent event) {
			if(event.getSource()== boldJCheckBox)
				valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
		
			if(event.getSource() == italicJCheckBox)
				valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
			
			textField.setFont(new Font("Serif", valBold + valItalic,14));
				}
		
	}
	
	

}
