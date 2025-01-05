
public class Response {

	int Id;
	String Gender;
	int Age;
	int Residence;
	int Education;
	int IncomeSource;
	int MaritalStatus;
	String Smoker;
	int Year;
	String Q9;
	int Q10;
	int Q11;
	int Q12;
	int Q13;
	int Q14;
	int Q15;
	String Q16;
	int Q17;
	int Q18;
	int Q19;
	int Q20;
	int Q21;
	int Q22;
	String Q23;
	int Q24;
	int Q25;
	int Q26;
	int Q27;
	int Q28;
	int Q29;
	int Q30;
	int quality;

	public Response(int id, int gender, int age, int residence, int education, int income, int marital, int smoker, int year, String q9, int q10, int q11, int q12, int q13, int q14, int q15, String q16, int q17, int q18, int q19, int q20, int q21, int q22, String q23, int q24, int q25, int q26, int q27, int q28, int q29, int q30) {
		Id = id;
		if (gender == 1) {
			Gender = "F";
		} else if (gender == 2) {
			Gender = "M";
		} else if (gender == 3) {
			Gender = "O";
		} else {
			Gender = "-";
		}
		Age = age;
		Residence = residence;
		Education = education;
		IncomeSource = income;
		MaritalStatus = marital;
		if (smoker == 1) {
			Smoker = "Yes";
		} else if (smoker == 0) {
			Smoker = "No";
		} else {
			Smoker = "/";
		}
		Year = year;
		Q9 = q9;
		Q10 = q10;
		Q11 = q11;
		Q12 = q12;
		Q13 = q13;
		Q14 = q14;
		Q15 = q15;
		Q16 = q16;
		Q17 = q17;
		Q18 = q18;
		Q19 = q19;
		Q20 = q20;
		Q21 = q21;
		Q22 = q22;
		Q23 = q23;
		Q24 = q24;
		Q25 = q25;
		Q26 = q26;
		Q27 = q27;
		Q28 = q28;
		Q29 = q29;
		Q30 = q30;

		quality = q13 + q14 + q15 + q17 + q18 + q19 + q21 + q22 + q24 + q25 + q26 + q27 + q28 + q29 + q30;
	}

	public int getId() {
		return Id;
	}

	public String getGender() {
		return Gender;
	}

	public int getAge() {
		return Age;
	}

	public int getResidence() {
		return Residence;
	}

	public int getEducation() {
		return Education;
	}

	public int getIncomeSource() {
		return IncomeSource;
	}

	public int getMaritalStatus() {
		return MaritalStatus;
	}

	public String getSmoker() {
		return Smoker;
	}

	public int getYear() {
		return Year;
	}

	public String getQ9() {
		return Q9;
	}

	public int getQ10() {
		return Q10;
	}

	public int getQ11() {
		return Q11;
	}

	public int getQ12() {
		return Q12;
	}

	public int getQ13() {
		return Q13;
	}

	public int getQ14() {
		return Q14;
	}

	public int getQ15() {
		return Q15;
	}

	public String getQ16() {
		return Q16;
	}

	public int getQ17() {
		return Q17;
	}

	public int getQ18() {
		return Q18;
	}

	public int getQ19() {
		return Q19;
	}

	public int getQ20() {
		return Q20;
	}

	public int getQ21() {
		return Q21;
	}

	public int getQ22() {
		return Q22;
	}

	public String getQ23() {
		return Q23;
	}

	public int getQ24() {
		return Q24;
	}

	public int getQ25() {
		return Q25;
	}

	public int getQ26() {
		return Q26;
	}

	public int getQ27() {
		return Q27;
	}

	public int getQ28() {
		return Q28;
	}

	public int getQ29() {
		return Q29;
	}

	public int get30() {
		return Q30;
	}
	
	public int getQuality() {
		return quality;
	}
	
	public void printResponse() {
		System.out.println("\nResponse ID: " + Id + "\nGender: " + Gender + "\nAge group: " + Age + "\nPlace of Residence: " + Residence + "\nEducation Level: " + Education + "\nSource of Income: " + IncomeSource + "\nMarital Status: " + MaritalStatus + "\nSmoker: " + Smoker);	
	}
}
