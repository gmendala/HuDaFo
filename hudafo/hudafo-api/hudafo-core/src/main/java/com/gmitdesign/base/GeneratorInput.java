package com.gmitdesign.base;

import java.util.List;


/**
 * An interface for any type of input that will be used by generator with input.
 * @author grzegorz
 *
 */
public interface GeneratorInput {

	<T> List<T> getInputForTheGenerator();
	
	
}
