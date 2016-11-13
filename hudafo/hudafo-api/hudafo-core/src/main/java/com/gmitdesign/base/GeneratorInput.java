package com.gmitdesign.base;

import java.util.List;


/**
 * An interface for any type of input that will be used by generator with input.
 * @author grzegorz
 *
 */
public interface GeneratorInput <T> {

	/**
	 * This is the method that should return a list of elements that will be feeding the generator.
	 * For example you can have a class implementing this interface and this method could then
	 * return a list of Strings. If this input would generate a list of names, then we would have a full list of them.
	 * With that list the generator could simply choose just one of them for each output. 
	 * That would be simple name generator feeding from an input implementing this interface.
	 * @return
	 */
	List<T> getInputForTheGenerator();
	
	
}
