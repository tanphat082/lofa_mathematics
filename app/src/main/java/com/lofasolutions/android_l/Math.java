package com.lofasolutions.android_l;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Math{

    public float getY(String calc, float x) {
		if(!calc.isEmpty() && x !== null){
			calc = this.handleCalc(calc, x);
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object result = engine.eval(calc);
			return result;
		} else {
			return false;
		}
	}
	
	public String handleCalc(String calc, float x) {
		String x = Float.toString(x);
		return calc.replaceAll("x", x);
	}
}