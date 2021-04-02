package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    Button mButtonTop;
    Button mButtonBottom;
    enum StoryNumber{
        ONE, TWO, THREE
    }
    Story nextStory = new Story(StoryNumber.ONE,R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nextStory.getStoryNumber() == StoryNumber.ONE){
                    Log.d(TAG, "onClick: T1 question is TRUE now we go to T3");
                    nextStory = new Story(StoryNumber.THREE,R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    setNextStory();
                }else if(nextStory.getStoryNumber() == StoryNumber.TWO){
                    Log.d(TAG, "onClick: T2 question is TRUE now we go to T3 final");
                    nextStory = new Story(StoryNumber.THREE,R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    setNextStory();
                }else if(nextStory.getStoryNumber() == StoryNumber.THREE){
                    Log.d(TAG, "onClick: T3 question is TRUE now we go to T6 final");
                    mStoryText.setText(R.string.T6_End);
                    removeButtons();
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nextStory.getStoryNumber() == StoryNumber.ONE){
                    Log.d(TAG, "onClick: T1 question is TRUE now we go to T2");
                    nextStory = new Story(StoryNumber.TWO,R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                    setNextStory();
                }else if (nextStory.getStoryNumber() == StoryNumber.TWO){
                    Log.d(TAG, "onClick: T2 question is FALSE now we go to T4 final");
                    mStoryText.setText(R.string.T4_End);
                    removeButtons();
                }else if (nextStory.getStoryNumber() == StoryNumber.THREE){
                    Log.d(TAG, "onClick: T3 question is FALSE T5 final");
                    mStoryText.setText(R.string.T5_End);
                    removeButtons();
                }
            }
        });
    }

    public void setNextStory(){
        mStoryText.setText(nextStory.getQuestionID());
        mButtonTop.setText(nextStory.mAnswerTopID);
        mButtonBottom.setText(nextStory.mAnswerBottomID);
    }
    public void removeButtons(){
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }
}
