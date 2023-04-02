package com.week8;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityNavigationUpdateBinding;
import java.util.Scanner;
import java.util.ArrayList;

public class navigationUpdate extends AppCompatActivity {
ActivityNavigationUpdateBinding binding;
Navigation adminNavi = new Navigation();
    private int ans = 0;
    private String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationUpdateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        adminNavi.setInitialNavigationKeyword();
        adminNavi.setInitialVideoKeyword();

        binding.btnAddKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelection();
                    adminNavi.updateKeyword(key,ans);
                Toast.makeText(navigationUpdate.this, "keyword has been added", Toast.LENGTH_SHORT).show();
                binding.listNavigation.setText(adminNavi.displayList());
            }
        });
        binding.btnDeleteKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelection();
                adminNavi.removeKeyword(key,ans);
                Toast.makeText(navigationUpdate.this, "keyword has been deleted", Toast.LENGTH_SHORT).show();
                binding.listNavigation.setText(adminNavi.displayList());
            }
        });

        binding.btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.listNavigation.setText(adminNavi.displayList());
            }
        });

    }

    private void getSelection(){
        key = binding.editKeyword.getText().toString().toLowerCase();

        int check_rd = binding.rdOption.getCheckedRadioButtonId();
        if (check_rd==binding.rdNavigation.getId()){
            ans = 2;
        } else if (check_rd == binding.rdExercise.getId()) {
            ans = 1;
        }
    }

    //to execute the admin update keyword features
    /*public static void main(String[] args) {

        navigationUpdate here = new navigationUpdate();
        Navigation adminNavi = new Navigation();
        Scanner cin = new Scanner(System.in);
        ArrayList<String> videoKeyword = new ArrayList<String>();
        ArrayList<String> navigationKeyword = new ArrayList<String>();
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


    }*/

}