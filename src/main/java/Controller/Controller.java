package Controller;

import Model.Polinom;
import View.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private GUI theView;
    private Polinom theModel;

    public Controller(GUI theView,Polinom theModel){
        this.theView=theView;
        this.theModel=theModel;
        this.theView.addListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ex) {
            Polinom firstPolinom=new Polinom();
            Polinom secondPolinom=new Polinom();
            try{
                firstPolinom.regexChecker("(\\+|-)?\\d+[Xx]\\^\\d+",theView.getFirstPolinom());
                secondPolinom.regexChecker("(\\+|-)?\\d+[Xx]\\^\\d+",theView.getSecondPolinom());

                firstPolinom=new Polinom(theModel.convertStringToMonomArray(theView.getFirstPolinom()));
                secondPolinom=new Polinom(theModel.convertStringToMonomArray(theView.getSecondPolinom()));
                switch (ex.getActionCommand()){
                    case "A+B":
                        theModel=firstPolinom.plus(secondPolinom);
                        theView.setCalcSolution(theModel.toString());
                        break;
                    case "A-B":
                        theModel=firstPolinom.minus(secondPolinom);
                        theView.setCalcSolution(theModel.toString());
                        break;
                    case "A*B":
                        theModel=firstPolinom.multiply(secondPolinom);
                        theView.setCalcSolution(theModel.toString());
                        break;
                    case "A/B":
                        theView.setCalcSolution("Not implemented");
                        break;
                    case "∂A":
                        theModel=firstPolinom.derivate();
                        theView.setCalcSolution(theModel.toString());
                        break;
                    case "∂B":
                        theModel=secondPolinom.derivate();
                        theView.setCalcSolution(theModel.toString());
                        break;
                    case "∫A":
                        theView.setCalcSolution("Not implemented");
                        break;
                    case "∫B":
                        theView.setCalcSolution("Not implemented");
                        break;
                }
            }
            catch (NumberFormatException e){
                System.out.println(e);
                theView.displayErrorMessage("The monom form has to be: aX^b or ax^b, where a,b are integer numbers");
            }
        }

    }
}
