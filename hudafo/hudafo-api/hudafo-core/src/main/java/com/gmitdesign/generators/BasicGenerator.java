package com.gmitdesign.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmitdesign.base.GeneratorBaseWithInput;
import com.gmitdesign.base.GeneratorInput;
import com.gmitdesign.base.GeneratorOutput;

/**
 * This is a basic generator that accept input data and randomly choose one of the elements of the input 
 * and send it to the output as a one element list. This class is an extension to GeneratorBaseWithInput and 
 * @author grzegorz
 * @param <T> - type of input.
 *
 */
public class BasicGenerator<T> extends GeneratorBaseWithInput<T>{

	/**
	 * Basic constructor. Takes input of type <T> and use it to randomly generate one result
	 * that will be put into output.
	 * @param output - defined output as an implementation of a GeneratorOutput interface.
	 * @param input - implementation of the GeneratorInput interface of type <T>.
	 */
	public BasicGenerator(GeneratorOutput output, GeneratorInput<T> input) {
		super(output, input);
	}
	
	/**
	 * Basic constructor. Takes input of type <T> and use it to randomly generate one result
	 * that will be put into output.
	 * @param output - defined output as an implementation of a GeneratorOutput interface.
	 * @param input - implementation of the GeneratorInput interface of type <T>.
	 * @param name - name of the implemented generator.
	 */
	public BasicGenerator(GeneratorOutput output, GeneratorInput<T> input, String name) {
		super(output, input, name);
	}

	/**
	 * Process the input and randomly takes one of the values and return it.
	 * @param list - list of elements that counts as an input.
	 * @return - one element list that is randomly chosen from the input elements.
	 */
	private List<T> processTheData(List<T> list) {
		Random rnd = new Random();
		int index = rnd.nextInt(list.size());
		List<T> result = new ArrayList<T>();
		result.add(list.get(index));
		return result;
	}

	@Override
	public List<T> processTheData() {
		return processTheData(this.getInput().getInputForTheGenerator());
	}

}
