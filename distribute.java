import java.util.ArrayList;
public class distribute {
    public void distributed(ArrayList<Integer> list) {
        int playerTotal[] = {0, 0, 0, 0};
        int curPlayer = 0;
        int j;
        final int total = 13;
        for (int i = 0; i < list.size(); i++) {
            for (j = 0; j < 4; j++) {
                if (playerTotal[curPlayer] < total) {
                    break;
                } else {
                    curPlayer = (curPlayer + 1) % 4;
                }
            }
                //cannot simply allocate, need to check how much more a player needs,
                //atlast if three players already received 13 each, means we can distribute the other cards all together to the last person
                //how to check ?
                int need = total - playerTotal[curPlayer];
                if (need <= list.get(i)) {
                    playerTotal[curPlayer] = playerTotal[curPlayer] + need;
                    //we need to add to current player
                    //make an array and add to it,no this won't work ..
                    //do something
                    //print here
                    //a bug, it prints 0 cards :(
                    System.out.println("Give player " + (curPlayer + 1) + " :: " + need + " Cards");
                    int remainingValue = list.get(i) - need;
                    list.remove(i);
                    list.add(i, need); //already assigned, now remaining value is entered into the list
                    if (remainingValue != 0)  // printing 0 , problem solved
                        list.add(i + 1, remainingValue);
                } else {
                    playerTotal[curPlayer] = playerTotal[curPlayer] + list.get(i);
                    System.out.println("Give player " + (curPlayer + 1) + " :: " + list.get(i) + " Cards");
                }
                curPlayer = (curPlayer + 1) % 4; //next player
           
        }
    }
}




