package com.imejpul;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Viajes {
    private JPanel panel;
    private JList viajes;
    private JTable etapas;

    private DefaultListModel listModel;
    private DefaultTableModel tableModel;

    private List<Viaje> lista_viajes;
    private List<Etapa> lista_etapas = new ArrayList<>();

    public Viajes() {

        //inicialización
        listModel = new DefaultListModel();
        tableModel = new DefaultTableModel();

        //manejo Jlist
        viajes.setModel(listModel);

        //manejo JTable
        etapas.setModel(tableModel);

        //llamada a BBDD para recuperar datos
        lista_viajes = viajes();

        //cargar datos en jlist
        mostrarViajes();

        //listener para cuando el usuario selecciona un viaje concreto
        viajes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int index = viajes.getSelectedIndex();

                Viaje v = lista_viajes.get(index);
                int idViaje = v.getId();

                //llamada a BD para recuperar etapas de viaje concreto (v)
                lista_etapas = etapas(idViaje);

                //visualizar etapas de viaje elegido en JTable
                mostrarEtapas();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Viajes");
        frame.setContentPane(new Viajes().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //funcion recuperar datos BD viajes
    public static List<Viaje> viajes() {

        List<Viaje> viajesLista = new ArrayList<>();

        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM VIAJE";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                viajesLista.add(new Viaje(rs.getInt("idVIAJE"),
                                rs.getString("titulo")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GestorBD.desconectar();

        return viajesLista;
    }

    //funcion recuperar datos BD etapas
    private static List<Etapa> etapas(int idViaje) {
        List<Etapa> etapasLista = new ArrayList<>();

        Connection conexion = GestorBD.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM ETAPA WHERE VIAJE_idVIAJE = " + idViaje + ";";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                etapasLista.add(new Etapa(rs.getInt("idETAPA"),
                                rs.getString("tipo"),
                                rs.getString("titulo"),
                                rs.getString("descripcion"),
                                idViaje
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GestorBD.desconectar();

        return etapasLista;
    }

    //funcion para visualizar datos en la ventana
    private void mostrarViajes() {
        listModel.clear();

        for (Viaje v : lista_viajes) {

            listModel.addElement(v);
        }
    }

    private void mostrarEtapas() {

    }

    //función para visualizar etapas de un viaje seleccionado
}
