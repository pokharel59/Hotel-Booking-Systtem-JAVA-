package CustomerGUI;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;

public class JcalendarComboBoxRenderer extends JPanel implements ListCellRenderer<JCalendar> {
    private JCalendar calendar;

    public JcalendarComboBoxRenderer() {
        setOpaque(true);
        calendar = new JCalendar();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends JCalendar> list, JCalendar value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            calendar.setCalendar(value.getCalendar());
        }
        return calendar;
    }
}

