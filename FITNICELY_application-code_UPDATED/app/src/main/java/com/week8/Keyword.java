package com.week8;
import java.util.ArrayList;
public abstract class Keyword {

    public abstract void setInitialVideoKeyword();
    public abstract void setInitialNavigationKeyword();
    public abstract Boolean findNavigation(String searchFeatures);
    public abstract String displayList();
    public abstract void removeKeyword(String key,int ans);

    public abstract void updateKeyword(String key,int ans);
}
