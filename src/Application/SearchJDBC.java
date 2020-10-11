package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class SearchJDBC {

	private Connection conn;

	public SearchJDBC(Connection c) {
		this.conn = c;
	}

	public void Insert(Search busca) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("INSERT INTO tb_scrap (titulo,Link,descricaoPost,URLDownload) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, busca.getTitulo());
			ps.setString(2, busca.getLinks());
			ps.setString(3, busca.getDescricaoPost());
			ps.setString(4, busca.getURLDownload());

			int linhasAfetadas = ps.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Inserido com sucesso!");
			} else {
				System.out.println("Algo errado! Nenhuma linha foi afetada.");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}

	}
}
