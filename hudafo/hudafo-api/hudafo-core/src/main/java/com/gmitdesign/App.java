package com.gmitdesign;

import com.gmitdesign.base.GeneratorOutput;
import com.gmitdesign.generators.BirthDateGenerator;
import com.gmitdesign.output.ConsoleGeneratorOutput;

/**
 * This is basic application class for personal information generation.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	GeneratorOutput out = new ConsoleGeneratorOutput();
    	/*GeneratorInput in = new SimpleTestGeneratorInput();
        BasicGenerator basicGen = new BasicGenerator(out, in);
        for (int i = 0; i < 10; i++) {
        	basicGen.generate();	
		}*/
        
        BirthDateGenerator brg = new BirthDateGenerator(out, 5);
        brg.generate();
        
    }
}
