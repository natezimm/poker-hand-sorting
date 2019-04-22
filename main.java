package com.nathan;

public class Main {

    public static void main(String[] args) {
        int cardsPerPlayer = 5;

        int numberOfHands = 5;

        String[] suits = {
                "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] values = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        // amount of cards
        int n = suits.length * values.length;

        // throw exception if too many players
        if (cardsPerPlayer * numberOfHands > n)
            throw new RuntimeException("Not enough cards for that many players!");

        // initialize deck
        String[] deck = new String[n];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length*i + j] = values[i] + " of " + suits[j];
            }
        }

        // shuffle cards
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // initialize arrays for hands
        String[] hand1 = new String[5];
        String[] hand2 = new String[5];
        String[] hand3 = new String[5];
        String[] hand4 = new String[5];
        String[] hand5 = new String[5];
        String[] hand6 = new String[5];
        String[] hand7 = new String[5];
        String[] hand8 = new String[5];
        String[] hand9 = new String[5];
        String[] hand10 = new String[5];

        // deal shuffled deck
        for (int i = 0; i < numberOfHands * cardsPerPlayer; i++) {
            if(i >= 0 && i < 5){
                hand1[i%5] = deck[i];
            } else if(i >= 5 && i < 10){
                hand2[i%5] = deck[i];
            } else if(i >= 10 && i < 15){
                hand3[i%5] = deck[i];
            } else if(i >= 15 && i < 20){
                hand4[i%5] = deck[i];
            } else if(i >= 20 && i < 25){
                hand5[i%5] = deck[i];
            } else if(i >= 25 && i < 30){
                hand6[i%5] = deck[i];
            } else if(i >= 30 && i < 35){
                hand7[i%5] = deck[i];
            } else if(i >= 35 && i < 40){
                hand8[i%5] = deck[i];
            } else if(i >= 40 && i < 45){
                hand9[i%5] = deck[i];
            } else {
                hand10[i%5] = deck[i];
            }
        }

        // sort hands
        for(int i = 0; i < numberOfHands; i++){
            if(i == 0){sortHand(hand1);}
            if(i == 1){sortHand(hand2);}
            if(i == 2){sortHand(hand3);}
            if(i == 3){sortHand(hand4);}
            if(i == 4){sortHand(hand5);}
            if(i == 5){sortHand(hand6);}
            if(i == 6){sortHand(hand7);}
            if(i == 7){sortHand(hand8);}
            if(i == 8){sortHand(hand9);}
            if(i == 9){sortHand(hand10);}
        }


        // print shuffled deck
        for (int i = 0; i < numberOfHands * cardsPerPlayer; i++){
            if(i < 5){
                if(i%5 == 0){ System.out.println("Hand 1:");}
                System.out.println(hand1[i%5]);
            } else if(i >= 5 && i < 10){
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 2:");}
                System.out.println(hand2[i%5]);
            }else if(i >= 10 && i < 15){
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 3:");}
                System.out.println(hand3[i%5]);
            }
            else if(i >= 15 && i < 20){
                if(i%5 == 0){System.out.println();
                    System.out.println("Hand 4:");}
                System.out.println(hand4[i%5]);
            }
            else if(i >= 20 && i < 25){
                if(i%5 == 0){System.out.println();
                    System.out.println("Hand 5:");}
                System.out.println(hand5[i%5]);
            }
            else if(i >= 25 && i < 30){
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 6:");}
                System.out.println(hand6[i%5]);
            }
            else if(i >= 30 && i < 35){
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 7:");}
                System.out.println(hand7[i%5]);
            }
            else if(i >= 35 && i < 40){
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 8:");}
                System.out.println(hand8[i%5]);
            }
            else if(i >= 40 && i < 45){
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 9:");}
                System.out.println(hand9[i%5]);
            } else {
                if(i%5 == 0){ System.out.println();
                    System.out.println("Hand 10:");}
                System.out.println(hand10[i%5]);
            }
        }

    }


    public static String[] sortHand(String[] hand){
        int n = hand.length;
        int[] cardValue = new int[5];
        for(int i = 0; i < cardValue.length - 1; i ++){
            cardValue[i] = 0;
        }

        // add suit value to each card
        for(int j = 0; j < n; j++){
            if(hand[j].contains("Diamonds")){cardValue[j] += 13;}
            if(hand[j].contains("Hearts")){cardValue[j] += 26;}
            if(hand[j].contains("Spades")){cardValue[j] += 39;}
        }

        // add rank value to each card
        for(int q = 0; q < n; q++){
            if(hand[q].contains("2")){cardValue[q] += 1;}
            if(hand[q].contains("3")){cardValue[q] += 2;}
            if(hand[q].contains("4")){cardValue[q] += 3;}
            if(hand[q].contains("5")){cardValue[q] += 4;}
            if(hand[q].contains("6")){cardValue[q] += 5;}
            if(hand[q].contains("7")){cardValue[q] += 6;}
            if(hand[q].contains("8")){cardValue[q] += 7;}
            if(hand[q].contains("9")){cardValue[q] += 8;}
            if(hand[q].contains("10")){cardValue[q] += 9;}
            if(hand[q].contains("Jack")){cardValue[q] += 10;}
            if(hand[q].contains("Queen")){cardValue[q] += 11;}
            if(hand[q].contains("King")){cardValue[q] += 12;}
        }

        // sort through array
        for(int k = 0; k < n-1; k++){
            for(int p = 0; p < n-k-1; p++){
                if(cardValue[p] > cardValue[p+1]){
                    String handTemp = hand[p];
                    int cardValueTemp = cardValue[p];
                    hand[p] = hand[p+1];
                    cardValue[p] = cardValue[p+1];
                    hand[p+1] = handTemp;
                    cardValue[p+1] = cardValueTemp;
                }
            }
        }
        return hand;
    }
}
