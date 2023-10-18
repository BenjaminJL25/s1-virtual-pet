import javax.swing.*;
public class RUnner {
    public RUnner(){
        VirtualPet p = new VirtualPet();
        p.start();



//        String ans = gR("how was your day going");
//        System.out.println(ans); //can you see this?

        //johnny yo dude hellloooooooooooooooo
        //BEN!!!! MY MAN!!!
        //im going to add a
        // file named plan.txt or something so we can talk in that instead
        //sick sick sick, also niko commits tax evasion
        // do you see it?
    }
    public String gR( String R){
        String s = (String)JOptionPane.showInputDialog(
                new JFrame(),
                R,
                "Your Title",
                JOptionPane.PLAIN_MESSAGE
        );
        return s;
    }
    public void takeABeat( int ms){
        try {
            Thread.sleep(ms);
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        new RUnner();


    }
}
