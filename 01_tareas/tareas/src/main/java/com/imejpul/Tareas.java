package com.imejpul;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tareas {
    private JList list1;
    private JButton completarButton;
    private JTextField textFieldNuevaTarea;
    private JButton almacenarNuevaTareaButton;
    private JPanel tareas;

    private List<String> listaTareas;
    private DefaultListModel listModel;

    public Tareas() {

        //inicializaciones
        listaTareas = new ArrayList<>();
        listModel = new DefaultListModel();

        //añadir aquí la serialización al abrir

        completarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //obtengo el índice del elemento seleccionado
                int index = list1.getSelectedIndex();

                //obtener la tarea a completar

                for (String t : listaTareas) {
                    if (t.equals(listModel.getElementAt(index))) {
                        listaTareas.remove(t);
                    }
                }
                listModel.remove(index);

                //llamo de nuevo a la función de mostrar elemntos del JList
                mostrarTareas();

            }
        });
        almacenarNuevaTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //obtener el texto de la tarea nueva de textFieldNuevaTarea
                String tareaNueva = textFieldNuevaTarea.getText();

                //añadirlo al arrayList de tareas
                listaTareas.add(tareaNueva);

                //actualizar visualización llamando a la función de mostrar elementos del JList
                mostrarTareas();

            }
        });

        //manejo del JList
        list1.setModel(listModel);

    }

    private void mostrarTareas() {

        listModel.clear();

        for (String t : listaTareas) {
            listModel.addElement(t);
        }

    }
}
