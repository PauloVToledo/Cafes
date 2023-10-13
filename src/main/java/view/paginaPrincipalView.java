package view;

import controller.cafeteriaController;
import model.Cafeteria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paginaPrincipalView extends JFrame{
    private JButton agregarCafeButton;
    private JButton eliminarCafeButton;
    private JButton modificaDatosCafeteriaButton;
    private JPanel panel;
    private JButton mostrarTodosLosCafesButton;

    public paginaPrincipalView(){
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450, 600);
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pagina principal");
        actionListeners();
    }
    public void actionListeners(){
        agregarCafeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new agregarCafeView();
                dispose();
            }
        });
        eliminarCafeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new eliminarCafeView();
                dispose();
            }
        });
        modificaDatosCafeteriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mostrarTodosLosCafesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mostrarCafesView(new cafeteriaController().obtenerCafes());
            }
        });

    }
}