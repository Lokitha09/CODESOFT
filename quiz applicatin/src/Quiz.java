import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
    String questions[]={" Which of the following is the correct way to declare a variable in Java?" ,
                        " Which data type is used to store a single character?",
                       "Which company created Java?",
                        "Which of the following can be used as a loop in Java?",
                        "Which keyword is used to define a method in Java?",
                        };
    String options[][]={
                            {"int num = 10;","num int = 10;","int = 10 num;","10 = int num;"},
                            {"String","int","char","float"},
                            {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
                            {"for" ,"while","do-while","All of the above" },
                            {"function", "def", "method", "None of the above"}
                            //none of the above for last question because (Methods in Java are defined using a return type, e.g., void, not with a specific keyword like method)
                        };
    char ans[]={
                'A',
                'C',
                'A',
                'D',
                'D'
                };
    char guess;
    char answer;
    int idx;
    int correct_guess=0;
    int total_questions=questions.length;
    int result;
    int sec=10;
    JFrame frame=new JFrame();
    JTextField textfield=new JTextField();
    JTextArea textarea=new JTextArea();
    JButton buttonA=new JButton();
    JButton buttonB=new JButton();
    JButton buttonC=new JButton();
    JButton buttonD=new JButton();
    JLabel anslabelA=new JLabel();
    JLabel anslabelB=new JLabel();
    JLabel anslabelC=new JLabel();
    JLabel anslabelD=new JLabel();
    JLabel timelabel=new JLabel();
    JLabel sec_left=new JLabel();
    JTextField num_right=new JTextField();
    JTextField percentage=new JTextField();
    Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			sec--;
			sec_left.setText(String.valueOf(sec));
			if(sec<=0) {
				displayans();
			}
			}
		});

    public Quiz(){
        frame.setTitle("QUIZ : FUNDAMENTALS OF JAVA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,25,25));
        textfield.setFont(new Font("Ink Free",Font.BOLD,25));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);

        textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		anslabelA.setBounds(125,100,500,100);
		anslabelA.setBackground(new Color(50,50,50));
		anslabelA.setForeground(new Color(25,255,0));
		anslabelA.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		anslabelB.setBounds(125,200,500,100);
		anslabelB.setBackground(new Color(50,50,50));
		anslabelB.setForeground(new Color(25,255,0));
		anslabelB.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		anslabelC.setBounds(125,300,500,100);
		anslabelC.setBackground(new Color(50,50,50));
		anslabelC.setForeground(new Color(25,255,0));
		anslabelC.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		anslabelD.setBounds(125,400,500,100);
		anslabelD.setBackground(new Color(50,50,50));
		anslabelD.setForeground(new Color(25,255,0));
		anslabelD.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		sec_left.setBounds(535,510,100,100);
		sec_left.setBackground(new Color(25,25,25));
		sec_left.setForeground(new Color(255,0,0));
		sec_left.setFont(new Font("Ink Free",Font.BOLD,60));
		sec_left.setBorder(BorderFactory.createBevelBorder(1));
		sec_left.setOpaque(true);
		sec_left.setHorizontalAlignment(JTextField.CENTER);
		sec_left.setText(String.valueOf(sec));
		
		timelabel.setBounds(535,475,100,25);
		timelabel.setBackground(new Color(50,50,50));
		timelabel.setForeground(new Color(255,0,0));
		timelabel.setFont(new Font("MV Boli",Font.PLAIN,16));
		timelabel.setHorizontalAlignment(JTextField.CENTER);
		timelabel.setText("timer >:D");
		
		num_right.setBounds(225,225,200,100);
		num_right.setBackground(new Color(25,25,25));
		num_right.setForeground(new Color(25,255,0));
		num_right.setFont(new Font("Ink Free",Font.BOLD,50));
		num_right.setBorder(BorderFactory.createBevelBorder(1));
		num_right.setHorizontalAlignment(JTextField.CENTER);
		num_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(timelabel);
		frame.add(sec_left);
		frame.add(anslabelA);
		frame.add(anslabelB);
		frame.add(anslabelC);
		frame.add(anslabelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();


    }
    public void nextQuestion(){

        if(idx>=total_questions) {
			result();
		}
		else {
			textfield.setText("Question "+(idx+1));
			textarea.setText(questions[idx]);
			anslabelA.setText(options[idx][0]);
			anslabelB.setText(options[idx][1]);
			anslabelC.setText(options[idx][2]);
			anslabelD.setText(options[idx][3]);
			timer.start();
		}
    }
    public void actionPerformed(ActionEvent e){

        buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == ans[idx]) {
					correct_guess++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == ans[idx]) {
					correct_guess++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == ans[idx]) {
					correct_guess++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == ans[idx]) {
					correct_guess++;
				}
			}
			displayans();
    }
    public void displayans(){
        timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(ans[idx] != 'A')
			anslabelA.setForeground(new Color(255,0,0));
		if(ans[idx] != 'B')
			anslabelB.setForeground(new Color(255,0,0));
		if(ans[idx] != 'C')
			anslabelC.setForeground(new Color(255,0,0));
		if(ans[idx] != 'D')
			anslabelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				anslabelA.setForeground(new Color(25,255,0));
				anslabelB.setForeground(new Color(25,255,0));
				anslabelC.setForeground(new Color(25,255,0));
				anslabelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				sec=10;
				sec_left.setText(String.valueOf(sec));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				idx++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();

    }
    public void result(){
        buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guess/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		anslabelA.setText("");
		anslabelB.setText("");
		anslabelC.setText("");
		anslabelD.setText("");
		
		num_right.setText("("+correct_guess+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(num_right);
		frame.add(percentage);
    }
        
}