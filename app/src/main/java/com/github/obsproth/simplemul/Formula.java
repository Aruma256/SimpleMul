package com.github.obsproth.simplemul;

class Formula {
    final double valA, valB, ans;
    final boolean isMul;

    Formula(double valA, double valB, boolean isMul, double ans) {
        this.valA = valA;
        this.valB = valB;
        this.isMul = isMul;
        this.ans = ans;
    }
}
