public class Cylce {
    public static void main(String[] args) {

       for(int i = 200000;i <= 235000;i++){
            if(i <= 210000 || i >= 220000) {
                System.out.println(i);
            }
        }

        int i = 200000;
       while (i <= 235000){
            if(i <= 210000 || i >= 220000) {
                System.out.println(i);
            }
            i++;
        }
    }
}
