package ludo;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe 
 * PROJECT: Project 1 - Deliverable 4 Spring 2021 
 * PROJECT DESCRIPTION: Functional Ludo Game 
 * DATE OF SUBMISSION: 04/27/2021 
 * DATE OF COMPLETION: 04/21/2021
 * @author akku 
 * class SetUpGUI
 */

public class SetUpGUI2 extends JFrame {
    int num = 0;

    JLabel selectLbl = new JLabel("Select Number of Players: ");

    ArrayList<JLabel> playerNameLbl = new ArrayList<>();
    //combo button for number of players reqd HERE
    ArrayList<JTextField> nameTextFld = new ArrayList<>();
    JButton startBtn = new JButton("Start");
    JButton cancelBtn = new JButton("Cancel");
    JButton exitBtn = new JButton("Exit");

    public SetUpGUI2() {
        initComponents();
    }

    private void initComponents() {
        this.setExtendedState(4);
        this.setSize(700, 700);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);

        selectLbl.setBounds(20, 30, 120, 30);
        this.add(selectLbl);
        //numComboBtn.setBounds(160, 30, 120, 30);
        //this.add(numComboBtn);

        startBtn.setBounds(300, 300, 120, 30);
        this.add(startBtn);

        cancelBtn.setBounds(400, 300, 120, 30);
        this.add(cancelBtn);

        exitBtn.setBounds(500, 300, 120, 30);
        this.add(exitBtn);

        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startBtnMouseClicked(evt);
            }
        });

        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtnMouseClicked(evt);
            }
        });

        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
    }

    private void startBtnMouseClicked(java.awt.event.MouseEvent evt) {
        //START
    }

    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {
        //CANCEL - resets screen

        repaint();
    }

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {
        //EXIT
        dispose();
    }

}
