package com.imejpul;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IMDB {

    private String[] columnNames = {"Rank", "Título", "Año", "Duración", "Rating"};
    private LeerFichero leerFichero;

    private JTable table1 /*= new JTable(leerFichero.getMatrizCampos(), columnNames)*/;
    private JPanel panel1;
    private JSpinner spinner1;
    private JLabel anyoLabel;

    private DefaultTableModel table_model;

    public IMDB() {
    }

    public IMDB(String[] columnNames, LeerFichero leerFichero) {
        this.columnNames = columnNames;
        this.leerFichero = leerFichero;

        //table1.setModel();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("IMDB");
        frame.setContentPane(new IMDB().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //https://github.com/Imejpul/ud7-persistencia/blob/master/01_tareas/tareas/src/main/java/com/imejpul/Tareas.java
    //https://docs.oracle.com/javase/tutorial/uiswing/components/spinner.html
    //https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
}
