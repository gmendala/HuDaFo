package com.gmitdesign.output;

import java.util.List;

import com.gmitdesign.base.GeneratorOutput;

public class ConsoleGeneratorOutput implements GeneratorOutput {

	
	public <T> void dispatchGeneratedData(List<T> data) {

		for (T currentData : data) {
			System.out.println(currentData);
		}

	}

}
