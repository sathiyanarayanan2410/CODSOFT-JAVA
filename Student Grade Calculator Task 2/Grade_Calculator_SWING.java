import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grade_Calculator_SWING {
    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Grade Calculator");
        JLabel label = new JLabel("Enter Number of Subjects");
        label.setBounds(120,130,400,60);
        label.setFont(new Font("MV boli",Font.ROMAN_BASELINE,20));

        JTextField noofsubs = new JTextField();
        noofsubs.setBounds(120,190,250,50);
        noofsubs.setFont(noofsubs.getFont().deriveFont(25.0f));
        noofsubs.setBorder(BorderFactory.createLineBorder(Color.red, 5,true));
        noofsubs.setHorizontalAlignment(JTextField.CENTER);
        noofsubs.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent m)
            {
                noofsubs.setText("");
            }
        });

        JButton button = new JButton("Enter Marks");
        button.setBounds(150, 280, 200, 40);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        button.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame Marks  = new JFrame("Grade Calculator");

                int noofields = Integer.parseInt(noofsubs.getText());
                JTextField fields[] = new JTextField[noofields];
                JLabel labels[] = new JLabel[noofields];

                int x = 90;
                int y = 60;

                for(int i=0;i<noofields;i++)
                {
                    labels[i] = new JLabel("Enter Subject "+(i+1)+" Mark");
                    labels[i].setBounds(x, y, 200, 30);
                    labels[i].setFont(new Font("MV boli",Font.ROMAN_BASELINE,16));
                    Marks.add(labels[i]);
                    y+=50;
                }
                
                y=60;
                x+=210;
                
                for(int i=0;i<noofields;i++)
                {
                    fields[i] = new JTextField();
                    fields[i].setBounds(x, y, 60, 30);
                    fields[i].setFont(fields[i].getFont().deriveFont(15.0f));
                    fields[i].setHorizontalAlignment(JTextField.CENTER);
                    fields[i].setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
                    Marks.add(fields[i]);
                    y+=50;
                }
                int yc = (noofields>=7)?((noofields>=9)?540:480):360;

                JButton button = new JButton("Back");
                button.setBounds(160, yc+50, 120, 30);
                button.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
                button.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));

                JButton calc = new JButton("Calculate");
                calc.setBounds(160, yc, 120, 30);
                calc.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
                calc.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));

                calc.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int sum = 0;
                        for(int i=0;i<noofields;i++)
                        {
                            sum+=Integer.parseInt(fields[i].getText());
                        }
                        double avg = sum/noofields;
                        String grade;
                        if(avg>=95) grade = "O";
                        else if(avg>=90 && avg<95) grade = "A+";
                        else if(avg>=80 && avg<90) grade = "A";
                        else if(avg>=70 && avg<80) grade = "B+";
                        else if(avg>=60 && avg<70) grade = "B";
                        else if(avg>=50 && avg<60) grade = "C";
                        else grade="F";

                        JOptionPane.showMessageDialog(Marks,"Student Grade Report\n\n"+"Total Marks: "+sum+"\nAverage Mark: "+avg+"\nGrade: \""+grade+"\""+((grade!="F")?"\nCongratulations!!!\n":"\nBetter Luck Next Time!\n"));
                    }
                });
                

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Marks.dispose();
                    }
                });
                int height = (noofields>=7)?((noofields>=9)?690:630):500;

                Marks.add(calc);
                Marks.add(button);
                Marks.setSize(500,height);
                Marks.setLayout(null);
                Marks.setLocationRelativeTo(null);
                Marks.setVisible(true);
            }
        };

        button.addActionListener(listener);

        frame.add(label);
        frame.add(noofsubs);
        frame.add(button);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    
}
