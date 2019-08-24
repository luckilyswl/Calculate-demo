package com.qingshangzuo.calculation;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{


    private TextView textview;
    private StringBuilder sb = new StringBuilder();

    private int count_negative = 0; //负数标记
    private final int vibrate_time = 5; //震动时长
    private boolean equals = false;
    private int count_bracket_left = 0;
    private int count_bracket_right = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        // 定义控件
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonDot =  findViewById(R.id.buttonDot);
        Button buttonEqual =  findViewById(R.id.buttonEqual);
        Button buttonAdd =  findViewById(R.id.buttonAdd);
        Button buttonDec =  findViewById(R.id.buttonDec);
        Button buttonMulti =  findViewById(R.id.buttonMulti);
        Button buttonAC =  findViewById(R.id.buttonAC);
        Button buttonBracketLeft =  findViewById(R.id.buttonBracketLeft);
        Button buttonBracketRight =  findViewById(R.id.buttonBracketRight);
        Button buttonDiv =  findViewById(R.id.buttonDiv);
        textview = findViewById(R.id.text_view);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonBracketLeft.setOnClickListener(this);
        buttonBracketRight.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonDec.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                sb = sb.append("0");
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button1:
                if (equals) { //当equals为true，输入数字，清空字符串，在把标志变为false
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*1");
                } else {
                    sb = sb.append("1");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button2:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*2");
                } else {
                    sb = sb.append("2");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button3:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*3");
                } else {
                    sb = sb.append("3");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button4:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*4");
                } else {
                    sb = sb.append("4");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button5:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*5");
                } else {
                    sb = sb.append("5");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button6:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*6");
                } else {
                    sb = sb.append("6");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button7:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*7");
                } else {
                    sb = sb.append("7");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button8:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*8");
                } else {
                    sb = sb.append("8");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.button9:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*9");
                } else {
                    sb = sb.append("9");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonC: //删除
                if (equals) {
                    equals = false;
                }
                if (sb.length() != 0) {
                    sb = sb.deleteCharAt(sb.length() - 1);
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonAC: //清空
                if (equals) {
                    equals = false;
                }
                sb = sb.delete(0, sb.length());
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonBracketLeft: //左括号
                if (equals) {
                    equals = false;
                }
                if (sb.length() > 0 && (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')) { //当前面是数字是，自动添加为'*('
                    sb = sb.append("*(");
                }
                if (sb.length() == 0) { //如果此时字符串是空的，也就是说想在式子最前面添加括号，就添加括号
                    sb = sb.append("(");
                }
                if (sb.length() > 0 && (sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/' || sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-')) { //如果当括号前面是符号时添加括号
                    sb = sb.append("(");
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonBracketRight: //=右括号
                if (equals) {
                    equals = false;
                }
                int count_num = 0; //数字的数目
                count_bracket_left = count_bracket_right = 0;
                if (sb.length() != 0) {
                    for (int i = sb.length() - 1; i >= 0; i--) { //对字符串进行遍历，如果存在左括号且括号中有数字，标记转为真,
                        if (count_bracket_left == 0 && (sb.charAt(i) >= '0' && sb.charAt(i) <= '9')) {
                            count_num++;
                        }
                        if (sb.charAt(i) == '(') {
                            count_bracket_left++;
                        }
                        if (sb.charAt(i) == ')') {
                            count_bracket_right++;
                        }
                    }
                    Log.d("count_bracket", String.valueOf(count_bracket_left+" "+count_bracket_right));
                    if ((count_bracket_left > count_bracket_right) && count_num > 0) { //当标记均为真，也就是存在左括号时且在左括号前面有数字，才让添加括号
                        sb = sb.append(")");
                    }
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonDiv: //除号
                if (equals) {
                    equals = false;
                }
                if (sb.length() != 0) {
                    if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') || sb.charAt(sb.length() - 1) == '.') {
                        if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')) { //如果前一位是数字，就直接添加
                            // if (count_negative > 0){ //如果前面是负数，就加上括号
                            //     sb = sb.append(")/");
                            //     count_negative = 0;
                            // } else {
                            sb = sb.append("/");
                            // }
                        }
                        if (sb.charAt(sb.length() - 1) == '.') { //如果前一位是'.',就先为前一位数字补0
                            sb = sb.append("0/");
                        }
                    }
                    if ((sb.charAt(sb.length() - 1) == ')')) { //如果前一位是')'也让加上/
                        sb = sb.append("/");
                    }
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonMulti: //乘号
                if (equals) {
                    equals = false;
                }
                if (sb.length() != 0) {
                    if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') || sb.charAt(sb.length() - 1) == '.') {
                        if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')) {//如果前一位是数字，就直接添加
                            sb = sb.append("*");
                        }
                        if (sb.charAt(sb.length() - 1) == '.') {//如果前一位是'.',就先为前一位数字补0
                            sb = sb.append("0*");
                        }
                    }
                    if ((sb.charAt(sb.length() - 1) == ')')) {
                        sb = sb.append("*");
                    }
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonDec: //减号
                if (equals) {
                    equals = false;
                }
                if (sb.length() != 0) {
                    if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') || sb.charAt(sb.length() - 1) == '.' ||
                            sb.charAt(sb.length() - 1) == '(') {
                        if (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') {//如果前一位是数字，就直接添加
                            // if (count_negative > 0) { //如果前面是负数，就加上括号
                            //     sb = sb.append(")-");
                            //     count_negative = 0;
                            // } else {
                            sb = sb.append("-");
                            // }
                        }
                        if (sb.charAt(sb.length() - 1) == '.') {//如果前一位是'.',就先为前一位数字补0
                            sb = sb.append("0-");
                        }
                        if (sb.charAt(sb.length() - 1) == '(') {
                            sb = sb.append("-");
                            count_negative++;
                        }

                    } else if ((sb.charAt(sb.length() - 1) == ')')) {
                        sb = sb.append("-");
                    } else {
                        sb = sb.append("(-");
                    }

                } else { //负号
                    sb = sb.append("(-");
                    count_negative++;
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonAdd: //加号
                if (equals) {
                    equals = false;
                }
                if (sb.length() != 0) {
                    if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') || sb.charAt(sb.length() - 1) == '.') {
                        if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')) {//如果前一位是数字，就直接添加
                            // if (count_negative > 0) { //如果前面是负数，就加上括号
                            //     sb = sb.append(")+");
                            //     count_negative = 0;
                            // } else {
                            sb = sb.append("+");
                            // }
                        }
                        if (sb.charAt(sb.length() - 1) == '.') {//如果前一位是'.',就先为前一位数字补0
                            sb = sb.append("0+");
                        }
                    }
                    if ((sb.charAt(sb.length() - 1) == ')')) {
                        sb = sb.append("+");
                    }
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonDot: //小数点
                if (equals) {
                    equals = false;
                }
                if (sb.length() != 0) {
                    int count_dot = 0;
                    for (int i = sb.length() - 1; i >= 0; i--) {
                        if (sb.charAt(i) == '.') {
                            count_dot++;
                        }
                        if (!(sb.charAt(i) >= '0' && sb.charAt(i) <= '9')) {
                            break;
                        }
                    }
                    if (count_dot == 0) {
                        if (sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/' || sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-') {
                            // 如果最后一位是符号时，直接输小数点会自动补'0'，形成'0.'
                            sb = sb.append("0.");
                        } else {
                            sb = sb.append(".");
                        }
                    }
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                textview.setText(sb.toString());
                break;
            case R.id.buttonEqual: //等号
                if (equals) {
                    equals = false;
                }
                count_bracket_right = count_bracket_left = 0;
                if (sb.length() != 0) {
                    for (int i = 0; i < sb.length(); i++) {
                        if (sb.charAt(i) == '(')
                            count_bracket_left++;
                        if (sb.charAt(i) == ')')
                            count_bracket_right++;
                    }
                    if (count_bracket_left != count_bracket_right) {
                        Toast.makeText(MainActivity.this, "请注意括号匹配", Toast.LENGTH_SHORT).show();
                    }
                    if (count_bracket_left == count_bracket_right &&
                            ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') || sb.charAt(sb.length() - 1) == ')')) {
                        equals = true;
                        count_negative = 0;
                        try {
                            textview.setText(InfixToSufix.Cal(InfixToSufix.Suffix(sb)));
                            sb = sb.delete(0, sb.length());
                            sb.append(textview.getText().toString());
                        } catch (Exception e){
                            textview.setText("Error");
                            sb = sb.delete(0, sb.length());
                        }
                    }
                }
                Vibrate.vSimple(view.getContext(), vibrate_time);
                break;
            default:
                break;
        }
    }

}
