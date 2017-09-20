/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;
import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
// �������� ��� �����
public class MyClock extends JApplet implements Runnable
{	private Thread myThread; // ��� ����
	private JLabel clock; // ��� �������
	private final int interval = 1000; // ��� �������� ��
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
	} // init
	// ������� ��� ������� start ��� ����� JApplet ��� ���
	// ��� ����� Thread
	public void start()
	{	if (myThread == null)
		{	myThread = new Thread(this, "clock");
			myThread.start();
		}
	} // start
	// ��������� ��� ������� run ��� �������� Runnable
	public void run()
	{	// ������� ������ ��� �� while, ��� ��� ��� ��
		// ������ run (����� �� ���� ��������)
		while (myThread == Thread.currentThread())
		{	// ������� ��� ���, �� ���������� ��� ���
			// ��������� ���� �������
			Date time = new Date();
			clock.setText(DateFormat.getTimeInstance
(DateFormat.MEDIUM).format(time));
			try
			{	// �� ���� ������������� ��� ��� ������������
				myThread.sleep(interval);
			}
			catch (InterruptedException e) {}
		}
	} // run
	public void stop()
	{ myThread = null; }
} // MyClock
