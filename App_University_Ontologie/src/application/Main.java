package application;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;

import tools.JenaEngine;

public class Main {
	/**
	 * @param args
	 *            the command line arguments
	 */
		public static void main(String[] args) {
	String NS = "";
		// lire le model a partir d'une ontologie
		OntModel model = (OntModel) JenaEngine.readModel("data/proj_version2.owl");
		if (model != null) {
			//lire le Namespace de l’ontologie
			NS = model.getNsPrefixURI("");
			
			// apply our rules on the owlInferencedModel
			//Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
			// query on the model after inference
		    System.out.println(JenaEngine.executeQueryFile(model,
				"data/query.txt"));
		} else {
			System.out.println("Error when reading model from ontology");
		}
	}
}

