import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class Main {
	/**
	 *Creates a JFrame and adds the Flag panel to the JFrame. Also contains a component listener for when the Panel is resized.
	 *If the component is resized then it redraws the flag.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flag");
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1900, 1030);

		Flag flag = new Flag(new Dimension(1900, 1000));

		frame.add(flag);
		frame.setVisible(true);
		frame.addComponentListener(new ComponentAdapter() {  
			public void componentResized(ComponentEvent evt) {
				frame.getContentPane().removeAll();
				Flag f = new Flag(frame.getContentPane().getSize());
				frame.getContentPane().add(f);
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
			}
		});
	}

}