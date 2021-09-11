package com.example.a16039015khy;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a16039015khy.R;
import com.example.a16039015khy.Week;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    View dialogView;
    EditText dlgEdt1, dlgEdt2, dlgEdt3, dlgEdt4, dlgEdt5;
    LinearLayout calendarLayout;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.month1) {
            Intent Month = new Intent(this, MainActivity.class);
            startActivity(Month);
        }
        if (id == R.id.week1) {
            Intent Week = new Intent(this, com.example.a16039015khy.Week.class);
            startActivity(Week);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar cal = Calendar.getInstance();

        setTitle("16039015 김형윤 달력 만들기");
        Date time = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat( "yy-MM-dd");
        final String time1 = format1.format(time);

        Button date = (Button)findViewById(R.id.todaydate);
        final EditText to1 = (EditText)findViewById(R.id.to1);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to1.setVisibility(View.VISIBLE);
                to1.setText(time1);
            }
        });


        final EditText memo1 = (EditText)findViewById(R.id.memo1);
        final EditText memo2 = (EditText)findViewById(R.id.memo2);
        final EditText memo3 = (EditText)findViewById(R.id.memo3);
        final EditText memo4 = (EditText)findViewById(R.id.memo4);
        final EditText memo5 = (EditText)findViewById(R.id.memo5);
        final EditText memo6 = (EditText)findViewById(R.id.memo6);
        calendarLayout = (LinearLayout) findViewById(R.id.calendarLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;



        final LinearLayout week[] = new LinearLayout[64];
        for (int i = 0; i < 64; i++) {
            week[i] = new LinearLayout(this);
            week[i].setOrientation(LinearLayout.HORIZONTAL);
        }

        for (int i = 0; i < 64; i++) {
            calendarLayout.addView(week[i]);
        }

        final Button btn[] = new Button[443];
        for (int i = 0; i < 443; i++) {
            btn[i] = new Button(this);
            btn[i].setWidth(20);
            btn[i].setTextSize(11);
            btn[i].setBackgroundColor(Color.WHITE);
            btn[i].setId(i);
        }

        for (int i = 0; i < 2; i++) {
            btn[i].setText("");
            week[0].addView(btn[i], params);
        }
        for (int i = 2; i < 3; i++) {
            btn[i].setText("1월");
            btn[i].setTextSize(20);
            week[0].addView(btn[i], params);
        }
        for (int i = 3; i < 7; i++) {
            btn[i].setText("" + (i - 2));
            btn[6].setTextColor(Color.BLUE);
            btn[7].setTextColor(Color.RED);
            week[0].addView(btn[i], params);
        }
        for (int i = 7; i < 14; i++) {
            btn[i].setText("" + (i - 2));
            btn[13].setTextColor(Color.BLUE);
            btn[14].setTextColor(Color.RED);
            week[1].addView(btn[i], params);
        }

        for (int i = 14; i < 21; i++) {
            btn[i].setText("" + (i - 2));
            btn[20].setTextColor(Color.BLUE);
            btn[21].setTextColor(Color.RED);
            week[2].addView(btn[i], params);
        }

        for (int i = 21; i < 28; i++) {
            btn[i].setText("" + (i - 2));
            btn[27].setTextColor(Color.BLUE);
            btn[28].setTextColor(Color.RED);
            week[3].addView(btn[i], params);
        }
        for (int i = 28; i < 32; i++) {
            btn[i].setText("" + (i - 2));
            week[4].addView(btn[i], params);
        }
        for (int i = 32; i < 34; i++) {
            btn[i].setText("" + (i - 2));
            week[4].addView(btn[i], params);
        }
        for (int i = 34; i < 35; i++) {
            btn[i].setText("");
            week[4].addView(btn[i], params);
        } //1월
        for (int i = 35; i < 40; i++) {
            btn[i].setText("");
            week[5].addView(btn[i], params);
        }
        for (int i = 40; i < 41; i++) {
            btn[i].setText("2월");
            btn[i].setTextSize(20);
            week[5].addView(btn[i], params);
        }
        for (int i = 41; i < 42; i++) {
            btn[i].setText("" + (i - 40));
            btn[41].setTextColor(Color.BLUE);
            week[5].addView(btn[i], params);
        }
        for (int i = 42; i < 49; i++) {
            btn[i].setText("" + (i - 40));
            btn[42].setTextColor(Color.RED);
            btn[48].setTextColor(Color.BLUE);
            btn[49].setTextColor(Color.RED);
            week[6].addView(btn[i], params);
        }

        for (int i = 49; i < 56; i++) {
            btn[i].setText("" + (i - 40));
            btn[55].setTextColor(Color.BLUE);
            btn[56].setTextColor(Color.RED);
            week[7].addView(btn[i], params);
        }

        for (int i = 56; i < 63; i++) {
            btn[i].setText("" + (i - 40));
            btn[62].setTextColor(Color.BLUE);
            btn[63].setTextColor(Color.RED);
            week[8].addView(btn[i], params);
        }
        for (int i = 63; i < 70; i++) {
            btn[i].setText("" + (i - 40));
            btn[69].setTextColor(Color.BLUE);
            btn[70].setTextColor(Color.RED);
            week[9].addView(btn[i], params);
        }//2월
        for (int i = 70; i < 71; i++) {
            btn[i].setText("");
            week[10].addView(btn[i], params);
        }
        for (int i = 71; i < 72; i++) {
            btn[i].setTextSize(20);
            btn[i].setText("3월");
            week[10].addView(btn[i]);
        } //3월 표시
        for (int i = 72; i < 79; i++) {
            btn[i].setText("" + (i - 71));
            btn[72].setTextColor(Color.RED);
            btn[78].setTextColor(Color.BLUE);
            week[11].addView(btn[i], params);
        }
        for (int i = 79; i < 86; i++) {
            btn[i].setText("" + (i - 71));
            btn[79].setTextColor(Color.RED);
            btn[85].setTextColor(Color.BLUE);
            week[12].addView(btn[i], params);
        }
        for (int i = 86; i < 93; i++) {
            btn[i].setText("" + (i - 71));
            btn[86].setTextColor(Color.RED);
            btn[92].setTextColor(Color.BLUE);
            week[13].addView(btn[i], params);
        }
        for (int i = 93; i < 100; i++) {
            btn[i].setText("" + (i - 71));
            btn[93].setTextColor(Color.RED);
            btn[99].setTextColor(Color.BLUE);
            week[14].addView(btn[i], params);
        }
        for (int i = 100; i < 103; i++) {
            btn[i].setText("" + (i - 71));
            btn[100].setTextColor(Color.RED);
            week[15].addView(btn[i], params);
        }
        for (int i = 103; i < 106; i++) {
            btn[i].setText("");
            week[15].addView(btn[i], params);
        } //3월 끝
        for (int i = 106; i < 107; i++) {
            btn[i].setText("4월");
            btn[i].setTextSize(20);
            week[15].addView(btn[i], params);
        } //4월 시작
        for (int i = 107; i < 110; i++) {
            btn[i].setText("");
            week[16].addView(btn[i], params);
        }
        for (int i = 110; i < 114; i++) {
            btn[i].setText("" + (i - 109));
            btn[113].setTextColor(Color.BLUE);
            week[16].addView(btn[i], params);
        }
        for (int i = 114; i < 121; i++) {
            btn[i].setText("" + (i - 109));
            btn[114].setTextColor(Color.RED);
            btn[120].setTextColor(Color.BLUE);
            week[17].addView(btn[i], params);
        }
        for (int i = 121; i < 128; i++) {
            btn[i].setText("" + (i - 109));
            btn[121].setTextColor(Color.RED);
            btn[127].setTextColor(Color.BLUE);
            week[18].addView(btn[i], params);
        }

        for (int i = 128; i < 135; i++) {
            btn[i].setText("" + (i - 109));
            btn[128].setTextColor(Color.RED);
            btn[134].setTextColor(Color.BLUE);
            week[19].addView(btn[i], params);
        }

        for (int i = 135; i < 140; i++) {
            btn[i].setText("" + (i - 109));
            btn[135].setTextColor(Color.RED);
            week[20].addView(btn[i], params);
        }
        for (int i = 140; i < 141; i++) {
            btn[i].setText("");
            week[20].addView(btn[i], params);
        }
        for (int i = 141; i < 142; i++) {
            btn[i].setText("5월");
            btn[i].setTextSize(20);
            week[20].addView(btn[i], params);
        }
        for (int i = 142; i < 147; i++) {
            btn[i].setText("");
            week[21].addView(btn[i], params);
        }// 5월 시작
        for (int i = 147; i < 149; i++) {
            btn[i].setText("" + (i - 146));
            btn[148].setTextColor(Color.BLUE);
            week[21].addView(btn[i], params);
        }
        for (int i = 149; i < 156; i++) {
            btn[i].setText("" + (i - 146));
            btn[149].setTextColor(Color.RED);
            btn[155].setTextColor(Color.BLUE);
            week[22].addView(btn[i], params);
        }
        for (int i = 156; i < 163; i++) {
            btn[i].setText("" + (i - 146));
            btn[156].setTextColor(Color.RED);
            btn[162].setTextColor(Color.BLUE);
            week[23].addView(btn[i], params);
        }

        for (int i = 163; i < 170; i++) {
            btn[i].setText("" + (i - 146));
            btn[163].setTextColor(Color.RED);
            btn[169].setTextColor(Color.BLUE);
            week[24].addView(btn[i], params);
        }
        for (int i = 170; i < 177; i++) {
            btn[i].setText("" + (i - 146));
            btn[170].setTextColor(Color.RED);
            btn[176].setTextColor(Color.BLUE);
            week[25].addView(btn[i], params);
        }
        for (int i = 177; i < 178; i++) {
            btn[i].setText("" + (i - 146));
            btn[177].setTextColor(Color.RED);
            week[26].addView(btn[i], params);
        } //5월 끝
        for (int i = 178; i < 182; i++) {
            btn[i].setText("");
            week[26].addView(btn[i], params);
        }
        for (int i = 182; i < 183; i++) {
            btn[i].setText("6월");
            btn[i].setTextSize(20);
            week[26].addView(btn[i], params);
        }// 6월 시작
        for (int i = 183; i < 184; i++) {
            btn[i].setText("");
            week[27].addView(btn[i], params);
        }
        for (int i = 184; i < 190; i++) {
            btn[i].setText("" + (i - 183));
            btn[189].setTextColor(Color.BLUE);
            week[27].addView(btn[i], params);
        }
        for (int i = 190; i < 197; i++) {
            btn[i].setText("" + (i - 183));
            btn[190].setTextColor(Color.RED);
            btn[196].setTextColor(Color.BLUE);
            week[28].addView(btn[i], params);
        }
        for (int i = 197; i < 204; i++) {
            btn[i].setText("" + (i - 183));
            btn[197].setTextColor(Color.RED);
            btn[203].setTextColor(Color.BLUE);
            week[29].addView(btn[i], params);
        }

        for (int i = 204; i < 211; i++) {
            btn[i].setText("" + (i - 183));
            btn[204].setTextColor(Color.RED);
            btn[210].setTextColor(Color.BLUE);
            week[30].addView(btn[i], params);
        }
        for (int i = 211; i < 214; i++) {
            btn[i].setText("" + (i - 183));
            btn[211].setTextColor(Color.RED);
            week[31].addView(btn[i], params);
        } //6월 끝
        for (int i = 214; i < 217; i++) {
            btn[i].setText("");
            week[31].addView(btn[i], params);
        }
        for (int i = 217; i < 218; i++) {
            btn[i].setText("7월");
            btn[i].setTextSize(20);
            week[31].addView(btn[i], params);
        } //7월 시작
        for (int i = 218; i < 221; i++) {
            btn[i].setText("");
            week[32].addView(btn[i], params);
        }
        for (int i = 221; i < 225; i++) {
            btn[i].setText("" + (i - 220));
            btn[224].setTextColor(Color.BLUE);
            week[32].addView(btn[i], params);
        }
        for (int i = 225; i < 232; i++) {
            btn[i].setText("" + (i - 220));
            btn[225].setTextColor(Color.RED);
            btn[231].setTextColor(Color.BLUE);
            week[33].addView(btn[i], params);
        }
        for (int i = 232; i < 239; i++) {
            btn[i].setText("" + (i - 220));
            btn[232].setTextColor(Color.RED);
            btn[238].setTextColor(Color.BLUE);
            week[34].addView(btn[i], params);
        }

        for (int i = 239; i < 246; i++) {
            btn[i].setText("" + (i - 220));
            btn[239].setTextColor(Color.RED);
            btn[245].setTextColor(Color.BLUE);
            week[35].addView(btn[i], params);
        }
        for (int i = 246; i < 252; i++) {
            btn[i].setText("" + (i - 220));
            btn[246].setTextColor(Color.RED);
            week[36].addView(btn[i], params);
        } //7월 끝
        for (int i = 252; i < 253; i++) {
            btn[i].setText("8월");
            btn[i].setTextSize(20);
            week[36].addView(btn[i], params);
        }
        for (int i = 253; i < 259; i++) {
            btn[i].setText("");
            week[37].addView(btn[i], params);
        }
        for (int i = 259; i < 260; i++) {
            btn[i].setText("" + (i - 258));
            btn[259].setTextColor(Color.BLUE);
            week[37].addView(btn[i], params);
        }
        for (int i = 260; i < 267; i++) {
            btn[i].setText("" + (i - 258));
            btn[260].setTextColor(Color.RED);
            btn[266].setTextColor(Color.BLUE);
            week[38].addView(btn[i], params);
        }
        for (int i = 267; i < 274; i++) {
            btn[i].setText("" + (i - 258));
            btn[267].setTextColor(Color.RED);
            btn[273].setTextColor(Color.BLUE);
            week[39].addView(btn[i], params);
        }

        for (int i = 274; i < 281; i++) {
            btn[i].setText("" + (i - 258));
            btn[274].setTextColor(Color.RED);
            btn[280].setTextColor(Color.BLUE);
            week[40].addView(btn[i], params);
        }
        for (int i = 281; i < 288; i++) {
            btn[i].setText("" + (i - 258));
            btn[281].setTextColor(Color.RED);
            btn[287].setTextColor(Color.BLUE);
            week[41].addView(btn[i], params);
        }
        for (int i = 288; i < 290; i++) {
            btn[i].setText("" + (i - 258));
            btn[288].setTextColor(Color.RED);
            week[42].addView(btn[i], params);
        }
        for (int i = 290; i < 294; i++) {
            btn[i].setText("");
            week[42].addView(btn[i], params);
        } // 8월 끝
        for (int i = 294; i < 295; i++) {
            btn[i].setText("9월");
            btn[i].setTextSize(20);
            week[42].addView(btn[i], params);
        }
        for (int i = 295; i < 297; i++) {
            btn[i].setText("");
            week[43].addView(btn[i], params);
        }
        for (int i = 297; i < 302; i++) {
            btn[i].setText("" + (i - 296));
            btn[301].setTextColor(Color.BLUE);
            week[43].addView(btn[i], params);
        }
        for (int i = 302; i < 309; i++) {
            btn[i].setText("" + (i - 296));
            btn[302].setTextColor(Color.RED);
            btn[308].setTextColor(Color.BLUE);
            week[44].addView(btn[i], params);
        }
        for (int i = 309; i < 316; i++) {
            btn[i].setText("" + (i - 296));
            btn[309].setTextColor(Color.RED);
            btn[315].setTextColor(Color.BLUE);
            week[45].addView(btn[i], params);
        }
        for (int i = 316; i < 323; i++) {
            btn[i].setText("" + (i - 296));
            btn[316].setTextColor(Color.RED);
            btn[322].setTextColor(Color.BLUE);
            week[46].addView(btn[i], params);
        }
        for (int i = 323; i < 327; i++) {
            btn[i].setText("" + (i - 296));
            btn[323].setTextColor(Color.RED);
            week[47].addView(btn[i], params);
        } //9월 끝
        for (int i = 327; i < 329; i++) {
            btn[i].setText("");
            week[47].addView(btn[i], params);
        }
        for (int i = 329; i < 330; i++) {
            btn[i].setText("10월");
            btn[i].setTextSize(20);
            week[47].addView(btn[i], params);
        }
        for (int i = 330; i < 334; i++) {
            btn[i].setText("");
            week[48].addView(btn[i], params);
        }
        for (int i = 334; i < 337; i++) {
            btn[i].setText("" + (i - 333));
            btn[336].setTextColor(Color.BLUE);
            week[48].addView(btn[i], params);
        }// 10월 시작
        for (int i = 337; i < 344; i++) {
            btn[i].setText("");
            btn[i].setText("" + (i - 333));
            btn[337].setTextColor(Color.RED);
            btn[343].setTextColor(Color.BLUE);
            week[49].addView(btn[i], params);
        }
        for (int i = 344; i < 351; i++) {
            btn[i].setText("" + (i - 333));
            btn[344].setTextColor(Color.RED);
            btn[350].setTextColor(Color.BLUE);
            week[50].addView(btn[i], params);
        }
        for (int i = 351; i < 358; i++) {
            btn[i].setText("");
            btn[i].setText("" + (i - 333));
            btn[351].setTextColor(Color.RED);
            btn[357].setTextColor(Color.BLUE);
            week[51].addView(btn[i], params);
        }
        for (int i = 358; i < 365; i++) {
            btn[i].setText("" + (i - 333));
            btn[358].setTextColor(Color.RED);
            btn[364].setTextColor(Color.BLUE);
            week[52].addView(btn[i], params);
        } // 10월 끝
        for (int i = 365; i < 371; i++) {
            btn[i].setText("");
            week[53].addView(btn[i], params);
        }
        for (int i = 371; i < 372; i++) {
            btn[i].setText("11월");
            btn[i].setTextSize(20);
            week[53].addView(btn[i], params);
        } //11월 시작
        for (int i = 372; i < 379; i++) {
            btn[i].setText("" + (i - 371));
            btn[372].setTextColor(Color.RED);
            btn[378].setTextColor(Color.BLUE);
            week[54].addView(btn[i], params);
        }
        for (int i = 379; i < 386; i++) {
            btn[i].setText("" + (i - 371));
            btn[379].setTextColor(Color.RED);
            btn[386].setTextColor(Color.BLUE);
            week[55].addView(btn[i], params);
        }
        for (int i = 386; i < 393; i++) {
            btn[i].setText("" + (i - 371));
            btn[386].setTextColor(Color.RED);
            btn[392].setTextColor(Color.BLUE);
            week[56].addView(btn[i], params);
        }
        for (int i = 393; i < 400; i++) {
            btn[i].setText("" + (i - 371));
            btn[393].setTextColor(Color.RED);
            btn[399].setTextColor(Color.BLUE);
            week[57].addView(btn[i], params);
        }
        for (int i = 400; i < 402; i++) {
            btn[i].setText("" + (i - 371));
            btn[400].setTextColor(Color.RED);
            week[58].addView(btn[i], params);
        } //11월 끝
        for (int i = 402; i < 406; i++) {
            btn[i].setText("");
            week[58].addView(btn[i], params);
        }
        for (int i = 406; i < 407; i++) {
            btn[i].setText("12월");
            btn[i].setTextSize(20);
            week[58].addView(btn[i], params);
        } //12월 시작

        for (int i = 407; i < 409; i++) {
            btn[i].setText("");
            week[59].addView(btn[i], params);
        }
        for (int i = 409; i < 414; i++) {
            btn[413].setTextColor(Color.BLUE);
            btn[i].setText("" + (i - 408));
            week[59].addView(btn[i], params);
        }
        for (int i = 414; i < 421; i++) {
            btn[i].setText("" + (i - 408));
            btn[414].setTextColor(Color.RED);
            btn[420].setTextColor(Color.BLUE);
            week[60].addView(btn[i], params);
        }
        for (int i = 421; i < 428; i++) {
            btn[i].setText("" + (i - 408));
            btn[421].setTextColor(Color.RED);
            btn[427].setTextColor(Color.BLUE);
            week[61].addView(btn[i], params);
        }
        for (int i = 428; i < 435; i++) {
            btn[i].setText("" + (i - 408));
            btn[428].setTextColor(Color.RED);
            btn[434].setTextColor(Color.BLUE);
            week[62].addView(btn[i], params);
        }
        for (int i = 435; i < 440; i++) {
            btn[i].setText("" + (i - 408));
            btn[435].setTextColor(Color.RED);
            week[63].addView(btn[i], params);
        }
        for (int i = 440; i < 442; i++) {
            btn[i].setText("");
            week[63].addView(btn[i], params);
        }

        for(int i = 0; i < 443; i++) {
            btn[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {


                    memo1.setText("약속 제목");
                    memo2.setText("시작 시간 날짜");
                    memo3.setText("종료 시간 날짜");
                    memo4.setText("장소");
                    memo5.setText("메모");

                    dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("일정");
                    dlgEdt1 = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                    dlgEdt2 = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                    dlgEdt3 = (EditText) dialogView.findViewById(R.id.dlgEdt3);
                    dlgEdt4 = (EditText) dialogView.findViewById(R.id.dlgEdt4);
                    dlgEdt5 = (EditText) dialogView.findViewById(R.id.dlgEdt5);

                    dlg.setIcon(R.drawable.cal);
                    dlg.setView(dialogView);
                    dlg.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                String txt1 = dlgEdt1.getText().toString();
                                String txt2 = dlgEdt2.getText().toString();
                                String txt3 = dlgEdt3.getText().toString();
                                String txt4 = dlgEdt4.getText().toString();
                                String txt5 = dlgEdt5.getText().toString();


                                    FileOutputStream outFs = openFileOutput
                                            ("MonthAssignment.txt", Context.MODE_APPEND);

                                    outFs.write(txt1.getBytes());
                                    outFs.write(txt2.getBytes());
                                    outFs.write(txt3.getBytes());
                                    outFs.write(txt4.getBytes());
                                    outFs.write(txt5.getBytes());
                                    outFs.close();
                                } catch(IOException e){
                                }
                                memo1.setText(dlgEdt1.getText().toString());
                                memo2.setText(dlgEdt2.getText().toString());
                                memo3.setText(dlgEdt3.getText().toString());
                                memo4.setText(dlgEdt4.getText().toString());
                                memo5.setText(dlgEdt5.getText().toString());
                                Toast.makeText(MainActivity.this, "저장했습니다.", Toast.LENGTH_SHORT).show();

                            }

                    }).setNeutralButton("일정 불러오기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            try {
                                FileInputStream fis = openFileInput("MonthAssignment.txt");//파일명
                                byte[] txt = new byte[500];
                                fis.read(txt);

                                String readedStr = new String(txt);
                                //읽어온 문장을 출력하기
                                memo6.setText(readedStr);
                                fis.close();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(MainActivity.this, "데이터를 불러왔습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    dlg.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText( MainActivity.this, "삭제했습니다.", Toast.LENGTH_SHORT).show();
                            deleteFile("MonthAssignment.txt");

                            memo1.setText("약속 제목");
                            memo2.setText("시작 시간 날짜");
                            memo3.setText("종료 시간 날짜");
                            memo4.setText("장소");
                            memo5.setText("메모");
                            memo6.setText("불러온 일정");
                        }
                    });

                    dlg.show();
                    return false;
                }
            });
        }
    }
}