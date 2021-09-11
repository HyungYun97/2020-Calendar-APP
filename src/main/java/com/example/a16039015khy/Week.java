package com.example.a16039015khy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a16039015khy.MainActivity;
import com.example.a16039015khy.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.Vector;

public class Week extends AppCompatActivity {


    View dialogView;
    EditText dlgEdt1, dlgEdt2, dlgEdt3, dlgEdt4, dlgEdt5;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        setTitle("16039015 김형윤 달력 만들기");


        Date time1 = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat( "yy-MM-dd");
        final String time2 = format2.format(time1);



        Button date2 = (Button)findViewById(R.id.todaydate1);
        final EditText to2 = (EditText)findViewById(R.id.to2);
        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to2.setVisibility(View.VISIBLE);
                to2.setText(time2);
            }
        });
        final EditText memo1 = (EditText)findViewById(R.id.memo1);
        final EditText memo2 = (EditText)findViewById(R.id.memo2);
        final EditText memo3 = (EditText)findViewById(R.id.memo3);
        final EditText memo4 = (EditText)findViewById(R.id.memo4);
        final EditText memo5 = (EditText)findViewById(R.id.memo5);
        final EditText memo6 = (EditText)findViewById(R.id.memo6);

        TableLayout Month = (TableLayout) findViewById(R.id.table);

        final LinearLayout hourLayout = (LinearLayout) findViewById(R.id.hourLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        final LinearLayout hour[] = new LinearLayout[26];
        for (int i = 0; i < 25; i++) {
            hour[i] = new LinearLayout(this);
            hour[i].setOrientation(LinearLayout.HORIZONTAL);
            hourLayout.addView(hour[i]);
        }

        final Button btn1[] = new Button[369];
        final Button btn2[] = new Button[369];
        final TableRow tb1[] = new TableRow[3];
        final Button btn3[] = new Button[51];

        for (int i = 0; i < 3; i++) {
            tb1[i] = new TableRow(this);
            tb1[i].setOrientation(LinearLayout.HORIZONTAL);
            Month.addView(tb1[i]);
        }

        for (int i = 0; i < 368; i++) {
            btn1[i] = new Button(this);
            btn1[i].setWidth(10);
            btn1[i].setTextSize(13);
            btn1[i].setBackgroundColor(Color.WHITE);
            btn1[i].setId(i);
        }

        for (int i = 0; i < 2; i++) {
            btn1[i].setText("");
            tb1[0].addView(btn1[i]);
        }
        for (int i = 2; i < 368; i++) {
            if (i % 7 == 2) {
                btn1[i].setText("수");
                tb1[0].addView(btn1[i]);
            } else if (i % 7 == 3) {
                btn1[i].setText("목");
                tb1[0].addView(btn1[i]);
            } else if (i % 7 == 4) {
                btn1[i].setText("금");
                tb1[0].addView(btn1[i]);
            } else if (i % 7 == 5) {
                btn1[i].setText("토");
                btn1[i].setTextColor(Color.BLUE);
                tb1[0].addView(btn1[i]);
            } else if (i % 7 == 6) {
                btn1[i].setText("일");
                btn1[i].setTextColor(Color.RED);
                tb1[0].addView(btn1[i]);
            } else if (i % 7 == 0) {
                btn1[i].setText("월");
                tb1[0].addView(btn1[i]);
            } else {
                btn1[i].setText("화");
                tb1[0].addView(btn1[i]);
            }
        }
        for (int j = 0; j < 368; j++) {
            btn2[j] = new Button(this);
            btn2[j].setWidth(10);
            btn2[j].setTextSize(13);
            btn2[j].setBackgroundColor(Color.WHITE);
            btn2[j].setId(j);
        }
        for (int j = 0; j < 2; j++) {
            btn2[j].setText("");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 2; j < 3; j++) {
            btn2[j].setText("1/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 3; j < 33; j++) {
            btn2[j].setText("" + (j - 1));
            btn2[5].setTextColor(Color.BLUE);
            btn2[6].setTextColor(Color.RED);
            btn2[12].setTextColor(Color.BLUE);
            btn2[13].setTextColor(Color.RED);
            btn2[19].setTextColor(Color.BLUE);
            btn2[20].setTextColor(Color.RED);
            btn2[26].setTextColor(Color.BLUE);
            btn2[27].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 1월
        for (int j = 33; j < 34; j++) {
            btn2[j].setText("2/1");
            btn2[33].setTextColor(Color.BLUE);
            tb1[1].addView(btn2[j]);
        }
        for (int j = 34; j < 62; j++) {
            btn2[j].setText("" + (j - 32));
            btn2[34].setTextColor(Color.RED);
            btn2[40].setTextColor(Color.BLUE);
            btn2[41].setTextColor(Color.RED);
            btn2[47].setTextColor(Color.BLUE);
            btn2[48].setTextColor(Color.RED);
            btn2[54].setTextColor(Color.BLUE);
            btn2[55].setTextColor(Color.RED);
            btn2[61].setTextColor(Color.BLUE);
            tb1[1].addView(btn2[j]);
        } // 2월
        for (int j = 62; j < 63; j++) {
            btn2[j].setText("3/1");
            btn2[62].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        }
        for (int j = 63; j < 93; j++) {
            btn2[j].setText("" + (j - 61));
            btn2[69].setTextColor(Color.RED);
            btn2[68].setTextColor(Color.BLUE);
            btn2[76].setTextColor(Color.RED);
            btn2[75].setTextColor(Color.BLUE);
            btn2[83].setTextColor(Color.RED);
            btn2[82].setTextColor(Color.BLUE);
            btn2[90].setTextColor(Color.RED);
            btn2[89].setTextColor(Color.BLUE);
            tb1[1].addView(btn2[j]);
        } // 3월
        for (int j = 93; j < 94; j++) {
            btn2[j].setText("4/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 94; j < 123; j++) {
            btn2[j].setText("" + (j - 92));
            btn2[97].setTextColor(Color.RED);
            btn2[96].setTextColor(Color.BLUE);
            btn2[104].setTextColor(Color.RED);
            btn2[103].setTextColor(Color.BLUE);
            btn2[111].setTextColor(Color.RED);
            btn2[110].setTextColor(Color.BLUE);
            btn2[117].setTextColor(Color.BLUE);
            btn2[118].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 4월
        for (int j = 123; j < 124; j++) {
            btn2[j].setText("5/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 124; j < 154; j++) {
            btn2[j].setText("" + (j - 122));
            btn2[124].setTextColor(Color.BLUE);
            btn2[125].setTextColor(Color.RED);
            btn2[131].setTextColor(Color.BLUE);
            btn2[132].setTextColor(Color.RED);
            btn2[138].setTextColor(Color.BLUE);
            btn2[139].setTextColor(Color.RED);
            btn2[145].setTextColor(Color.BLUE);
            btn2[146].setTextColor(Color.RED);
            btn2[152].setTextColor(Color.BLUE);
            btn2[153].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 5월
        for (int j = 154; j < 155; j++) {
            btn2[j].setText("6/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 155; j < 184; j++) {
            btn2[j].setText("" + (j - 153));
            btn2[159].setTextColor(Color.BLUE);
            btn2[160].setTextColor(Color.RED);
            btn2[166].setTextColor(Color.BLUE);
            btn2[167].setTextColor(Color.RED);
            btn2[173].setTextColor(Color.BLUE);
            btn2[174].setTextColor(Color.RED);
            btn2[180].setTextColor(Color.BLUE);
            btn2[181].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 6월
        for (int j = 184; j < 185; j++) {
            btn2[j].setText("7/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 185; j < 215; j++) {
            btn2[j].setText("" + (j - 183));
            btn2[187].setTextColor(Color.BLUE);
            btn2[188].setTextColor(Color.RED);
            btn2[194].setTextColor(Color.BLUE);
            btn2[195].setTextColor(Color.RED);
            btn2[201].setTextColor(Color.BLUE);
            btn2[202].setTextColor(Color.RED);
            btn2[208].setTextColor(Color.BLUE);
            btn2[209].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 7월
        for (int j = 215; j < 216; j++) {
            btn2[j].setText("8/1");
            btn2[215].setTextColor(Color.BLUE);
            tb1[1].addView(btn2[j]);
        }
        for (int j = 216; j < 246; j++) {
            btn2[j].setText("" + (j - 214));
            btn2[216].setTextColor(Color.RED);
            btn2[222].setTextColor(Color.BLUE);
            btn2[223].setTextColor(Color.RED);
            btn2[229].setTextColor(Color.BLUE);
            btn2[230].setTextColor(Color.RED);
            btn2[236].setTextColor(Color.BLUE);
            btn2[237].setTextColor(Color.RED);
            btn2[243].setTextColor(Color.BLUE);
            btn2[244].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 8월

        for (int j = 246; j < 247; j++) {
            btn2[j].setText("9/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 247; j < 276; j++) {
            btn2[j].setText("" + (j - 245));
            btn2[250].setTextColor(Color.BLUE);
            btn2[251].setTextColor(Color.RED);
            btn2[257].setTextColor(Color.BLUE);
            btn2[258].setTextColor(Color.RED);
            btn2[264].setTextColor(Color.BLUE);
            btn2[265].setTextColor(Color.RED);
            btn2[271].setTextColor(Color.BLUE);
            btn2[272].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 9월

        for (int j = 276; j < 277; j++) {
            btn2[j].setText("10/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 277; j < 307; j++) {
            btn2[j].setText("" + (j - 275));
            btn2[278].setTextColor(Color.BLUE);
            btn2[279].setTextColor(Color.RED);
            btn2[285].setTextColor(Color.BLUE);
            btn2[286].setTextColor(Color.RED);
            btn2[292].setTextColor(Color.BLUE);
            btn2[293].setTextColor(Color.RED);
            btn2[299].setTextColor(Color.BLUE);
            btn2[300].setTextColor(Color.RED);
            btn2[306].setTextColor(Color.BLUE);
            tb1[1].addView(btn2[j]);
        } // 10월

        for (int j = 307; j < 308; j++) {
            btn2[j].setText("11/1");
            btn2[307].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        }
        for (int j = 308; j < 337; j++) {
            btn2[j].setText("" + (j - 306));
            btn2[313].setTextColor(Color.BLUE);
            btn2[314].setTextColor(Color.RED);
            btn2[320].setTextColor(Color.BLUE);
            btn2[321].setTextColor(Color.RED);
            btn2[327].setTextColor(Color.BLUE);
            btn2[328].setTextColor(Color.RED);
            btn2[334].setTextColor(Color.BLUE);
            btn2[335].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 11월

        for (int j = 337; j < 338; j++) {
            btn2[j].setText("12/1");
            tb1[1].addView(btn2[j]);
        }
        for (int j = 338; j < 368; j++) {
            btn2[j].setText("" + (j - 336));
            btn2[341].setTextColor(Color.BLUE);
            btn2[342].setTextColor(Color.RED);
            btn2[348].setTextColor(Color.BLUE);
            btn2[349].setTextColor(Color.RED);
            btn2[355].setTextColor(Color.BLUE);
            btn2[356].setTextColor(Color.RED);
            btn2[362].setTextColor(Color.BLUE);
            btn2[363].setTextColor(Color.RED);
            tb1[1].addView(btn2[j]);
        } // 12월

        for (int i =0; i<2; i++){
            btn2[i].setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View view) {
                    hourLayout.setVisibility(View.INVISIBLE);
                }
            });
        }
        for(int i = 2; i < 368; i++) {
            btn2[i].setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View view) {
                    memo1.setText("약속 제목");
                    memo2.setText("시작 시간 날짜");
                    memo3.setText("종료 시간");
                    memo4.setText("장소");
                    memo5.setText("메모");
                    hourLayout.setVisibility(View.VISIBLE);

                }
            });
        }

        // 주간달력 버튼 클릭시 24시간 표현

        for (int k = 0; k < 50; k++) {
            btn3[k] = new Button(this);
            btn3[k].setWidth(10);
            btn3[k].setTextSize(13);
            btn3[k].setBackgroundColor(Color.WHITE);
            btn3[k].setId(k);
        }

        for (int k = 0; k < 1; k++) {
            btn3[k].setText("AM 12");
            hour[0].addView(btn3[k], params);
        }
        for (int k = 1; k < 2; k++) {
            btn3[k].setText("");
            hour[0].addView(btn3[k], params);
        }
        for(int k = 2; k < 3; k++){
            btn3[k].setText("AM 1");
            hour[1].addView(btn3[k], params);
        }
        for (int k = 3; k < 4; k++) {
            btn3[k].setText("");
            hour[1].addView(btn3[k], params);
        }
        for (int k = 4; k < 5; k++) {
            btn3[k].setText("AM 2");
            hour[2].addView(btn3[k], params);
        }
        for (int k = 5; k < 6; k++) {
            btn3[k].setText("");
            hour[2].addView(btn3[k], params);
        }
        for(int k = 6; k < 7; k++){
            btn3[k].setText("AM 3");
            hour[3].addView(btn3[k], params);
        }
        for (int k = 7; k < 8; k++) {
            btn3[k].setText("");
            hour[3].addView(btn3[k], params);
        }
        for (int k = 8; k < 9; k++) {
            btn3[k].setText("AM 4");
            hour[4].addView(btn3[k], params);
        }
        for (int k = 9; k < 10; k++) {
            btn3[k].setText("");
            hour[4].addView(btn3[k], params);
        }
        for(int k = 10; k < 11; k++){
            btn3[k].setText("AM 5");
            hour[5].addView(btn3[k], params);
        }
        for (int k = 11; k < 12; k++) {
            btn3[k].setText("");
            hour[5].addView(btn3[k], params);
        }
        for (int k = 12; k < 13; k++) {
            btn3[k].setText("AM 6");
            hour[6].addView(btn3[k], params);
        }
        for (int k = 13; k < 14; k++) {
            btn3[k].setText("");
            hour[6].addView(btn3[k], params);
        }
        for(int k = 14; k < 15; k++){
            btn3[k].setText("AM 7");
            hour[7].addView(btn3[k], params);
        }
        for (int k = 15; k < 16; k++) {
            btn3[k].setText("");
            hour[7].addView(btn3[k], params);
        }
        for (int k = 16; k < 17; k++) {
            btn3[k].setText("AM 8");
            hour[8].addView(btn3[k], params);
        }
        for (int k = 17; k < 18; k++) {
            btn3[k].setText("");
            hour[8].addView(btn3[k], params);
        }
        for(int k = 18; k < 19; k++){
            btn3[k].setText("AM 9");
            hour[9].addView(btn3[k], params);
        }
        for (int k = 19; k < 20; k++) {
            btn3[k].setText("");
            hour[9].addView(btn3[k], params);
        }
        for (int k = 20; k < 21; k++) {
            btn3[k].setText("AM 10");
            hour[10].addView(btn3[k], params);
        }
        for (int k = 21; k < 22; k++) {
            btn3[k].setText("");
            hour[10].addView(btn3[k], params);
        }
        for(int k = 22; k < 23; k++){
            btn3[k].setText("AM 11");
            hour[11].addView(btn3[k], params);
        }
        for (int k = 23; k < 24; k++) {
            btn3[k].setText("");
            hour[11].addView(btn3[k], params);
        }
        for (int k = 24; k < 25; k++) {
            btn3[k].setText("PM 12");
            hour[12].addView(btn3[k], params);
        }
        for (int k = 25; k < 26; k++) {
            btn3[k].setText("");
            hour[12].addView(btn3[k], params);
        }
        for(int k = 26; k < 27; k++){
            btn3[k].setText("PM 1");
            hour[13].addView(btn3[k], params);
        }
        for (int k = 27; k < 28; k++) {
            btn3[k].setText("");
            hour[13].addView(btn3[k], params);
        }
        for(int k = 28; k < 29; k++){
            btn3[k].setText("PM 2");
            hour[14].addView(btn3[k], params);
        }
        for (int k = 29; k < 30; k++) {
            btn3[k].setText("");
            hour[14].addView(btn3[k], params);
        }
        for (int k = 30; k < 31; k++) {
            btn3[k].setText("PM 3");
            hour[15].addView(btn3[k], params);
        }
        for (int k = 31; k < 32; k++) {
            btn3[k].setText("");
            hour[15].addView(btn3[k], params);
        }
        for(int k = 32; k < 33; k++){
            btn3[k].setText("PM 4");
            hour[16].addView(btn3[k], params);
        }
        for (int k = 33; k < 34; k++) {
            btn3[k].setText("");
            hour[16].addView(btn3[k], params);
        }
        for (int k = 34; k < 35; k++) {
            btn3[k].setText("PM 5");
            hour[17].addView(btn3[k], params);
        }
        for (int k = 35; k < 36; k++) {
            btn3[k].setText("");
            hour[17].addView(btn3[k], params);
        }
        for(int k = 36; k < 37; k++){
            btn3[k].setText("PM 6");
            hour[18].addView(btn3[k], params);
        }
        for (int k = 37; k < 38; k++) {
            btn3[k].setText("");
            hour[18].addView(btn3[k], params);
        }
        for (int k = 38; k < 39; k++) {
            btn3[k].setText("PM 7");
            hour[19].addView(btn3[k], params);
        }
        for (int k = 39; k < 40; k++) {
            btn3[k].setText("");
            hour[19].addView(btn3[k], params);
        }
        for(int k = 40; k < 41; k++){
            btn3[k].setText("PM 8");
            hour[20].addView(btn3[k], params);
        }
        for (int k = 41; k < 42; k++) {
            btn3[k].setText("");
            hour[20].addView(btn3[k], params);
        }
        for (int k = 42; k < 43; k++) {
            btn3[k].setText("PM 9");
            hour[21].addView(btn3[k], params);
        }
        for (int k = 43; k < 44; k++) {
            btn3[k].setText("");
            hour[21].addView(btn3[k], params);
        }
        for(int k = 44; k < 45; k++){
            btn3[k].setText("PM 10");
            hour[22].addView(btn3[k], params);
        }
        for (int k = 45; k < 46; k++) {
            btn3[k].setText("");
            hour[22].addView(btn3[k], params);
        }
        for (int k = 46; k < 47; k++) {
            btn3[k].setText("PM 11");
            hour[23].addView(btn3[k], params);
        }
        for (int k = 47; k < 48; k++) {
            btn3[k].setText("");
            hour[23].addView(btn3[k], params);
        }
        for(int k = 48; k < 49; k++){
            btn3[k].setText("PM 12");
            hour[24].addView(btn3[k], params);
        }
        for (int k = 49; k < 50; k++) {
            btn3[k].setText("");
            hour[24].addView(btn3[k], params);
        }

        for(int k = 0; k < 50; k++) {
            btn3[k].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    dialogView = (View) View.inflate(Week.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Week.this);
                    dlgEdt1 = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                    dlgEdt2 = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                    dlgEdt3 = (EditText) dialogView.findViewById(R.id.dlgEdt3);
                    dlgEdt4 = (EditText) dialogView.findViewById(R.id.dlgEdt4);
                    dlgEdt5 = (EditText) dialogView.findViewById(R.id.dlgEdt5);
                    dlg.setTitle("일정");
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
                                        ("WeekAssignment.txt", Context.MODE_APPEND);

                                outFs.write(txt1.getBytes());
                                outFs.write(txt2.getBytes());
                                outFs.write(txt3.getBytes());
                                outFs.write(txt4.getBytes());
                                outFs.write(txt5.getBytes());
                                outFs.close();

                            } catch (IOException e) {

                            }
                            memo1.setText(dlgEdt1.getText().toString());
                            memo2.setText(dlgEdt2.getText().toString());
                            memo3.setText(dlgEdt3.getText().toString());
                            memo4.setText(dlgEdt4.getText().toString());
                            memo5.setText(dlgEdt5.getText().toString());

                            Toast.makeText(Week.this, "저장했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dlg.setNeutralButton("일정 불러오기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            try {
                                FileInputStream fis = openFileInput("WeekAssignment.txt");//파일명
                                byte[] txt = new byte[500];
                                fis.read(txt);

                                String readedStr = new String(txt);
                                //읽어온 문장을 출력하기
                                memo6.setText(readedStr);
                                fis.close();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(Week.this, "데이터를 불러왔습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dlg.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteFile("WeekAssignment.txt");
                            Toast.makeText(Week.this, "삭제했습니다.", Toast.LENGTH_SHORT).show();
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

    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if (id == R.id.month1) {
            Intent Month = new Intent(this, MainActivity.class);
            startActivity(Month);
        }
        if (id == R.id.week1) {
            Intent Week = new Intent(this, Week.class);
            startActivity(Week);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }
}