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

/**
 * This generator creates a list of randomly generated dates for an adults. There is no input because everything is 
 * generated inside this class. The only thing that user needs to specify is the number of results
 * in the output list.
 * @author grzegorz
 *
 */
public class BirthDateGenerator extends GeneratorBase<Date> {

	/** Number of results in output list. **/
	private int numberOfResults;
	/** Specified adult age **/
	private static final int ADULT_AGE = 18;
	/** Formatter to clean the Date format **/
	private static final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Constructs this generator using supported output and a number of results in the output.
	 * @param output - the results will appear in this implementation of the GeneratorOutput interface.
	 * @param numberOfResults - number of results that will be generated.
	 */
	public BirthDateGenerator(GeneratorOutput output, int numberOfResults) {
		super(output);
		this.numberOfResults = numberOfResults;
	}

	@Override
	public List<Date> processTheData() {
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
					dates.add((Date) formatter.parse(formatter.format(result.getTime())));
				} catch (ParseException e) {
					e.printStackTrace();
				}	
			}
		}
		return dates;
	}
}
