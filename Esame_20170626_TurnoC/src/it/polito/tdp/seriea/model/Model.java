package it.polito.tdp.seriea.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.seriea.db.SerieADAO;

public class Model {
	
	private DirectedWeightedPseudograph<Integer, DefaultWeightedEdge> grafo; //cambiare il tipo di grafo usare il cappio
	private Map<Integer, Integer> idMap;
	
	public Model() {
		grafo = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
		idMap = new HashMap<>();
	}

	public String creaGrafo() {
		String risultato="";
		SerieADAO dao = new SerieADAO();
		dao.getGoalCasa(idMap);
		List<RisultatoPartita> risultati = dao.getRisultatiPartite(idMap);
		Graphs.addAllVertices(grafo, idMap.values());
		for(RisultatoPartita rp: risultati) {
			if(!grafo.containsVertex(rp.getRisultato1())) {
				grafo.addVertex(rp.getRisultato1());
			}
			if(!grafo.containsVertex(rp.getRisultato2())) {
				grafo.addVertex(rp.getRisultato2());
			}
			
			DefaultWeightedEdge edge = grafo.getEdge(rp.getRisultato1(), rp.getRisultato2());
			if(edge==null) {
					Graphs.addEdgeWithVertices(grafo, rp.getRisultato1(), rp.getRisultato2(), rp.getPeso());
				}
			}
		risultato+="Grafo creato! Vertici: "+grafo.vertexSet().size()+" Archi: "+grafo.edgeSet().size()+"\n";
		return risultato;
	}

	public List<Integer> getVertici() {
		SerieADAO dao = new SerieADAO();
		List<Integer> vertici = new LinkedList<>(grafo.vertexSet());
		return vertici;
	}

	public String getRisultati(Integer numGoalCasa) {
		String risultato="";
		SerieADAO dao = new SerieADAO();
		List<Risultato> risultati = dao.getRisultati(idMap, numGoalCasa);
		for(Risultato r: risultati) {
			risultato+=r.getGoal1()+" - "+r.getGoal2()+" Partite con questo risultato: "+r.getCnt()+"\n";
		}
		return risultato;
	}

}
