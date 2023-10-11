import javax.swing.*;

/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */
public class VirtualPet {
    
    VirtualPetFace face;
    private int tiredness = 100;
    int hunger = 0;   // how hungry the pet is.
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hello.");
    }


    public void change(String I, String M){
        face.setImage(I);
        face.setMessage(M);
    }
    public String gR( String R){
        String s = (String) JOptionPane.showInputDialog(
                new JFrame(),
                R,
                "Your Title",
                JOptionPane.PLAIN_MESSAGE
        );
        return s;
    }
    public void choose(String Q){
        String ans = gR("how was your day going");

        face.setMessage(ans); //can you see this?
    }









    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
    }
    
    public void exercise() {
        hunger = hunger + 3;
        face.setMessage("1, 2, 3, jump.  Whew.");
        face.setImage("tired");
        if (hunger > 30){
            face.setImage("pushingdaisies");
            face.setMessage("bruh");

        }
    }
    
    public void sleep() {
        hunger = hunger + 1;
        face.setImage("asleep");
    }

} // end Virtual Pet
