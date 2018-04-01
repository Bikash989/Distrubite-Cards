import java.util.ArrayList;

public class distribute {
    int totalCards = 0;

    public void distributed(ArrayList<Integer> list) {
        int playerTotal[] = {0, 0, 0, 0};
        ArrayList<Integer> finalList = new ArrayList<>();
        int curPlayer = 0;
        int j;
        final int total = 13;
        int curPlayerCount;
        for (int i = 0; i < list.size(); i++) {
            curPlayerCount=0;
            for (j = 0; j < 4; j++) {

                if (playerTotal[curPlayer] < total) {
                    break;
                } else {
                    curPlayer = (curPlayer + 1) % 4;
                    curPlayerCount+=1;
                }
            }
            if (j == 4 && totalCards != 52) {
                //need to redivide or else ignore, it's not goona happen, i have checked many times
                //how to know that value still remains and chk is 4?
                // By maintaining a total count if total ! = 52 and j is 4, means we need to split
                //create a object of dynamic_prg_duplicate class and call it's divide method containing split
                System.out.println("Something's wrong");
            } else if (curPlayerCount == 4 && totalCards == 52) {
                System.out.println("Distributed");
            } else {
                //cannot simply allocate, need to check how much more a player needs,
                //atlast if three players already received 13 each, means we can distribute the other cards all together to the last person
                //how to check ?
                int need = total - playerTotal[curPlayer];
                if (need <= list.get(i)) {
                    playerTotal[curPlayer] = playerTotal[curPlayer] + need;
                    //we need to add to specified player
                    //make an array and add to it,no this won't work ..
                    //do something
                    //print here
                    //a bug, it prints 0 cards :(
                    System.out.println("Give player " + (curPlayer + 1) + " :: " + need + " Cards");

                    totalCards = totalCards + need;
                    int remainingValue = list.get(i) - need;
                    list.remove(i);
                    list.add(i, need); //already assigned, now remaining value is entered into the list
                    if (remainingValue != 0)  // printing 0 , problem solved
                        list.add(i + 1, remainingValue);
                } else {
                    playerTotal[curPlayer] = playerTotal[curPlayer] + list.get(i);

                    totalCards = totalCards + list.get(i);
                    System.out.println("Give player " + (curPlayer + 1) + " :: " + list.get(i) + " Cards");
                }
                curPlayer = (curPlayer + 1) % 4; //next player

            }
        }
    }
}




