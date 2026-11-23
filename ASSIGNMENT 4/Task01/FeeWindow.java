import java.awt.*;
import java.awt.event.*;

public class FeeWindow extends Frame implements ActionListener {
    TextField registrationField, amountField;
    Label resultLabel;
    Button payButton, clearButton;

    public FeeWindow() {
        setTitle("Fee Payment");
        setSize(420, 250);
        setLayout(new GridLayout(5, 2, 10, 10));
        add(new Label("Registration Number:"));
        registrationField = new TextField(); add(registrationField);
        add(new Label("Amount:"));
        amountField = new TextField(); add(amountField);
        payButton = new Button("Pay"); clearButton = new Button("Clear");
        payButton.addActionListener(this); clearButton.addActionListener(this);
        add(payButton); add(clearButton);
        add(new Label("Status:")); resultLabel = new Label(""); add(resultLabel);
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { dispose(); } });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {
            resultLabel.setText(FeeService.validateAndPay(registrationField.getText(), amountField.getText()));
        } else {
            registrationField.setText(""); amountField.setText(""); resultLabel.setText("");
        }
    }
    public static void main(String[] args) { new FeeWindow(); }
}
