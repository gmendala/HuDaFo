package com.gmitdesign.generators;

import java.util.Date;
import java.util.List;

import com.gmitdesign.base.GeneratorBase;
import com.gmitdesign.base.GeneratorOutput;

public class PeselGenerator extends GeneratorBase<String> {

	private Date birthdate;
	private GenderType gender;
	
	public PeselGenerator(GeneratorOutput output, Date birthdate, GenderType gender) {
		super(output);
		this.birthdate = birthdate;
		this.gender = gender;
	}
	
	@Override
	public List<String> processTheData() {
		//String year = Calendar.
		return null;
	}

}
