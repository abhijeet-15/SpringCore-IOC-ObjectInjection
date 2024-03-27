package com.abhijeetsingh.betterWay;

public class BetterStudent {

    private EnglishCheat englishCheat;

    public BetterStudent(){};

    public BetterStudent(EnglishCheat englishCheat) {
        this.englishCheat = englishCheat;
    }

//    public void setEnglishCheat(EnglishCheat englishCheat) {
//        this.englishCheat = englishCheat;
//    }

    public void cheat() {
        englishCheat.startEnglishCheat();
    }

}
