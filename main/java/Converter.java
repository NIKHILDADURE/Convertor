package main.java;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class Converter extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] currencyUnits=
            {
                    "units",
                    "Indian Rupee",
                    "US Dollar",
                    "Canadian Dollar",
                    "Kenyan Shilling",
                    "Nigerian Naira",
                    "Brazilian Real",
                    "Indonesian Rupiah",
                    "Philippine_Pisco",
            };

    int Indian_Rupee = 82;
    int US_Dollar = 1;
    int Canadian_Dollar = 2;
    int Kenyan_Shilling = 132;
    int Nigerian_Naira = 476;
    int Brazilian_Real = 5;
    int Indonesian_Rupiah = 19554;
    int Philippine_Pisco = 71;

    Converter()
    {
        setBounds(300,60,590,500);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel maintitle = new JLabel("Currency Converter");
        maintitle.setBounds(150,30,650,60);
        maintitle.setFont(new Font("Arial",Font.BOLD,30));
        maintitle.setForeground(Color.black);
        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(10,150,50,50);
        from.setFont(new Font("Arial",Font.PLAIN,15));
        from.setForeground(Color.black);
        add(from);

        fromcountry = new JComboBox(new String[] { "Select One..", "India", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" });
        fromcountry.setBounds(100,165,150,30);
        fromcountry.setFont(new Font("Arial",Font.PLAIN,15));

        //fromcountry.setForeground(Color.white);
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry);

        fromtext = new TextField();
        fromtext.setBounds(280,165,150, 30);
        fromtext.setFont(new Font("Arial",Font.PLAIN,15));
        fromtext.setForeground(Color.BLACK);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(450,165,150,30);
        fromunit.setFont(new Font("Arial",Font.ITALIC,15));
        fromunit.setForeground(Color.BLACK);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(10,230,50,50);
        to.setFont(new Font("Arail",Font.PLAIN,15));
        to.setForeground(Color.black);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One..", "India", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" });
        tocountry.setBounds(100,240,150,30);
        tocountry.setFont(new Font("Arial",Font.PLAIN,15));
        //tocountry.setForeground(Color.white);
        tocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);

        Answer = new TextField(" ");
        Answer.setBounds(280,240,150, 30);
        Answer.setFont(new Font("Arial",Font.PLAIN,15));
        Answer.setForeground(Color.BLACK);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(450,210,250,90);
        tounit.setFont(new Font("Arial",Font.ITALIC,15));
        tounit.setForeground(Color.BLACK);
        add(tounit);

        convert = new JButton("Convert");
        convert.setBounds(100,320,110,30);
        convert.setFont(new Font("Arial",Font.PLAIN,15));
        convert.addActionListener(this);
        add(convert);


        reset = new JButton("Reset");
        reset.setBounds(220,320,110,30);
        reset.setFont(new Font("Arial",Font.PLAIN,15));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);

        exit = new JButton("Exit");
        exit.setBounds(340,320,110,30);
        exit.setFont(new Font("Arial",Font.PLAIN,15));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new Converter();
    }


    private void fromcountryItemStateChanged(java.awt.event.ItemEvent evt) {
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(currencyUnits[position]);
    }

    private void tocountryItemStateChanged(java.awt.event.ItemEvent evt) {
        int position = tocountry.getSelectedIndex();
        tounit.setText(currencyUnits[position]);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;

                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "India":
                        amountInPounds = amountToChange / Indian_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "Kenyan":
                        amountInPounds = amountToChange / Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        amountInPounds = amountToChange / Nigerian_Naira;
                        break;
                    case "Brazil":
                        amountInPounds = amountToChange / Brazilian_Real;
                        break;
                    case "Indonesia":
                        amountInPounds = amountToChange / Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        amountInPounds = amountToChange / Philippine_Pisco;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "India":
                        newamount = amountInPounds * Indian_Rupee;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newamount = amountInPounds * Canadian_Dollar;
                        break;
                    case "Kenyan":
                        newamount = amountInPounds * Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        newamount = amountInPounds * Nigerian_Naira;
                        break;
                    case "Brazil":
                        newamount = amountInPounds * Brazilian_Real;
                        break;
                    case "Indonesia":
                        newamount = amountInPounds * Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        newamount = amountInPounds * Philippine_Pisco;
                        break;
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                Answer.setText(amount);
            }
        }


    }
}