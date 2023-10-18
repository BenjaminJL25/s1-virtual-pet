import javax.swing.*;

/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */
public class VirtualPet {
    
    VirtualPetFace face;
    private int St;
    private int tiredness = 0;
    private int day = 0;
    private int hunger = 0;   // how hungry the pet is.
    private int ec = 0; //eat counter (shows how much sandwitch is left)
    private int exc = 0;
    private String name;
    private void reset(){
        name = "";
        tiredness =0;
        day = 0;
        hunger = 0;
        ec = 0;
        exc = 0;
        face.setImage("joyful");
        face.setMessage("Day: 0 -------------------------------");
        name = gR("name your pet!");
    }
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("joyful");
    }

    public void stop( int ms){
        try {
            Thread.sleep(ms);
        }catch (Exception e){

        }
    }
    public void change(String I, String M){
        face.setImage(I);
        face.setMessage(M);


    }
    public int question(String q, String o1, String o2, String o3){
        Object[] options = {o1,
                o2, o3};
        return JOptionPane.showOptionDialog(null,
                q,
                "---_---",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]);
    }
    public String gR( String R){
        String s = (String) JOptionPane.showInputDialog(
                new JFrame(),
                R,
                "Your Title",
                JOptionPane.PLAIN_MESSAGE
        );
        System.out.println(this.St);
        return s;

    }


    public void choose(String Q){
        face.setMessage(Q);
        String ans = gR(Q);//asks the quesstion
        System.out.println(this.St);
        face.setMessage(ans); //prints response

    }


    public void feed() {

        if (ec < 8){
            if (hunger > 10) {
                hunger = hunger - 10;
            } else {
                hunger = 0;
            }
            face.setImage("bites");
            face.setMessage("Yum, thanks");
            ec++;
            face.setMessage("Bites left " + Integer.toString(8-ec));
        }   else if (ec == 8){
            if (hunger > 10) {
                hunger = hunger - 10;
            } else {
                hunger = 0;
            }
            face.setImage("bitel");
            face.setMessage("oh no this is the last peice");
            ec++;
        } else {
            face.setImage("starving");
            face.setMessage("I wish I had more food");
            face.setMessage(":(");

        }

    }
    
    public void exercise() {
        hunger = hunger + 3;
        exc += 1;
        face.setMessage("1, 2, 3, jump.  Whew.");
        face.setImage("exercising");
    }
    public void sleep() {
        day += 1;
        hunger += 4;
        face.setImage("next");
        face.setMessage("day: " + Integer.toString(day) + " -----------------------------");
    }
    public boolean pd(){
        if (question("please leave", "yes", "no", "no") == 0){
            return true;
        }else {
            face.setMessage("We told you not to do it...");

            face.setImage("d0");
            stop(5000);
            face.setImage("dark");
            stop(500);
            face.setImage("d1");
            face.setMessage("You walk towards the door");
            face.setMessage("...");
            stop(4000);
            face.setImage("dark");
            stop(500);
            face.setImage("d2");
            face.setMessage("...");
            stop(4000);
            face.setImage("dark");
            stop(500);
            face.setImage("d3");
            face.setMessage("...");
            stop(4000);
            face.setImage("dark");
            stop(500);
            face.setImage("d4");
            face.setMessage("...");
            stop(4000);
            face.setImage("dark");
            stop(500);
            face.setImage("d5");

            face.setMessage("...");
            stop(4000);
            face.setMessage("...");
            stop(4000);
            face.setMessage("...");
            stop(4000);
            face.setMessage("you hear a shuffle");
            stop(4000);
            face.setMessage("...");
            stop(4000);
            face.setImage("d6");
            stop(2000);
            face.setImage("d7");
            face.setMessage("what you lookin at?");
            stop(2000);
            face.setImage("d8");
            stop(4000);
            face.setImage("d9");
            stop(2000);
            face.setImage("da");
            stop(20000);
            return false;
        }

    }
    public void start(){
        boolean deez = true;
        while (deez) {
            int r = question("want to play", "yes", "no", "don't click this");
            if (r == 0){
                reset();
                Cycle(question("Difficulty level?", "1", "2", "3"));
                System.out.println("outofcycle");
                face.setImage("pushing");
                face.setMessage("You have killed " + name);
                face.setMessage("You survived for: " + Integer.toString(day) + " days");
                face.setMessage("You ate: " + Integer.toString(ec) + " times");
                face.setMessage("You exercised: " + Integer.toString(exc) + " times");
                stop(10000);
            } else if (r == 1) {
                deez = false;
                System.out.println("elif");
            } else {
                System.out.println("else");
                deez = pd();
            }
        }
        System.out.println("lout");
        stop(10000);
    }
    public boolean Cycle(int d){
        d = 7 - d;
        boolean b = true;
        int f = 10;

        while (b){
            System.out.println(hunger+tiredness);
            System.out.println(Integer.toString(5*d));
            if ((hunger + tiredness) < 5*d){
                this.St = question("what do", "eat", "exercise", "sleep");
                if (this.St == 0){
                    feed();
                    stop(5000);
                } else if (this.St == 1) {
                    exercise();
                    stop(5000);
                } else {
                    sleep();
                    stop(5000);
                }
            }else {
                b = false;
            }
            if ((hunger + tiredness) < 4*d){
                face.setImage("joyful");
            } else {
                face.setImage("sick");
                face.setMessage("I'm not feeling well");
            }
        }
        System.out.println("deone");
        return b;
    }
    //public boolean Socialize(int s){
    //if (interactions >= 10){
    //
} // end Virtual Pet
