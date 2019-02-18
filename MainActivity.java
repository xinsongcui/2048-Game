
package edu.purdue.cui102.project5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

import edu.purdue.cui102.project5.TwentyFortyEight;


/**
 * MainActivity class that serves the same purpose to an Android app as the heart does to humans
 * Basically, the most important class of the app
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @author Tori Shurman (vshurman@purdue.edu)
 */
public class

MainActivity extends AppCompatActivity {

    //The context of the app. Context is used to refer to certain resources of the app outside of
    //the MainActivity class
    //private boolean initialized = true;
    private static Context mContext;

    //String filename = "bestScore";
    //int bestScore = 0;
    //FileOutputStream outputStream;

    //public MainActivity() {
       // try {
         //   outputStream =  openFileOutput(filename, Context.MODE_PRIVATE);
        //} catch (FileNotFoundException e) {
          //  e.printStackTrace();
        //}
        //this.initialized = false;
    //}

    /**
     * Get the context of the app
     *
     * @return the context of the app
     */
    //public void setBestScore(int a) {
      //  bestScore = a;
    //}

   // public int getBestScore() {
     //   return bestScore;
    //}

    public static Context getAppContext() {
        return mContext;
    }

    //An object of our TwentyFortyEight class
    private TwentyFortyEight twentyFortyEight;

    //An object of CustomGrid class
    private CustomGrid customGrid;

    //The score box text in the app
    private TextView scoreBox;

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.
     * @see #onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.splashScreenTheme);

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        twentyFortyEight = new TwentyFortyEight(4);
        customGrid = new CustomGrid();

        GridView grid = (GridView) findViewById(R.id.mainGrid);
        scoreBox = (TextView) findViewById(R.id.scoreBox);

        grid.setAdapter(customGrid);

        //TODO: Call the reset() method of your TwentyFortyClass to reset the board when the app

        //first starts

        twentyFortyEight.reset();


    }

    public void resetAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        twentyFortyEight.reset();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));

        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Up button is pressed
     *
     * @param view - the UI of the app
     */
    public void upAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        while (twentyFortyEight.moveUp()) {
        }
        twentyFortyEight.placeRandom();
        //stack.push(twentyFortyEight.getBoard());
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));
        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Down button is pressed
     *
     * @param view - the UI of the app
     */
    public void downAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        while (twentyFortyEight.moveDown()) {
        }
        ;
        twentyFortyEight.placeRandom();
        //stack.push(twentyFortyEight.getBoard());
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));


        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Left button is pressed
     *
     * @param view - the UI of the app
     */
    public void leftAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        while (twentyFortyEight.moveLeft()) {
        }
        ;
        twentyFortyEight.placeRandom();
        //stackh(tw.pusentyFortyEight.getBoard());
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));


        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Right button is pressed
     *
     * @param view - the UI of the app
     */
    public void rightAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        while (twentyFortyEight.moveRight()) {
        }
        ;
        twentyFortyEight.placeRandom();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));


        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    public void undoAction(View view) {
        if (twentyFortyEight.getStack().size() > 1) {
            int[][] temp = new int[4][4];
            int[][] temp2 = twentyFortyEight.getStack().peek();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp[i][j] = temp2[i][j];
                }
            }

            twentyFortyEight.getRedoStack().push(temp);
            twentyFortyEight.getStack().pop();
            twentyFortyEight.setBoard(twentyFortyEight.getStack().peek());
            customGrid.updateGrid(twentyFortyEight.getBoard());
            twentyFortyEight.updateScore();
            scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));
        }
    }

    public void redoAction(View view) {
        if (twentyFortyEight.getRedoStack().size() >= 1) {
            twentyFortyEight.getStack().push(twentyFortyEight.getRedoStack().pop());
            twentyFortyEight.setBoard(twentyFortyEight.getStack().peek());
            customGrid.updateGrid(twentyFortyEight.getBoard());
            twentyFortyEight.updateScore();
            scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));
        }
    }
}