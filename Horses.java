package FinalTest3;

public class Horses extends Pack_animals implements Action{
    private int id;

    private String names;

    private String actions;

    private String birthdate;

    private int species_id;

    public void action(){
        System.out.println("action");
    }
}
