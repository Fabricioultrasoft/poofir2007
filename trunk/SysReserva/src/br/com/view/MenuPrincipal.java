package src.br.com.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import src.br.com.jdbc.dao.HospedeDao;
import src.br.com.model.Hospede;

public class MenuPrincipal extends JFrame {

	public MenuPrincipal(){
		super("SysReserva");
		JMenuItem cadastrarHospede;
		JMenu menuCadastro = new JMenu("Cadastro");
		JMenuBar menuBar = new JMenuBar();
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		cadastrarHospede = new JMenuItem("Hóspede");
		ActionHospede ah = new ActionHospede();
		cadastrarHospede.addActionListener(ah);
		menuCadastro.add(cadastrarHospede);
		menuBar.add(menuCadastro);
		container.add(menuBar);

		setSize(980, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ActionHospede implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HospedeDao hospedeDao = new HospedeDao();
			Hospede hospede = (Hospede) hospedeDao.find(1);
			HospedeView hospedeView = new HospedeView(hospede);
		}

	}

}
