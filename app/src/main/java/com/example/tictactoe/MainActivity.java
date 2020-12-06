package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    boolean gameActive = true;
    int activeplayer = 0;
    int [] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winpositions = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};
    public void playerTap(View view)
        {
            ImageView img = (ImageView) view;
            int tappedimage = Integer.parseInt(img.getTag().toString());
            if (!gameActive){
                gamest(view);
            }
            if (gamestate[tappedimage]==2 && gameActive)
            {
                gamestate[tappedimage]=activeplayer;
                img.setTranslationY(-1000f);
                if(activeplayer==0){
                    img.setImageResource(R.drawable.xx);
                    activeplayer=1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's Turn");
                }
                else{
                    img.setImageResource(R.drawable.oo);
                    activeplayer=0;TextView status = findViewById(R.id.status);
                    status.setText("X's Turn");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            for (int [] winposition: winpositions){
                if (gamestate[winposition[0]] == gamestate[winposition[1]] &&
                        gamestate[winposition[1]] == gamestate[winposition[2]] &&
                    gamestate[winposition[0]]!=2){
                    String winner;
                    gameActive = false;
                    if (gamestate[winposition[0]] == 0){
                        winner = "X has won the game";
                    }
                    else{
                        winner = "O has won the game";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winner);

                }
            }




        }
    public void gamest(View view){
        gameActive = true;
        activeplayer = 0;
        for (int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }
    public  void restart(View view){
        gameActive = true;
        activeplayer = 0;
        TextView status = findViewById(R.id.status);
        status.setText("X's turn tap to play");
        for (int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}