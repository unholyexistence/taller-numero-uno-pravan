import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PartirPrograma();
    }

    /**
     * Subprograma donde se encuentra el codigo.
     */
    public static void PartirPrograma(){

        //Creacion de ventana
        double min = -1.0;
        double max = 1.0;
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.enableDoubleBuffering();

        //Array con los colores
        Color[] colores = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow};

        //Numeros random para luego darle un color a cada linea.
        int random = (int) (Math.random()* colores.length);
        int random1 = (int) (Math.random()* colores.length);
        int random2 = (int) (Math.random()* colores.length);
        int random3 = (int) (Math.random()* colores.length);
        int random4 = (int) (Math.random()* colores.length);
        int random5 = (int) (Math.random()* colores.length);

        Color primerColor = colores[random];

        double x0Inicial = min + (max - min) * Math.random();
        double y0Inicial = min + (max - min) * Math.random();
        double xIInicial = min + (max - min) * Math.random();
        double yIInicial = min + (max - min) * Math.random();
        double vx = Math.random()*0.06;
        double vy = Math.random()*0.06;

        //Posiciones de las lineas que siguen a la primera.
        double xO1=0;
        double xO2=0;
        double xO3=0;
        double xO4=0;
        double xO5=0;
        //--------------
        double xI1=0;
        double xI2=0;
        double xI3=0;
        double xI4=0;
        double xI5=0;
        //--------------
        double yO1=0;
        double yO2=0;
        double yO3=0;
        double yO4=0;
        double yO5=0;
        //--------------
        double yI1=0;
        double yI2=0;
        double yI3=0;
        double yI4=0;
        double yI5=0;

        //Colores de las lineas.
        Color color1 = colores[random1];
        Color color2 = colores[random2];
        Color color3 = colores[random3];
        Color color4 = colores[random4];
        Color color5 = colores[random5];

        //Dibujar la primera linea.
        StdDraw.setPenColor(primerColor);
        StdDraw.line(x0Inicial,y0Inicial,xIInicial,yIInicial);
        StdDraw.show();

        //Ciclo para luego dibujar las lineas
        int ciclo = 0;

        //While donde se va a realizar el movimiento de las lineas.
        while(true){
            //Cndicionales para detectar cuando las lineas toquen los bordes y luego rebotar.
            if (Math.abs(xIInicial+vx)>1.0){
                vx = -vx;
            }
            if (Math.abs(x0Inicial+vx)>1.0){
                vx = -vx;
            }
            if (Math.abs(y0Inicial+vy)>1.0){
                vy = -vy;
            }
            if (Math.abs(yIInicial+vy)>1.0){
                vy = -vy;
            }

            //Limpieza de pantalla
            StdDraw.clear();

            //Condicionales para hacer que las demas lineas sigan a la primera y tambien dibujarlas.
            if (ciclo>=5) {
                xO5 =xO4;
                xI5 =xI4;
                yO5 =yO4;
                yI5 =yI4;
                StdDraw.setPenColor(color5);
                StdDraw.line(xO5,yO5,xI5,yI5);
            }
            if (ciclo>=4) {
                xO4 =xO3;
                xI4 =xI3;
                yO4 =yO3;
                yI4 =yI3;
                StdDraw.setPenColor(color4);
                StdDraw.line(xO4,yO4,xI4,yI4);
            }
            if (ciclo>=3) {
                xO3 =xO2;
                xI3 =xI2;
                yO3 =yO2;
                yI3 =yI2;
                StdDraw.setPenColor(color3);
                StdDraw.line(xO3,yO3,xI3,yI3);
            }
            if (ciclo>=2) {
                xO2 =xO1;
                xI2 =xI1;
                yO2 =yO1;
                yI2 =yI1;
                StdDraw.setPenColor(color2);
                StdDraw.line(xO2,yO2,xI2,yI2);
            }
            if (ciclo>=1) {
                xO1 =x0Inicial;
                xI1 =xIInicial;
                yO1 =y0Inicial;
                yI1 =yIInicial;
                StdDraw.setPenColor(color1);
                StdDraw.line(xO1,yO1,xI1,yI1);
            }
            //Movimiento de la primera linea.
            x0Inicial+=vx;
            xIInicial+=vx;
            y0Inicial+=vy;
            yIInicial+=vy;
            //Actualizacion de primera linea.
            StdDraw.setPenColor(primerColor);
            StdDraw.line(x0Inicial,y0Inicial,xIInicial,yIInicial);

            //Mostar las lineas.
            StdDraw.show();
            //Pausa para darle mas "fluidez".
            StdDraw.pause(75);
            //Aumento de ciclo para mantener el orden de las lineas.
            ciclo++;
        }
    }
}
