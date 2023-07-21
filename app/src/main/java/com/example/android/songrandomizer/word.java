package com.example.android.songrandomizer;

public class word {

    private String mDifault;
    private String mMiwok;

    private int mImageResourceId;
    private int mAudioresourceId;

    public word(String Difault , String Miwok , int imageResourceId ,int audioResorceId){
        mDifault = Difault;
        mMiwok = Miwok;
        mImageResourceId = imageResourceId;
        mAudioresourceId = audioResorceId;

    }

    public String getmDifault(){ return mDifault;}

    public String getmMiwok(){return mMiwok;}

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public int getmAudioresourceId(){
        return mAudioresourceId;
    }


}
