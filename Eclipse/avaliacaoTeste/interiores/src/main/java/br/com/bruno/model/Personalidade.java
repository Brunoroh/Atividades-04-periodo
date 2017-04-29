package br.com.bruno.model;

public class Personalidade {

	private int codigo;
	private boolean natureza; // sim = gosta de natureza // não = gosta de cidades
	private boolean adulto; // sim = é um adulto // não = não = é um jovem/criança
	private boolean feliz; // sim = feliz // não = gotico
	private boolean ocidental; // sim = ocidental // não = oriental
	private boolean colorido; // sim = colorido // não = monocromatico
	private boolean futurista; //sim = futurista // não = classico
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isNatureza() {
		return natureza;
	}
	public void setNatureza(boolean natureza) {
		this.natureza = natureza;
	}
	public boolean isAdulto() {
		return adulto;
	}
	public void setAdulto(boolean adulto) {
		this.adulto = adulto;
	}
	public boolean isFeliz() {
		return feliz;
	}
	public void setFeliz(boolean feliz) {
		this.feliz = feliz;
	}
	public boolean isOcidental() {
		return ocidental;
	}
	public void setOcidental(boolean ocidental) {
		this.ocidental = ocidental;
	}
	public boolean isColorido() {
		return colorido;
	}
	public void setColorido(boolean colorido) {
		this.colorido = colorido;
	}
	public boolean isFuturista() {
		return futurista;
	}
	public void setFuturista(boolean futurista) {
		this.futurista = futurista;
	}
	
	
}
