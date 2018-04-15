package com.cpal.tax.calculator.api;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum StateTax {

	AL("4"),
	AK("0"),
	AZ("5.6"),
	AR("6.5"),
	CA("7.25"),
	CO("2.9"),
	CT("6.35"),
	DE("0"),
	FL("6"),
	GA("4"),
	HI("4"),
	ID("6"),
	IL("6.25"),
	IN("7"),
	IA("6"),
	KS("6.5"),
	KY("6"),
	LA("5"),
	ME("5.5"),
	MD("6"),
	MA("6.25"),
	MI("6"),
	MN("6.875"),
	MS("7"),
	MO("4.225"),
	MT("0"),
	NE("5.5"),
	NV("6.85"),
	NH("0"),
	NJ("6.875"),
	NM("5.125"),
	NY("4"),
	NC("4.75"),
	ND("5"),
	OH("5.75"),
	OK("4.5"),
	OR("0"),
	PA("6"),
	RI("7"),
	SC("6"),
	SD("4.5"),
	TN("7"),
	TX("6.25"),
	UT("5.95"),
	VT("6"),
	VA("5.3"),
	WA("6.5"),
	WV("6"),
	WI("5"),
	WY("4"),
	DC("5.75");
	
	private BigDecimal taxRate;
	
	private StateTax(String taxRate) {
		this.taxRate = new BigDecimal(taxRate).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	
}
