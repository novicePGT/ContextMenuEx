package com.example.contextmenuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn1, btn2;
    static int angle = 0;
    // 버튼의 회전 변수를 저장하기 위한 변수 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ContextMenuEx");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        btn1 = (Button) findViewById(R.id.btn1);
        registerForContextMenu(btn1); // 버튼에 메뉴를 등록
        btn2 = (Button) findViewById(R.id.btn2);
        registerForContextMenu(btn2); // 버튼에 메뉴를 등록
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        // 메뉴 아이템을 선택했을 때, 이벤트 처리 할 메소드
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.subRotate:
                angle = angle + 45;
                btn1.setRotation(angle);
                return true;
            case R.id.subSize:
                btn1.setScaleX(2);
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == btn1) { // btn1에 메뉴를 등록
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        } if (v == btn2) { // btn2에 메뉴를 등록
            mInflater.inflate(R.menu.menu2, menu);
        } else {
            Toast.makeText(MainActivity.this, "버튼이 선택되었습니다.", Toast.LENGTH_SHORT).show();
        }

    }
}