package Model;

public class Monom {
    private int coeficient;
    private int grade;

    public Monom(int coeficient){
        this.setCoeficient(coeficient);
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public int getGrade() {
        return grade;
    }

//    public Monom addition(Monom a,Monom b){
//        if(a==null)
//            return b;
//        if(b == null)
//            return a;
//        return new Monom(a.getCoeficient()+b.getCoeficient());
//    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /*public void substraction(Monom b){
        this.coeficient=this.coeficient-b.coeficient;
    }*/

    @Override
    public String toString() {
        return this.getCoeficient()+ "X^" + this.getGrade();
    }
}