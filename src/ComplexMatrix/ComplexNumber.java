package ComplexMatrix;

public class ComplexNumber {

    final private double real, img;

    public ComplexNumber(double real, double img){
        this.real = real;
        this.img = img;
    }

    public ComplexNumber(){
        this(0, 0);
    }

    public ComplexNumber(double real){
        this(real, 0);
    }

    public ComplexNumber(ComplexNumber ref){
        this(ref.real, ref.img);
    }

    public double getReal() { return this.real; }
    public double getImg() { return this.img; }

    public void print() {
        if (this.img > 0) {
            System.out.print(this.real + "+" + this.img + "i");
        }else if(this.img == 0){
            System.out.print(this.real);
        }
        else {
            System.out.print(this.real +""+ this.img + "i");
        }
    }
    public ComplexNumber add(ComplexNumber num2) {
        return new ComplexNumber(this.real + num2.real,
                this.img + num2.img);
    }

    public ComplexNumber multiply(ComplexNumber num2){
        double a = this.real, b = this.img, c = num2.real, d = num2.img;
        return new ComplexNumber(a*c - b*d, a*d + b*c);
    }

    public ComplexNumber subtract(ComplexNumber num2){
        return this.add(num2.multiply(new ComplexNumber(-1)));
    }

}
