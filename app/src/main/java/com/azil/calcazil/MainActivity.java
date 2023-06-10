package com.azil.calcazil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    // Declaring Our Layout Elements Variables
    TextView Layout_result;
    public Button button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0;
    Button button_c,button_divide,button_percent,button_multiply,button_minus,button_plus,button_equals;
    Button button_dot;
    public float a;
    public float b = 0;
    public float results;
    public String lastOperator ="";
    public boolean MinusLock=true;
    public boolean PowerLock=true;
    public boolean DivisionLock = true;
    boolean OpOrTxt;
    boolean Equalock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        OpOrTxt = false;
        Equalock = false;
        a = 0;
        results = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking Our Layout Variables to the Layout Elements and setting its listener
        Layout_result=findViewById(R.id.textview_result);

        button_1=findViewById(R.id.button_1);
        button_1.setOnClickListener(this);

        button_2=findViewById(R.id.button_2);
        button_2.setOnClickListener(this);

        button_3=findViewById(R.id.button_3);
        button_3.setOnClickListener(this);

        button_4=findViewById(R.id.button_4);
        button_4.setOnClickListener(this);

        button_5=findViewById(R.id.button_5);
        button_5.setOnClickListener(this);

        button_6=findViewById(R.id.button_6);
        button_6.setOnClickListener(this);

        button_7=findViewById(R.id.button_7);
        button_7.setOnClickListener(this);

        button_8=findViewById(R.id.button_8);
        button_8.setOnClickListener(this);

        button_9=findViewById(R.id.button_9);
        button_9.setOnClickListener(this);

        button_0=findViewById(R.id.button_0);
        button_0.setOnClickListener(this);

        button_c=findViewById(R.id.button_c);
        button_c.setOnClickListener(this);

        button_divide=findViewById(R.id.button_divide);
        button_divide.setOnClickListener(this);

        button_percent=findViewById(R.id.button_percent);
        button_percent.setOnClickListener(this);

        button_multiply=findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);

        button_minus=findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);

        button_plus=findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);

        button_equals=findViewById(R.id.button_equals);
        button_equals.setOnClickListener(this);

        button_dot=findViewById(R.id.button_dot);
        button_dot.setOnClickListener(this);

        Layout_result.setText("");

     /*
    assignIdlistenerg(button_1,R.id.button_1);
    void assignIdlistenerg(Button btn,int theid)
    {
      //  btn = findViewById(theid);
       // btn.setOnClickListener(this);
    }
   */


    }

    // Detecting The clicks of buttons
    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String btntxt = button.getText().toString();
        String datatocalculate = Layout_result.getText().toString();
        if(btntxt.equals("1") || btntxt.equals("2") || btntxt.equals("3") || btntxt.equals("4")
                ||btntxt.equals("5") || btntxt.equals("6") ||btntxt.equals("7")
                || btntxt.equals("8") ||btntxt.equals("9") || btntxt.equals("0") ||btntxt.equals("."))
        {
            datatocalculate = datatocalculate + btntxt;
            Layout_result.setText(datatocalculate);
            OpOrTxt=true;

        }
        else {

//##################################################################################################
            if (btntxt.equals("+")&&OpOrTxt) {
                datatocalculate = Layout_result.getText().toString();
                System.out.println("begining of click resullts :  " + results);
                System.out.println("begining of click OpOrTxt :  " + OpOrTxt);
                System.out.println("begining of click a :  " + a);
                b = Float.valueOf(datatocalculate);
                System.out.println("value on input b :" + b);
                a += b;
                System.out.println("a += b : " + a);
                Layout_result.setText("");
                this.lastOperator = "+";
                OpOrTxt = false;
                Equalock=true;
                System.out.println("end of click plus OpOrTxt :  "+ OpOrTxt);
            }
//##################################################################################################
            if (btntxt.equals("-")&&OpOrTxt) {
                datatocalculate = Layout_result.getText().toString();
                System.out.println("begining of Minus click resullts :  " + results);
                System.out.println("begining of Minus click a :  " + a);
                if (this.MinusLock)  // for first sequence and else is similar to addition
                {
                    a = Float.valueOf(datatocalculate);
                    System.out.println("inside first lock of Minus click a  :  " + a);
                    b = 0;
                    System.out.println("inside first lock of Minus click b :  " + b);
                    this.MinusLock = false;
                } else {
                    b = Float.valueOf(datatocalculate);
                    System.out.println("value on input b :" + b);
                    a -= b;
                    System.out.println("a -= b : " + a);
                }

                Layout_result.setText("");
                this.lastOperator = "-";
                OpOrTxt = false;
                Equalock=true;
            }
//##################################################################################################
            if (btntxt.equals("X")&&OpOrTxt) {
                datatocalculate = Layout_result.getText().toString();
                System.out.println("begining of Power click resullts :  " + results);
                System.out.println("begining of Power click a :  " + a);
                if (this.PowerLock)  // for first sequence and else is similar to addition
                {
                    a = Float.valueOf(datatocalculate);

                    System.out.println("inside first lock of Power click a :  " + a);
                    //b = Float.valueOf(datatocalculate);
                    System.out.println("inside first lock of Power click b :  " + b);
                    this.PowerLock = false;
                } else {
                    b = Float.valueOf(datatocalculate);
                    System.out.println("value on input b :" + b);
                    a *= b;
                    System.out.println("a *= b : " + a);
                    this.lastOperator = "X";
                }
                Layout_result.setText("");
                this.lastOperator = "X";
                OpOrTxt = false;
                Equalock=true;
            }
//##################################################################################################
            if (btntxt.equals("/")&&OpOrTxt) {
                datatocalculate = Layout_result.getText().toString();
                System.out.println("begining of Division click resullts :  " + results);
                System.out.println("begining of Division click a :  " + a);
                if (this.DivisionLock)  // for first sequence and else is similar to addition
                {
                    a = Float.valueOf(datatocalculate);
                    ;
                    System.out.println("inside first lock of Division click a :  " + a);
                    //b = Float.valueOf(datatocalculate);
                    System.out.println("inside first lock of Division click b :  " + b);
                    this.DivisionLock = false;
                } else {
                    b = Float.valueOf(datatocalculate);
                    System.out.println("value on input b :" + b);
                    a /= b;
                    System.out.println("a /= b : " + a);
                    this.lastOperator = "/";
                }
                Layout_result.setText("");
                this.lastOperator = "/";
                OpOrTxt = false;
                Equalock=true;
            }
//##################################################################################################
            if (btntxt.equals("%")&&OpOrTxt) {
                datatocalculate = Layout_result.getText().toString();
                System.out.println("begining of Percent click resullts :  " + results);
                System.out.println("begining of Percent click a :  " + a);

                a = Float.valueOf(datatocalculate);
                ;
                System.out.println(" Percent after click a :  " + a);
                a = a / 100;
                System.out.println("the Percentage a :  " + a);
                Layout_result.setText(String.valueOf(a));
                this.lastOperator = "%";

            }
//##################################################################################################
            // we restart our initiale state
            if (btntxt.equals("C")) {
                datatocalculate = Layout_result.getText().toString();
                a = 0;
                b = 0;
                results = 0;
                lastOperator = "";
                MinusLock = true;
                PowerLock = true;
                DivisionLock = true;
                Layout_result.setText("");
                OpOrTxt = false;
                Equalock=false;
            }


//##################################################################################################
            // we check the case we are working on
            if (btntxt.equals("=")&&Equalock) {
                // getting the previous written and convert it to txt
                System.out.println("in equal button resullts :  " + results);
                System.out.println("in equal button " + a);
                System.out.println("in equalOpOrTxt :  " + OpOrTxt);
                OpOrTxt = true;
                Equalock=false;
                System.out.println("in equal OpOrTxt :  " + OpOrTxt);
                switch (this.lastOperator) {
                    case "+":
                        b = Float.valueOf(datatocalculate);
                        System.out.println("value on input b :" + b);
                        this.results = this.a + b;

                        System.out.println("in equal button after adding resullts :  " + results);
                        break;
                    case "-":
                        b = Float.valueOf(datatocalculate);
                        this.results = this.a - b;
                        this.MinusLock = true;
                        System.out.println("in equal button after Minus resullts :  " + results);

                        break;
                    case "/":
                        b = Float.valueOf(datatocalculate);
                        this.results = this.a / b;
                        System.out.println("in equal button after Division resullts :  " + results);
                        this.DivisionLock = true;
                        break;
                    case "X":
                        b = Float.valueOf(datatocalculate);
                        this.results = this.a * b;
                        this.PowerLock = true;
                        System.out.println("in equal button after Power resullts :  " + results);
                        break;

                }

                Layout_result.setText(String.valueOf(this.results));
                // this next two lines are for reinstalling the new calculation after the equal
                this.a = 0;
                this.results = 0;


            }

        }



    }



}