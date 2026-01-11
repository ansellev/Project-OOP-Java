package showroom.ui.dialogs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import showroom.models.Car;
import showroom.utils.AppTheme;

public class ShowCarDialog extends JDialog {
    public ShowCarDialog(JDialog parent, List<Car> list, String title) { 
        this((JFrame)null, list, title); 
    }
    
    public ShowCarDialog(JFrame parent, List<Car> list, String title) {
        super(parent, title, true);
        setSize(800, 500);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(AppTheme.BG_DARK);
        setLayout(new BorderLayout());

        JLabel lbl = new JLabel(title, 0);
        lbl.setForeground(AppTheme.CYAN_ACCENT);
        lbl.setFont(AppTheme.FONT_TITLE);
        add(lbl, BorderLayout.NORTH);

        String[] col = {"Type", "Name", "Capacity", "HP", "Color", "Plate", "VIN"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        for(Car c : list) model.addRow(new Object[]{c.getType(), c.getName(), c.getCapacity(), c.getHp(), c.getColor(), c.getNumberPlate(), c.getVin()});

        JTable table = new JTable(model);
        AppTheme.styleTable(table); 

        JScrollPane sp = new JScrollPane(table);
        sp.getViewport().setBackground(AppTheme.BG_DARK);
        sp.setBorder(BorderFactory.createEmptyBorder());
        add(sp, BorderLayout.CENTER);
    }
}