package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JLabel a=new JLabel("A:");
    private JLabel b=new JLabel("B:");
    private JLabel result=new JLabel("Result:");
    private JTextField firstPolinom = new JTextField(24);
    private JTextField secondPolinom = new JTextField(24);
    private JButton plusButton = new JButton("A+B");
    private JButton minusButton = new JButton("A-B");
    private JButton multiplyButton = new JButton("A*B");
    private JButton divideButton = new JButton("A/B");
    private JButton derivateButton1=new JButton("∂A");
    private JButton derivateButton2=new JButton("∂B");
    private JButton integrateButton1=new JButton("∫A");
    private JButton integrateButton2=new JButton("∫B");
    private JTextField calcSolution = new JTextField(48);

    public GUI() {
        JPanel calcPanel = new JPanel();
        this.setTitle("Polinomial calculator");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 150);
        plusButton.setText("A+B");
        minusButton.setText("A-B");
        multiplyButton.setText("A*B");
        divideButton.setText("A/B");
        derivateButton1.setText("∂A");
        derivateButton2.setText("∂B");
        integrateButton1.setText("∫A");
        integrateButton2.setText("∫B");
        calcPanel.add(a);
        calcPanel.add(firstPolinom);
        calcPanel.add(b);
        calcPanel.add(secondPolinom);
        calcPanel.add(result);
        calcPanel.add(calcSolution);
        calcPanel.add(plusButton);
        calcPanel.add(minusButton);
        calcPanel.add(multiplyButton);
        calcPanel.add(divideButton);
        calcPanel.add(derivateButton1);
        calcPanel.add(derivateButton2);
        calcPanel.add(integrateButton1);
        calcPanel.add(integrateButton2);
        this.add(calcPanel);
    }

    public String getFirstPolinom() {
        return firstPolinom.getText();
    }

    public String getSecondPolinom() {
        return secondPolinom.getText();
    }

    public String getCalcSolution() {
        return calcSolution.getText();
    }

    public void setCalcSolution(String solution){
        calcSolution.setText(solution);
    }

    public void addListener(ActionListener listenForButtons){
        plusButton.addActionListener(listenForButtons);
        minusButton.addActionListener(listenForButtons);
        multiplyButton.addActionListener(listenForButtons);
        divideButton.addActionListener(listenForButtons);
        derivateButton2.addActionListener(listenForButtons);
        derivateButton1.addActionListener(listenForButtons);
        integrateButton1.addActionListener(listenForButtons);
        integrateButton2.addActionListener(listenForButtons);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}