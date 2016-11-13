package com.gmitdesign.base;

import java.util.List;


/**
 * An interface for any type of output used by generators.
 * @author grzegorz
 *
 */
public interface GeneratorOutput {

	/**
	 * This method should take a list of T and transform it to a format 
	 * specified by the implementation. Then it should be sent to a 
	 * defined destination. This means that for example data can be transformed
	 * into a list of strings and sent to a console output or file or database table - you name it.
	 * @param data - data incoming from a generator in a form of a list.
	 */
	public <T> void dispatchGeneratedData(List<T> data);
	
}
