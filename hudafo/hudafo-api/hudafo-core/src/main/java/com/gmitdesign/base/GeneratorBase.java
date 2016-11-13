package com.gmitdesign.base;

import java.util.List;
import com.gmitdesign.base.GeneratorOutput;

/**
 * Base for generator classes. You should use it by inheriting it into more complex and
 * strictly defined generator class. Every time a generator will create a list of processed data by
 * the usage of processTheData method, you should use generate method to simply send that list into 
 * output connected to the generator.
 * @author grzegorz
 *
 */
public abstract class GeneratorBase<T> {

	/** Output that will be used for generated data **/
	private GeneratorOutput output;
	/** Utility name of the implemented generator. **/
	private String name;
	
	/**
	 * Constructor with defined output interface.
	 * @param output - this is an interface designed to take generated data and 
	 * dispatch it to designed destination. Destination can be defined as console, file,
	 * database and others.
	 */
	public GeneratorBase(GeneratorOutput output){
		this.output = output;
		
	}
	
	/**
	 * Constructor with defined output interface and implementation name.
	 * @param output - this is an interface designed to take generated data and 
	 * dispatch it to designed destination. Destination can be defined as console, file,
	 * database and others.
	 * @param name - specific name used to identify the exact implementation of the generator.
	 */
	public GeneratorBase(GeneratorOutput output, String name){
		this.output = output;
		this.name = name;		
	}
	
	/**
	 * This is the main method for data generation. It creates output as a list of T.
	 * In this method, you should write down everything that generator should do to
	 * return a list of generated data. You should remember, that in implementation this will create 
	 * raw list of data (if you need it), but generators are designed to return data to
	 * their defined output, so we recommend to use generate() method.
	 * @return A list of T after the process of data generation.
	 */
	public abstract List<T> processTheData();
	
	/**
	 * Main method of this generator. Invoking it will generate data and send it to defined output.
	 * You should use it as an implementation method for generating data and sending it to the output.
	 */
	public void generate(){
		output.dispatchGeneratedData(processTheData());
	}

	/**
	 * Gets the name defined for implementation of this generator.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this generator.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}