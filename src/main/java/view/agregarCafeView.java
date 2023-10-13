package view;

import controller.cafeteriaController;
import model.Cafe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class agregarCafeView extends JFrame{

	private JTextField gCafeTextField;
	private JTextField mmAguaTextField;
	private JTextField sizeTextField;
	private JComboBox comboBox;
	private JButton cancelarButton;
	private JButton agregarButton;
	private JComboBox sizeComboBox;
	private JPanel panel;

	public agregarCafeView() {
		setLocationRelativeTo(null); // Centramos la ventana en la pantalla
		setSize(450, 600);
		setContentPane(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pagina principal");
		ActionListeners();
	}

	public void ActionListeners() {
		agregarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int gramos=Integer.parseInt(
						!gCafeTextField.getText().matches("[0-9]+")?"0":gCafeTextField.getText());
				int mmAgua=Integer.parseInt(
						!mmAguaTextField.getText().matches("[0-9]+")?"0":mmAguaTextField.getText());
				String size= Objects.requireNonNull(sizeComboBox.getSelectedItem()).toString();
				String ingredienteExtra= Objects.requireNonNull(comboBox.getSelectedItem()).toString();
				if(gramos>0 && !size.isEmpty() && mmAgua>0 && !ingredienteExtra.isEmpty()){
					cafeteriaController cafeteriaController=new cafeteriaController();
					boolean results=cafeteriaController.agregarCafe(new Cafe(gramos,mmAgua,size,ingredienteExtra));
					if(results){
						JOptionPane.showMessageDialog(null,"Se agrego correctamente");
					}else{
						JOptionPane.showMessageDialog(null,"Ha ocurrido un problema");
					}
				}
			}
		});
		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new paginaPrincipalView();
				dispose();
			}
		});
	}
}