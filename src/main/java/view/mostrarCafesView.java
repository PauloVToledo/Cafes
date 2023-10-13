package view;

import model.Cafe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class mostrarCafesView extends JFrame{
    private JTable table1;
    private JPanel panel;

    public mostrarCafesView(ArrayList<Cafe> cafes) {
        setContentPane(panel);
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cafes");
        crearTabla(cafes);

    }
    public void crearTabla(ArrayList<Cafe> cafes){
        Object[][] datos = new Object[cafes.size()][4];
        for (int i = 0; i <cafes.size(); i++) {
            Cafe cafe=cafes.get(i);
            datos[i][0]=cafe.getGCafe();
            datos[i][1]=cafe.getMmAgua();
            datos[i][2]=cafe.getSize();
            datos[i][3]=cafe.getOptIngrediente();

        }

        table1.setModel(new DefaultTableModel(
                datos,
                new String[]{"Gramos Cafe","mm Agua","Tamaño","Ingrediente opcional"}
        ));
    }
}
