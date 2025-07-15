
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;


public class HomeworkThree {

	JFrame frame;
	JLabel lbIm1;
	BufferedImage imgOne;
	BufferedImage imgTwo;
	BufferedImage imgTh;
	BufferedImage imgFo;
	BufferedImage imgFi;
	BufferedImage imgSi;
	BufferedImage imgSev;
	BufferedImage imgEi;
	BufferedImage imgNi;
	BufferedImage imgTen;
	int width = 512; // default image width and height
	int height = 512;

	/** Read Image RGB
	 *  Reads the image of given width and height at the given imgPath into the provided BufferedImage.
	 */
	private void readImageRGB(int width, int height, String imgPath, BufferedImage img, String num)
	{
		try
		{
			int nums= Integer.parseInt(num);
			int frameLength = width*height*3;

			File file = new File(imgPath);
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			raf.seek(0);

			long len = frameLength;
			byte[] bytes = new byte[(int) len];

			raf.read(bytes);
			byte[][] reshapedArray_r = new byte[height][width]; // Create a 2D array with dimensions 2x10

			// Reshape the flat array into a 2D array
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					reshapedArray_r[i][j] = bytes[i * width + j];
				}
			}
			byte[][] reshapedArray_g = new byte[height][width]; // Create a 2D array with dimensions 2x10

			// Reshape the flat array into a 2D array
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					reshapedArray_g[i][j] = bytes[i * width + j+(width*height)];
				}
			}
			byte[][] reshapedArray_b = new byte[height][width]; // Create a 2D array with dimensions 2x10

			// Reshape the flat array into a 2D array
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					reshapedArray_b[i][j] = bytes[i * width + j+(2*width*height)];
				}
			}

//////////////level=8
			int sizeofdata=2;
			int [][] r_array_1_row= new int [height][width];
			int [][] r_array_1_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata); x++){
				for (int y=0;y<width;y++){
					byte rval1_a=reshapedArray_r[y][2*x];
					byte rval1_b=reshapedArray_r[y][2*x+1];
					int R1a_r=rval1_a & 0xff;
					int R1b_r=rval1_b & 0xff;
					r_array_1_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_1_row[y][(height/sizeofdata)+x]=(R1a_r-R1b_r)/2;
				}
			}
			for (int x=0;x< (height/sizeofdata); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_1_row[2*x][y];
					int rval1_b=r_array_1_row[2*x+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_1_col[x][y]=(R1a_r+R1b_r)/2;
					r_array_1_col[(height/sizeofdata)+x][y]=(R1a_r-R1b_r)/2;
				}
			}
//

//////////////level=7 128
			int sizeofdata_2=4;
			int [][] r_array_2_row= new int [height][width];;
			int [][] r_array_2_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_2); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_1_col[y][2*x];
					int rval1_b=r_array_1_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_2_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_2_row[y][(height/sizeofdata_2)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_2); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_2_row[(2*x)][y];
					int rval1_b=r_array_2_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_2_col[(height/sizeofdata_2)+x][y]=(R1a_r-R1b_r)/2;
					r_array_2_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

//////level=6 64

			int sizeofdata_3=8;
			int [][] r_array_3_row= new int [height][width];;
			int [][] r_array_3_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_3); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_2_col[y][2*x];
					int rval1_b=r_array_2_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_3_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_3_row[y][(height/sizeofdata_3)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_3); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_3_row[(2*x)][y];
					int rval1_b=r_array_3_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_3_col[(height/sizeofdata_3)+x][y]=(R1a_r-R1b_r)/2;
					r_array_3_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=5 n=32

			int sizeofdata_4=16;
			int [][] r_array_4_row= new int [height][width];;
			int [][] r_array_4_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_4); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_3_col[y][2*x];
					int rval1_b=r_array_3_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_4_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_4_row[y][(height/sizeofdata_4)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_4); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_4_row[(2*x)][y];
					int rval1_b=r_array_4_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_4_col[(height/sizeofdata_4)+x][y]=(R1a_r-R1b_r)/2;
					r_array_4_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=4 n=16

			int sizeofdata_5=32;
			int [][] r_array_5_row= new int [height][width];;
			int [][] r_array_5_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_5); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_4_col[y][2*x];
					int rval1_b=r_array_4_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_5_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_5_row[y][(height/sizeofdata_5)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_5); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_5_row[(2*x)][y];
					int rval1_b=r_array_5_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_5_col[(height/sizeofdata_5)+x][y]=(R1a_r-R1b_r)/2;
					r_array_5_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=3 n=8

			int sizeofdata_6=64;
			int [][] r_array_6_row= new int [height][width];;
			int [][] r_array_6_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_6); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_5_col[y][2*x];
					int rval1_b=r_array_5_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_6_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_6_row[y][(height/sizeofdata_6)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_6); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_6_row[(2*x)][y];
					int rval1_b=r_array_6_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_6_col[(height/sizeofdata_6)+x][y]=(R1a_r-R1b_r)/2;
					r_array_6_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

/////////level=2 n=4

			int sizeofdata_7=128;
			int [][] r_array_7_row= new int [height][width];;
			int [][] r_array_7_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_7); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_6_col[y][2*x];
					int rval1_b=r_array_6_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_7_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_7_row[y][(height/sizeofdata_7)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_7); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_7_row[(2*x)][y];
					int rval1_b=r_array_7_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_7_col[(height/sizeofdata_7)+x][y]=(R1a_r-R1b_r)/2;
					r_array_7_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

			/////////level=1 n=2

			int sizeofdata_8=256;
			int [][] r_array_8_row= new int [height][width];;
			int [][] r_array_8_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_8); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_7_col[y][2*x];
					int rval1_b=r_array_7_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_8_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_8_row[y][(height/sizeofdata_8)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_8); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_8_row[(2*x)][y];
					int rval1_b=r_array_8_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_8_col[(height/sizeofdata_8)+x][y]=(R1a_r-R1b_r)/2;
					r_array_8_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
			/////////level=0 n=1

			int sizeofdata_9=512;
			int [][] r_array_9_row= new int [height][width];;
			int [][] r_array_9_col= new int [height][width];
			for (int x=0;x< (height/sizeofdata_9); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_8_col[y][2*x];
					int rval1_b=r_array_8_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					r_array_9_row[y][x]=(R1a_r+R1b_r)/2;
					r_array_9_row[y][(height/sizeofdata_9)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_9); x++){
				for (int y=0;y<width;y++){
					int rval1_a=r_array_9_row[(2*x)][y];
					int rval1_b=r_array_9_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					r_array_9_col[(height/sizeofdata_9)+x][y]=(R1a_r-R1b_r)/2;
					r_array_9_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

////////////////////////////red channel/////////////////////////////////////
//			int sizeofdata=2;
			int [][] g_array_1_row = new int [height][width];
			int [][] g_array_1_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata); x++){
				for (int y=0;y<width;y++){
					byte rval1_a=reshapedArray_g[y][2*x];
					byte rval1_b=reshapedArray_g[y][2*x+1];
					int R1a_r=rval1_a & 0xff;
					int R1b_r=rval1_b & 0xff;
					g_array_1_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_1_row[y][(height/sizeofdata)+x]=(R1a_r-R1b_r)/2;
				}
			}
			for (int x=0;x< (height/sizeofdata); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_1_row[2*x][y];
					int rval1_b= g_array_1_row[2*x+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_1_col[x][y]=(R1a_r+R1b_r)/2;
					g_array_1_col[(height/sizeofdata)+x][y]=(R1a_r-R1b_r)/2;
				}
			}
//

			//////////////level=7 128
//			int sizeofdata_2=4;
			int [][] g_array_2_row = new int [height][width];;
			int [][] g_array_2_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_2); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_1_col[y][2*x];
					int rval1_b= g_array_1_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_2_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_2_row[y][(height/sizeofdata_2)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_2); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_2_row[(2*x)][y];
					int rval1_b= g_array_2_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_2_col[(height/sizeofdata_2)+x][y]=(R1a_r-R1b_r)/2;
					g_array_2_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

//////level=6 64

//			int sizeofdata_3=8;
			int [][] g_array_3_row = new int [height][width];;
			int [][] g_array_3_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_3); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_2_col[y][2*x];
					int rval1_b= g_array_2_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_3_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_3_row[y][(height/sizeofdata_3)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_3); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_3_row[(2*x)][y];
					int rval1_b= g_array_3_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_3_col[(height/sizeofdata_3)+x][y]=(R1a_r-R1b_r)/2;
					g_array_3_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=5 n=32

//			int sizeofdata_4=16;
			int [][] g_array_4_row = new int [height][width];;
			int [][] g_array_4_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_4); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_3_col[y][2*x];
					int rval1_b= g_array_3_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_4_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_4_row[y][(height/sizeofdata_4)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_4); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_4_row[(2*x)][y];
					int rval1_b= g_array_4_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_4_col[(height/sizeofdata_4)+x][y]=(R1a_r-R1b_r)/2;
					g_array_4_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=4 n=16

//			int sizeofdata_5=32;
			int [][] g_array_5_row = new int [height][width];;
			int [][] g_array_5_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_5); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_4_col[y][2*x];
					int rval1_b= g_array_4_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_5_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_5_row[y][(height/sizeofdata_5)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_5); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_5_row[(2*x)][y];
					int rval1_b= g_array_5_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_5_col[(height/sizeofdata_5)+x][y]=(R1a_r-R1b_r)/2;
					g_array_5_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=3 n=8

//			int sizeofdata_6=64;
			int [][] g_array_6_row = new int [height][width];;
			int [][] g_array_6_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_6); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_5_col[y][2*x];
					int rval1_b= g_array_5_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_6_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_6_row[y][(height/sizeofdata_6)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_6); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_6_row[(2*x)][y];
					int rval1_b= g_array_6_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_6_col[(height/sizeofdata_6)+x][y]=(R1a_r-R1b_r)/2;
					g_array_6_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

/////////level=2 n=4

//			int sizeofdata_7=128;
			int [][] g_array_7_row = new int [height][width];;
			int [][] g_array_7_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_7); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_6_col[y][2*x];
					int rval1_b= g_array_6_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_7_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_7_row[y][(height/sizeofdata_7)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_7); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_7_row[(2*x)][y];
					int rval1_b= g_array_7_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_7_col[(height/sizeofdata_7)+x][y]=(R1a_r-R1b_r)/2;
					g_array_7_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

			/////////level=1 n=2

//			int sizeofdata_8=256;
			int [][] g_array_8_row = new int [height][width];;
			int [][] g_array_8_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_8); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_7_col[y][2*x];
					int rval1_b= g_array_7_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_8_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_8_row[y][(height/sizeofdata_8)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_8); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_8_row[(2*x)][y];
					int rval1_b= g_array_8_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_8_col[(height/sizeofdata_8)+x][y]=(R1a_r-R1b_r)/2;
					g_array_8_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
			/////////level=0 n=1

//			int sizeofdata_9=512;
			int [][] g_array_9_row = new int [height][width];;
			int [][] g_array_9_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_9); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_8_col[y][2*x];
					int rval1_b= g_array_8_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					g_array_9_row[y][x]=(R1a_r+R1b_r)/2;
					g_array_9_row[y][(height/sizeofdata_9)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_9); x++){
				for (int y=0;y<width;y++){
					int rval1_a= g_array_9_row[(2*x)][y];
					int rval1_b= g_array_9_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					g_array_9_col[(height/sizeofdata_9)+x][y]=(R1a_r-R1b_r)/2;
					g_array_9_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

////////////////////////////////blue channel/////////////////////////////////////
			int [][] b_array_1_row = new int [height][width];
			int [][] b_array_1_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata); x++){
				for (int y=0;y<width;y++){
					byte rval1_a=reshapedArray_b[y][2*x];
					byte rval1_b=reshapedArray_b[y][2*x+1];
					int R1a_r=rval1_a & 0xff;
					int R1b_r=rval1_b & 0xff;
					b_array_1_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_1_row[y][(height/sizeofdata)+x]=(R1a_r-R1b_r)/2;
				}
			}
			for (int x=0;x< (height/sizeofdata); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_1_row[2*x][y];
					int rval1_b= b_array_1_row[2*x+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_1_col[x][y]=(R1a_r+R1b_r)/2;
					b_array_1_col[(height/sizeofdata)+x][y]=(R1a_r-R1b_r)/2;
				}
			}
//

			//////////////level=7 128
//			int sizeofdata_2=4;
			int [][] b_array_2_row = new int [height][width];;
			int [][] b_array_2_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_2); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_1_col[y][2*x];
					int rval1_b= b_array_1_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_2_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_2_row[y][(height/sizeofdata_2)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_2); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_2_row[(2*x)][y];
					int rval1_b= b_array_2_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_2_col[(height/sizeofdata_2)+x][y]=(R1a_r-R1b_r)/2;
					b_array_2_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

//////level=6 64

			//			int sizeofdata_3=8;
			int [][] b_array_3_row = new int [height][width];;
			int [][] b_array_3_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_3); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_2_col[y][2*x];
					int rval1_b= b_array_2_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_3_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_3_row[y][(height/sizeofdata_3)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_3); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_3_row[(2*x)][y];
					int rval1_b= b_array_3_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_3_col[(height/sizeofdata_3)+x][y]=(R1a_r-R1b_r)/2;
					b_array_3_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=5 n=32

			//			int sizeofdata_4=16;
			int [][] b_array_4_row = new int [height][width];;
			int [][] b_array_4_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_4); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_3_col[y][2*x];
					int rval1_b= b_array_3_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_4_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_4_row[y][(height/sizeofdata_4)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_4); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_4_row[(2*x)][y];
					int rval1_b= b_array_4_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_4_col[(height/sizeofdata_4)+x][y]=(R1a_r-R1b_r)/2;
					b_array_4_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=4 n=16

			//			int sizeofdata_5=32;
			int [][] b_array_5_row = new int [height][width];;
			int [][] b_array_5_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_5); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_4_col[y][2*x];
					int rval1_b= b_array_4_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_5_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_5_row[y][(height/sizeofdata_5)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_5); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_5_row[(2*x)][y];
					int rval1_b= b_array_5_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_5_col[(height/sizeofdata_5)+x][y]=(R1a_r-R1b_r)/2;
					b_array_5_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
/////////level=3 n=8

			//			int sizeofdata_6=64;
			int [][] b_array_6_row = new int [height][width];;
			int [][] b_array_6_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_6); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_5_col[y][2*x];
					int rval1_b= b_array_5_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_6_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_6_row[y][(height/sizeofdata_6)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_6); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_6_row[(2*x)][y];
					int rval1_b= b_array_6_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_6_col[(height/sizeofdata_6)+x][y]=(R1a_r-R1b_r)/2;
					b_array_6_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

/////////level=2 n=4

			//			int sizeofdata_7=128;
			int [][] b_array_7_row = new int [height][width];;
			int [][] b_array_7_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_7); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_6_col[y][2*x];
					int rval1_b= b_array_6_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_7_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_7_row[y][(height/sizeofdata_7)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_7); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_7_row[(2*x)][y];
					int rval1_b= b_array_7_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_7_col[(height/sizeofdata_7)+x][y]=(R1a_r-R1b_r)/2;
					b_array_7_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

			/////////level=1 n=2

			//			int sizeofdata_8=256;
			int [][] b_array_8_row = new int [height][width];;
			int [][] b_array_8_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_8); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_7_col[y][2*x];
					int rval1_b= b_array_7_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_8_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_8_row[y][(height/sizeofdata_8)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_8); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_8_row[(2*x)][y];
					int rval1_b= b_array_8_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_8_col[(height/sizeofdata_8)+x][y]=(R1a_r-R1b_r)/2;
					b_array_8_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}
			/////////level=0 n=1

			//			int sizeofdata_9=512;
			int [][] b_array_9_row = new int [height][width];;
			int [][] b_array_9_col = new int [height][width];
			for (int x=0;x< (height/sizeofdata_9); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_8_col[y][2*x];
					int rval1_b= b_array_8_col[y][2*x+1];
					int R1a_r=rval1_a;
					int R1b_r=rval1_b;
					b_array_9_row[y][x]=(R1a_r+R1b_r)/2;
					b_array_9_row[y][(height/sizeofdata_9)+x]=(R1a_r-R1b_r)/2;
//					System.out.println(height/sizeofdata_2);
				}

			}
			for (int x=0;x< (height/sizeofdata_9); x++){
				for (int y=0;y<width;y++){
					int rval1_a= b_array_9_row[(2*x)][y];
					int rval1_b= b_array_9_row[(2*x)+1][y];
					int R1a_r=rval1_a; //& 0xff;
					int R1b_r=rval1_b;// & 0xff;
					b_array_9_col[(height/sizeofdata_9)+x][y]=(R1a_r-R1b_r)/2;
					b_array_9_col[x][y]=(R1a_r+R1b_r)/2;
				}
			}

///////////////////////////done with encoding///////////////////////////////////////
/////////////////////////////decloding////////////////////////////
			int [][] r_array_1_col_dec = new int [height][width];
			int [][] g_array_1_col_dec = new int [height][width];
			int [][] b_array_1_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata;
					int smallImageY = j / sizeofdata;
					r_array_1_col_dec[i][j] = r_array_1_col[smallImageX][smallImageY];
					g_array_1_col_dec[i][j] = g_array_1_col[smallImageX][smallImageY];
					b_array_1_col_dec[i][j] = b_array_1_col[smallImageX][smallImageY];
				}
			}


			int [][] r_array_2_col_dec = new int [height][width];
			int [][] g_array_2_col_dec = new int [height][width];
			int [][] b_array_2_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_2;
					int smallImageY = j / sizeofdata_2;
					r_array_2_col_dec[i][j] = r_array_2_col[smallImageX][smallImageY];
					g_array_2_col_dec[i][j] = g_array_2_col[smallImageX][smallImageY];
					b_array_2_col_dec[i][j] = b_array_2_col[smallImageX][smallImageY];
				}
			}

			int [][] r_array_3_col_dec = new int [height][width];
			int [][] g_array_3_col_dec = new int [height][width];
			int [][] b_array_3_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_3;
					int smallImageY = j / sizeofdata_3;
					r_array_3_col_dec[i][j] = r_array_3_col[smallImageX][smallImageY];
					g_array_3_col_dec[i][j] = g_array_3_col[smallImageX][smallImageY];
					b_array_3_col_dec[i][j] = b_array_3_col[smallImageX][smallImageY];
				}
			}

			int [][] r_array_4_col_dec = new int [height][width];
			int [][] g_array_4_col_dec = new int [height][width];
			int [][] b_array_4_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_4;
					int smallImageY = j / sizeofdata_4;
					r_array_4_col_dec[i][j] = r_array_4_col[smallImageX][smallImageY];
					g_array_4_col_dec[i][j] = g_array_4_col[smallImageX][smallImageY];
					b_array_4_col_dec[i][j] = b_array_4_col[smallImageX][smallImageY];
				}
			}

			int [][] r_array_5_col_dec = new int [height][width];
			int [][] g_array_5_col_dec = new int [height][width];
			int [][] b_array_5_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_5;
					int smallImageY = j / sizeofdata_5;
					r_array_5_col_dec[i][j] = r_array_5_col[smallImageX][smallImageY];
					g_array_5_col_dec[i][j] = g_array_5_col[smallImageX][smallImageY];
					b_array_5_col_dec[i][j] = b_array_5_col[smallImageX][smallImageY];
				}
			}
			int [][] r_array_6_col_dec = new int [height][width];
			int [][] g_array_6_col_dec = new int [height][width];
			int [][] b_array_6_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_6;
					int smallImageY = j / sizeofdata_6;
					r_array_6_col_dec[i][j] = r_array_6_col[smallImageX][smallImageY];
					g_array_6_col_dec[i][j] = g_array_6_col[smallImageX][smallImageY];
					b_array_6_col_dec[i][j] = b_array_6_col[smallImageX][smallImageY];
				}
			}

			int [][] r_array_7_col_dec = new int [height][width];
			int [][] g_array_7_col_dec = new int [height][width];
			int [][] b_array_7_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_7;
					int smallImageY = j / sizeofdata_7;
					r_array_7_col_dec[i][j] = r_array_7_col[smallImageX][smallImageY];
					g_array_7_col_dec[i][j] = g_array_7_col[smallImageX][smallImageY];
					b_array_7_col_dec[i][j] = b_array_7_col[smallImageX][smallImageY];
				}
			}
			int [][] r_array_8_col_dec = new int [height][width];
			int [][] g_array_8_col_dec = new int [height][width];
			int [][] b_array_8_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_8;
					int smallImageY = j / sizeofdata_8;
					r_array_8_col_dec[i][j] = r_array_8_col[smallImageX][smallImageY];
					g_array_8_col_dec[i][j] = g_array_8_col[smallImageX][smallImageY];
					b_array_8_col_dec[i][j] = b_array_8_col[smallImageX][smallImageY];
				}
			}

			int [][] r_array_9_col_dec = new int [height][width];
			int [][] g_array_9_col_dec = new int [height][width];
			int [][] b_array_9_col_dec = new int [height][width];

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int smallImageX = i / sizeofdata_9;
					int smallImageY = j / sizeofdata_9;
					r_array_9_col_dec[i][j] = r_array_9_col[smallImageX][smallImageY];
					g_array_9_col_dec[i][j] = g_array_9_col[smallImageX][smallImageY];
					b_array_9_col_dec[i][j] = b_array_9_col[smallImageX][smallImageY];
				}
			}




		int ind = 0;
			for(int y = 0; y < height; y++)
			{
				for(int x = 0; x < width; x++)
				{
					if (nums==0){
					int g=g_array_9_col_dec[y][x];
					int r=r_array_9_col_dec[y][x];
					int b=b_array_9_col_dec[y][x];

					int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
					//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
					img.setRGB(x,y,pix);
					ind++;

				}
					if (nums==1){
						int g=g_array_8_col_dec[y][x];
						int r=r_array_8_col_dec[y][x];
						int b=b_array_8_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==2){
						int g=g_array_7_col_dec[y][x];
						int r=r_array_7_col_dec[y][x];
						int b=b_array_7_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==3){
						int g=g_array_6_col_dec[y][x];
						int r=r_array_6_col_dec[y][x];
						int b=b_array_6_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==4){
						int g=g_array_5_col_dec[y][x];
						int r=r_array_5_col_dec[y][x];
						int b=b_array_5_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==5){
						int g=g_array_4_col_dec[y][x];
						int r=r_array_4_col_dec[y][x];
						int b=b_array_4_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==6){
						int g=g_array_3_col_dec[y][x];
						int r=r_array_3_col_dec[y][x];
						int b=b_array_3_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==7){
						int g=g_array_2_col_dec[y][x];
						int r=r_array_2_col_dec[y][x];
						int b=b_array_2_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==8){
						int g=g_array_1_col_dec[y][x];
						int r=r_array_1_col_dec[y][x];
						int b=b_array_1_col_dec[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
					if (nums==9){
						int g=reshapedArray_g[y][x];
						int r=reshapedArray_r[y][x];
						int b=reshapedArray_b[y][x];

						int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
						//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
						img.setRGB(x,y,pix);
						ind++;

					}
////					byte a = 0;
////					byte r = bytes[ind];
////					byte g = bytes[ind+height*width];
////					byte b = bytes[ind+height*width*2];
////					byte r = reshapedArray_r[y][x];
//					int g=g_array_7_col_dec[y][x];
//					int r=r_array_7_col_dec[y][x];
//					int b=b_array_7_col_dec[y][x];
//
//					int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
//					//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
//					img.setRGB(x,y,pix);
//					ind++;
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void showIms(String[] args){

		// Read a parameter from command line
		String param1 = args[1];
		String pathref="./"+args[0];
		System.out.println("The second parameter was: " + param1);
		int numxs= Integer.parseInt(param1);
		if (numxs==-1){
			imgOne = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"0");


			// Use label to display the image
			frame = new JFrame();
			GridBagLayout gLayout = new GridBagLayout();
			frame.getContentPane().setLayout(gLayout);

			lbIm1 = new JLabel(new ImageIcon(imgOne));

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.CENTER;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 0;

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			frame.getContentPane().add(lbIm1, c);

			frame.pack();
			frame.setVisible(true);

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"1");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));
			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"2");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"3");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"4");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"5");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"6");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"7");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"8");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));

			try {
				Thread.sleep(500); // Wait for 500ms before displaying the second image
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,"9");

			// Update the label with the second image
			lbIm1.setIcon(new ImageIcon(imgOne));


		} else {
			imgOne = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			readImageRGB(width, height, pathref, imgOne,param1);


			// Use label to display the image
			frame = new JFrame();
			GridBagLayout gLayout = new GridBagLayout();
			frame.getContentPane().setLayout(gLayout);

			lbIm1 = new JLabel(new ImageIcon(imgOne));

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.CENTER;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 0;

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			frame.getContentPane().add(lbIm1, c);

			frame.pack();
			frame.setVisible(true);

		}


//		// Read in the specified image
//		imgOne = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		readImageRGB(width, height, args[0], imgOne,param1);
//
//
//		// Use label to display the image
//		frame = new JFrame();
//		GridBagLayout gLayout = new GridBagLayout();
//		frame.getContentPane().setLayout(gLayout);
//
//		lbIm1 = new JLabel(new ImageIcon(imgOne));
//
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.anchor = GridBagConstraints.CENTER;
//		c.weightx = 0.5;
//		c.gridx = 0;
//		c.gridy = 0;
//
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 0;
//		c.gridy = 1;
//		frame.getContentPane().add(lbIm1, c);
//
//		frame.pack();
//		frame.setVisible(true);
//
//		try {
//			Thread.sleep(500); // Wait for 500ms before displaying the second image
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
////		imgTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		readImageRGB(width, height, args[0], imgOne,"5");
//
//		// Update the label with the second image
//		lbIm1.setIcon(new ImageIcon(imgOne));




//		frame.pack();
//		frame.setVisible(true);

	}

	public static void main(String[] args) {
		HomeworkThree ren = new HomeworkThree();
		ren.showIms(args);
	}

}
