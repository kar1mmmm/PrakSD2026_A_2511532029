package pekan1_2511532029;

public final class Jam_2511532029{
	private int hh; // 0..23
	private int mm; // 0..59
	private int ss; // 0..59
	
	//---Valiadator--
	public static boolean isValid(int h, int m, int s) {
		return (0 <= h && h <= 23) && (0 <=m && m <=59) && (0 <= s && s <= 59);
	}
	
	//--Kreator--
	public Jam_2511532029 (int h, int m, int s) {
		this.hh = h;
		this.mm = m;
		this.ss = s;
	}
	
	//--Selector--
	public int getHour() { return hh;}
	public int getMinute() { return mm;}
	public int getSecond() { return ss;}
	
	//--Mutator--
	public void setHour(int h){this.hh = h;}
	public void seMinute(int m){this.mm = m;}
	public void setSecond (int s){this.ss = s;}
	
	//--Konversi--
	public int toSecond() {return hh * 3600 + mm * 60 + ss;}
	public static Jam_2511532029 fromSecond (int total) {
		if (total < 0) throw new IllegalArgumentException("detik negatif");
		total %= 24 * 3600; //warp 24 jam
		int h = total / 3600;
			total %= 3600;
		int m = total / 60;
		int s = total % 60;
		return new Jam_2511532029 (h, m, s);
	}

	
	//--Relasional--
	public int compareTo (Jam_2511532029 other ) { return Integer.compare(this.toSecond(), other.toSecond());}
	public boolean equals (Object o) {
		if (!(o instanceof Jam_2511532029 j)) return false;
		return hh == j.hh && mm == j.mm && ss == j.ss;
	}
	
	public int hashCode() {return java.util.Objects.hash (hh, mm, ss); }
	
	//--Aritmatika--
	public Jam_2511532029 plus(Jam_2511532029 other) {return fromSecond(this.toSecond() + other.toSecond());}
	public Jam_2511532029 minus(Jam_2511532029 other) {return fromSecond(Math.floorMod(this.toSecond()- other.toSecond(), 24*3600));}
	public Jam_2511532029 nextSecond() {return fromSecond(this.toSecond() + 1);}
	public Jam_2511532029 nextNsecond (int n) { return fromSecond(this.toSecond() + Math.max(0, n));}
	public Jam_2511532029 prevSecond() {return fromSecond(Math.floorMod(this.toSecond() - 1, 24*3600));}
	public Jam_2511532029 prevNSecond(int n) {return fromSecond(Math.floorMod(toSecond() - Math.max(0,  n), 24 * 3600));}

	public static int durasiDetik(Jam_2511532029 jaw, Jam_2511532029 jakh) {return jakh.toSecond() - jaw.toSecond();}
	public String toString () {return String.format("%02d:%02d:02d", hh, mm, ss);}
}
	

