package com.calculator_project;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class InfixEvaluate{
	double evaluate(String expression) {
		char[] tokens = expression.toCharArray();
		
		//Number stack => values
		Stack<Double> values = new Stack<Double>();
		
		//Operators stack => ops
		Stack<Character> ops = new Stack<Character>();
		
		for(int i=0; i<tokens.length;i++) {
//			if (tokens[i]==' ') { //Skipping White spaces
//				continue;
//			}
			
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				
				StringBuffer strBuff = new StringBuffer();
				
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {// || tokens[i]=='.'
					strBuff.append(tokens[i++]);	
				}
				
				values.push(Double.parseDouble(strBuff.toString()));
				
				i--;
				
			}else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			}else if (tokens[i] == ')') {
				
				while (ops.peek() != '(') {
					//Use function applyop here 
					values.push(applyOperator(ops.pop(), values.pop(), values.pop()));					
				}
				ops.pop();
			}else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
					//Use hasPrecedance & apply ops here
					values.push(applyOperator(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(tokens[i]);
			}
		}
		
		while (!ops.empty()) {
			//not iterate the remaining part
			values.push(applyOperator(ops.pop(), values.pop(), values.pop()));
		}
		
		return values.pop();
	}
	
	boolean hasPrecedence(char c1, char c2) {
		if (c2 == '(' || c2 == ')') {
			return false;
		}else if ((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-')) {
			return false;
		}else {
			return true;
		}
	}
	
	double applyOperator(char  opr, double b, double a ) {
		switch (opr)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException(
                      "Cannot divide by zero");
            return a / b;
        }
        return 0;
	}
	
}

@WebServlet("/evaluate")
public class EvaluateExpressionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InfixEvaluate e1 = new InfixEvaluate();
		String exp = req.getAttribute("expression").toString();
		System.out.println(e1.evaluate(exp));
		req.setAttribute("sol", e1.evaluate(exp));
	}
}
