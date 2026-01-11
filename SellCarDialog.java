package showroom.ui.dialogs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import showroom.models.Car;
import showroom.utils.AppTheme;

public class SellCarDialog extends JDialog {

    public SellCarDialog(JFrame parent, List<Car> carList) {
        super(parent, "Sell Car", true);
        
        setSize(900, 550); 
        setLocationRelativeTo(parent);
        getContentPane().setBackground(AppTheme.BG_DARK);
        setLayout(new BorderLayout());

        JLabel lblInfo = new JLabel("Select a car to sell", SwingConstants.CENTER);
        lblInfo.setForeground(Color.WHITE);
        lblInfo.setFont(AppTheme.FONT_REGULAR);
        lblInfo.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        add(lblInfo, BorderLayout.NORTH);

        String[] columns = {"Type", "Name", "Capacity", "HP", "Color", "Plate", "VIN"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for(Car c : carList) {
            model.addRow(new Object[]{
                c.getType(), 
                c.getName(), 
                c.getCapacity(), 
                c.getHp(), 
                c.getColor(), 
                c.getNumberPlate(), 
                c.getVin()
            });
        }

        JTable table = new JTable(model);
        AppTheme.styleTable(table); 

        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(AppTheme.BG_DARK);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        add(scroll, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        
        JButton btnSell = new JButton("Sell Selected Car");
        btnSell.setPreferredSize(new Dimension(200, 45));
        btnSell.setBackground(new Color(255, 80, 80)); 
        btnSell.setForeground(Color.WHITE);
        btnSell.setFocusPainted(false);
        btnSell.setFont(new Font("SansSerif", Font.BOLD, 14));

        btnSell.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row first.");
                return;
            }

            String vin = (String) table.getValueAt(selectedRow, 6);
            String name = (String) table.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to sell " + name + "?", "Confirm Sell", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
               
                carList.removeIf(c -> c.getVin().equals(vin));
                
                model.removeRow(selectedRow);
                
                JOptionPane.showMessageDialog(this, "Car Sold Successfully!");
            }
        });

        btnPanel.add(btnSell);
        add(btnPanel, BorderLayout.SOUTH);
    }
}