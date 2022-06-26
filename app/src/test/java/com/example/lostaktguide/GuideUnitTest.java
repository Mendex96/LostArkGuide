package com.example.lostaktguide;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import com.example.lostaktguide.app.GuideMediator;
import com.example.lostaktguide.init.InitActivity;
import com.example.lostaktguide.login.LoginActivity;
import com.example.lostaktguide.register.RegisterActivity;
import com.example.lostaktguide.class_Detail.Class_DetailActivity;
import com.example.lostaktguide.subclass.SubClassActivity;
import com.example.lostaktguide.types.TypeActivity;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class GuideUnitTest {

    ActivityController<InitActivity> controller1;
    ActivityController<LoginActivity> controller2;
    ActivityController<RegisterActivity> controller3;
    ActivityController<SubClassActivity> controller4;
    ActivityController<TypeActivity> controller5;
    ActivityController<Class_DetailActivity> controller6;

    //Pantalla init

    Button Login, register, guest;

    //Pantalla login
    TextView userL, passwordL;
    EditText userIntL, passwordIntL;
    Button LogL;

    //Pantalla register
    TextView userR, passwordR;
    EditText userIntR, passwordIntR;
    Button Reg;

    //Pantalla subClass

    TextView SubclassName;
    ImageButton next, previous, favorite;
    Button search;
    ImageView subClass;

    //Pantalla SubClass_detail
    ImageView superior;
    TextView info;
    WebView guia;


    public void setUp(){

        GuideMediator.resetInstance();

        controller1 = Robolectric.buildActivity(InitActivity.class);
        controller2 = Robolectric.buildActivity(LoginActivity.class);
        controller3 = Robolectric.buildActivity(RegisterActivity.class);
        controller4 = Robolectric.buildActivity(SubClassActivity.class);
        controller5 = Robolectric.buildActivity(TypeActivity.class);
        controller6 = Robolectric.buildActivity(Class_DetailActivity.class);

        controller1.create().resume().visible();
        updateResources1();
        updateResources2();
        updateResources3();
        updateResources4();
        updateResources5();

    }

    private void updateResources1() {

        InitActivity activity1 = controller1.get();

        Login = activity1.findViewById(R.id.login_button);
        register = activity1.findViewById(R.id.register_button);
        guest = activity1.findViewById(R.id.guest_button);
    }

    private void updateResources2() {

        LoginActivity activity2 = controller2.get();


        userIntL = activity2.findViewById(R.id.user_nameL);
        passwordL = activity2.findViewById(R.id.password_nameL);

        userIntL = activity2.findViewById(R.id.user_inputL);
        passwordIntL = activity2.findViewById(R.id.password_inputL);

        LogL = activity2.findViewById(R.id.log_button);
    }

    private void updateResources3() {

        RegisterActivity activity3 = controller3.get();

        userR = activity3.findViewById(R.id.user_nameR);
        passwordR = activity3.findViewById(R.id.password_nameR);

        userIntR = activity3.findViewById(R.id.guest_button);
        passwordIntR = activity3.findViewById(R.id.password_inputR);

        Reg = activity3.findViewById(R.id.reg_button);

    }

    private void updateResources4() {

        SubClassActivity activity4 = controller4.get();

        next = activity4.findViewById(R.id.next_button);
        previous = activity4.findViewById(R.id.previous_button);
        favorite = activity4.findViewById(R.id.star_button);

        search = activity4.findViewById(R.id.search_button);

        subClass = activity4.findViewById(R.id.subClass_image);

    }

    private void updateResources5() {

        Class_DetailActivity activity6 = controller6.get();

        superior = activity6.findViewById(R.id.superior);
        info = activity6.findViewById(R.id.detalle);
        guia = activity6.findViewById(R.id.guia);

    }

    private void rotate1() {

        Bundle bundle = new Bundle();

        controller2
                .saveInstanceState(bundle)
                .pause()
                .stop()
                .destroy();

        controller2 = Robolectric.buildActivity(LoginActivity.class)
                .create(bundle)
                .restoreInstanceState(bundle)
                .resume()
                .visible();

    }

    private void rotate2() {

        Bundle bundle = new Bundle();

        controller3
                .saveInstanceState(bundle)
                .pause()
                .stop()
                .destroy();

        controller3 = Robolectric.buildActivity(RegisterActivity.class)
                .create(bundle)
                .restoreInstanceState(bundle)
                .resume()
                .visible();

    }

    private void rotate3() {

        Bundle bundle = new Bundle();

        controller4
                .saveInstanceState(bundle)
                .pause()
                .stop()
                .destroy();

        controller4 = Robolectric.buildActivity(SubClassActivity.class)
                .create(bundle)
                .restoreInstanceState(bundle)
                .resume()
                .visible();

    }

    private void rotate4() {

        Bundle bundle = new Bundle();

        controller5
                .saveInstanceState(bundle)
                .pause()
                .stop()
                .destroy();

        controller5 = Robolectric.buildActivity(TypeActivity.class)
                .create(bundle)
                .restoreInstanceState(bundle)
                .resume()
                .visible();

    }

    private void rotate5() {

        Bundle bundle = new Bundle();

        controller6
                .saveInstanceState(bundle)
                .pause()
                .stop()
                .destroy();

        controller6 = Robolectric.buildActivity(Class_DetailActivity.class)
                .create(bundle)
                .restoreInstanceState(bundle)
                .resume()
                .visible();

    }



    @Test
    public void whenLogin_incorrect() {


    }

    @Test
    public void whenLogin_correct() {


    }
    @Test
    public void whenLogin_rotate_without_text() {


    }

    @Test
    public void whenLogin_rotate_with_text() {


    }

    @Test
    public void whenRegister_rotate_with_text() {


    }

    @Test
    public void whenRegister_rotate_without_text() {


    }

    @Test
    public void whenRegister_user_used() {


    }

    @Test
    public void whenRegister_completed() {


    }

    @Test
    public void maga_pressed() {


    }

    @Test
    public void guest_pressed_favorite_click() {


    }

    @Test
    public void cazasombra_search() {


    }

    @Test
    public void cazasombra_search_rotate() {


    }


    @Test
    public void cazasombra_search_Striker() {


    }

    @Test
    public void artista_favorite() {


    }

    @Test
    public void artista_favorite_rotate() {


    }

    @Test
    public void maga_no_favorite() {


    }

    @Test
    public void gujista_details() {


    }

    @Test
    public void gujista_details_rotate() {


    }
}