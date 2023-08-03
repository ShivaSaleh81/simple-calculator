import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static double fNum , sNum;
    public static String Opt;
    public static int state = 0;

    public static void main(String[] args)
            throws FileNotFoundException {

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(300,380);

        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(new Color(185, 183, 189));
        panel.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(20,20,260,40);

        PrintStream fileOut = new PrintStream(new FileOutputStream("history.txt", true));

        JButton button1 = new JButton();
        button1.setText("1");
        button1.setBounds(20,80,59,40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"1");
            }
        });

        JButton button2 = new JButton();
        button2.setText("2");
        button2.setBounds(87,80,59,40);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"2");
            }
        });

        JButton button3 = new JButton();
        button3.setText("3");
        button3.setBounds(154,80,59,40);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "3");
            }
        });

        JButton button4 = new JButton();
        button4.setText("4");
        button4.setBounds(20,130,59,40);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"4");
            }
        });

        JButton button5 = new JButton();
        button5.setText("5");
        button5.setBounds(87,130,59,40);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"5");
            }
        });

        JButton button6 = new JButton();
        button6.setText("6");
        button6.setBounds(154,130,59,40);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"6");
            }
        });

        JButton button7 = new JButton();
        button7.setText("7");
        button7.setBounds(20,180,59,40);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"7");
            }
        });

        JButton button8 = new JButton();
        button8.setText("8");
        button8.setBounds(87,180,59,40);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"8");
            }
        });

        JButton button9 = new JButton();
        button9.setText("9");
        button9.setBounds(154,180,59,40);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"9");
            }
        });

        JButton button0 = new JButton();
        button0.setText("0");
        button0.setBounds(87,230,59,40);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +"0");
            }
        });

        JButton buttonD = new JButton();
        buttonD.setText("/");
        buttonD.setBounds(221,80,59,40);
        buttonD.setForeground(new Color(252,127,3));
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 0) {
                    fNum = Double.parseDouble(textField.getText());
                    fileOut.println(fNum);
                    Opt = "/";
                    state = 1;
                } else {
                    sNum = Double.parseDouble(textField.getText());
                    fileOut.println(sNum);
                    if (Opt.equals("/")) {
                        if (sNum == 0) {
                            state = 0;
                        } else {
                            fNum = divide(fNum,sNum);
                        }
                    } else if (Opt.equals("*")) {
                        fNum = multiply(fNum, sNum);
                    } else if (Opt.equals("-")) {
                        fNum = subtract(fNum,sNum);
                    } else if (Opt.equals("+")) {
                        fNum = add(fNum,sNum);
                    }
                    Opt = "/";
                }
                textField.setText("");
                fileOut.println("/");
            }
        });

        JButton buttonM = new JButton();
        buttonM.setText("*");
        buttonM.setBounds(221,130,59,40);
        buttonM.setForeground(new Color(252,127,3));
        buttonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 0) {
                    fNum = Double.parseDouble(textField.getText());
                    fileOut.println(fNum);
                    Opt = "*";
                    state = 1;
                } else {
                    sNum = Double.parseDouble(textField.getText());
                    fileOut.println(sNum);
                    if (Opt.equals("/")) {
                        if (sNum == 0) {
                            state = 0;
                        } else {
                            fNum = divide(fNum,sNum);
                        }
                    } else if (Opt.equals("*")) {
                        fNum = multiply(fNum, sNum);
                    } else if (Opt.equals("-")) {
                        fNum = subtract(fNum,sNum);
                    } else if (Opt.equals("+")) {
                        fNum = add(fNum,sNum);
                    }
                    Opt = "*";
                }
                textField.setText("");
                fileOut.println("*");
            }
        });

        JButton buttonS = new JButton();
        buttonS.setText("-");
        buttonS.setBounds(221,180,59,40);
        buttonS.setForeground(new Color(252,127,3));
        buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText("-");
                } else {
                    if (state == 0) {
                        fNum = Double.parseDouble(textField.getText());
                        fileOut.println(fNum);
                        Opt = "-";
                        state = 1;
                    } else {
                        sNum = Double.parseDouble(textField.getText());
                        fileOut.println(sNum);
                        if (Opt.equals("/")) {
                            if (sNum == 0) {
                                state = 0;
                            } else {
                                fNum = divide(fNum,sNum);
                            }
                        } else if (Opt.equals("*")) {
                            fNum = multiply(fNum, sNum);
                        } else if (Opt.equals("-")) {
                            fNum = subtract(fNum,sNum);
                        } else if (Opt.equals("+")) {
                            fNum = add(fNum,sNum);
                        }
                        Opt = "-";
                    }
                    textField.setText("");
                    fileOut.println("-");
                }
            }
        });

        JButton buttonA = new JButton();
        buttonA.setText("+");
        buttonA.setBounds(221,230,59,40);
        buttonA.setForeground(new Color(252,127,3));
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 0) {
                    fNum = Double.parseDouble(textField.getText());
                    fileOut.println(fNum);
                    Opt = "+";
                    state = 1;
                } else {
                    sNum = Double.parseDouble(textField.getText());
                    fileOut.println(sNum);
                    if (Opt.equals("/")) {
                        if (sNum == 0) {
                            state = 0;
                        } else {
                            fNum = divide(fNum,sNum);
                        }
                    } else if (Opt.equals("*")) {
                        fNum = multiply(fNum, sNum);
                    } else if (Opt.equals("-")) {
                        fNum = subtract(fNum,sNum);
                    } else if (Opt.equals("+")) {
                        fNum = add(fNum,sNum);
                    }
                    Opt = "+";
                }
                textField.setText("");
                fileOut.println("+");
            }
        });

        JButton buttonDot = new JButton();
        buttonDot.setText(".");
        buttonDot.setBounds(20,230,59,40);
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() +".");
            }
        });

        JButton buttonE = new JButton();
        buttonE.setText("=");
        buttonE.setBounds(154,230,59,40);
        buttonE.setForeground(new Color(80, 200, 120));
        buttonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sNum = Double.parseDouble(textField.getText());
                fileOut.println(sNum);
                fileOut.println("=");
                state = 0;

                textField.setText("");
                if (Opt.equals("/")) {
                    if (sNum == 0) {
                        textField.setText("not valid");
                        fileOut.println("not valid");
                    } else {
                        textField.setText(String.valueOf(divide(fNum,sNum)));
                        fileOut.println(String.valueOf(divide(fNum,sNum)));
                    }
                } else if (Opt.equals("*")) {
                    textField.setText(String.valueOf(multiply(fNum, sNum)));
                    fileOut.println(String.valueOf(multiply(fNum, sNum)));
                } else if (Opt.equals("-")) {
                    textField.setText(String.valueOf(subtract(fNum,sNum)));
                    fileOut.println(String.valueOf(subtract(fNum,sNum)));
                } else if (Opt.equals("+")) {
                    textField.setText(String.valueOf(add(fNum,sNum)));
                    fileOut.println(String.valueOf(add(fNum,sNum)));
                }
                fileOut.println("------");
            }
        });

        JButton buttonClear = new JButton();
        buttonClear.setText("clear");
        buttonClear.setBounds(87,280,59,40);
        buttonClear.setForeground(new Color(199, 0, 57));
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        JButton buttonLog = new JButton();
        buttonLog.setText("log");
        buttonLog.setBounds(154,280, 59,40);
        buttonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(new File("history.txt"));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                while (fileIn.hasNextLine()) {
                    System.out.println(fileIn.nextLine());
                }
            }
        });

        panel.add(textField);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonD);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonM);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonS);
        panel.add(buttonDot);
        panel.add(button0);
        panel.add(buttonE);
        panel.add(buttonA);
        panel.add(buttonClear);
        panel.add(buttonLog);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static double add(double numOne, double numTwo) {
        return numOne + numTwo;
    }

    public static double subtract(double numOne, double numTwo) {
        return numOne - numTwo;
    }

    public static double divide(double numOne, double numTwo) {
        return numOne / numTwo;
    }

    public static double multiply(double numOne, double numTwo) {
        return numOne * numTwo;
    }
}
