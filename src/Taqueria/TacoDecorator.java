package Taqueria;
import Taqueria.TacoInterface.Taco;

public abstract class TacoDecorator implements Taco {


    protected Taco taco;

    public Taco getTaco() {
        return taco;
    }

}
