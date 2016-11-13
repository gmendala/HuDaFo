package com.gmitdesign.base;

import java.util.List;


/**
 * An interface for any type of output used by generators.
 * @author grzegorz
 *
 */
public interface GeneratorOutput {

	public <T> void dispatchGeneratedData(List<T> data);
	
}
