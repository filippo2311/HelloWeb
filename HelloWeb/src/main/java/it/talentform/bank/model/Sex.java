package it.talentform.bank.model;

public enum Sex {

    MALE('M', "maschio"), FEMALE('F', "femmina"), NON_BINARY('N', "non binario");
	
	public final String label;
	public final String initial;
	

	Sex (char initial, String label){
		this.label = label;
		this.initial = Character.toString(initial);
	}
}

	