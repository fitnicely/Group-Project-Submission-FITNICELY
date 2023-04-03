
import java.util.ArrayList;
import java.util.Scanner;
public class Navigation extends Keyword {
    //implementing inheritance

    private ArrayList<String> videoKeyword = new ArrayList<>();
    private ArrayList<String> navigationKeyword = new ArrayList<>();

    public void setInitialVideoKeyword() {
        try {
            videoKeyword.add("pilates");
            videoKeyword.add("yoga");
            videoKeyword.add("zumba");
            videoKeyword.add("aerobic");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setInitialNavigationKeyword(){
        try {
            navigationKeyword.add("profile");
            navigationKeyword.add("logout");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Boolean findNavigation(String searchFeatures) {
        String[] oneKey = searchFeatures.split(" ");
        for (int i = 0; i < oneKey.length; i++) {
            if (navigationKeyword.contains(oneKey[i])) {
                //System.out.println(searchFeatures+" found in "+navigationKeyword);
                return true;
            }
            else if (videoKeyword.contains(oneKey[i])){
                //System.out.println(searchFeatures + " found in " + videoKeyword);
                return true;
            }
        }
        return false;
    }

    public void updateKeyword(String key, int ans){
        try {
            if(ans == 1){
                this.videoKeyword.add(key);
            }
            else if (ans==2){
                this.navigationKeyword.add(key);
            }}
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }


    public void removeKeyword(String key, int ans){
        try {
            if(ans ==1){
                this.videoKeyword.remove(key);
            }
            else if (ans==2){
                this.navigationKeyword.remove(key);
            }    }
        catch(Exception ex) {
            ex.printStackTrace();

        }
    }

    public String displayList(){
        try {

            String result = "video keyword : " +this.videoKeyword+"\nnavigation keyword : "+this.navigationKeyword;
            return result;
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;}



    //application code : to execute without the GUI
    public static void main(String args[]){

        Scanner cin = new Scanner(System.in);
        Keyword keyword = new Navigation();
        //creating a new object for the subclass without creating a new object for the abstract class


        keyword.setInitialVideoKeyword();
        keyword.setInitialNavigationKeyword();

        //executing the search bar featuresin the app
        System.out.println("------------USER VIEW--------------");
        System.out.println("keyword to search: ");
        String searchFeature= cin.nextLine().toLowerCase().trim();
        boolean find = keyword.findNavigation(searchFeature);
        if (find == true){
            System.out.println("found");
            //it will go to the page they searched for
        }
        else{
            System.out.println("not found");
        }

        System.out.println(keyword.displayList()) ;
    }
}
