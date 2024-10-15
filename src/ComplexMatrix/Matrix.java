package ComplexMatrix;


public class Matrix {

    final private ComplexNumber[][] matrix;

    public Matrix(){
        this.matrix = new ComplexNumber[0][0];
    }

    public Matrix(int n, int m) throws IllegalArgumentException{
        if (n < 1 || m < 1){
            throw new IllegalArgumentException("The number of columns and rows must be more than 0");
        }

        this.matrix = new ComplexNumber[n][m];
        this.init();
    }

    public Matrix(ComplexNumber[][] ref){
        this.matrix =  ref.clone();
    }

    public void init(){
        for (int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                matrix[i][j] = new ComplexNumber();
            }
        }
    }



    public void print(){
        for (int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                if (matrix[i][j].getImg() == 0){
                    matrix[i][j].print();
                    System.out.print("     ");
                }
                else matrix[i][j].print();
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public Matrix add(Matrix m2) throws IllegalArgumentException{
        if (m2.getRowSize() != this.getRowSize() || m2.getCollSize() != this.getCollSize()) {
            throw new IllegalArgumentException("Adding Matrices must have equal dimensions");
        }

        Matrix res = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; ++i){
            for (int j = 0; j < this.matrix[0].length; ++j){
                res.matrix[i][j] = this.matrix[i][j].add(m2.matrix[i][j]);
            }
        }
        return res;
    }


    public Matrix subtract(Matrix m2) throws IllegalArgumentException{
        if (m2.getRowSize() != this.getRowSize() || m2.getCollSize() != this.getCollSize()) {
            throw new IllegalArgumentException("Adding Matrices must have equal dimensions");
        }

        Matrix res = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; ++i){
            for (int j = 0; j < this.matrix[0].length; ++j){
                res.matrix[i][j] = this.matrix[i][j].subtract(m2.matrix[i][j]);
            }
        }
        return res;
    }

    public Matrix mutliply(Matrix mat2)  throws IllegalArgumentException{
        if (mat2.getRowSize() != this.getRowSize() || mat2.getCollSize() != this.getCollSize()) {
            throw new IllegalArgumentException("number of columns of first matrix must be equal to the number of the second one");
        }

        Matrix res = new Matrix(this.matrix.length, mat2.matrix[0].length);

        for (int i = 0; i < this.matrix.length; ++i){
            for (int j = 0; j < mat2.matrix[0].length; ++j){
                for (int k = 0; k < this.matrix[0].length; ++k){
                    res.matrix[i][j] = res.matrix[i][j].add(this.matrix[i][k].multiply(mat2.matrix[k][j]));
                }
            }
        }
        return res;
    }

    public int getCollSize() {
        return matrix.length;
    }

    public boolean IsEmpty(){
        return matrix.length == 0;
    }

    public int getRowSize() {
        return matrix[0].length;
    }


    public Matrix transpose() throws IllegalArgumentException{
        Matrix mat = new Matrix(this.getRowSize(), this.getCollSize());
        for (int i = 0; i < this.getRowSize(); ++i){
            for (int j = 0; j < this.getCollSize(); ++j){
                mat.matrix[i][j] = this.matrix[j][i];
            }
        }
        return mat;
    }

    public  ComplexNumber determinant()  throws IllegalArgumentException{

        if (this.getRowSize() != this.getCollSize()) {
            throw new IllegalArgumentException("the matrix must be squared");
        }

        if (this.getRowSize() == 1) {
            return this.matrix[0][0];
        }

        ComplexNumber det = new ComplexNumber();
        for (int i = 0; i < this.getCollSize(); i++){
            det = det.add(calcMinor(i, 0).multiply(this.matrix[i][0]));
        }
        return det;
    }


    private ComplexNumber calcMinor(int i, int j) {
        Matrix minor = new Matrix(this.getCollSize() - 1, this.getRowSize() - 1);

        int m_i = 0, m_j = 0;
        for (int ii = 0; ii < this.getCollSize(); ii++){
            if (ii == i) continue;
            for (int jj = 0; jj < this.getRowSize(); jj++){
                if(jj == j) continue;
                minor.matrix[m_i][m_j] = this.matrix[ii][jj];
                m_j++;
            }
            m_j = 0;
            m_i++;
        }

        return (i + j) % 2 == 0 ? minor.determinant() : minor.determinant().multiply(new ComplexNumber(-1));
    }
}
