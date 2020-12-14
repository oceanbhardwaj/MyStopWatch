import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class StopWatch implements ActionListener{
	
	JFrame frame=new JFrame();
	JButton StartButton =new JButton("START");
	JButton ResetButton =new JButton("RESET");
	JButton StopButton =new JButton("STOP");
	JLabel timeLabel=new JLabel();
	
	
	int elapsedTime=0; //hold time in ms
	int seconds=0;
	int minutes=0;
	int hours=0;
	boolean started=false; //timer has started or not
	String sec_String=String.format("%02d",seconds);
	String min_String=String.format("%02d",minutes);
	String hour_String=String.format("%02d",hours);
	
	
	Timer timer=new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			elapsedTime=elapsedTime+1000;
			hours=elapsedTime/3600000;
			minutes=(elapsedTime/60000)%60;
			seconds=(elapsedTime/1000)%60;
			 sec_String=String.format("%02d",seconds);
			 min_String=String.format("%02d",minutes);
			 hour_String=String.format("%02d",hours);
			 
			 timeLabel.setText(hour_String+":"+min_String+":"+sec_String);
			
		}
	});
	
	
	
	
	
	
	
	
	
	
	
   StopWatch()
   {
	   timeLabel.setText(hour_String+":"+min_String+":"+sec_String);
	   timeLabel.setBounds(100,100,200,100);
	   timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
	   timeLabel.setBorder(BorderFactory.createBevelBorder(1));
	   timeLabel.setOpaque(true);
	   timeLabel.setHorizontalAlignment(JTextField.CENTER);
	   timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.BLACK);
		timeLabel.setOpaque(true);
	
	   
	   
	   StartButton.setBounds(100,200,100,50);
	   StartButton.setFont(new Font("Ink Free",Font.PLAIN,20));
	   StartButton.setFocusable(false);
	   StartButton.addActionListener(this);
	   StartButton.setBackground(Color.CYAN);
	   ResetButton.setBackground(Color.CYAN);
	   StopButton.setBackground(Color.CYAN);
	   
	   
	   ResetButton.setBounds(200,200,100,50);
	   ResetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
	   ResetButton.setFocusable(false);
	   ResetButton.addActionListener(this);
	   
	   frame.add(StartButton);
	   frame.add(ResetButton);
	   frame.add(timeLabel);
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setTitle("MY STOPWATCH");
		frame.setLayout(null);
		frame.setSize(420,420);
		frame.setResizable(false);
		
		frame.setVisible(true);//make sure this line should b at end
	   
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==StartButton)
			{ if(started==false)
			{
				started=true;
				StartButton.setText("STOP");
				start();
			}
			
			else
			{
				started=false;
				StartButton.setText("START");
				stop();
				
			}
			
			
			
			}
		if(e.getSource()==ResetButton)
		{
			started=false;
			StartButton.setText("START");
			reset();
		}
		
		
		
		
			}
		
	
	
	public void start()
	{ timer.start();
		
	}
	public void stop()
	{
		timer.stop();
	}
	
	public void reset()
	{
		timer.stop();
		elapsedTime=0;
		seconds=0;
		minutes=0;
		hours=0;
		
		sec_String=String.format("%02d",seconds);
		 min_String=String.format("%02d",minutes);
		 hour_String=String.format("%02d",hours);
		 
		 timeLabel.setText(hour_String+":"+min_String+":"+sec_String);
		
		
		
		
	}

}
