class FractionDriver {
	public static void main(String[] args){
		Fraction frac = new Fraction("3/0");
		Fraction frac1 = new Fraction(frac);
		System.out.println(frac.getNum());
		System.out.println(frac.getDen());
		System.out.println(frac);
		System.out.println(frac.toDouble());
		frac.setNum(-5);
		frac.setDen(-7);
		System.out.println(frac);
		frac.reduce();
		System.out.println(frac);
		Fraction frac2 = new Fraction(9, 4);
		Fraction product = Fraction.multiply(frac, frac2);
		System.out.println(product);
		System.out.println(Fraction.divide(frac,frac2));
		Fraction zero = new Fraction(0,1);
		System.out.println(Fraction.divide(frac,zero));
		System.out.println(Fraction.add(frac, frac2));
		System.out.println(Fraction.subtract(frac, frac2));
	}
	
}
