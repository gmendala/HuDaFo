package com.gmitdesign.output;

import java.util.List;

import com.gmitdesign.base.GeneratorOutput;

/**
 * Simple output that gets the list of processed data and sends its elements to the console. 
 * For each element being sent to the console, their toString() method is used as an output information being sent to console.
 * @author grzegorz
 *
 */
public class ConsoleGeneratorOutput implements GeneratorOutput {

	public <T> void dispatchGeneratedData(List<T> data) {

		for (T currentData : data) {
			System.out.println(currentData);
		}

	}

}
