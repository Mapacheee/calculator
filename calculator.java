package graficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator {

    public static void main(String[] args) {

        CalculatorFrame calculator = new CalculatorFrame();

    }

}
class CalculatorFrame extends JFrame {

    public CalculatorFrame() {

        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(500,300,550,400);

        add(new CalculatorSheet());

    }

}
class CalculatorSheet extends JPanel {

    private JButton screen = new JButton(" ");
    private double result;
    private JPanel CalculatorSheet2;
    private boolean principle;
    private String lastOperation;


    public CalculatorSheet() {

        principle = true;

        setLayout(new BorderLayout());

        screen.setEnabled(false);
        add(screen, BorderLayout.NORTH);

        CalculatorSheet2 = new JPanel();
        CalculatorSheet2.setLayout(new GridLayout(4, 4));


        setButton("7", new InsertNumber());
        setButton("8", new InsertNumber());
        setButton("9", new InsertNumber());
        setButton("/", new OrderAction());
        
        setButton("4", new InsertNumber());
        setButton("5", new InsertNumber());
        setButton("6", new InsertNumber());
        setButton("*", new OrderAction());

        setButton("1", new InsertNumber());
        setButton("2", new InsertNumber());
        setButton("3", new InsertNumber());
        setButton("-", new OrderAction());

        setButton("0", new InsertNumber());
        setButton(".", new InsertNumber());
        setButton("+", new OrderAction());
        setButton("=", new OrderAction());

        add(CalculatorSheet2);
        lastOperation = "=";

    }
    private class InsertNumber implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (principle) {

                screen.setText("");
                principle = false;

            }

            String entry = e.getActionCommand();

            screen.setText(screen.getText() + entry);

        }
    }
    private class OrderAction implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            String operation = e.getActionCommand();

            calculate(Double.parseDouble(screen.getText()));

            lastOperation = operation;

            principle = true;

        }

        public void calculate(double number) {

            if (lastOperation.equals("+")) {

                result += number;

            } else if (lastOperation.equals("-")) {
                
                result -= number;
                
            } else if (lastOperation.equals("*")) {

                result *= number;
                
            } else if (lastOperation.equals("/")) {

                result /= number;

            } else if (lastOperation.equals("=")) {

                result = number;

            }

            screen.setText("" + result);
        }

    }

    private void setButton(String label, ActionListener listener) {

        JButton button = new JButton(label);
        button.addActionListener(listener);

        CalculatorSheet2.add(button);

    }
}