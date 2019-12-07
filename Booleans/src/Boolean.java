public class Boolean {
    public static void main(String[] args) {
        int man1Age = 15;
        int man2Age = 13;
        int man3Age = 52;

        int min = -1;
        int middle = -1;
        int max = -1;

        if (man1Age < man2Age && man1Age < man3Age){
            min = man1Age;
            if(man2Age < man3Age){
                middle = man2Age;
                max = man3Age;
            }
            else {
                middle = man3Age;
                max = man2Age;
            }
        }
        else if (man2Age < man1Age && man2Age < man3Age){
            min = man2Age;
            if(man1Age < man3Age){
                middle = man1Age;
                max = man3Age;
            }
            else {
                middle = man3Age;
                max = man1Age;
            }
        }
        else {
            min = man3Age;
            if(man1Age < man2Age){
                middle = man1Age;
                max = man2Age;
            }
            else {
                middle = man2Age;
                max = man1Age;
            }
        }
        System.out.println("Min: " + min + " Middle: " + middle + " Max: " + max );
    }
}
