import Controller.Controller;
import Model.Monom;
import Model.Polinom;
import View.GUI;

public class Main {
    public static void main(String[] args){
        GUI theView=new GUI();
        Polinom poli= new Polinom();
        Controller theController=new Controller(theView,poli);
        theView.setVisible(true);
    }
}
