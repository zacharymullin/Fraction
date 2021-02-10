class Fraction {
	private int num, den;
	
	//Constructor

	public Fraction() {
		this.num = 1;
		this.den = 1;
	}
	
	public Fraction(int n, int d){
		this.num = n;
		denCheck(d);
	}
	
	public Fraction(String str){
		if(!str.contains("/")) System.out.println("Must use proper format!");
		else{
			this.num = Integer.valueOf(str.substring(0,str.indexOf("/")));
			int potD = Integer.valueOf(str.substring(str.indexOf("/")+1,str.length()));
			denCheck(potD);
		}
	}
	
	public Fraction(Fraction frac){
		this.num = frac.num;
		denCheck(frac.den);
	}
	
	//Accessor
	
	public int getNum(){
		return this.num;
	}
	
	public int getDen(){
		return this.den;
	}
	
	public String toString(){
		return this.num + "/" + this.den;
	}
	
	public double toDouble(){
		return (double) this.num / (double) this.den;
	}
	
	//Mutator
	
	public void reduce(){
		int factor = 0;
		if(this.num == this. den){
			this.num = 1;
			this.den = 1;
			factor = 1;
		}
		else if(Math.abs(this.num) > Math.abs(this.den)) factor = GCF(this.num, this.den);
		else if(Math.abs(this.num) < Math.abs(this.den))factor = GCF(this.den, this.num);
		//System.out.println(factor);
		this.num = this.num / factor;
		this.den = this.den / factor;
		if(this.num < 0 && this.den < 0){
			this.num = Math.abs(this.num);
			this.den = Math.abs(this.den);
		}
	}

	public void setNum(int n){
		this.num = n;	
	}
	
	public void setDen(int d){
		denCheck(d);
	}

	//Static
	
	public static Fraction multiply(Fraction a, Fraction b){
		int newNum = a.getNum() * b.getNum();
		int newDen = a.getDen() * b.getDen();
		Fraction f = new Fraction(newNum, newDen);
		//f.reduce();
		return f;
	}
	
	public static Fraction divide(Fraction a, Fraction b){
		Fraction f = multiply(a, recip(b));
		//System.out.println("R: " + recip(b));
		f.reduce();
		return f;
	}
	
	public static Fraction add(Fraction a, Fraction b){
		int d = a.getDen() * b.getDen();
		int n = (b.getDen() * a.getNum()) + (a.getDen() * b.getNum());
		Fraction f = new Fraction(n, d);
		f.reduce();
		return f;
	}
	
	public static Fraction subtract(Fraction a, Fraction b){
		int d = a.getDen() * b.getDen();
		int n = (b.getDen() * a.getNum()) - (a.getDen() * b.getNum());
		Fraction f = new Fraction(n, d);
		f.reduce();
		return f;
	}
	
	//Helper

	private void denCheck(int d){
		if(d != 0) this.den = d;
		else {
			System.out.println("Denominator cannot be 0! Fraction set to default value.");
			this.den = 1;
			this.num = 1;
		}
	}
	
	private int GCF(int big, int small){
		if(big != 0 && small != 0){
			big = Math.abs(big);
			small = Math.abs(small);
			int temp = 0;
			while(big != small){
				big = big - small;
				if(small > big){
					temp = big;
					big = small;
					small = temp;
				}
			}
			return big;
		}
		else return 1;
	}
	
	private static Fraction recip(Fraction a){
		if(a.num != 0){
			Fraction f = new Fraction(a.getDen(), a.getNum());
			return f;
		}
		else{
			Fraction f = new Fraction();
			System.out.println("Error dividing fraction: cannot get reciprocal of fraction with numerator 0, default value assigned");
			return f;
		}
	}
}