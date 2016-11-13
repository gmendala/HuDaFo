package com.gmitdesign.input;

import java.util.Arrays;
import java.util.List;

import com.gmitdesign.base.GeneratorInput;

public class SimpleTestGeneratorInput implements GeneratorInput<String> {

	private String[] table = {"Andrew", "Barbara", "Camille", "Daniel", "Eugene", 
			"Francis", "Gary", "Hugh", "Ingrid", "Jacob", "Kate", "Ludvig", "Mark", 
			"Norman", "Otis", "Penelope", "Quentin", "Robert", "Samantha", "Toby", 
			"Ulrich", "Vladimir", "Walter", "Zenon"};
	
	
	
	public List<String> getInputForTheGenerator() {
		return Arrays.asList(table);
	}

}
