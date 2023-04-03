package com.week8;

import java.util.ArrayList;
import java.util.Random;
import  java.util.Scanner;


public class quotesInformation{
    protected ArrayList<String> quotesList;
    public quotesInformation(){

        quotesList = new ArrayList<>();
        quotesList.add("Create healthy habits, not restrictions.");
        quotesList.add("Healthy is an outfit that looks different on everybody.");
        quotesList.add("He who has health has hope and he who has hope has everything.");
        quotesList.add("Let’s build wellness rather than treat disease");
        quotesList.add("A healthy outside starts from the inside.");
        quotesList.add("It is health that is real wealth and not pieces of gold and silver.");
        quotesList.add("Let’s build wellness rather than treat disease.");
        quotesList.add("Yes, I am trying to be healthy. No, I am not on a diet.");
    }

    public String displayQuotesList() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Quotes list:\n");
        for (String quote : getQuotesList()) {
            sb.append("• ").append(quote).append("\n");
        }
        return sb.toString();
    }
    public void updateQuotes(String quote){

        this.quotesList.add(quote);
    }



    public void removeQuotes(String quote){

        this.quotesList.remove(quote);
    }

    public ArrayList<String> getQuotesList() {

        return this.quotesList;
    }

    public String getRandomElement(){
        Random rand = new Random();
        int index = rand.nextInt(quotesList.size());
        return quotesList.get(index);
    }

    //application code : to execute without the GUI
   /* public static void main(String args[]){

        Scanner cin = new Scanner(System.in);
        quotesInformation obj = new quotesInformation();

        //creating a new ArrayList quotesList
        ArrayList<String> quotesList;
        String quote;

        System.out.println("Do you want to add or delete quotes? (A for add, D for delete)");
        String answer = cin.nextLine();

        if (answer.equalsIgnoreCase("A")) {
            System.out.println("Type the quote: ");
            quote = cin.nextLine();
            obj.updateQuotes(quote);
        } else if (answer.equalsIgnoreCase("D")) {
            System.out.println("Type the quote: ");
            quote = cin.nextLine();
            obj.removeQuotes(quote);
        }

        //display the arraylist after add/remove
        System.out.println(obj.displayQuotesList());
    }*/
}