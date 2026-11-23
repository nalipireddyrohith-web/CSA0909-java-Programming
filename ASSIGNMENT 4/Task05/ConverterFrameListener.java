import java.awt.*; import java.awt.event.*;
public class ConverterFrameListener extends Frame implements ActionListener {
    TextField input = new TextField(10); Label output = new Label("Output: ");
    public ConverterFrameListener() {
        setTitle("Converter - Frame Listener"); setSize(400,200); setLayout(new FlowLayout());
        add(new Label("Kilometers:")); add(input); Button convert=new Button("Convert"); add(convert); add(output);
        convert.addActionListener(this); addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){dispose();}}); setVisible(true);
    }
    public void actionPerformed(ActionEvent e){try{output.setText("Output: "+(Double.parseDouble(input.getText())*1000)+" meters");}catch(NumberFormatException ex){output.setText("Enter a valid number.");}}
    public static void main(String[] args){new ConverterFrameListener();}
}
