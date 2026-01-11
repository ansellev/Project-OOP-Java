package showroom.ui.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import showroom.models.*;
import showroom.utils.AppTheme;

public class CreateCarDialog extends JDialog {

    public CreateCarDialog(JFrame parent, List<Car> carList) {
        super(parent, "Create New Car", true);
        setSize(450, 550); 
        setLocationRelativeTo(parent);
        getContentPane().setBackground(AppTheme.BG_DARK);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        JLabel lblTitle = new JLabel("Select Car Type", SwingConstants.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc.gridy = 0; 
        add(lblTitle, gbc);

        JToggleButton btnSedan = createBigRoundedToggle("Sedan");
        JToggleButton btnSUV = createBigRoundedToggle("SUV");
        JToggleButton btnHatch = createBigRoundedToggle("Hatchback");

        ButtonGroup grp = new ButtonGroup();
        grp.add(btnSedan);
        grp.add(btnSUV);
        grp.add(btnHatch);

        JPanel typePanel = new JPanel(new GridLayout(1, 3, 15, 0)); 
        typePanel.setOpaque(false);
        typePanel.add(btnSedan);
        typePanel.add(btnSUV);
        typePanel.add(btnHatch);
        
        gbc.gridy = 1; 
        add(typePanel, gbc);

        JLabel lblName = new JLabel("Car Name", SwingConstants.CENTER);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridy = 2; 
        add(lblName, gbc);

        JTextField tfName = new JTextField();
        AppTheme.styleInput(tfName); 
        gbc.gridy = 3; 
        add(tfName, gbc);

        JButton btnConfirm = new JButton("Confirm Build") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                
                super.paintComponent(g);
            }
        };

        
        btnConfirm.setPreferredSize(new Dimension(200, 50)); 
        btnConfirm.setBackground(AppTheme.CYAN_ACCENT);
        btnConfirm.setForeground(Color.BLACK);
        btnConfirm.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnConfirm.setFocusPainted(false);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setContentAreaFilled(false); 
        
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btnConfirm.setBackground(new Color(100, 245, 255)); }
            public void mouseExited(MouseEvent e) { btnConfirm.setBackground(AppTheme.CYAN_ACCENT); }
        });

        btnConfirm.addActionListener(e -> {
            String name = tfName.getText().trim();
            if (name.isEmpty() || grp.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Please select type and input name.");
                return;
            }
            
            Car newCar = null;
            if (btnSedan.isSelected()) newCar = new Sedan(name);
            else if (btnSUV.isSelected()) newCar = new SUV(name);
            else if (btnHatch.isSelected()) newCar = new Hatchback(name);
            
            carList.add(newCar);
            JOptionPane.showMessageDialog(this, "Car Created Successfully!");
            dispose();
        });

        gbc.gridy = 4;
        gbc.insets = new Insets(30, 20, 20, 20); // Jarak atas lebih jauh
        add(btnConfirm, gbc);
    }

    private JToggleButton createBigRoundedToggle(String text) {
        JToggleButton btn = new JToggleButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (isSelected()) {
                    g2.setColor(AppTheme.CYAN_ACCENT); 
                } else {
                    g2.setColor(new Color(50, 50, 55)); 
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                if (!isSelected()) {
                    g2.setColor(Color.GRAY);
                    g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
                }

                super.paintComponent(g);
            }
        };

        btn.setPreferredSize(new Dimension(100, 80)); 
        btn.setForeground(Color.GRAY);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);      
        btn.setContentAreaFilled(false);  
        
        
        btn.addItemListener(e -> {
            if (btn.isSelected()) {
                btn.setForeground(Color.BLACK); 
            } else {
                btn.setForeground(Color.GRAY);  
            }
        });

        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }
}