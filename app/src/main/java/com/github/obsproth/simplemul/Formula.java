package com.github.obsproth.simplemul;

class Formula {
    final double valA, valB;
    final boolean isMul;
    final String ansStr;

    Formula(double valA, double valB, boolean isMul, String ansStr) {
        this.valA = valA;
        this.valB = valB;
        this.isMul = isMul;
        this.ansStr = ansStr;
    }
}
