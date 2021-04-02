package com.londonappbrewery.destini;

import static com.londonappbrewery.destini.MainActivity.*;

public class Story {
    StoryNumber mStoryNumber;
    int mQuestionID;
    int mAnswerTopID;
    int mAnswerBottomID;



    public Story(StoryNumber storyNumber, int questionID, int answerTopID, int answerBottomID) {
        mStoryNumber = storyNumber;
        mQuestionID = questionID;
        mAnswerTopID = answerTopID;
        mAnswerBottomID = answerBottomID;
    }


    public int getQuestionID() {
        return mQuestionID;
    }

    public int getAnswerTopID() {
        return mAnswerTopID;
    }

    public int getAnswerBottomID() {
        return mAnswerBottomID;
    }

    public StoryNumber getStoryNumber() {
        return mStoryNumber;
    }
}
