package view;

import controller.cafeteriaController;
import model.Cafe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class eliminarCafeView extends JFrame {

	private JButton cancelarButton;
	private JButton eliminarButton;
	private JComboBox comboBox1;
	private JPanel panel;

	public eliminarCafeView()  {
		setLocationRelativeTo(null); // Centramos la ventana en la pantalla
		setSize(450, 600);
		setContentPane(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Eliminar Cafes");
		ActionListeners();	}

	public void ActionListeners() {
		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new paginaPrincipalView();
				dispose();
			}
		});
		eliminarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] cafe= Objects.requireNonNull(comboBox1.getSelectedItem()).toString().split(",");
				cafeteriaController cafeteriaController=new cafeteriaController();
				boolean result=cafeteriaController.eliminarCafe(new Cafe(Integer.parseInt(cafe[0]),Integer.parseInt(cafe[1]),cafe[2],cafe[3]));
				if(result){
					JOptionPane.showMessageDialog(null,"Se elimino correctamente");
				}else{
					JOptionPane.showMessageDialog(null,"Ha ocurrdo un problema");
				}
			}
		});
	}

	public void inicializarComboBox() {
		cafeteriaController cafeteriaController=new cafeteriaController();
		ArrayList<Cafe> cafes= cafeteriaController.obtenerCafes();
		for (int i = 0; i <cafes.size() ; i++) {
			comboBox1.addItem(cafes.get(i));
		}
	}
}