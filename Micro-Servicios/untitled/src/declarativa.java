import java.util.List;

public static void main(String[]args){

        }
public class declarativa {
    private List <Integer> numbers = List.of(18,6,4,15,55,78,12,9,8);
    int contador =0;
    for(String numero : numbers) {


        if (numero < 9){
            System.out.println("Este es menor " + numero);
        }else{
            System.out.println("Este es mayor " + numero);
        }

    }

}
