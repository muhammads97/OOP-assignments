package eg.edu.alexu.csd.oop.calculator.cs41;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Stack;

import eg.edu.alexu.csd.oop.calculator.Calculator;

public class SalahCalculator implements Calculator {
    private final String[] operators = {"+", "*", "/", "-"};
    private final String saveFile = ".//history.txt";
    
    private Stack<String> prev = new Stack<String>();
    private Stack<String> next = new Stack<String>();
    
    private double input1;
    private double input2;
    private String operator;

    @Override
    public void input(String s) {
        while(!next.isEmpty()) {
            prev.push(next.pop());
        }
        prev.push(new String(s));
        if(prev.size() > 5) {
            Stack<String> temp = new Stack();
            for(int i = 0; i < 5; i++) {
                temp.push(prev.pop());
            }
            prev.clear();
            while(!temp.isEmpty()) {
                prev.push(temp.pop());
            }
        }
    }

    @Override
    public String getResult() {
        if(prev.isEmpty()) return null;
        parseCurrent();
        String res;
        switch (operator) {
        case "+":
            res = String.valueOf(sum());
            break;
        case "-":
            res = String.valueOf(sub());
            break;
        case "*": 
            res = String.valueOf(mult());
            break;
        case "/":
            res = String.valueOf(div());
            break;
        default:
            res = null;
            break;
        }
        return res;
    }

    @Override
    public String current() {
        if(prev.isEmpty()) {
            return null;
        }
        return prev.peek();
    }

    @Override
    public String prev() {
        if(prev.size() == 1) {
            return null;
        }
        try {
            next.push(prev.pop());
            return prev.peek();
        } catch(Exception e) {
            return null;
        }
        
    }

    @Override
    public String next() {
        try {
            prev.push(next.pop());
            return prev.peek();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save() {
        PrintWriter pr = null;
        if(prev.isEmpty()) {
            try {
                pr = new PrintWriter(saveFile);
                pr.print("");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            return;
        }
        
        try {
            pr = new PrintWriter(saveFile);
            String line = prev.peek();
            int i = 0;
            while(prev.size() > 0 && i < 5) {
                line = prev.pop();
                pr.println(line);
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    }

    @Override
    public void load() {
        prev.clear();
        next.clear();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(saveFile));
            String line;
            while ((line = br.readLine()) != null) {
                next.push(new String(line));
            }
            while(next.peek() != null) {
                prev.push(next.pop());
            }
        } catch (Exception e) { 
        } finally {
            try {
                br.close();
            } catch (Exception e2) {
            }
        }

    }
    
    private Double sum() {
        return input1 + input2;
    }
    
    private Double sub() {
        return input1 - input2;
    }
    
    private Double mult() {
        return input1 * input2;
    }
    
    private Double div() {
        try {
            return input1 / input2;
        } catch( Exception e) {
            return null;
        }
    }
    private void parseCurrent() {
        if(prev.isEmpty()) return;
        String s = prev.peek();
        int input1sign = 1;
        if(s.startsWith("-")) {
            input1sign = -1;
            s = s.substring(1);
        } 
        for(int i = 0; i < operators.length; i++) {
            String[] op = s.split("\\".concat(operators[i]), 2);
            if(op.length != 2) {
                continue;
            }
            operator = operators[i];
            input1 = Double.valueOf(op[0]) * input1sign;
            input2 = Double.valueOf(op[1]);
            return;
        }
    }
}
