import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NumberGame extends JFrame 
{
    private int randomNumber;
    private int attempts=5;
    private JTextField inputField;
    private JLabel result;
    private JButton guess,exit;

    public NumberGame() 
	{
        setTitle("Number Guessing Game");
        setLayout(new FlowLayout(FlowLayout.LEFT, 45, 15)); 
        
        JLabel l = new JLabel("Guess a number between 1 and 100: ");
        add(l);
		
		inputField = new JTextField(10);
        add(inputField);

        guess = new JButton("Guess");
        guess.addActionListener(new GuessButton());

        result= new JLabel(" Total Attempts: " +attempts+"                                        ");
        add(result); 

        exit = new JButton("Exit");
        exit.addActionListener(new ExitButtonListener());

        add(guess);
        add(exit);
		
        randomNumber = (int) (Math.random() * 100) + 1;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Guessing Game");
        setSize(531, 202);
        setVisible(true);
    }

    private class GuessButton implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            try 
			{
                int num = Integer.parseInt(inputField.getText());
                String text;

                if (num == randomNumber) 
				{
                    text= "Congratulations! You guessed the correct number. ";
                } 
				else if (num > randomNumber) 
				{
                    text = "Your guess is too high. ";
                } 
				else 
				{ 
                    text = "Your guess is too low. ";
                }

             attempts--;

                if  (attempts == 0) 
				{
                    text += "The number generated was: "+randomNumber;
                    guess.setEnabled(false);
                }
				else 
				{
                    text += "\nAttempts remaining: " + attempts;
                }

                result.setText(text);
                inputField.setText("");
            } 
			catch (NumberFormatException exception) 
			{
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
            }
        }
    }

    private class ExitButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) 
	{
        new NumberGame();

    }
}
