package src.br.com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.br.com.jdbc.ConnectionFactory;
import src.br.com.model.Endereco;
import src.br.com.model.Hospede;

public class HospedeDao implements EntidadeDao {

	private Connection connection;

	public HospedeDao() {

		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Object obj) {
		Hospede hospede = (Hospede) obj;
		try {
			PreparedStatement ps = this.connection
					.prepareStatement("DELETE FROM HOSPEDE WHERE IN_HOSPEDE_ID=?");
			ps.setInt(1, hospede.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* Método que retorna o hóspede pelo código */
	public Object find(int id) {
		Hospede hospede = new Hospede();
		Endereco endereco = new Endereco();
		hospede.setEndereco(endereco);
		try {
			PreparedStatement ps = this.connection
					.prepareStatement("SELECT * FROM HOSPEDE WHERE IN_HOSPEDE_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hospede.setId(id);
				hospede.setNome(rs.getString("VA_NOME"));
				hospede.setFoneContato(rs.getString("VA_FONERESIDENCIAL"));
				hospede.setFoneResidencial(rs.getString("VA_FONECONTATO"));
				hospede.setDataNascimento(rs.getDate("DT_DATANASCIMENTO"));
				hospede.getEndereco().setLogradouro(rs.getString("VA_LOGRADOURO"));
				hospede.getEndereco().setBairro(rs.getString("VA_BAIRRO"));
				hospede.getEndereco().setEstado(rs.getString("VA_ESTADO"));
				hospede.getEndereco().setCep(rs.getString("VA_CEP"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospede;
	}

	public List list() {
		List<Hospede> hospedes = new ArrayList<Hospede>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM HOSPEDE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hospede hospede = new Hospede(rs.getInt("IN_HOSPEDE_ID"), rs.getString("VA_NOME"));
				Endereco endereco = new Endereco();
				endereco.setLogradouro(rs.getString("VA_LOGRADOURO"));
				endereco.setBairro(rs.getString("VA_BAIRRO"));
				endereco.setEstado(rs.getString("VA_ESTADO"));
				endereco.setCep(rs.getString("VA_CEP"));
				hospede.setEndereco(endereco);
				hospede.setFoneResidencial(rs.getString("VA_FONERESIDENCIAL"));
				hospede.setFoneContato(rs.getString("VA_FONECONTATO"));
				hospedes.add(hospede);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospedes;

	}

	public List list(String nome){
		List<Hospede> hospedes = new ArrayList<Hospede>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM HOSPEDE WHERE VA_NOME LIKE ?");
			ps.setString(1, nome + '%');
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hospede hospede = new Hospede(rs.getInt("IN_HOSPEDE_ID"), rs.getString("VA_NOME"));
				Endereco endereco = new Endereco();
				endereco.setLogradouro(rs.getString("VA_LOGRADOURO"));
				endereco.setBairro(rs.getString("VA_BAIRRO"));
				endereco.setEstado(rs.getString("VA_ESTADO"));
				endereco.setCep(rs.getString("VA_CEP"));
				hospede.setEndereco(endereco);
				hospede.setFoneResidencial(rs.getString("VA_FONERESIDENCIAL"));
				hospede.setFoneContato(rs.getString("VA_FONECONTATO"));
				hospedes.add(hospede);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospedes;

	}

	/* Método que atualiza os dados do hóspede na base. */
	private void update(Hospede hospede) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE HOSPEDE SET " + "VA_NOME=?, "
							+ "VA_LOGRADOURO=?, " + "VA_BAIRRO=?, "
							+ "VA_ESTADO=?, " + "VA_CEP=?, "
							+ "VA_FONERESIDENCIAL=?, " + "VA_FONECONTATO=? " +
							// "DT_DATANASCIMENTO=? "+
							"WHERE IN_HOSPEDE_ID=?");
			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getEndereco().getLogradouro());
			ps.setString(3, hospede.getEndereco().getBairro());
			ps.setString(4, hospede.getEndereco().getEstado());
			ps.setString(5, hospede.getEndereco().getCep());
			ps.setString(6, hospede.getFoneResidencial());
			ps.setString(7, hospede.getFoneContato());
			//ps.setDate(9, hospede.getDataNascimento());
			ps.setInt(8, hospede.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insert(Hospede hospede) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO HOSPEDE (" + "VA_NOME, "
							+ "VA_LOGRADOURO, " + "VA_BAIRRO, " + "VA_ESTADO, "
							+ "VA_CEP, " + "VA_FONERESIDENCIAL, "
							+ "VA_FONECONTATO) VALUES(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getEndereco().getLogradouro());
			ps.setString(3, hospede.getEndereco().getBairro());
			ps.setString(4, hospede.getEndereco().getEstado());
			ps.setString(5, hospede.getEndereco().getCep());
			ps.setString(6, hospede.getFoneResidencial());
			ps.setString(7, hospede.getFoneContato());
			// ps.setDate(4, hospede.getDataNascimento());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save(Object obj) {
		Hospede hospede = (Hospede) obj;
		if (hospede.getId() == 0)
			insert(hospede);
		else
			update(hospede);

	}
}
