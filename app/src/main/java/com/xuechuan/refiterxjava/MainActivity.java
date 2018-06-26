package com.xuechuan.refiterxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.xuechuan.refiterxjava.db.Students;
import com.xuechuan.refiterxjava.db.Teacher;
import com.xuechuan.refiterxjava.mvp.contract.loginContract;
import com.xuechuan.refiterxjava.mvp.model.loginModel;
import com.xuechuan.refiterxjava.mvp.presenter.loginPresenter;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        , loginContract.View {

    private Button mButton;
    private Button mButton2;
    private EditText mEt1;
    private EditText mEt2;
    private TextView mTvShow;
    private loginPresenter mPresenter;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private EditText mEtDel;
    private EditText mEtUpData;
    private EditText mEtFind;
    private TextView mTvShow1;
    private TextView mTvShow2;
    private TextView mTvShow3;
    private TextView mTvShow4;
    private RadioButton mRdbStudent;
    private RadioButton mRdbTeacher;

    private Class<?> modelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mPresenter = new loginPresenter();
        mPresenter.initModelView(new loginModel(), this);
        mRdbStudent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    modelClass = Students.class;
                }
            }
        });
        mRdbTeacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    modelClass = Teacher.class;
                }
            }
        });
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);

        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mEt1 = (EditText) findViewById(R.id.et_1);
        mEt1.setOnClickListener(this);
        mEt2 = (EditText) findViewById(R.id.et_2);
        mEt2.setOnClickListener(this);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        mTvShow.setOnClickListener(this);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton4.setOnClickListener(this);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton5.setOnClickListener(this);
        mButton6 = (Button) findViewById(R.id.button6);
        mButton6.setOnClickListener(this);
        mButton7 = (Button) findViewById(R.id.button7);
        mButton7.setOnClickListener(this);
        mEtDel = (EditText) findViewById(R.id.et_del);
        mEtDel.setOnClickListener(this);
        mEtUpData = (EditText) findViewById(R.id.et_upData);
        mEtUpData.setOnClickListener(this);
        mEtFind = (EditText) findViewById(R.id.et_find);
        mEtFind.setOnClickListener(this);
        mTvShow1 = (TextView) findViewById(R.id.tv_show1);
        mTvShow1.setOnClickListener(this);
        mTvShow2 = (TextView) findViewById(R.id.tv_show2);
        mTvShow2.setOnClickListener(this);
        mTvShow3 = (TextView) findViewById(R.id.tv_show3);
        mTvShow3.setOnClickListener(this);
        mTvShow4 = (TextView) findViewById(R.id.tv_show4);
        mTvShow4.setOnClickListener(this);
        mRdbStudent = (RadioButton) findViewById(R.id.rdb_student);
        mRdbStudent.setOnClickListener(this);
        mRdbTeacher = (RadioButton) findViewById(R.id.rdb_teacher);
        mRdbTeacher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                int nubmer = 20;
                for (int i = 0; i < nubmer; i++) {
                    Students students = new Students();
                    students.setAge(String.valueOf(i));
                    students.setName("123456" + i);
                    students.setId(i);
                    students.setNumber(String.valueOf(i));
                    students.setPaw("123456" + i);
                    students.save();
                    Teacher teacher = new Teacher();
                    teacher.setId(i);
                    teacher.setAge(String.valueOf(i));
                    teacher.setName(String.valueOf(i));
                    teacher.setPaw("123456" + i);
                }

                break;
            case R.id.button2:
                submit();
                break;
            case R.id.button3://查询全部
                List all = LitePal.findAll(modelClass);
                if (all == null) {
                    Toast.makeText(MainActivity.this, "查询数据不存在", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer = new StringBuffer();
                if (modelClass == Students.class) {
                    for (int i = 0; i < all.size(); i++) {
                        Students students = (Students) all.get(i);
                        buffer.append("年龄=" + students.getAge() + "\n");
                        buffer.append("名字=" + students.getName() + "\n");
                        buffer.append("数字=" + students.getNumber() + "\n");
                        buffer.append("密码=" + students.getPaw() + "\n");
                        buffer.append("================" + "\n");

                    }
                } else if (modelClass == Teacher.class) {
                    for (int i = 0; i < all.size(); i++) {
                        Teacher students = (Teacher) all.get(i);
                        buffer.append("年龄=" + students.getAge() + "\n");
                        buffer.append("名字=" + students.getName() + "\n");
                        buffer.append("密码=" + students.getPaw() + "\n");
                        buffer.append("================" + "\n");
                    }
                }

                mTvShow.setText(buffer.toString());
                break;
            case R.id.button4://删除全部
                LitePal.deleteAll(Students.class, "");
                break;
            case R.id.button5://删除其中一个
                String trim = mEtDel.getText().toString().trim();
                Students find = doFind(trim);
                if (find == null) {
                    Toast.makeText(MainActivity.this, "该数据已经删除", Toast.LENGTH_SHORT).show();
                } else {
                    LitePal.delete(Students.class, find.getId());
                }
                break;
            case R.id.button6://更新数据
                String trim1 = mEtUpData.getText().toString().trim();
                Students students1 = doFind(trim1);
                if (students1 == null) {
                    Toast.makeText(MainActivity.this, "查询到不到数据", Toast.LENGTH_SHORT).show();
                    return;
                }
                Students students = new Students();
                students.setPaw("123456789");
                students.setNumber("2");
                students.setName("123456789");
                students.setAge("2");
                students.update(students1.getId());
                break;
            case R.id.button7://查询其中一个数据
                String trim2 = mEtFind.getText().toString().trim();
                Students students2 = doFind(trim2);
                if (students2 == null) {
                    Toast.makeText(MainActivity.this, "查询到不到数据", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    doShow(mTvShow4, students2);
                }

                break;
        }
    }

    private Students doFind(String name) {
            Students first = LitePal.where("name=" + name)
                    .findFirst(Students.class);
            return first;
    }
    private Teacher doFinds(String name) {
        Teacher first = LitePal.where("name=" + name)
                .findFirst(Teacher.class);
        return first;
    }

    private void submit() {
        // validate
        String name = mEt1.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String paw = mEt2.getText().toString().trim();
        if (TextUtils.isEmpty(paw)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.login(name, paw);

    }

    @Override
    public void Success(Students com) {
        doShow(mTvShow, com);
    }

    private void doShow(TextView mTvShow, Students com) {
        mTvShow.setText("年龄" + com.getAge() + "\n" +
                "id=" + com.getId() + "\n"
                + "名字=" + com.getName() + "\n"
                + "数字=" + com.getNumber() + "\n"
                + "密码=" + com.getPaw() + "\n");
    }

    @Override
    public void Error(Students msg) {
        Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
    }

}
