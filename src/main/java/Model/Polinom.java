package Model;

import java.util.ArrayList;
import java.util.regex.*;
public class Polinom {
    private ArrayList<Monom> polinom;

    public Polinom() {
    }

    public Polinom(Monom[] monoms) {
        this.polinom = ArrayToArrayList(monoms);
    }

    private ArrayList<Monom> ArrayToArrayList(Monom[] monoms){
        ArrayList<Monom> p=new ArrayList<Monom>();
        for(int i=0;i< monoms.length;i++){
            monoms[i].setGrade(i);
            p.add(monoms[i]);
        }
        return p;
    }

    public void regexChecker(String theRegex, String str2Check)throws NumberFormatException{
        Pattern checkRegex=Pattern.compile(theRegex);
        Matcher regexMatcher=checkRegex.matcher(str2Check);
        String result="";
        while (regexMatcher.find()){
            if(regexMatcher.group().length()!=0){
                //System.out.print(regexMatcher.group().trim()+ " ");
                result+=regexMatcher.group();
            }
        }
        if(!result.contentEquals(str2Check))
            throw new NumberFormatException();
    }

    public Monom[] convertStringToMonomArray(String string){
        ArrayList<Integer> numbers=convertStringtoArrayList("(\\+|-)?\\d+",string);
        Integer size=1;
        if(numbers.size()>=2)
            size=numbers.get(1)+1;
        Integer[] grades= new Integer[size];
        for(int i=0;i<grades.length;i++) grades[i]=0;
        for(int i=0;i<numbers.size();i++){
            if(i%2==1)
                grades[numbers.get(i)] = numbers.get(i - 1);
        }
        Monom[] monoms=new Monom[size];
        for (int i=0;i<grades.length;i++) {
            monoms[i]=new Monom(grades[i]);
        }
        return monoms;
    }

    public ArrayList<Integer> convertStringtoArrayList(String theRegex,String string){
        ArrayList<Integer> numbers=new ArrayList<>();
        Pattern checkRegex=Pattern.compile(theRegex);
        Matcher regexMatcher=checkRegex.matcher(string);
        while (regexMatcher.find()){
            if(regexMatcher.group().length()!=0){
                numbers.add(Integer.parseInt(regexMatcher.group().trim()));
            }
        }
        return numbers;
    }
//    public ArrayList<Integer> convertStringtoArrayList(String string){
//        ArrayList<Integer> numbers=new ArrayList<>();
//        int max=string.length();
//        int value;
//        int i=0;
//        while (i<max){
//            int j=i;
//            if(string.charAt(i)>='0' && string.charAt(i)<='9'){
//                while(j<max && string.charAt(j)>='0' && string.charAt(j)<='9'){j++; }
//                value=Integer.parseInt(string.substring(i,j));
//                if(i>0)
//                    if(string.charAt(i-1)=='-') value=value*(-1);
//                numbers.add(value);
//            }
//            if(i!=j) i=j+1;
//            else i++;
//        }
//        return numbers;
//    }
    public Polinom plus(Polinom a){
        ArrayList<Monom> result=new ArrayList<Monom>();
        int lenghtA=a.polinom.size()-1;
        int lengthThis=this.polinom.size()-1;
        Integer max= lengthThis > lenghtA ? lengthThis: lenghtA ;
        int i=0;
        while(i <= max){
            result.add(Calculator.addMonoms(i>lenghtA? null:a.polinom.get(i) , i>lengthThis? null: this.polinom.get(i)));
            i++;
        }
        Monom[] monoms= result.toArray(new Monom[result.size()]);
        Polinom p=new Polinom(monoms);
        return p;
    }

    public Polinom minus(Polinom a){
        ArrayList<Monom> result=new ArrayList<Monom>();
        int lenghtA=a.polinom.size()-1;
        int lengthThis=this.polinom.size()-1;
        Integer max= lengthThis > lenghtA ? lengthThis: lenghtA ;
        int i=0;
        while(i <= max){
            result.add(Calculator.subMonoms(i>lenghtA? null:a.polinom.get(i) , i>lengthThis? null: this.polinom.get(i)));
            i++;
        }
        Monom[] monoms= result.toArray(new Monom[result.size()]);
        Polinom p=new Polinom(monoms);
        return p;
    }

    public Polinom multiply(Polinom a){
        ArrayList<Monom> result=new ArrayList<>();
        int max=this.polinom.size()+a.polinom.size()-1;
        for(int i=0;i<max;i++)
            result.add(new Monom(0));
        for (int i=0;i<this.polinom.size();i++)
            for (int j=0;j<a.polinom.size();j++)
                result.get(i+j).setCoeficient(Calculator.addMonoms(result.get(i+j),Calculator.mulMonoms(this.polinom.get(i),a.polinom.get(j))).getCoeficient());
        Monom[] monoms= result.toArray(new Monom[result.size()]);
        Polinom p=new Polinom(monoms);
        return p;
    }

    public Polinom derivate(){
        ArrayList<Monom> result=new ArrayList<>();
        int max=this.polinom.size()-1;
        for (int i=0;i<max;i++)
            result.add(new Monom(0));
        for (int i=1;i<this.polinom.size();i++)
            result.get(i-1).setCoeficient(Calculator.derMonoms(this.polinom.get(i)).getCoeficient());

        Monom[] monoms= result.toArray(new Monom[result.size()]);
        Polinom p=new Polinom(monoms);
        return p;
    }
    @Override
    public String toString() {
        String result= new String();
        for(int i=this.polinom.size()-1;i>=0;i--){
            String aux;
            if(this.polinom.get(i).getCoeficient()>0)
                result += "+" + this.polinom.get(i).toString();
            else
                if(this.polinom.get(i).getCoeficient()<0)
                    result += this.polinom.get(i).toString();
        }
        if (result.startsWith("+")) result=result.substring(1,result.length());
        return result;
    }
}
