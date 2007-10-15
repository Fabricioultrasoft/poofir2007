package src.br.com.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.br.com.controller.HospedeController;
import src.br.com.model.Hospede;

public class HospedeView extends JFrame {
	private JTextField txtNome, txtLogradouro, txtBairro, txtCep,
			txtFoneResidencial, txtFoneContato;

	private JComboBox cbxEstado;

	private JFormattedTextField txtDataNascimento;

	JButton btnSalvar;

	private Container container;

	private Hospede hospede;

	public HospedeView(Hospede hospede) {
		super("Cadastro de Hospede");
		this.hospede = hospede;
		// Cria os objetos do frame.
		this.container = getContentPane();
		txtNome = new JTextField(83);
		txtLogradouro = new JTextField(80);
		txtBairro = new JTextField(46);
		cbxEstado = getEstados();
		txtCep = new JTextField(15);
		txtFoneResidencial = new JTextField(15);
		txtFoneContato = new JTextField(15);
		txtDataNascimento = new JFormattedTextField(new SimpleDateFormat(
				"dd/MM/yyyy"));
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionSave());
		init();
	}

	private void init() {

		// Input de nome.
		txtNome.setText(hospede.getNome());
		container.add(new JLabel("Nome:"));
		container.add(txtNome);

		// Inpute de logradouro.
		txtLogradouro.setText(hospede.getEndereco().getLogradouro());
		container.add(new JLabel("Logradouro:"));
		container.add(txtLogradouro);

		// Input de bairro.
		txtBairro.setText(hospede.getEndereco().getBairro());
		container.add(new JLabel("Bairro:"));
		container.add(txtBairro);

		// Input de estado.
		container.add(new JLabel("Estado:"));
		container.add(cbxEstado);

		// Input de cep.
		txtCep.setText(hospede.getEndereco().getCep());
		container.add(new JLabel("CEP:"));
		container.add(txtCep);

		// Input de fone residencial.
		txtFoneResidencial.setText(hospede.getFoneResidencial());
		container.add(new JLabel("Fone residencial:"));
		container.add(txtFoneResidencial);

		// Input de fone para contato.
		txtFoneContato.setText(hospede.getFoneContato());
		container.add(new JLabel("Fone para contato:"));
		container.add(txtFoneContato);

		// Input de data de nascimento.
		// txtDataNascimento.setText(hospede.getDataNascimento());
		container.add(new JLabel("Data de Nascimento"));
		container.add(txtDataNascimento);
		container.add(btnSalvar);

		// Definindo os layouts.
		container.setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(980, 200);
		setVisible(true);
	}

	private JComboBox getEstados() {
		DefaultComboBoxModel cbxEstadoModel = new DefaultComboBoxModel();
		JComboBox estados = new JComboBox(cbxEstadoModel);
		cbxEstadoModel.addElement(new String("Acre"));
		cbxEstadoModel.addElement(new String("Alagoas"));
		cbxEstadoModel.addElement(new String("Amapá"));
		cbxEstadoModel.addElement(new String("Amazonas"));
		cbxEstadoModel.addElement(new String("Bahia"));
		cbxEstadoModel.addElement(new String("Ceará"));
		cbxEstadoModel.addElement(new String("Distrito Federal"));
		cbxEstadoModel.addElement(new String("Espírito Santo"));
		cbxEstadoModel.addElement(new String("Goias"));
		cbxEstadoModel.addElement(new String("Maranhão"));
		cbxEstadoModel.addElement(new String("Minas Gerais"));
		cbxEstadoModel.addElement(new String("Mato Grosso do Sul"));
		cbxEstadoModel.addElement(new String("Mato Grosso"));
		cbxEstadoModel.addElement(new String("Pará"));
		cbxEstadoModel.addElement(new String("Paraíba"));
		cbxEstadoModel.addElement(new String("Pernambuco"));
		cbxEstadoModel.addElement(new String("Piauí"));
		cbxEstadoModel.addElement(new String("Paraná"));
		cbxEstadoModel.addElement(new String("Rio de Janeiro"));
		cbxEstadoModel.addElement(new String("Rio Grande do Norte"));
		cbxEstadoModel.addElement(new String("Rio Grande do Sul"));
		cbxEstadoModel.addElement(new String("Rondônia"));
		cbxEstadoModel.addElement(new String("Roraima"));
		cbxEstadoModel.addElement(new String("Santa Catarina"));
		cbxEstadoModel.addElement(new String("Sergipe"));
		cbxEstadoModel.addElement(new String("São Paulo"));
		cbxEstadoModel.addElement(new String("Tocantins"));
		return estados;
	}

	class ActionSave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame("Teste");
			HospedeController hospedeController = new HospedeController();
			hospede.setNome(txtNome.getText());
			hospede.getEndereco().setLogradouro(txtLogradouro.getText());
			hospede.getEndereco().setBairro(txtBairro.getText());
			hospede.getEndereco().setCep(txtCep.getText());
			hospede.setFoneResidencial(txtFoneResidencial.getText());
			hospede.setFoneContato(txtFoneContato.getText());
			hospedeController.salvarHospede(hospede);
		}
	}

}
