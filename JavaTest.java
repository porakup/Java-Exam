import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaTest {

    public static void main(String[] args){
        checkNumber();
    }


    public static void checkNumber(){
        Scanner scanner = new Scanner(System.in);
        String inputA = "";
        String inputN = "";
        List<String> inputBList = new ArrayList<String>();
        List<String> resultList = new ArrayList<String>();

        System.out.println("The number must not start with 0 and length must less than 20");

        while(inputA.length() == 0) {
            System.out.print("Input A :");
            inputA = scanner.next();
            if(!((inputA.matches("\\d+")) && (inputA.charAt(0) != '0') && (inputA.length() < 20))){
                inputA = "";
            }
        }

        while(inputN.length() == 0) {
            System.out.print("Input number of B line :");
            inputN = scanner.next();
            if(!((inputN.matches("\\d+")) && (inputA.charAt(0) != '0') && (inputN.length() < 20))){
                inputN = "";
            }
        }

        System.out.println("The B number must not start with 0 and length must equal to A number");


            for(int i = 0; i < Integer.parseInt(inputN); i++ ){
                System.out.print(String.format("Input B line %d :",i+1));
                inputBList.add(i,scanner.next());
                if(!((inputBList.get(i).matches("\\d+")) && (inputBList.get(i).charAt(0) != '0')
                    && (inputBList.get(i).length() < 20) && (inputA.length() == inputBList.get(i).length()))){
                    inputBList.remove(i);
                    i--;
                }
                else{
                    boolean compareA = true;
                    boolean compareB = true;

                    for(int j = 0; j < inputBList.get(i).length(); j++){
                        if(inputA.charAt(j) == inputBList.get(i).charAt(j)){
                            compareA = false;
                            break;
                        }
                    }

                    if(compareA){
                        outer:for(int k = 0; k < inputBList.size(); k++){
                            for(int l = 0; l < inputBList.get(k).length(); l++){
                                if(i != k){
                                    if(inputBList.get(i).charAt(l) == inputBList.get(k).charAt(l)){
                                        compareB = false;
                                        break outer;
                                    }
                                }
                            }
                        }
                    }

                    resultList.add(i,(compareA && compareB) ? "Valid" : "Invalid");
                }
            }

        System.out.println("\nResult \nInput A : "+inputA);
        for(int i = 0 ; i < inputBList.size(); i++){
            System.out.println(String.format("Input B line %s : %s = %s",i+1,inputBList.get(i),resultList.get(i)));
        }
    }

}
