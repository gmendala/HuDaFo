package com.gmitdesign.generators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.gmitdesign.base.GeneratorBase;
import com.gmitdesign.base.GeneratorOutput;

public class BirthDateGenerator extends GeneratorBase {

	private int numberOfResults;
	private static final int ADULT_AGE = 18;
	private static final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	
	
	public BirthDateGenerator(GeneratorOutput output, int numberOfResults) {
		super(output);
		this.numberOfResults = numberOfResults;
	}

	@Override
	public <T> List<T> processTheData() {
		List<Date> dates = new ArrayList<Date>();
		Random rnd = new Random();
		if(this.numberOfResults > 0){
			for (int i = 0; i < this.numberOfResults; i++) {
				Calendar result = Calendar.getInstance();
				int year = result.get(Calendar.YEAR)  - rnd.nextInt(60) - ADULT_AGE; 
				result.set(Calendar.YEAR, year);
				result.set(Calendar.MONTH, rnd.nextInt(12));
				int day = rnd.nextInt(result.getMaximum(Calendar.DATE)) + 1 ;
				result.set(Calendar.DATE, day);
				try {
					dates.add(formatter.parse(formatter.format(result.getTime())));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
						
			}
		}
		return (List<T>) dates;
	}

}
