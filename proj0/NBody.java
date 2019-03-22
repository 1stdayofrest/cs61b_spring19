
public class NBody  {
	public static double readRadius(String filepath){
		In in = new In (filepath);
		int n = in.readInt();
		double r = in.readDouble();

		return r;
	}

	public static Body[] readBodies(String filepath){
		In in = new In(filepath);
		int n = in.readInt();
		double r = in.readDouble();

		Body[] Bodies = new Body[n];
		for (int i = 0;i < n ;i++ ) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();

			Bodies[i] = new Body (xxPos,yyPos,xxVel,yyVel,mass,img);

		}
		return Bodies;

	}

	private static void drawset(double r){
		StdDraw.setScale(-2 * r,2 * r);

		// StdDraw.clear();

		StdDraw.picture(0,0,"images/starfield.jpg");




	}

	public static void main(String[] args) {

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);

		String filename = args[2];

		double readRadius = readRadius(filename);
		Body[] Bodies = readBodies(filename);

		drawset(readRadius);

		StdDraw.enableDoubleBuffering();

		double time;
		int j;
		for (time = 0; time < T ;time += dt ) {
			j = 0;

			double[] xForces = new double[Bodies.length];
			double[] yForces = new double[Bodies.length];

			for (int i = 0; i < Bodies.length ;i++ ) {

				xForces[i] = Bodies[i].calcNetForceExertedByX(Bodies);
				yForces[i] = Bodies[i].calcNetForceExertedByY(Bodies);

				Bodies[i].update(dt, xForces[i], yForces[i]);
			}

			
		
			drawset(readRadius);
			for (Body p : Bodies ) {

				p.draw();
				
			}	
			
			StdDraw.show();
			StdDraw.pause(10);
			j++;

		}		
	
		StdOut.printf("%d\n", Bodies.length);
		StdOut.printf("%.2e\n", readRadius);

		for(Body p : Bodies ){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
		}
	}





}