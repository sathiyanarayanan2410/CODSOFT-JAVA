import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class BankAccount {
    private String name;
    private long accountNumber;
    private double balance;
    private Random random = new Random();

    public BankAccount(double initialBalance,String name) {
        this.name = name;
        this.balance = initialBalance;
        this.accountNumber = Math.abs(random.nextLong())% 10000000000L;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public long getaccnum()
    {
        return accountNumber;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM{
    public static void main(String[] args) {
        
        ArrayList<BankAccount> Accounts = new ArrayList<>();
        
        JFrame frame = new JFrame("ATM Interface");

        JLabel label = new JLabel("ATM Interface");
        label.setBounds(160,30,200,50);
        label.setFont(new Font("MV boli",Font.ROMAN_BASELINE,28));

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Balance");
        JButton createAccountButton = new JButton("Create");
        
        createAccountButton.setBounds(150, 100, 180, 50);
        createAccountButton.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        createAccountButton.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));
        
        checkBalanceButton.setBounds(150, 180, 180, 50);
        checkBalanceButton.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        checkBalanceButton.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));
        
        depositButton.setBounds(150, 260, 180, 50);
        depositButton.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        depositButton.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));
        
        withdrawButton.setBounds(150, 340, 180, 50);
        withdrawButton.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        withdrawButton.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));

        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == createAccountButton)
                {
                    JFrame newuser = new JFrame("New Account");

                    JButton create = new JButton("Create");
                    
                    JLabel label = new JLabel("New Account");
                    label.setBounds(80,30,200,50);
                    label.setFont(new Font("MV boli",Font.ROMAN_BASELINE,28));
                    
                    JLabel label1 = new JLabel("Name");
                    label1.setBounds(50,90,200,50);
                    label1.setFont(new Font("MV boli",Font.ROMAN_BASELINE,20));
                    
                    JLabel label2 = new JLabel("Initial Deposit");
                    label2.setBounds(50,150,200,50);
                    label2.setFont(new Font("MV boli",Font.ROMAN_BASELINE,20));

                    JTextField text1 = new JTextField();
                    text1.setBounds(120,90,150,40);
                    text1.setFont(text1.getFont().deriveFont(20.0f));
                    
                    JTextField text2 = new JTextField();
                    text2.setBounds(200,150,100,40);
                    text2.setFont(text2.getFont().deriveFont(20.0f));

                    create.setBounds(80, 230, 180, 50);
                    create.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
                    create.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));
                    
                    create.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BankAccount newAccount = new BankAccount(Double.parseDouble(text2.getText()),text1.getText());
                            Accounts.add( newAccount );
                            JTextArea textArea = new JTextArea("New Account Created!!!"+"\n Your Account Number is "+newAccount.getaccnum());
                            textArea.setEditable(false);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            JOptionPane.showMessageDialog(null, scrollPane);
                        }
                    });
                    
                     newuser.add(label);
                     newuser.add(label1);
                     newuser.add(label2);
                     newuser.add(text1);
                     newuser.add(text2);
                     newuser.add(create);
                     newuser.setSize(350, 350);
                     newuser.setLocationRelativeTo(null);
                     newuser.setLayout(null);
                     newuser.setVisible(true);
                }
                else
                {
                        JFrame user = new JFrame("Account Details");

                        JButton ok = new JButton("Ok");
                        ok.setBounds(130, 190, 160, 40);
                        ok.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
                        ok.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));
                        
                        JLabel label3 = new JLabel("Account Number: ");
                        label3.setBounds(50,50,200,50);
                        label3.setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));

                        JTextField text3 = new JTextField();
                        text3.setBounds(230,50,170,40);
                        text3.setFont(text3.getFont().deriveFont(18.0f));

                        final JLabel[] label4={null};
                        final JTextField[] text4={null};

                        if(e.getSource() == withdrawButton)
                        {
                            label4[0] = new JLabel("Enter amount to withdraw:");

                            text4[0] = new JTextField();
                            
                            
                        }
                        else if(e.getSource() == depositButton)
                        {
                            label4[0] = new JLabel("Enter amount to deposit:");
    
                            text4[0] = new JTextField();

                        }

                        if(text4[0]!=null && label4[0]!=null)
                        {

                            text4[0].setBounds(300,120,120,40);
                            text4[0].setFont(text4[0].getFont().deriveFont(18.0f));                    
                            
                            label4[0].setBounds(50,120,250,50);
                            label4[0].setFont(new Font("MV boli",Font.ROMAN_BASELINE,18));

                            user.add(label4[0]);
                            user.add(text4[0]);
                        }

                        final BankAccount[] userfound = {null};
                        
                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e1)
                            {
        
                                Accounts.forEach(account->{
                                    if(account.getaccnum()==Long.parseLong(text3.getText()))
                                    {
                                        userfound[0] = account;
                                    }
                                });
                                
                                if(userfound[0]==null)
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Account Number!!!");
                                }
                                else if(e.getSource() == checkBalanceButton)
                                {
                                    JOptionPane.showMessageDialog(null,"Your Current Balance is :"+userfound[0].getBalance());
                                }
                                else if(e.getSource() == depositButton)
                                {
                                    userfound[0].deposit(Double.parseDouble(text4[0].getText()));
                                    JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + userfound[0].getBalance());
                                }
                                else if (e.getSource() == withdrawButton)
                                {
                                    double amount = Double.parseDouble(text4[0].getText());
                                    if (userfound[0].withdraw(amount))
                                    {
                                        JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: " + userfound[0].getBalance());
                                    }
                                    else 
                                    {
                                        JOptionPane.showMessageDialog(null, "Insufficient funds.");
                                    }
                                }
                                
                            }
                            
                        });

                         user.add(label3);
                         user.add(text3);
                         user.add(ok);
                         user.setSize(450, 300);
                         user.setLocationRelativeTo(null);
                         user.setLayout(null);
                         user.setVisible(true);

                }
            }
        };
        
        createAccountButton.addActionListener(listener);
        withdrawButton.addActionListener(listener);
        depositButton.addActionListener(listener);
        checkBalanceButton.addActionListener(listener);


        frame.add(label);
        frame.add(createAccountButton);
        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(checkBalanceButton);


        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}