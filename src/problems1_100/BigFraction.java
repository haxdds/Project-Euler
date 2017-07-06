package problems1_100;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Lagrange on 4/14/2017.
 */
public class BigFraction {

    BigInteger numerator;
    BigInteger denominator;

    BigFraction(BigInteger num, BigInteger den){
        this.numerator = num;
        this.denominator = den;
    }

    BigFraction(BigInteger num){
        this.numerator = num;
        this.denominator = BigInteger.ONE;
    }

    BigFraction(int num, int den){
        this.numerator = BigInteger.valueOf(num);
        this.denominator = BigInteger.valueOf(den);
    }
    BigFraction(long num, long den){
        this.numerator = BigInteger.valueOf(num);
        this.denominator = BigInteger.valueOf(den);
    }

    BigFraction(int num){
        this.numerator = BigInteger.valueOf(num);
        this.denominator = BigInteger.ONE;
    }
    BigFraction(long num){
        this.numerator = BigInteger.valueOf(num);
        this.denominator = BigInteger.ONE;
    }



    BigFraction add(BigFraction bf){
        return new BigFraction(this.numerator.multiply(bf.denominator).add(bf.numerator.multiply(this.denominator)), this.denominator.multiply(bf.denominator));
    }

    BigFraction subtract(BigFraction bf){
        return new BigFraction(this.numerator.multiply(bf.denominator).subtract(bf.numerator.multiply(this.denominator)), this.denominator.multiply(bf.denominator));
    }
    BigFraction multiply(BigFraction bf){
        return new BigFraction(this.numerator.multiply(bf.numerator),this.denominator.multiply(bf.denominator));
    }
    BigFraction divide(BigFraction bf){
        return new BigFraction(this.numerator.multiply(bf.denominator), this.denominator.multiply(bf.numerator));
    }
    BigFraction simplify(){
        BigInteger n = this.numerator;
        BigInteger d = this.denominator;
        for(BigInteger k = d; k.compareTo(BigInteger.ONE) == 1; k = k.subtract(BigInteger.ONE)){
            if(n.mod(k).compareTo(BigInteger.ZERO) == 0 && d.mod(k).compareTo(BigInteger.ZERO) == 0) {
                n = n.divide(k);
                d = d.divide(k);
                break;
            }
        }
        return new BigFraction(n,d);
    }



    public String toString(){
        return this.numerator + " / " + this.denominator;
    }

    public BigDecimal toBigDecimal(){
        return BigDecimal.valueOf(this.numerator.longValue()).divide(BigDecimal.valueOf(this.denominator.longValue()));
    }





    public BigInteger getNumerator() {
        return numerator;
    }

    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public void setDenominator(BigInteger denominator) {
        this.denominator = denominator;
    }





}
