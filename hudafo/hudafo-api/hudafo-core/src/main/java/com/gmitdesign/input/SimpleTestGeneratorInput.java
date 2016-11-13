package com.gmitdesign.input;

import java.util.Arrays;
import java.util.List;

import com.gmitdesign.base.GeneratorInput;

/**
 * This simple test input is used as a feed for some generator. This particular GeneratorInput
 * contains names that some generator can use to process. For example one generator can take this list
 * and randomly choose one of them.
 * @author grzegorz
 *
 */
public class SimpleTestGeneratorInput implements GeneratorInput<String> {

	private String[] table = {"Andrew", "Barbara", "Camille", "Daniel", "Eugene", 
			"Francis", "Gary", "Hugh", "Ingrid", "Jacob", "Kate", "Ludvig", "Mark", 
			"Norman", "Otis", "Penelope", "Quentin", "Robert", "Samantha", "Toby", 
			"Ulrich", "Vladimir", "Walter", "Zenon"};
	
	
	/**
	 * Returns the list of names that has been statically specified and hard coded into this class.
	 * The resulting list contains both male and female names.
	 */
	public List<String> getInputForTheGenerator() {
		return Arrays.asList(table);
	}

}
