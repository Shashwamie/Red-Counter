package counter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * Class counter extends Jframe createting the window
 * adds a counter that counts everytime red shows up on the button
 * uses random colors
 * 
 * @author Bryce Barbee
 *
 */
public class Counter extends JFrame {

	private JPanel contentPane;
	private Random rand = new Random();
	private int redCounter = 0;
	private int previouseNum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initializes the counstructor to create the frame
	 * adds the main panel
	 * adds the name label
	 */
	public Counter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainPanel = createMainPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		JLabel lblName = createLblName();
		contentPane.add(lblName, BorderLayout.SOUTH);
	}

	/**
	 * Creates the name label and adds it to the 
	 * south of the jframe
	 * 
	 * @return the label
	 */
	private JLabel createLblName() {
		JLabel lblName = new JLabel("Bryce's GUI");
		lblName.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblName.setOpaque(true);
		lblName.setFont(new Font("Noteworthy", Font.PLAIN, 16));
		lblName.setBackground(new Color(245, 245, 245));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		return lblName;
	}

	/**
	 * creates the main panel and adds it to the center of the frame
	 * creates the red counter label
	 * creates the button that changes the color
	 * button changes the color randomly
	 * 
	 * @return the panel 
	 */
	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblRedCounter = new JLabel(updateCounter());
		lblRedCounter.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblRedCounter.setOpaque(true);
		lblRedCounter.setBackground(new Color(220, 220, 220));
		lblRedCounter.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(lblRedCounter);
		
		JButton btnClickMe = new JButton("Click Me");
		btnClickMe.setFocusable(false);
		btnClickMe.setOpaque(true);
		btnClickMe.setBorderPainted(false);
		btnClickMe.setBackground(Color.BLUE);
		btnClickMe.setForeground(new Color(255, 255, 255));
		btnClickMe.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int randNum = rand.nextInt(0,5);
				while(randNum == previouseNum) {
					randNum = rand.nextInt(0,5);
				}
				switch(randNum) {
				case 0:
					btnClickMe.setBackground(Color.BLUE);
					break;
				case 1:
					btnClickMe.setBackground(Color.GREEN);
					break;
				case 2:
					btnClickMe.setBackground(Color.RED);
					++redCounter;
					lblRedCounter.setText(updateCounter());
					break;
				case 3:
					btnClickMe.setBackground(Color.ORANGE);
					break;
				case 4:
					btnClickMe.setBackground(Color.MAGENTA);
					break;
				}
				previouseNum = randNum;
			}
		});
		mainPanel.add(btnClickMe);
		return mainPanel;
	}
	
	/**
	 * updates the string for the counter label
	 * displays the number with two digits
	 * 
	 * @return the string to be displayed
	 */
	private String updateCounter() {
		String counterString = "Red Counter: 00";
		
		if(redCounter > 9)
			counterString = "Red Counter: " + redCounter;
		if(redCounter < 10)
			counterString = "Red Counter: 0" + redCounter;
		return counterString;
	}

}
