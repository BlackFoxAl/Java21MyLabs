package com.java21.lesson11;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class CalendarProgram {
    static JLabel lblMonth,lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static  JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar;
    static JScrollPane stblCalendar;
    static JPanel pnlCalendar;
    static int realYear, realMonth, realDay, currentYear, currentMonth;

    public static void main(String[] arguments) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }   catch (ClassNotFoundException e) {}
            catch (InstantiationException e) {}
            catch (IllegalAccessException e) {}
            catch (UnsupportedLookAndFeelException e) {}
        frmMain = new JFrame("Calendar Program");
        frmMain.setSize(330,375);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblMonth = new JLabel("January");
        lblYear = new JLabel("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");
        mtblCalendar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        pane.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        pnlCalendar.setBounds(0,0,320,335);
        lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2,25,100,25);
        lblYear.setBounds(10,305,80,20);
        cmbYear.setBounds(230,305,80,20);
        btnPrev.setBounds(10,25,50,25);
        btnNext.setBounds(260,25,50,25);
        stblCalendar.setBounds(10,50,300,250);
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        GregorianCalendar cal = new GregorianCalendar();
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
        realMonth = cal.get(GregorianCalendar.MONTH);
        realYear = cal.get(GregorianCalendar.YEAR);
        currentMonth = realMonth;
        currentYear = realYear;
        String[] headers = {
                "Sun",
                "Mon",
                "Tue",
                "Wed",
                "Thu",
                "Fri",
                "Sat"};
        for (int i = 0; i < 7; i++) {
            mtblCalendar.addColumn(headers[i]);
        }
        tblCalendar.getParent().setBackground(tblCalendar.getBackground());
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        for (int i = realYear - 100; i <= realYear +100; i++) {
            cmbYear.addItem(String.valueOf(i));
        }
        refreshCalendar(realMonth,realYear);

    }
    public static void refreshCalendar(int month, int year) {
        String[] months = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };
        int nod, som;
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= realYear - 10) {
            btnPrev.setEnabled(false);
        }
        if (month == 11 && year >= realYear + 100) {
            btnNext.setEnabled(false);
        }
        lblMonth.setText((months[month]));
        lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2,25,180,25);
        cmbYear.setSelectedItem(String.valueOf(year));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                mtblCalendar.setValueAt(null,i,j);
            }
        }
        GregorianCalendar cal = new GregorianCalendar(year,month,1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        //named
        for (int i = 1; i <= nod; i++) {
            int row = ((i + som - 2) / 7);
            int column = (i + som -2) % 7;
            mtblCalendar.setValueAt(i,row,column);
        }
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0),new tblCalendarRenderer());

    }
    static class tblCalendarRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table,Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table,value,selected, focused,row, column);
            if (column == 0 || column == 6) {
                setBackground(new Color(255,220,220));
            } else {
                setBackground((new Color(255,255,255)));
            }
            if (value != null) {
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear) {
                    setBackground(new Color(220,220,255));
                }
            }
            setBorder(null);
            setForeground(Color.BLACK);
            return this;
        }
    }
    static class btnPrev_Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear -= 1;
            } else {
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth,currentYear);
        }
    }
    static class btnNext_Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear += 1;
            } else {
                currentMonth += 1;
            }
            refreshCalendar(currentMonth,currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cmbYear.getSelectedItem() != null) {
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth,currentYear);
            }
        }
    }
}
