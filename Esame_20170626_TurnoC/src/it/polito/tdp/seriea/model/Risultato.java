package it.polito.tdp.seriea.model;

public class Risultato {
	
	private Integer goal1;
	private Integer goal2;
	private double cnt;
	public Risultato(Integer goal1, Integer goal2, double cnt) {
		super();
		this.goal1 = goal1;
		this.goal2 = goal2;
		this.cnt = cnt;
	}
	public Integer getGoal1() {
		return goal1;
	}
	public void setGoal1(Integer goal1) {
		this.goal1 = goal1;
	}
	public Integer getGoal2() {
		return goal2;
	}
	public void setGoal2(Integer goal2) {
		this.goal2 = goal2;
	}
	public double getCnt() {
		return cnt;
	}
	public void setCnt(double cnt) {
		this.cnt = cnt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goal1 == null) ? 0 : goal1.hashCode());
		result = prime * result + ((goal2 == null) ? 0 : goal2.hashCode());
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
		Risultato other = (Risultato) obj;
		if (goal1 == null) {
			if (other.goal1 != null)
				return false;
		} else if (!goal1.equals(other.goal1))
			return false;
		if (goal2 == null) {
			if (other.goal2 != null)
				return false;
		} else if (!goal2.equals(other.goal2))
			return false;
		return true;
	}

}
