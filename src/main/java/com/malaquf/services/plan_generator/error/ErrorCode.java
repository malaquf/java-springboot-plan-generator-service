package com.malaquf.services.plan_generator.error;

public enum ErrorCode {
	MISSING_REQUEST(1),
	MISSING_LOAN_DURATION(2),
	MISSING_LOAN_AMOUNT(3),
	MISSING_NOMINAL_RATE(4),
	MISSING_START_DATE(5),
	INVALID_LOAN_DURATION(6),
	INVALID_LOAN_AMOUNT(7),
	INVALID_NOMINAL_RATE(8),
	INVALID_START_DATE(9);
	
	private final int value;
	ErrorCode(int value){
		this.value = value;
    }
    public int getValue(){
        return value;
    }
}
