package it.polito.tdp.genes.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.genes.model.Adiacenza;
import it.polito.tdp.genes.model.Genes;
import it.polito.tdp.genes.model.Interactions;


public class GenesDao {
	
	public List<Adiacenza> getAdiacenze(){
		
		String sql = "select  c1.localization as l1, c2.localization as l2, count(distinct i.type) as peso "
				+ "from classification c1, classification c2, interactions i "
				+ "where c1.localization < c2.localization "
				+ "and c1.geneID <> c2.geneID "
				+ "and ((c1.geneID = i.geneID1 && c2.geneID = i.geneID2) || (c2.geneID = i.geneID1 && c1.geneID = i.geneID2)) "
				+ "group by l1,l2 ";
		
		List<Adiacenza> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				
				Adiacenza s = new Adiacenza(res.getString("l1"),res.getString("l2"),res.getDouble("peso"));
				result.add(s);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	
	public List<String> getVertici(){
		String sql = " select distinct localization "
				+ "from classification "
				+ "order by localization asc ";
						
		
		List<String> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				String s = new String(res.getString("localization"));
				
				result.add(s);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	public List<Genes> getAllGenes(){
		String sql = "SELECT DISTINCT GeneID, Essential, Chromosome FROM Genes";
		List<Genes> result = new ArrayList<Genes>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	


	
}
