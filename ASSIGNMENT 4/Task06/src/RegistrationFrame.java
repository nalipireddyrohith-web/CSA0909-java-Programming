import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*; import java.sql.SQLException; import java.util.List;
public class RegistrationFrame extends JFrame {
    private final JTextField studentId=new JTextField(),studentName=new JTextField(),eventName=new JTextField(),department=new JTextField();
    private final JComboBox<String> filter=new JComboBox<>(new String[]{"All","Tech Fest","Sports Meet","Cultural Fest"});
    private final DefaultTableModel model=new DefaultTableModel(new Object[]{"ID","Student ID","Student Name","Event","Department"},0);
    private final JTable table=new JTable(model); private final RegistrationService service=new RegistrationService();
    public RegistrationFrame(){setTitle("Campus Event Registration");setSize(850,550);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setLocationRelativeTo(null);
        JPanel form=new JPanel(new GridLayout(4,2,8,8));form.add(new JLabel("Student ID:"));form.add(studentId);form.add(new JLabel("Student Name:"));form.add(studentName);form.add(new JLabel("Event Name:"));form.add(eventName);form.add(new JLabel("Department:"));form.add(department);
        JButton register=new JButton("Register"),clear=new JButton("Clear"),filterButton=new JButton("Filter");JPanel bottom=new JPanel(new FlowLayout());bottom.add(register);bottom.add(clear);bottom.add(new JLabel("Event Filter:"));bottom.add(filter);bottom.add(filterButton);add(form,BorderLayout.NORTH);add(new JScrollPane(table),BorderLayout.CENTER);add(bottom,BorderLayout.SOUTH);
        register.addActionListener(e->register());clear.addActionListener(e->clear());filterButton.addActionListener(e->load());setVisible(true);
    }
    private void register(){String msg=service.register(new Registration(studentId.getText(),studentName.getText(),eventName.getText(),department.getText()));JOptionPane.showMessageDialog(this,msg);if(msg.equals("Registration successful.")){clear();load();}}
    private void clear(){studentId.setText("");studentName.setText("");eventName.setText("");department.setText("");}
    private void load(){try{String s=(String)filter.getSelectedItem();List<Registration> rows=service.filter("All".equals(s)?"%":s);model.setRowCount(0);for(Registration r:rows)model.addRow(new Object[]{r.getId(),r.getStudentId(),r.getStudentName(),r.getEventName(),r.getDepartment()});}catch(SQLException e){JOptionPane.showMessageDialog(this,"Database error: "+e.getMessage());}}
}
