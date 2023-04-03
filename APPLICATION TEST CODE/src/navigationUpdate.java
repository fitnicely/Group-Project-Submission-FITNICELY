import java.util.Scanner;
import java.util.ArrayList;

public class navigationUpdate {
    private int ans = 0;
    private String key = "";


    //to execute the admin update keyword features
    //test code
    public static void main(String[] args) {

        navigationUpdate here = new navigationUpdate();
        Navigation adminNavi = new Navigation();
        Scanner cin = new Scanner(System.in);

        adminNavi.setInitialNavigationKeyword();
        adminNavi.setInitialVideoKeyword();
        int option = 0;
        System.out.println("-----------ADMIN VIEW--------------");
        //method getSelection not GUI-based
        System.out.println("enter the keyword to update : ");
        here.key = cin.nextLine();
        System.out.println("[1]update in video list \n[2]update in navigation list");
        here.ans = cin.nextInt();
        System.out.println("[1]ADD KEYWORD TO THE LIST \n[2] DELETE KEYWORD IN THE LIST");
        option = cin.nextInt();

        try{
            if (option == 1){
                adminNavi.updateKeyword(here.key, here.ans);}
            else if(option ==2) {
                adminNavi.removeKeyword(here.key, here.ans);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(adminNavi.displayList());


    }

}