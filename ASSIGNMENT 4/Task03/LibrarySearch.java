import java.awt.*;
import java.awt.event.*;

public class LibrarySearch extends Frame implements ActionListener {
    TextField searchField;
    Choice categoryChoice;
    TextArea resultArea;
    Button searchButton, clearButton;

    public LibrarySearch() {
        setTitle("Library Search"); setSize(600, 400); setLayout(new BorderLayout(10, 10));
        Panel top = new Panel(new BorderLayout(10, 10));
        top.add(new Label("Library Search", Label.CENTER), BorderLayout.NORTH);
        Panel search = new Panel(new FlowLayout());
        searchField = new TextField(25); categoryChoice = new Choice();
        categoryChoice.add("Book"); categoryChoice.add("Author"); categoryChoice.add("Category");
        searchButton = new Button("Search"); clearButton = new Button("Clear");
        search.add(new Label("Search:")); search.add(searchField); search.add(categoryChoice); search.add(searchButton); search.add(clearButton);
        top.add(search, BorderLayout.SOUTH); add(top, BorderLayout.NORTH);
        resultArea = new TextArea(); resultArea.setEditable(false); add(resultArea, BorderLayout.CENTER);
        add(new Label("Use the controls above to search the library.", Label.CENTER), BorderLayout.SOUTH);
        searchButton.addActionListener(this); clearButton.addActionListener(this);
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { dispose(); } });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String text = searchField.getText().trim();
            if (text.isEmpty()) resultArea.setText("Enter a search term.");
            else resultArea.setText("Search category: " + categoryChoice.getSelectedItem() + "\nSearch term: " + text + "\nResult: Search request processed.");
        } else { searchField.setText(""); resultArea.setText(""); }
    }
    public static void main(String[] args) { new LibrarySearch(); }
}
