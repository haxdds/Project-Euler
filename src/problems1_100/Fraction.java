package problems1_100;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Lagrange on 4/14/2017.
 */
public final class Fraction{


    private int numerator;
    private int denominator;

    Fraction(long numerator, long denominator){
        this.numerator= (int)numerator;
        this.denominator = (int)denominator;
    }

    Fraction(long numerator){
        this.numerator = (int)numerator;
        this.denominator = 1;
    }
    Fraction(int numerator, int denominator){
        this.numerator= numerator;
        this.denominator = denominator;
    }

    Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }



    public Fraction add(Fraction f){
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator, this.denominator * f.denominator);
    }

    public Fraction subtract(Fraction f){
        return new Fraction(this.numerator * f.denominator - f.numerator * this.denominator, this.denominator * f.denominator);
    }

    public Fraction multiply(Fraction f){
        return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
    }
    public Fraction divide(Fraction f){
        return new Fraction(this.numerator * f.denominator, this.denominator * f.numerator);
    }
    public Fraction reciprocal(){
        return new Fraction(this.denominator,this.numerator);
    }

    public Fraction simplify(){
        long n = this.numerator;
        long d = this.denominator;
        for(long k = d; k >= 1; k--){
            if(n % k == 0 && d % k == 0) {
                n = n / k;
                d = d / k;
                break;
            }
        }
        return new Fraction(n,d);
    }

    public boolean equals(Fraction f){
        return f.simplify().getNumerator() == this.simplify().getNumerator() && f.simplify().getDenominator() == this.simplify().getDenominator();
    }
    public boolean is(Fraction f){
        return f.numerator == this.numerator && f.denominator == this.denominator;
    }


    public String toString(){
        return this.numerator + " / " + this.denominator;
    }

    public double toDouble(){
        return (double)this.numerator /(double)this.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }












}
