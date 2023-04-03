public class Main {
    //mainPage1
    //test code for quotes

    //application code : to execute without the GUI
    public static void main(String args[]){

        quotesInformation quotes = new quotesInformation();
        //creating a new object for quotesInformation class

        //executing the random quotes list that is displayed on the textView in mainPage1
        System.out.println("Quotes: ");
        System.out.println(quotes.getRandomElement()) ;
    }
}