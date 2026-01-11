package showroom.utils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class AppTheme {
    
    public static final Color CYAN_ACCENT = new Color(0, 229, 255);
    public static final Color BG_DARK = new Color(20, 20, 24);
    public static final Color PANEL_TRANSPARENT = new Color(30, 30, 35, 240);
    public static final Color TEXT_WHITE = Color.WHITE;
    public static final Color TEXT_GRAY = new Color(170, 170, 170);
    public static final Color TEXT_GREENISH = new Color(200, 255, 200); 

    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 28);
    public static final Font FONT_SUBTITLE = new Font("SansSerif", Font.BOLD, 12);
    public static final Font FONT_REGULAR = new Font("SansSerif", Font.PLAIN, 14);

    public static void styleInput(JTextField tf) {
        tf.setBackground(BG_DARK);
        tf.setForeground(TEXT_WHITE);
        tf.setCaretColor(CYAN_ACCENT);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tf.setBorder(new CompoundBorder(
            new MatteBorder(0, 0, 2, 0, CYAN_ACCENT),
            new EmptyBorder(5, 5, 5, 5)
        ));
    }

    public static void styleTable(JTable table) {
        table.setBackground(new Color(30, 30, 35));
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(60, 60, 60));
        table.setRowHeight(30);
        table.setSelectionBackground(CYAN_ACCENT);
        table.setSelectionForeground(Color.BLACK);
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(20, 20, 20));
        header.setForeground(CYAN_ACCENT);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
}