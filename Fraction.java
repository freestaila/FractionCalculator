public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int n, int d){
        if (d == 0) {
            throw new IllegalArgumentException("Dominator is zero");
        }else if(n <0 && d < 0) {
            this.denominator = -1*d;
            this.numerator = -1*n;
        }else if(n>=0 && d<0){
            this.denominator = -1*d;
            this.numerator = -1*n;
        }
        this.numerator = n;
        this.numerator= d;
    }

    public Fraction(int numerator){
        this(numerator,1);
    }
    public Fraction(){
        this(0,1);
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }
    public double toDouble(){
        return (double) numerator/denominator;
    }

    public Fraction add(Fraction other){
        Fraction frac = new Fraction((this.numerator*other.denominator)+(other.numerator*this.denominator), (this.denominator*other.denominator));
        frac.toLowestTerms();
        return frac;


    }

    public Fraction subtract(Fraction other){
        Fraction frac = new Fraction((this.numerator*other.denominator)-(other.numerator*this.denominator), (this.denominator*other.denominator));
        frac.toLowestTerms();
        return frac;
    }

    public Fraction multiply(Fraction other){
        Fraction frac = new Fraction((this.numerator* other.numerator),(other.denominator*this.denominator));
        frac.toLowestTerms();
        return frac;
    }

    public Fraction divide(Fraction other){
        if(other.numerator == 0){
            throw new IllegalArgumentException();
        }
        Fraction frac = new Fraction((this.numerator*other.denominator),(this.denominator*other.numerator));
        frac.toLowestTerms();
        return frac;
    }

    public boolean equals(Object other){
        if(other instanceof Fraction){
            Fraction otherFraction = (Fraction)other;
            this.toLowestTerms();
            otherFraction.toLowestTerms();


        }
        return true;
    }

    public void toLowestTerms(){
        int result = 0;
        while(this.numerator !=0 && this.denominator != 0)
        {
            result = this.numerator % this.denominator;
            this.numerator = this.denominator;
            this.denominator = result;
        }
    }

    public static int gcd(int num , int den){
        int gcd=0;
            if(num > den ){
                if(num%den == 0){
                    return den;
                 }
                else{
                    gcd= den-1;
                    while(den%gcd==0 && num%gcd==0){
                        gcd--;
                    }
                    return gcd;
                }
            }
            else if(num < den){
                if(den%num ==0){
                   return num;
                }else {
                    gcd = num - 1;
                    while (den % gcd == 0 && num % gcd == 0) {
                        gcd--;
                    }
                    return gcd;
                }
            }
            return gcd;
    }
    }


