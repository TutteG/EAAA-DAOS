package cykeldb2;

public class Rytter {
	private String init;
	private String navn;

	public Rytter(String init, String navn) {
		// TODO Auto-generated constructor stub
		this.init = init;
		this.navn = navn;
	}

	public String getInit() {
		return init;
	}

	public String getNavn() {
		return navn;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
}
