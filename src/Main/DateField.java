package Main;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateField extends JFrame
{
	public DateField()
	{
		final SpinnerDateModel sdm = new SpinnerDateModel();
		final JSpinner spinner = new JSpinner(sdm);
		spinner.setEditor(new DateEditor(spinner,"dd.MM.yyyy"));
		
		spinner.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent arg0)
			{
				Date fromSpinner = (Date) spinner.getValue();
				Date fromModel = sdm.getDate();
				System.out.println(fromSpinner + " or " + fromModel);
			}
			
		});
		
		setPreferredSize(new Dimension(100,100));
		add(spinner);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}