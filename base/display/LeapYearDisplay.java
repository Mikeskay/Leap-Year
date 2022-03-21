package leapyear.base.display;

import leapyear.base.engine.LeapYear;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



public class LeapYearDisplay extends JFrame implements ActionListener {
    protected JPanel mainPanel = new JPanel(new GridLayout());
    protected JPanel topPanel;
    protected JPanel midPanel;
    protected JPanel flowPanel;
    protected JPanel textfieldPanel;
    protected Object buttonPressed;

    protected JTextField leapYearTextField;

    protected JLabel leapYearLabel;

    protected JButton submitButton;

    protected int leapyear;
    

    public LeapYearDisplay(){
        setTitle("Leap Year Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel);
        getRootPane().setDefaultButton(submitButton);

        mainPanel.add(topPanel());
        submitButton.addActionListener(this);
               
        setBounds(100,100, 550, 75);

        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e){
        buttonPressed = e.getSource();
        
        if (buttonPressed == submitButton){

            try {
                leapyear = Integer.parseInt(leapYearTextField.getText()); 
                
                if(LeapYear.calLeapYear(leapyear) == true){

                    leapYearLabel.setText("Yep that's a Leap Year");
                    leapYearLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
                    
                    topPanel.validate();
                    topPanel.repaint();
        
                 }else{
                    leapYearLabel.setText("nope that's not a Leap Year");        
                    leapYearLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
                    
                    topPanel.validate();
                    topPanel.repaint();
        
                 } 
               
            } catch (Throwable error) {
                
                    leapYearLabel.setText("Something went wrong: enter a valid Year");  
                    leapYearLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
                    topPanel.validate();
                    topPanel.repaint();
            }
         
        }
        
    }

    public JPanel topPanel(){
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setSize(400, 100);
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        leapYearLabel = new JLabel("Enter a Valid Year");
        leapYearLabel.setForeground( (new Color(65, 66, 64)));
        leapYearLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
    
       

        leapYearTextField = new JTextField(5);
        submitButton = new JButton("Submit");  
    
        topPanel.add(leapYearLabel);
        topPanel.add(leapYearTextField);
        topPanel.add(submitButton);
        topPanel.setBackground(new Color(235, 140, 82));

        return topPanel;
    }

   


}
