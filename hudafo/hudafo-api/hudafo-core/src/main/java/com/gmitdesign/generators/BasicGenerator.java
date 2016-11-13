package com.gmitdesign.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmitdesign.base.GeneratorBaseWithInput;
import com.gmitdesign.base.GeneratorInput;
import com.gmitdesign.base.GeneratorOutput;

public class BasicGenerator extends GeneratorBaseWithInput{


	public BasicGenerator(GeneratorOutput output, GeneratorInput input) {
		super(output, input);
	}
	
	public BasicGenerator(GeneratorOutput output, GeneratorInput input, String name) {
		super(output, input, name);
	}

	private List<String> processTheData(List<Object> list) {
		Random rnd = new Random();
		int index = rnd.nextInt(list.size());
		List<String> result = new ArrayList<String>();
		result.add((String) list.get(index));
		return result;
	}

	@Override
	public List<String> processTheData() {
		return processTheData(this.getInput().getInputForTheGenerator());
	}

}
