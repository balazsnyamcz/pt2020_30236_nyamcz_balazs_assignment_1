package Model;
        import java.util.Comparator;

public class Calculator {
    public static Monom addMonoms(Monom a,Monom b){
        if(a==null)
            return b;
        if(b == null)
            return a;
        return new Monom(a.getCoeficient()+b.getCoeficient());
    }

    public static Monom subMonoms(Monom b, Monom a) {
        if(a==null)
            return new Monom(b.getCoeficient()*(-1));
        if(b == null)
            return a;
        return new Monom(a.getCoeficient()-b.getCoeficient());
    }

    public static Monom mulMonoms(Monom a, Monom b){
        return new Monom(a.getCoeficient()*b.getCoeficient());
    }

    public static Monom derMonoms(Monom a){
        return new Monom(a.getCoeficient()*a.getGrade());
    }
}
