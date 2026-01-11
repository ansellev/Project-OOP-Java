package showroom.ui.dialogs;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import showroom.models.Car;
import showroom.utils.AppTheme;

public class SearchCarDialog extends JDialog {

    public SearchCarDialog(JFrame parent, List<Car> carList) {
        super(parent, "Search Car", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(AppTheme.BG_DARK);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        
        JLabel lbl = new JLabel("Enter Car Name:", SwingConstants.CENTER);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(AppTheme.FONT_REGULAR);
        gbc.gridy = 0;
        add(lbl, gbc);
        
        JTextField tfSearch = new JTextField();
        AppTheme.styleInput(tfSearch);
        gbc.gridy = 1;
        add(tfSearch, gbc);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(AppTheme.CYAN_ACCENT);
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setFocusPainted(false);
        
        btnSearch.addActionListener(e -> {
            String keyword = tfSearch.getText().trim().toLowerCase();
            if (keyword.isEmpty()) return;
            
            List<Car> results = carList.stream()
                .filter(c -> c.getName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No car found!");
            } else {
                dispose();                
                new ShowCarDialog(parent, results, "Search Result: " + keyword).setVisible(true);
            }
        });

        gbc.gridy = 2;
        gbc.insets = new Insets(30, 20, 20, 20); 
        add(btnSearch, gbc);
    }
}