import java.lang.reflect.Array;
import java.util.Arrays;

public class camara {

    //camera settings -resolution
    private int vXPixel;
    private int vYPixel;
    //camera settings -fov
    private double vXFov;
    private double vYFov;


    public camara() {
        //Constructor
        this.vXPixel = 20;
        this.vYPixel = 20;
        this.vXFov = 50;
        this.vYFov = 50;

        this.fInit();
    }

    private void fInit(){
        //the fInit calculates the vRenderVectors
        /*
        Bestimmt den Richtungsvektor der einzelnen Pixelstrahlen aus dem orts udn richtungsvektor der camera und den FOV
         */

        //determining the angle for each vektor
        double xDifference = this.vXFov/this.vXPixel;
        double yDifference = this.vYFov/this.vYPixel;

        // splitting the main matrix in 4 sectors s1(x|y), s2(x|-y), s3(-x|-y), s4(-x|y)

        //calculating s1
        double s1[][][] = new double[this.vXPixel/2][this.vYPixel/2][2];
        double s2[][][] = new double[this.vXPixel/2][this.vYPixel/2][2];
        double s3[][][] = new double[this.vXPixel/2][this.vYPixel/2][2];
        double s4[][][] = new double[this.vXPixel/2][this.vYPixel/2][2];

        for(int x = 0; x < s1.length; x++){
            for (int y = 0; y<s1[x].length;y++){
                s1[x][y][0] = xDifference*x+1;
                s1[x][y][1] = -yDifference*y+1;

            }
        }

        //transposing s1 to s2..s4

        //adding it all together

        String finalOut[][] = new String[s1.length][];
        for(int x = 0; x< s1.length; x++){
            String temp1[] = new String[s1[x].length];
            for (int y = 0; y< s1[x].length; y++){
                String xAngle = String.valueOf(s1[x][y][0]);
                String yAngle = String.valueOf(s1[x][y][1]);
                temp1[y] = xAngle +"°, "+ yAngle +"° ||";
            }
            finalOut[x] = temp1;
            System.out.println(Arrays.toString(temp1));
        }





    }

    public boolean fRenderImage(){
        //renders
        return false;
    }

    public double fCalculateIntersection(){
        //receives one vector.
        //on its own its gets all object(s) within the determent Render Distance

        //calculates intersection if intersected return true, else false
        return 0;
    }
}
