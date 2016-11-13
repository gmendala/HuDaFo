package com.gmitdesign.base;


/**
 * Extension for the abstract generator class. This should be inherited by any generator
 * that uses any form of input data. You can define for example an input that will be a 
 * list of items coming from database query, from a file or simply from a hard-coded table.
 * @author grzegorz
 * @param <T>
 *
 */
public abstract class GeneratorBaseWithInput<T> extends GeneratorBase<T> {

	/**
	 * An Input used by inheriting processors of the generator. The generated output
	 * is defined by the generator method - processTheData() - describing the rules used on this input.
	 */
	private GeneratorInput<T> input;
	
	/**
	 * Extended constructor. It defines both input and output data.
	 * @param output - is used as a destination point of generated data - for example console, file, database table.
	 * @param input - is a list of data to be used by the generator in order to generate data that is sent 
	 * to the output.
	 */
	public GeneratorBaseWithInput(GeneratorOutput output, GeneratorInput<T> input) {
		super(output);
		this.input = input;
	}
	
	/**
	 * Extended constructor. It defines both input and output data and the implementation identifier
	 * known as the generator name.
	 * @param output - is used as a destination point of generated data - for example console, file, database table.
	 * @param input - is a list of data to be used by the generator in order to generate data that is sent 
	 * to the output.
	 * @param name - generator unique name.
	 */
	public GeneratorBaseWithInput(GeneratorOutput output, GeneratorInput<T> input, String name) {
		super(output, name);
		this.input = input;
	}

	/**
	 * Gets the input interface for this generator.
	 * @return
	 */
	public GeneratorInput<T> getInput() {
		return input;
	}
}
