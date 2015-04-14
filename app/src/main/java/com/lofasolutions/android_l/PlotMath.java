package com.lofasolutions.android_l;


import android.content.Context;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlotMath {

    private int precision;
    private String angle_type = "degrees";
    private String angle_settings;

    public float getY(String calc) {
        try {
            Expression e = new Expression(calc);

            e = e.setPrecision(0);

            e.addOperator(e.new Operator("/", 30, true) {
                @Override
                public BigDecimal eval(BigDecimal v1, BigDecimal v2) {
                    MathContext mc = new MathContext(precision);
                    BigDecimal answer = v1.divide(v2, mc);
                    return answer;
                }
            });
            e.addFunction(e.new Function("asin", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
                    BigDecimal parameter = parameters.get(0);
                    String parameter_str = parameter.toString();
                    double parameter_dbl = Double.parseDouble(parameter_str);
                    double answer = Math.asin(parameter_dbl);
                    double answer_final;
                    if (angle_type == "radians") {
                        answer_final = answer;
                    } else {
                        answer_final = Math.toDegrees(answer);
                    }
                    BigDecimal answer_bd = new BigDecimal(answer_final);
                    answer_bd = answer_bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
                    return answer_bd;
                }
            });
            e.addFunction(e.new Function("acos", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
                    BigDecimal parameter = parameters.get(0);
                    String parameter_str = parameter.toString();
                    double parameter_dbl = Double.parseDouble(parameter_str);
                    double answer = Math.acos(parameter_dbl);
                    double answer_final;
                    if (angle_type == "radians") {
                        answer_final = answer;
                    } else {
                        answer_final = Math.toDegrees(answer);
                    }
                    BigDecimal answer_bd = new BigDecimal(answer_final);
                    answer_bd = answer_bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
                    return answer_bd;
                }
            });
            e.addFunction(e.new Function("atan", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
                    BigDecimal parameter = parameters.get(0);
                    String parameter_str = parameter.toString();
                    double parameter_dbl = Double.parseDouble(parameter_str);
                    double answer = Math.atan(parameter_dbl);
                    double answer_final;
                    if (angle_type == "radians") {
                        answer_final = answer;
                    } else {
                        answer_final = Math.toDegrees(answer);
                    }
                    BigDecimal answer_bd = new BigDecimal(answer_final);
                    answer_bd = answer_bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
                    return answer_bd;
                }
            });
            e.addFunction(e.new Function("sin", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
                    BigDecimal parameter = parameters.get(0);
                    String parameter_str = parameter.toString();
                    double parameter_dbl = Double.parseDouble(parameter_str);
                    double parameter_final;
                    System.out.println(angle_settings);
                    if (angle_type == "radians") {
                        parameter_final = parameter_dbl;
                    } else {
                        parameter_final = Math.toRadians(parameter_dbl);
                    }
                    double answer = Math.sin(parameter_final);
                    System.out.println(answer);
                    BigDecimal answer_bd = new BigDecimal(answer);
                    answer_bd = answer_bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
                    return answer_bd;
                }
            });
            e.addFunction(e.new Function("cos", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
                    BigDecimal parameter = parameters.get(0);
                    String parameter_str = parameter.toString();
                    double parameter_dbl = Double.parseDouble(parameter_str);
                    double parameter_final;
                    if (angle_type == "radians") {
                        parameter_final = parameter_dbl;
                    } else {
                        parameter_final = Math.toRadians(parameter_dbl);
                    }
                    double answer = Math.cos(parameter_final);
                    System.out.println(answer);
                    BigDecimal answer_bd = new BigDecimal(answer);
                    answer_bd = answer_bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
                    return answer_bd;
                }
            });
            e.addFunction(e.new Function("tan", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
                    BigDecimal parameter = parameters.get(0);
                    String parameter_str = parameter.toString();
                    double parameter_dbl = Double.parseDouble(parameter_str);
                    double parameter_final;
                    if (angle_type == "radians") {
                        parameter_final = parameter_dbl;
                    } else {
                        parameter_final = Math.toRadians(parameter_dbl);
                    }
                    double answer = Math.tan(parameter_final);
                    System.out.println(answer);
                    BigDecimal answer_bd = new BigDecimal(answer);
                    answer_bd = answer_bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
                    return answer_bd;
                }
            });
            e.addFunction(e.new Function("SQRT", 1) {
                @Override
                public BigDecimal eval(List<BigDecimal> parameters) {
					/*
					 * From The Java Programmers Guide To numerical Computing
					 * (Ronald Mak, 2003)
					 */
                    BigDecimal x = parameters.get(0);
                    if (x.compareTo(BigDecimal.ZERO) == 0) {
                        return new BigDecimal(0);
                    }
                    BigInteger n = x.movePointRight(precision << 1)
                            .toBigInteger();

                    int bits = (n.bitLength() + 1) >> 1;
                    BigInteger ix = n.shiftRight(bits);
                    BigInteger ixPrev;

                    do {
                        ixPrev = ix;
                        ix = ix.add(n.divide(ix)).shiftRight(1);
                        // Give other threads a chance to work;
                        Thread.yield();
                    } while (ix.compareTo(ixPrev) != 0);

                    return new BigDecimal(ix, precision);
                }
            });
            BigDecimal result_bd = e.eval();

            String tmp_result = result_bd.toPlainString();
            float f = Float.parseFloat(tmp_result);
            return f;
//            editText.setText(tmp_result);
//            calc = editText.getText().toString();
//            no_calc = false;
//            press = '=';
//            editText.setSelection(editText.getText().length());
        } catch (Exception err) {
//            Context context = getApplicationContext();
//            CharSequence text = "Input error.";
//            int duration = Toast.LENGTH_SHORT;
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//            // TODO Here is equal
        }
        return -0;
    }
	
	public String makeExpression(String calc, float x) {
        String xString = Float.toString(x);
        String newCalc = calc.replace("x", xString);
        return newCalc;
	}
}