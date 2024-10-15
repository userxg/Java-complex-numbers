package ComplexMatrix;


public class Main {

    public static void main(String[] args){
        try{
            printComplexNUmbers();
            printMatrixOperations();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());

        }

    }

    public static void Test(){
    }

    private static void printMatrixOperations() {

        ComplexNumber[][] a = {
                {new ComplexNumber(1, 2), new ComplexNumber(3, -1)},
                {new ComplexNumber(4), new ComplexNumber(5, 6)}
        };

        ComplexNumber[][] b = {
                {new ComplexNumber(2, -3), new ComplexNumber(1, 1)},
                {new ComplexNumber(-1, 2), new ComplexNumber(3, -4)}
        };

        System.out.println("\nA = ");
        Matrix A = new Matrix(a);
        A.print();
        try{
            System.out.println("It's determinant: ");
            (new ComplexNumber(A.determinant())).print();
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }


        System.out.println("\n\nB = ");
        Matrix B = new Matrix(b);
        B.print();
        try{
            System.out.println("It's determinant: ");
            (new ComplexNumber(B.determinant())).print();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Matrix C_added = A.add(B);
        System.out.println("\n\nA + B = C (2x2)");
        C_added.print();

        Matrix C_subtracted = A.subtract(B);
        System.out.println("\nA - B = C (2x2)");
        C_subtracted.print();


        ComplexNumber[][] d = {
                {new ComplexNumber(1, 2), new ComplexNumber(3, -1)},
                {new ComplexNumber(4), new ComplexNumber(5, 6)},
                {new ComplexNumber(7, -1), new ComplexNumber(8, 2)}
        };

        ComplexNumber[][] e = {
                {new ComplexNumber(2, -3), new ComplexNumber(1, 1), new ComplexNumber(4)},
                {new ComplexNumber(-1, 2), new ComplexNumber(3, -4), new ComplexNumber(5)}
        };

        System.out.println("\nD (3x2) = ");
        Matrix D = new Matrix(d);
        D.print();

        System.out.println("\nE (2x3) = ");
        Matrix E = new Matrix(e);
        E.print();

        try{
            Matrix C_multiplied = D.mutliply(E);
            System.out.println("\nD x E = C (3x3) ");
            C_multiplied.print();
            System.out.print("It's determinant: ");
            (new ComplexNumber(C_multiplied.determinant())).print();
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("\n\nD (3x2) = ");
            D.print();
            System.out.println("\nD(2x3) - transposed = ");
            Matrix C_transponed = D.transpose();
            C_transponed.print();
            System.out.println("end");
        }
    }

    public static void printComplexNUmbers(){
        ComplexNumber a = new ComplexNumber(4, 1);
        ComplexNumber b  = new ComplexNumber(4, -1);
        ComplexNumber c = new ComplexNumber(4);
        ComplexNumber d = new ComplexNumber();

        System.out.println("Complex number constructors");
        a.print();
        System.out.println();
        b.print();
        System.out.println();
        c.print();
        System.out.println();
        d.print();
        System.out.println();
        (new ComplexNumber(a.multiply(b))).print();
        System.out.println();

    }
}


