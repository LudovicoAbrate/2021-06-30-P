package it.polito.tdp.genes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {

	private Graph<String,DefaultWeightedEdge> grafo;
	
	Map<String,String> idMap;
	GenesDao dao;
	
	
	
	public Model() {
		this.idMap= new HashMap<>();
		this.dao = new GenesDao();
	}
	
	public void creaGrafo() {
		
		
		
		idMap.clear();
		for(String s : dao.getVertici()) {
			idMap.put(s,s);
		}
		
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, this.dao.getVertici());

		for (Adiacenza a : dao.getAdiacenze()) {
			
			if(idMap.containsKey(a.loca1) && idMap.containsKey(a.loca2))
			Graphs.addEdgeWithVertices(this.grafo, a.loca1, a.loca2, a.p);
		}
	
	}
	
	public List<ArchiAdiacenti> getLocalizzazioniConnesse(String localizzazione){
		
		List<ArchiAdiacenti> atemp = new ArrayList<>();
		
			List<String> vicini = Graphs.successorListOf(this.grafo, localizzazione);
			
			for( String s : vicini) {
				
				atemp.add(new ArchiAdiacenti(s, this.grafo.getEdgeWeight(this.grafo.getEdge(localizzazione,s))));
				
			}
		
		
		return atemp;
		
		
	}
	
	public int getArchi() {
		return this.grafo.edgeSet().size();
	}
	public int getVertici() {
		return this.grafo.vertexSet().size();
		
	}

	public List<String> getLocalizzazioni() {
		// TODO Auto-generated method stub
		return this.dao.getVertici();
	}
}