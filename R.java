import java.util.*;

public class R{
	boolean mat[][];
	LinkedList<String> list;
	int xfinal, yfinal;


	/*recursion*/
	void getpath(int x, int y, StringBuilder path){
		String box = "[%s]";
		StringBuilder aux = new StringBuilder();
		aux.append(path.toString());
		boolean isAdd = false;

		if((x <= mat.length-1 && y<=mat[0].length-1)&&(x == xfinal && y == yfinal)){
			aux.append(String.format("(%d,%d)", y, x));
			list.add(String.format(box, aux.toString()));
			return;
		} 
		if(x < mat.length-1 && y<mat[0].length-1 ){
			if(mat[x][y+1]){
				aux.append(String.format("(%d,%d), ", y, x));
				getpath(x, y+1, aux);
			} if(mat[x+1][y]){
				isAdd = true;
				if(!isAdd)
				aux.append(String.format("(%d,%d), ", y, x));
				getpath(x+1, y, aux);
			}
		}
	}

	void print(Object ob){
		System.out.print(ob.toString());
	}

	void makeMat(int width, int height){
		mat = new boolean[width][height];
		Random ran = new Random();
		String dis = "inicio\n";
		for(int i=0; i<width; i++){
			for(int ii = 0; ii<height; ii++){
				mat[i][ii]=(ran.nextInt(101)%2)==0;
				dis = dis.concat(mat[i][ii]+" | ");
			}
			dis += "\n";
		}		
		print(dis);
	}

	void init(){
		Scanner scan = new Scanner(System.in);
		int width, height;
		list = new LinkedList<>();
		print("\nNuevo Ejemplo de recursion\n\n");

		print("NO REGRESA PORQUE NO ESTAN LOS CASOS CONTEMPLADOS\n\n");
		for(;;){
			print("ingrese tamano de x de la matriz: \n");
			width = scan.nextInt();
			if(width>0) break;
			else print("debe ser mayor a 0");
		}
		for(;;){
			print("ingrese tamano de y de la matriz: \n");
			height = scan.nextInt();
			if(height>0) break;
			else print("debe ser mayor a 0");
		}

		makeMat(width, height);

		print("ingrese x a buscar: \n");
		yfinal = scan.nextInt();
		print("ingrese y a buscar: \n");
		xfinal = scan.nextInt();

		getpath(0, 0, new StringBuilder());
		print("\n"+list.toString()+"\n");

		for(;;){
			list = new LinkedList<>();
			print("buscar una nueva coordenada (0 no): ");
			if(scan.nextInt()==0) break;
			print("ingrese x a buscar: \n");
			yfinal = scan.nextInt();
			print("ingrese y a buscar: \n");
			xfinal = scan.nextInt();
			getpath(0, 0, new StringBuilder());
			print("\n"+list.toString()+"\n");
		}
	}

	private R(){}

	public static void main(String args[]){
		new R().init();
	}
}