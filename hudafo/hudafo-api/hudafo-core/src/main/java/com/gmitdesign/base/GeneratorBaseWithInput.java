package com.gmitdesign.base;


/**
 * Extension for the abstract generator class. This should be inherited by any generator
 * that uses any form of input data. You can define for example an input that will be a 
 * list of items coming from database query, from a file or simply from a hard-coded table.
 * @author grzegorz
 *
 */
public abstract class GeneratorBaseWithInput extends GeneratorBase {

	private GeneratorInput input;
	

	public GeneratorBaseWithInput(GeneratorOutput output, GeneratorInput input) {
		super(output);
		this.input = input;
	}
	
	public GeneratorBaseWithInput(GeneratorOutput output, GeneratorInput input, String name) {
		super(output, name);
		this.input = input;
	}

	public GeneratorInput getInput() {
		return input;
	}
}
