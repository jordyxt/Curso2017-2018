package application;

import java.util.LinkedList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import javafx.scene.image.Image;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

public class QuerySearch {

	public static String createQuery(String name, String district, boolean free, boolean lon, boolean mo, boolean tu,
			boolean we, boolean th, boolean fr, boolean sa, boolean su) {
		//TODO
		return null;
	}

	public static LinkedList<Event> executeQuery(String query){
		LinkedList<Event> resultslist = new LinkedList<Event>();
		//TODO
		//La comprobacion se hizo en la connectToData
		//por tanto no hacemos un try-catch
		String url = "jdbc:virtuoso://localhost:1111";
		VirtGraph set = new VirtGraph("http://localhost:8890/datosevento",url, "dba", "dba");	
		Query sparql = QueryFactory.create(query);
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
		ResultSet results = vqe.execSelect();
		while (results.hasNext()) {
			QuerySolution result = results.nextSolution();
		    RDFNode name = result.get("name");
		    RDFNode description = result.get("description");
		    RDFNode uriToLocation = result.get("location");
		    resultslist.add(new Event(name.toString(), description.toString(), uriToLocation.toString())) ;
		}
		return resultslist;
	}
	
	public static Image getMapImage(String locationURI){
		//TODO
		return null;
	}


}
