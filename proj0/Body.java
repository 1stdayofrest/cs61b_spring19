

public class Body  {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private double G = 6.67e-11;
	public Body(double xP, double yP, double xV,
				 double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Body(Body p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Body p){
		double r,x;
		x = (p.xxPos - this.xxPos)*(p.xxPos - this.xxPos) + 
		(p.yyPos - this.yyPos)*(p.yyPos - this.yyPos);
		r = Math.sqrt(x);
		return r;
	}
	public double calcForceExertedBy(Body p){
		double r =  G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return r;
	}
	public double calcForceExertedByX(Body p){
		if ((p.xxPos - this.xxPos) > 0) {
			return  this.calcForceExertedBy(p)*(p.xxPos - this.xxPos)/this.calcDistance(p);
		}
		return this.calcForceExertedBy(p)*(this.xxPos - p.xxPos)/this.calcDistance(p);		
	}
	public double calcForceExertedByY(Body p){
		if ((p.yyPos - this.yyPos) > 0) {
			return  this.calcForceExertedBy(p)*(p.yyPos - this.yyPos)/this.calcDistance(p);
		}
		return this.calcForceExertedBy(p)*(this.yyPos - p.yyPos)/this.calcDistance(p);		
	}

	public double calcNetForceExertedByX(Body[] p){
		int i = p.length;
		double a = 0.0;
		while (i > 0){
			if (this.equals(p[i-1]) == true){
				i--;
				continue;
			}
			if ((p[i-1].xxPos - this.xxPos) > 0) {
				a += this.calcForceExertedByX(p[i-1]);			
			}else{
				a -= this.calcForceExertedByX(p[i-1]);
			}
			i--;
		}
		return a;
	}

	public double calcNetForceExertedByY(Body[] p){
		int i = p.length;
		double a = 0.0;
		while (i > 0){
			if (this.equals(p[i-1]) == true){
				i--;
				continue;
			}
			if ((p[i-1].yyPos - this.yyPos) > 0) {
				a += this.calcForceExertedByY(p[i-1]);			
			}else{
				a -= this.calcForceExertedByY(p[i-1]);
			}
			i--;
		}
		return a;
	}

	public void update(double dt,double xForce,double yForce){
		double xxacc;
		double yyacc;

		xxacc = xForce / this.mass ;
		yyacc = yForce / this.mass ;

		this.xxVel += (xxacc * dt);
		this.yyVel += (yyacc * dt);

		this.xxPos += (this.xxVel * dt);
		this.yyPos += (this.yyVel * dt);

	}
	public void draw(){

		StdDraw.picture(this.xxPos,this.yyPos,this.imgFileName);
	}


}