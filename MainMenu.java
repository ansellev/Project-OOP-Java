package showroom.ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import showroom.models.Car;
import showroom.ui.components.*;
import showroom.ui.dialogs.*;
import showroom.utils.AppTheme;
import showroom.utils.FileManager;

public class MainMenu extends JFrame {

    private ArrayList<Car> carList = new ArrayList<>();

    public MainMenu() {
        setTitle("First Auto Factory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        setSize(1080, 720); 
        setLocationRelativeTo(null);

        BackgroundPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(new GridBagLayout());
        
        RoundedPanel menuBox = new RoundedPanel(30); 
        menuBox.setLayout(new BoxLayout(menuBox, BoxLayout.Y_AXIS));
        menuBox.setBackground(new Color(20, 20, 25, 245)); 
                
        menuBox.setBorder(new EmptyBorder(50, 60, 50, 60));
        
        addHeader(menuBox);
        
        menuBox.add(createBtn(" +  Create Car", true, e -> new CreateCarDialog(this, carList).setVisible(true)));
        menuBox.add(Box.createVerticalStrut(15)); 

        menuBox.add(createBtn(" 🚗  Show Car", false, e -> new ShowCarDialog(this, carList, "Garage Inventory").setVisible(true)));
        menuBox.add(Box.createVerticalStrut(15));
       
        menuBox.add(createBtn(" 🔍  Search Car", false, e -> new SearchCarDialog(this, carList).setVisible(true)));
        menuBox.add(Box.createVerticalStrut(15));
        
        menuBox.add(createBtn(" $  Sell Car", false, e -> new SellCarDialog(this, carList).setVisible(true)));
        menuBox.add(Box.createVerticalStrut(15));
        
        menuBox.add(createBtn(" 💾  Save Game", false, e -> {
            FileManager.save(carList);
            JOptionPane.showMessageDialog(this, "Game Saved!");
        }));
        menuBox.add(Box.createVerticalStrut(15));
        
        menuBox.add(createBtn(" 🚪  Exit", false, e -> System.exit(0)));

        mainPanel.add(menuBox);
        add(mainPanel);
    }
        
    private void addHeader(JPanel p) {
        
        JLabel icon = new JLabel("🚗", 0); 
        icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48)); 
        icon.setForeground(AppTheme.CYAN_ACCENT); 
        icon.setAlignmentX(CENTER_ALIGNMENT);
        
        
        JLabel title = new JLabel("FIRST AUTO", 0); 
        title.setFont(new Font("SansSerif", Font.BOLD, 32)); 
        title.setForeground(Color.WHITE); 
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        
        JLabel factory = new JLabel("FACTORY", 0); 
        factory.setFont(new Font("SansSerif", Font.BOLD, 32));
        factory.setForeground(AppTheme.TEXT_GREENISH); 
        factory.setAlignmentX(CENTER_ALIGNMENT);

        
        JLabel sub = new JLabel("BUILD YOUR EMPIRE", 0); 
        sub.setFont(new Font("SansSerif", Font.BOLD, 10)); 
        sub.setForeground(Color.GRAY); 
        sub.setAlignmentX(CENTER_ALIGNMENT);
        
        p.add(icon); 
        p.add(Box.createVerticalStrut(10));
        p.add(title); 
        p.add(factory); 
        p.add(Box.createVerticalStrut(5));
        p.add(sub); 
        p.add(Box.createVerticalStrut(40)); 
    }

    
    private JButton createBtn(String txt, boolean pri, ActionListener act) {
        JButton b = new JButton(txt) {
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g);
            }
        };

        
        b.setFont(new Font("SansSerif", Font.BOLD, 14));
        b.setFocusPainted(false);
        b.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Dimension dim = new Dimension(320, 45);
        b.setPreferredSize(dim);
        b.setMaximumSize(dim);
        b.setMinimumSize(dim);

        if (pri) {
            
            b.setBackground(AppTheme.CYAN_ACCENT);
            b.setForeground(Color.BLACK);
            b.setBorder(BorderFactory.createEmptyBorder()); 
        } else {
            
            b.setBackground(new Color(35, 35, 40));
            b.setForeground(Color.WHITE);
            
            b.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 70), 1));
        }
        
        
        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { 
                b.setBackground(pri ? new Color(100, 245, 255) : new Color(50, 50, 55)); 
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) { 
                b.setBackground(pri ? AppTheme.CYAN_ACCENT : new Color(35, 35, 40)); 
            }
        });
        
        b.addActionListener(act);
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}