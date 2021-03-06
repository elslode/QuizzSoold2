package slode.elsloude.quizzsoold;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; //перменная для левой картинки + текст
    public int numRight; //переменная для правой картинки + текст
    Array array = new Array(); //создали новый объект из класса Array
    Random random = new Random(); //для генерации случайных чисел
    public int count = 0; //счетчик правильных ответов
    private ImageView background_level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level3);//установили текст

        //развернуть экран на весь кран начало
        final Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //азвернуть экран на весь экран конец

        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        ImageView background_level = (ImageView)findViewById(R.id.background_level1);
        background_level.setImageResource(R.drawable.level3);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //который скругляе углы левой картинки
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //который скругляе углы правой картинки
        img_right.setClipToOutline(true);

        //путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        //путь к правой textView
        final  TextView text_right = findViewById(R.id.text_right);

        //вызов диалогового окна в начале игры
        dialog = new Dialog(this);//оздаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.prieviewdialog);//путь к макету диалоговому окну
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //устанавливаем картинку в диалоговое окно начало
        ImageView previewimg2 = (ImageView)dialog.findViewById(R.id.priviewimg);
        previewimg2.setImageResource(R.drawable.previewimg3);
        //устанавливаем картинку в диалоговое окно конец

        //устанавливаем фон диалогового окна - начало
        LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.previewbackgroundfon);
        //устанавливаем фон диалогового окна - конец

        //устанавливаем описание задания начало
        TextView textDescription = (TextView) dialog.findViewById(R.id.textdescription);
        textDescription.setText(R.string.levelthree);
        //устанавливаем описание задания конец

        //кнопка которая закрывает диалоговое окно - начало
        final TextView btnclose = (TextView) dialog.findViewById(R.id.btnClose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка кнопки от ошибок
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    //тут код не нужен.
                }
                dialog.dismiss();//закрываем диалоговое окно
            }
        });


        //кнопка "Продолжить" начало
        Button buttonContinue = (Button) dialog.findViewById(R.id.buttoncontinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); //закрыть диалоговое окно
            }
            //кнопка "Продолжить" конец
        });
        //кнопка "Продолжить" конец

        dialog.show();//показать диалоговое окно

        //__________________________
        //вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);//оздаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end);//путь к макету диалоговому окну
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialogEnd.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //Устанавливаем фон диалогового окна - начало
        LinearLayout dialogfonEnd = (LinearLayout) dialogEnd.findViewById(R.id.dialogfon);
        dialogfonEnd.setBackgroundResource(R.drawable.previewbackgroundfon);
        //Устанавливаем фон диалогового окна - конец

        //нтересный факт начало
        TextView textDescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textDescriptionEnd.setText(R.string.levelThreeEnd);
        //интересный факт конец

        //кнопка которая закрывает диалоговое окно - начало
        final TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnClose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка кнопки от ошибок
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    //тут код не нужен.
                }
                dialogEnd.dismiss();//закрываем диалоговое окно
            }
        });
        //кнопка "Продолжить" начало
        Button buttonContinue3 = (Button) dialogEnd.findViewById(R.id.buttoncontinue);
        buttonContinue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Level3.this, Level4.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    //тут код не нужен
                }
                dialogEnd.dismiss(); //закрыть диалоговое окно
            }
            //кнопка "Продолжить" конец
        });
        //__________________________

        //кнопка назад начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабвтываем нажатие кнопки "назад" - начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level3.this, GameLevels.class); //амерение для перехода
                    startActivity(intent); //старт намерения
                    finish();//Закрыть этот класс*-
                    //вернуться назад к выбору уровня конец
                } catch (Exception e) {
                    //тут код не нужен
                }

                //обрабвтываем нажатие кнопки "назад" - конец
            }
        });
        //кнопка назад конец

        //массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4,
                R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12,
                R.id.point13,R.id.point14, R.id.point15, R.id.point16, R.id.point17,
                R.id.point18, R.id.point19, R.id.point20, R.id.point20, R.id.point20,
        };
        //массив для прогресса игры - конец

        //подключаем анимацию начало
        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);
        //подключаем анимацию - конец

        numLeft = random.nextInt(21); //генерация сл.числа
        img_left.setImageResource(array.images3[numLeft]); //достаем из массива картинку
        text_left.setText(array.texts3[numLeft]); //Достаем из массива текст

        numRight = random.nextInt(21); //генерация сл.числа

        //цикл с предусловием сравнения чисел начало
        while (numRight == numLeft) {
            numRight = random.nextInt(21);
        }
        //цикл с предусловием сравнения чисел конец

        img_right.setImageResource(array.images3[numRight]); //достаем из массива картинку
        text_right.setText(array.texts3[numRight]); //Достаем из массива текст

        //обрабатываем нажате на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки - начало
                    img_right.setEnabled(false);  //блокируем праую картинку
                    if (numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    //если коснулся картинки - конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if(numLeft>numRight) {
                        if(count < 20) {
                            count = count+1;
                        }
                        //закрашиваем прогресс серым цветом начало
                            for (int i = 0; i < 20; i++) {
                              TextView tv = findViewById(progress[i]);
                              tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //Определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым - конец

                    } else {
                        //Если левая картинка меньше
                        if(count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 2;
                            }
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //Определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым - конец
                    }
                    //Если отпустил палец - конец
                    if(count == 20) {
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    } else {
                        numLeft = random.nextInt(21); //генерация сл.числа
                        img_left.setImageResource(array.images3[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]); //Достаем из массива текст

                        numRight = random.nextInt(21); //генерация сл.числа

                        //цикл с предусловием сравнения чисел начало
                        while (numRight == numLeft) {
                            numRight = random.nextInt(21);
                        }
                        //цикл с предусловием сравнения чисел конец


                        img_right.setImageResource(array.images3[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]); //Достаем из массива текст

                        img_right.setEnabled(true); //включаем обратно правую картинку
                    }
                }
                //Условие касания картинки - конец
                return true;
            }
        });
         //обрабатываем нажате на левую картинку - конец

        ///обрабатываем нажате на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки - начало
                    img_left.setEnabled(false);  //блокируем левую картинку
                    if (numRight > numLeft) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    //если коснулся картинки - конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if(numRight > numLeft) {
                        //если правая картинка больше
                        if(count < 20) {
                            count = count+1;
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //Определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым - конец

                    } else {
                        //Если правая картинка меньше
                        if(count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 2;
                            }
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //Определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым - конец
                    }
                    //Если отпустил палец - конец
                    if(count == 20) {
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    } else {
                        numLeft = random.nextInt(21); //генерация сл.числа
                        img_left.setImageResource(array.images3[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]); //Достаем из массива текст

                        numRight = random.nextInt(21); //генерация сл.числа

                        //цикл с предусловием проверки чисел - начало
                        while (numLeft == numRight) {
                            numRight = random.nextInt(21);
                        }
                        //цикл с предусловием проверки чисел - конец

                        img_right.setImageResource(array.images3[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]); //Достаем из массива текст

                        img_left.setEnabled(true); //включаем обратно левую картинку
                    }
                }
                //Условие касания картинки - конец
                return true;
            }
        });
        //обрабатываем нажате на правую картинку - конец

    }
    //системная кнопка назад начало
    @Override
    public void onBackPressed(){
        //обрабвтываем нажатие кнопки "назад" - начало
        try {
            //вернуться назад к выбору уровня начало
            Intent intent = new Intent(Level3.this, GameLevels.class); //амерение для перехода
            startActivity(intent); //старт намерения
            finish();//Закрыть этот класс
            //вернуться назад к выбору уровня конец
        } catch (Exception e) {
            //тут код не нужен
        }
        //обрабвтываем нажатие кнопки "назад" - конец
    }
    //системная кнопка назад конец
}
