package com.github.obsproth.simplemul;

public class Formula {
    public final double valA, valB;
    public final boolean isMul;
    public final double ans;

    public Formula(double valA, double valB, boolean isMul) {
        this.valA = valA;
        this.valB = valB;
        this.isMul = isMul;
        this.ans = isMul ? valA * valB : valA / valB;
    }
}
