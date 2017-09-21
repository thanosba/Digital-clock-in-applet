
package myclock;
import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
public class MyClock extends JApplet implements Runnable
{	private Thread myThread; 
	private JLabel clock; 
	private final int interval = 1000; 
// milliseconds
	public void init()
	{	clock = new JLabel("", SwingConstants.CENTER);
		clock.setFont (new Font ("Comic Sans MS", Font.BOLD,
28));
		clock.setBackground(Color.GREEN.darker());
		clock.setForeground(Color.WHITE);
		clock.setOpaque(true);
		getContentPane().add(clock);
		setSize(250, 100);
	} 
	
	public void start()
	{	if (myThread == null)
		{	myThread = new Thread(this, "clock");
			myThread.start();
		}
	} 
	public void run()
	{	
		while (myThread == Thread.currentThread())
		{	
			Date time = new Date();
			clock.setText(DateFormat.getTimeInstance
(DateFormat.MEDIUM).format(time));
			try
			{	
				myThread.sleep(interval);
			}
			catch (InterruptedException e) {}
		}
	} 
	public void stop()
	{ myThread = null; }
} 

