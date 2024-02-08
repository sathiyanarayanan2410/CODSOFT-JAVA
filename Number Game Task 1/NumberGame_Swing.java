import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class NumberGame{
    private static int attempt = 0;
    private static Random rand = new Random();
    private static int targetnumber = rand.nextInt(1,101);
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Number Game");
        JLabel label = new JLabel("Enter Your Guess between 1 and 100");
        label.setBounds(60,130,400,60);
        label.setFont(new Font("MV boli",Font.ROMAN_BASELINE,20));
        
        JTextField guess = new JTextField();
        guess.setBounds(65,200,350,50);
        guess.setFont(guess.getFont().deriveFont(25.0f));
        guess.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5,true));
        guess.setHorizontalAlignment(JTextField.CENTER);
        guess.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent m)
            {
                guess.setText("");
            }
        });
        
        JButton button = new JButton("Check");
        button.setBounds(200, 280, 100, 40);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        button.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));
        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                attempt++;
                if(attempt<=12)
                {
                    int guessNumber= Integer.parseInt(guess.getText());
                    if(guessNumber>targetnumber)
                    JOptionPane.showMessageDialog(frame,"\nAttempts Remaining: "+(((12-attempt)==0)?"Final Attempt":(12-attempt) )+"\nEnter low Number");
                    else if(guessNumber<targetnumber)
                    JOptionPane.showMessageDialog(frame,"\nAttempts Remaining: "+(((12-attempt)==0)?"Final Attempt":(12-attempt)) +"\nEnter high Number");
                    else if(guessNumber==targetnumber)
                    {
                        int score = 0;
                        if(attempt==1) score=10;
                        else if(attempt<=3) score = 9;
                        else if(attempt<=4) score = 8;
                        else if(attempt<=5) score = 7;
                        else if(attempt<=7) score = 6;
                        else if(attempt<=8) score = 5;
                        else if(attempt<=9) score = 4;
                        else if(attempt<=10) score = 3;
                        else if(attempt<12) score = 2;
                        else if(attempt==12) score = 1;
                        JOptionPane.showMessageDialog(frame,"Correct guess!!\n"+"Attempts: "+attempt+"\nScore: "+score+"/10");
                        attempt = 0;
                        targetnumber = rand.nextInt(1,101);
                        guess.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Better Luck Next Time\n Attempts Over!!");
                    attempt = 0;
                    targetnumber = rand.nextInt(1,101);
                    guess.setText("");
                }
            }
        }; 
        
        button.addActionListener(listener);
        
        frame.add(label);
        frame.add(guess);
        frame.add(button);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}