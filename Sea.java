import java.util.Scanner;
import java.util.Random;

class Sea{
    public static void main(String[] args){
        Random r = new Random();
        Scanner sc = new Scanner();

        char before;
        Scanner before = new Scanner(System.in);
        int right;
        Scanner right = new Scanner(System.in);

        public void replace(char before){
            int after = Character.getNumericValue(before);
            if( before == "a"){
                before = 1;
            }else if( before == "b"){
                before = 2;
            }else if( before == "c"){
                before = 3;
            }else if( before == "d"){
                before = 4;
            }else{
                before = 5;
            }
        }

        public void response(int before){
            char before = (char) after;
            if( after == 1){
                after = "a";
            }else if( after == 2){
                after = "b";
            }else if( after == 3){
                after = "c";
            }else if( after == 4){
                after = "d";
            }else{
                after = "e";
            }
            System.out.println(after+number);
        }
    }
}
