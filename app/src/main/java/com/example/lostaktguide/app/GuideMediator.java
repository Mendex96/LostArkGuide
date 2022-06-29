package com.example.lostaktguide.app;

import com.example.lostaktguide.class_Detail.Class_DetailState;
import com.example.lostaktguide.data.ClassItem;
import com.example.lostaktguide.data.FavoriteItem;
import com.example.lostaktguide.data.InitItem;
import com.example.lostaktguide.data.SubClassItem;
import com.example.lostaktguide.data.UserItem;
import com.example.lostaktguide.login.LoginState;
import com.example.lostaktguide.register.RegisterState;
import com.example.lostaktguide.subclass.SubClassState;
import com.example.lostaktguide.types.TypeState;

@SuppressWarnings("unused")
public class GuideMediator {

    private LoginState loginState = new LoginState();
    private RegisterState registerState = new RegisterState();
    private TypeState typeState = new TypeState();
    private SubClassState subClassState = new SubClassState();
    private Class_DetailState class_detailState = new Class_DetailState();

    private static GuideMediator INSTANCE;

    private ClassItem Class;
    private SubClassItem subClass;
    private FavoriteItem favorite;
    private UserItem user;
    private InitItem initState;
    private InitToTypeState init_State;

    private GuideMediator() {

    }


    public static GuideMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GuideMediator();
        }

        return INSTANCE;
    }

    // to reset the state when testing
    public static void resetInstance() {
        INSTANCE = null;
    }

    public Class_DetailState getClass_detailState(){return class_detailState;}
    public LoginState getLoginState(){return loginState;}
    public RegisterState getRegisterState(){return registerState;}
    public TypeState getTypeState(){return typeState;}
    public SubClassState getSubClassState(){return subClassState;}

    public UserItem getUser(){
        UserItem item = user;
        return item;
    }

    public ClassItem getClassI(){
        ClassItem item = Class;
        return item;
    }

    public SubClassItem getSubClass(){
        SubClassItem item = subClass;
        return item;
    }

    public FavoriteItem getFavorite(){
        FavoriteItem item = favorite;
        return item;
    }

    public InitToTypeState getInit_State(){
        InitToTypeState item = init_State;
        return item;
    }

    public void setClassItem(ClassItem item){Class = item;}
    public void setUser(UserItem item){user = item;}
    public void setSubClass(SubClassItem item){subClass = item;}
    public void setFavorite(FavoriteItem item){favorite = item;}
    public void setInit_State(InitToTypeState item){init_State = item;}


}