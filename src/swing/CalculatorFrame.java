package src.swing;

import graficas.src.swing.CalculatorSheet;

import javax.swing.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame() {

        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(500,300,550,400);

        add(new CalculatorSheet());

    }

}
