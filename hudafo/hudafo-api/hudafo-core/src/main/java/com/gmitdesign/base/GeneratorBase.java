package com.gmitdesign.base;

import java.util.List;

/**
 * Base for generator classes. You should use it by inheriting it into more complex and
 * strictly defined generator class. Every time a generator will create a list of processed data by
 * the usage of processTheData method, you should use generate method to simply send that list into 
 * output connected to the generator.
 * @author grzegorz
 *
 */
public abstract class GeneratorBase {

	private GeneratorOutput output;
	private String name;
	
	public GeneratorBase(GeneratorOutput output){
		this.output = output;
		
	}
	
	public GeneratorBase(GeneratorOutput output, String name){
		this.output = output;
		this.name = name;		
	}
	
	public abstract <T> List<T> processTheData();
	
	public void generate(){
		output.dispatchGeneratedData(processTheData());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}