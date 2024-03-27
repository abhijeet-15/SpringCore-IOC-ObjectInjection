package com.abhijeetsingh.wrongWay;

public class Student {

    public MathCheat mathCheat;

    public Student(MathCheat mathCheat) {
        this.mathCheat = mathCheat;
    }

    public void cheat() {
        mathCheat.startMathCheat();
    }

}
