package ml.himpunan.ta_iak3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BasketCounter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_counter);
    }
    //Global Object
    BasketGame basketGame = new BasketGame();
    //teamA Button
    public void A3pointButton(View view) {
        basketGame.teamAscore = basketGame.teamAscore + 3;
        showAScore();
    }
    public void A2pointButton(View view) {
        basketGame.teamAscore = basketGame.teamAscore + 2 ;
        showAScore();
    }
    public void AfreeThrowButton(View view) {
        basketGame.teamAscore = basketGame.teamAscore + 1 ;
        showAScore();
    }
    public void showAScore () {
        TextView scoreText = (TextView) findViewById(R.id.teamAscore_text);
        scoreText.setText("" + basketGame.teamAscore);
    }
    //teamB Button
    public void B3pointButton(View view) {
        basketGame.teamBscore = basketGame.teamBscore + 3;
        showBScore();
    }
    public void B2pointButton(View view) {
        basketGame.teamBscore = basketGame.teamBscore + 2 ;
        showBScore();
    }
    public void BfreeThrowButton(View view) {
        basketGame.teamBscore = basketGame.teamBscore + 1;
        showBScore();
    }
    public void showBScore () {
        TextView scoreText = (TextView) findViewById(R.id.teamBscore_text);
        scoreText.setText("" + basketGame.teamBscore);
    }
    //reset button
    public void resetButton (View view) {
        basketGame.teamAscore = 0;
        basketGame.teamBscore = 0;
        showAScore();
        showBScore();

        showBScore();
    }
}
