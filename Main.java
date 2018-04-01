
import java.util.*;
public class Main {
    //create object of distribute class
    distribute Distribute;
    Random r = new Random();
    ArrayList<Integer> arr = new ArrayList<>();  //will hold the random values
    ArrayList<Integer> val = new ArrayList<>();  //dividing the number's in power of two and storing it in "val"

    public void generate() {
        int c = 0,rand,total=52;
        while (total != 0) {
            if (c == 0) {
                rand = 1 + r.nextInt(10);
            } else if (c == 2) {
                rand = 1 + r.nextInt(15);
            } else {
                rand = 1 + r.nextInt(total);
            }
            if (rand <= total) {
                if (total <= 6) {
                    arr.add(total);
                    total = 0;
                    c++;

                } else {
                    arr.add(rand);
                    total = total - rand;
                    c++;
                }
            }
        }
        if (c < 6) {
            arr.clear();
            generate();
        } else {
            val=divide(arr);
            Distribute = new distribute();

            Distribute.distributed(val);
        }
    }
    public ArrayList<Integer> divide(ArrayList<Integer> list) {
        int n;
        ArrayList<Integer> result = new ArrayList<>();
        for (int loop = 0; loop < arr.size(); loop++) {
            n = list.get(loop);
            if ((n & (n - 1)) == 0) {   //if true, the number can be represented using power of 2, in 1, 2 ,4 ,8, 16, 32 direct value, single value
                if(n==1 || n==2){
                    result.add(n);
                }
                else {
                    n = n - 1;
                    ArrayList<Integer> temp;
                    temp = powerOfTwo(n);
                    for (int i = 0; i < temp.size(); i++) {
                        result.add(temp.get(i));
                    }
                    result.add(1);
                }

            } else {
                ArrayList<Integer> temp;
                temp = powerOfTwo(n);
                for (int i = 0; i < temp.size(); i++) {
                    result.add(temp.get(i));
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> powerOfTwo(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        String temp_binary = "";
        String binary = Integer.toBinaryString(n);
        // reverse the array
        for (int i = binary.length() - 1; i >= 0; i--)
            temp_binary = temp_binary + binary.charAt(i);
        for (int i = 0; i < temp_binary.length(); i++) {
            if (temp_binary.charAt(i) == '1') {
                //System.out.print((int)Math.pow(2,i));
                list.add((int) Math.pow(2, i));
            }
        }
        return list;
    }

    public static void main(String args[]) {
        Main obj = new Main();
        obj.generate();
    }
}
