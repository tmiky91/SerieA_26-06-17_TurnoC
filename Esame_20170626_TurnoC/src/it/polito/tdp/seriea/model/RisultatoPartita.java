package it.polito.tdp.seriea.model;

public class RisultatoPartita {
	
	private Integer risultato1;
	private Integer risultato2;
	private double peso;
	public RisultatoPartita(Integer risultato1, Integer risultato2, double peso) {
		super();
		this.risultato1 = risultato1;
		this.risultato2 = risultato2;
		this.peso = peso;
	}
	public Integer getRisultato1() {
		return risultato1;
	}
	public void setRisultato1(Integer risultato1) {
		this.risultato1 = risultato1;
	}
	public Integer getRisultato2() {
		return risultato2;
	}
	public void setRisultato2(Integer risultato2) {
		this.risultato2 = risultato2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((risultato1 == null) ? 0 : risultato1.hashCode());
		result = prime * result + ((risultato2 == null) ? 0 : risultato2.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RisultatoPartita other = (RisultatoPartita) obj;
		if (risultato1 == null) {
			if (other.risultato1 != null)
				return false;
		} else if (!risultato1.equals(other.risultato1))
			return false;
		if (risultato2 == null) {
			if (other.risultato2 != null)
				return false;
		} else if (!risultato2.equals(other.risultato2))
			return false;
		return true;
	}

}
