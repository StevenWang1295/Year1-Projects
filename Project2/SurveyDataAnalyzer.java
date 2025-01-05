//Steven Wang

import java.io.IOException;
import java.util.Arrays;

public class SurveyDataAnalyzer {
	
	public static int[] genderDistribution(CustomHashTable hashTable) {
		int[] genderDistr = new int[4];
		int F = 0;
		int M = 0;
		int O = 0;
		int NA = 0;
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getGender().equals("F")) {
				F ++;
			} else if (hashTable.search(i).getGender().equals("M")) {
				M ++;
			} else if (hashTable.search(i).getGender().equals("O")) {
				O ++;
			} else if (hashTable.search(i).getGender().equals("-")) {
				NA ++;
			}
		}
		
		genderDistr[0] = F;
		genderDistr[1] = M;
		genderDistr[2] = O;
		genderDistr[3] = NA;
		
		return genderDistr;
	}
	
	public static int[] ageGroupDistribution(CustomHashTable hashTable) {
		int[] ageDistr = new int[4];
		int group1 = 0;
		int group2 = 0;
		int group3 = 0;
		int group4 = 0;
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getAge() == 1) {
				group1 ++;
			} else if (hashTable.search(i).getAge() == 2) {
				group2 ++;
			} else if (hashTable.search(i).getAge() == 3) {
				group3 ++;
			} else if (hashTable.search(i).getAge() == 4) {
				group4 ++;
			}
		}
		
		ageDistr[0] = group1;
		ageDistr[1] = group2;
		ageDistr[2] = group3;
		ageDistr[3] = group4;
		
		return ageDistr;
	}
	
	public static int[] residenceDistribution(CustomHashTable hashTable) {
		int[] ageDistr = new int[4];
		int group1 = 0;
		int group2 = 0;
		int group3 = 0;
		int group4 = 0;
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getResidence() == 1) {
				group1 ++;
			} else if (hashTable.search(i).getResidence() == 2) {
				group2 ++;
			} else if (hashTable.search(i).getResidence() == 3) {
				group3 ++;
			} else if (hashTable.search(i).getResidence() == 4) {
				group4 ++;
			}
		}
		
		ageDistr[0] = group1;
		ageDistr[1] = group2;
		ageDistr[2] = group3;
		ageDistr[3] = group4;
		
		return ageDistr;
	}
	
	public static int[] educationDistribution(CustomHashTable hashTable) {
		int[] eduDistr = new int[4];
		int group1 = 0;
		int group2 = 0;
		int group3 = 0;
		int group4 = 0;
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getEducation() == 1) {
				group1 ++;
			} else if (hashTable.search(i).getEducation() == 2) {
				group2 ++;
			} else if (hashTable.search(i).getEducation() == 3) {
				group3 ++;
			} else if (hashTable.search(i).getEducation() == 4) {
				group4 ++;
			}
		}
		
		eduDistr[0] = group1;
		eduDistr[1] = group2;
		eduDistr[2] = group3;
		eduDistr[3] = group4;
		
		return eduDistr;
	}
	
	public static int[] incomeDistribution(CustomHashTable hashTable) {
		int[] incomeDistr = new int[4];
		int group1 = 0;
		int group2 = 0;
		int group3 = 0;
		int group4 = 0;
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getIncomeSource() == 1) {
				group1 ++;
			} else if (hashTable.search(i).getIncomeSource() == 2) {
				group2 ++;
			} else if (hashTable.search(i).getIncomeSource() == 3) {
				group3 ++;
			} else if (hashTable.search(i).getIncomeSource() == 4) {
				group4 ++;
			}
		}
		
		incomeDistr[0] = group1;
		incomeDistr[1] = group2;
		incomeDistr[2] = group3;
		incomeDistr[3] = group4;
		
		return incomeDistr;
	}
	
	public static int[] maritalDistribution(CustomHashTable hashTable) {
		int[] maritalDistr = new int[4];
		int group1 = 0;
		int group2 = 0;
		int group3 = 0;
		int group4 = 0;
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getMaritalStatus() == 1) {
				group1 ++;
			} else if (hashTable.search(i).getMaritalStatus() == 2) {
				group2 ++;
			} else if (hashTable.search(i).getMaritalStatus() == 3) {
				group3 ++;
			} else if (hashTable.search(i).getMaritalStatus() == 4) {
				group4 ++;
			}
		}
		
		maritalDistr[0] = group1;
		maritalDistr[1] = group2;
		maritalDistr[2] = group3;
		maritalDistr[3] = group4;
		
		return maritalDistr;
	}
	
	public static int[] smokerDistribution(CustomHashTable hashTable) {
		int[] smokerDistr = new int[2];
		int yes = 0;
		int no = 0;

		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getSmoker().equals("Yes")) {
				yes ++;
			} else if (hashTable.search(i).getSmoker().equals("No")) {
				no ++;
			} 
		}
		
		smokerDistr[0] = no;
		smokerDistr[1] = yes;
		
		return smokerDistr;
	}
	
	public static double lifeQualityGeneral(CustomHashTable hashTable) {
		double totalQuality = 0;
		
		for (int i = 1; i <= 300; i++) {
			totalQuality += hashTable.search(i).getQuality();
		}	
		
		return totalQuality/300;
	}
	
	public static double[] lifeQualityGenderBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double qualityF = 0;
		double qualityM = 0;
		double qualityO = 0;
		double qualityNA = 0;
		int[] distribution = genderDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getGender().equals("F")) {
				qualityF += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getGender().equals("M")) {
				qualityM += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getGender().equals("O")) {
				qualityO += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getGender().equals("-")) {
				qualityNA += hashTable.search(i).getQuality();
			}
		}
		
		quality[0] = qualityF / distribution[0];
		quality[1] = qualityM / distribution[1];
		quality[2] = qualityO / distribution[2];
		quality[3] = qualityNA / distribution[3];
		
		return quality;
	}
	
	public static double[] lifeQualityAgeBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double quality1 = 0;
		double quality2 = 0;
		double quality3 = 0;
		double quality4 = 0;
		int[] distribution = ageGroupDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getAge() == 1) {
				quality1 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getAge() == 2) {
				quality2 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getAge() == 3) {
				quality3 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getAge() == 4) {
				quality4 += hashTable.search(i).getQuality();
			}
		}
		
		quality[0] = quality1 / distribution[0];
		quality[1] = quality2 / distribution[1];
		quality[2] = quality3 / distribution[2];
		quality[3] = quality4 / distribution[3];
		
		return quality;
	}
	
	public static double[] lifeQualityResidenceBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double quality1 = 0;
		double quality2 = 0;
		double quality3 = 0;
		double quality4 = 0;
		int[] distribution = residenceDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getResidence() == 1) {
				quality1 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getResidence() == 2) {
				quality2 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getResidence() == 3) {
				quality3 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getResidence() == 4) {
				quality4 += hashTable.search(i).getQuality();
			}
		}
		
		quality[0] = quality1 / distribution[0];
		quality[1] = quality2 / distribution[1];
		quality[2] = quality3 / distribution[2];
		quality[3] = quality4 / distribution[3];
		
		return quality;
	}
	
	public static double[] lifeQualityEducationBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double quality1 = 0;
		double quality2 = 0;
		double quality3 = 0;
		double quality4 = 0;
		int[] distribution = educationDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getEducation() == 1) {
				quality1 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getEducation() == 2) {
				quality2 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getEducation() == 3) {
				quality3 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getEducation() == 4) {
				quality4 += hashTable.search(i).getQuality();
			}
		}
		
		quality[0] = quality1 / distribution[0];
		quality[1] = quality2 / distribution[1];
		quality[2] = quality3 / distribution[2];
		quality[3] = quality4 / distribution[3];
		
		return quality;
	}
	
	public static double[] lifeQualityIncomeBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double quality1 = 0;
		double quality2 = 0;
		double quality3 = 0;
		double quality4 = 0;
		int[] distribution = incomeDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getIncomeSource() == 1) {
				quality1 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getIncomeSource() == 2) {
				quality2 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getIncomeSource() == 3) {
				quality3 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getIncomeSource() == 4) {
				quality4 += hashTable.search(i).getQuality();
			}
		}
		
		quality[0] = quality1 / distribution[0];
		quality[1] = quality2 / distribution[1];
		quality[2] = quality3 / distribution[2];
		quality[3] = quality4 / distribution[3];
		
		return quality;
	}
	
	public static double[] lifeQualityMaritalBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double quality1 = 0;
		double quality2 = 0;
		double quality3 = 0;
		double quality4 = 0;
		int[] distribution = maritalDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getMaritalStatus() == 1) {
				quality1 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getMaritalStatus() == 2) {
				quality2 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getMaritalStatus() == 3) {
				quality3 += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getMaritalStatus() == 4) {
				quality4 += hashTable.search(i).getQuality();
			}
		}
		
		quality[0] = quality1 / distribution[0];
		quality[1] = quality2 / distribution[1];
		quality[2] = quality3 / distribution[2];
		quality[3] = quality4 / distribution[3];
		
		return quality;
	}
	
	public static double[] lifeQualitySmokerBased(CustomHashTable hashTable) {
		double[] quality = new double[2];
		double qualityYes = 0;
		double qualityNo = 0;

		int[] distribution = smokerDistribution(hashTable);
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getSmoker().equals("Yes")) {
				qualityYes += hashTable.search(i).getQuality();
			} else if (hashTable.search(i).getSmoker().equals("No")) {
				qualityNo += hashTable.search(i).getQuality();
			} 
		}
		
		quality[0] = qualityYes / distribution[1];
		quality[1] = qualityNo / distribution[0];
		
		return quality;
	}
	
	public static String[] mostCommonTreatment(CustomHashTable hashTable) {
		String[] treatment = new String[5];
		int immuno = 0;
		int chemo = 0;
		int surgical = 0;
		int molecular = 0;
		int radio = 0;
		
		for (int i = 1; i <= 300; i++) {
			String[] treatmentsArray = hashTable.search(i).getQ9().split(";");
			
			for (int j = 0; j < treatmentsArray.length; j++) {
				if (treatmentsArray[j].equals("Immunotherapy")) {
					immuno ++;
				} else if (treatmentsArray[j].equals("Chemotherapy")) {
					chemo ++;
				} else if (treatmentsArray[j].equals("Surgical")) {
					surgical ++;
				} else if (treatmentsArray[j].equals("MolecularlyTargetedTherapy")) {
					molecular ++;
				} else if (treatmentsArray[j].equals("Radiotherapy")) {
					radio ++;
				}
			}
		}
		
		int[] treatmentNumbers = {immuno, chemo, surgical, molecular, radio};
		Arrays.sort(treatmentNumbers);
		
		for (int i = 0; i < treatment.length; i++) {
			if (treatmentNumbers[i] == immuno) {
				treatment[treatment.length-1-i] = "Immunotherapy";
			} else if (treatmentNumbers[i] == chemo) {
				treatment[treatment.length-1-i] = "Chemotherapy";
			} else if (treatmentNumbers[i] == surgical) {
				treatment[treatment.length-1-i] = "Surgical";
			} else if (treatmentNumbers[i] == molecular) {
				treatment[treatment.length-1-i] = "MolecularlyTargetedTherapy";
			} else if (treatmentNumbers[i] == radio) {
				treatment[treatment.length-1-i] = "Radiotherapy";
			}
		}
		
		return treatment;
	}
	
	public static String[] mostCommonSymptoms(CustomHashTable hashTable) {
		String[] treatment = new String[7];
		int breath = 0;
		int cough = 0;
		int blood = 0;
		int hoarse = 0;
		int chest = 0;
		int weak = 0;
		int none = 0;
		
		for (int i = 1; i <= 300; i++) {
			String[] treatmentsArray = hashTable.search(i).getQ16().split(";");
			
			for (int j = 0; j < treatmentsArray.length; j++) {
				if (treatmentsArray[j].equals("ShortnessOfBreath")) {
					breath ++;
				} else if (treatmentsArray[j].equals("Cough")) {
					cough ++;
				} else if (treatmentsArray[j].equals("CoughingUpBlood")) {
					blood ++;
				} else if (treatmentsArray[j].equals("Hoarseness")) {
					hoarse ++;
				} else if (treatmentsArray[j].equals("ChestPain")) {
					chest ++;
				} else if (treatmentsArray[j].equals("Weakness")) {
					weak ++;
				} else if (treatmentsArray[j].equals("None")) {
					none ++;
				}
			}
		}
		
		int[] treatmentNumbers = {breath, cough, blood, hoarse, chest, weak, none};
		Arrays.sort(treatmentNumbers);
		
		for (int i = 0; i < treatment.length; i++) {
			if (treatmentNumbers[i] == breath) {
				treatment[treatment.length-i-1] = "ShortnessOfBreath";
			} else if (treatmentNumbers[i] == cough) {
				treatment[treatment.length-i-1] = "Cough";
			} else if (treatmentNumbers[i] == blood) {
				treatment[treatment.length-i-1] = "CoughingUpBlood";
			} else if (treatmentNumbers[i] == hoarse) {
				treatment[treatment.length-i-1] = "Hoarseness";
			} else if (treatmentNumbers[i] == chest) {
				treatment[treatment.length-i-1] = "ChestPain";
			} else if (treatmentNumbers[i] == weak) {
				treatment[treatment.length-i-1] = "Weakness";
			} else if (treatmentNumbers[i] == none) {
				treatment[treatment.length-i-1] = "None";
			} 
		}
		
		return treatment;
	}
	
	public static String[] mostCommonLifeAspects(CustomHashTable hashTable) {
		String[] treatment = new String[6];
		int psych = 0;
		int phys = 0;
		int social = 0;
		int DNA = 0;
		int family = 0;
		int prof = 0;
		
		for (int i = 1; i <= 300; i++) {
			String[] treatmentsArray = hashTable.search(i).getQ23().split(";");
			
			for (int j = 0; j < treatmentsArray.length; j++) {
				if (treatmentsArray[j].equals("PsychologicalAspect")) {
					psych ++;
				} else if (treatmentsArray[j].equals("PhysicalAspect")) {
					phys ++;
				} else if (treatmentsArray[j].equals("SocialLife")) {
					social ++;
				} else if (treatmentsArray[j].equals("DoesNotAffect")) {
					DNA ++;
				} else if (treatmentsArray[j].equals("FamilyLife")) {
					family ++;
				} else if (treatmentsArray[j].equals("ProfessionalLife")) {
					prof ++;
				}
			}
		}
		
		int[] treatmentNumbers = {psych, phys, social, DNA, family, prof};
		Arrays.sort(treatmentNumbers);
		
		for (int i = 0; i < treatment.length; i++) {
			if (treatmentNumbers[i] == psych) {
				treatment[treatment.length-i-1] = "PsychologicalAspect";
			} else if (treatmentNumbers[i] == phys) {
				treatment[treatment.length-i-1] = "PhysicalAspect";
			} else if (treatmentNumbers[i] == social) {
				treatment[treatment.length-i-1] = "SocialLife";
			} else if (treatmentNumbers[i] == DNA) {
				treatment[treatment.length-i-1] = "DoesNotAffect";
			} else if (treatmentNumbers[i] == family) {
				treatment[treatment.length-i-1] = "FamilyLife";
			} else if (treatmentNumbers[i] == prof) {
				treatment[treatment.length-i-1] = "ProfessionalLife";
			}
		}
		
		return treatment;
	}
	
	public static double[] lifeQualityMixConditionsBased(CustomHashTable hashTable) {
		double[] quality = new double[2];
		double single = 0;
		double singleQ = 0;
		double married = 0;
		double marriedQ = 0;
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getMaritalStatus() == 1 && hashTable.search(i).getResidence() == 4) {
				singleQ += hashTable.search(i).getQuality();
				single ++;
			} else if (hashTable.search(i).getMaritalStatus() == 2 && (hashTable.search(i).getResidence() == 1 || hashTable.search(i).getResidence() == 2)) {
				marriedQ += hashTable.search(i).getQuality();
				married ++;
			}
		}
		
		quality[0] = singleQ / single;
		quality[1] = marriedQ / married;
		
		return quality;
	}
	
	public static double[] lifeQualityResponseBased(CustomHashTable hashTable) {
		double[] quality = new double[4];
		double veryGood = 0;
		double good = 0;
		double bad = 0;
		double veryBad = 0;
		double veryGoodQ = 0;
		double goodQ = 0;
		double badQ = 0;
		double veryBadQ = 0;
		
		for (int i = 1; i <= 300; i++) {
			if (hashTable.search(i).getQ15() == 1) {
				veryGoodQ += hashTable.search(i).getQuality();
				veryGood ++;
			} else if (hashTable.search(i).getQ15() == 2) {
				goodQ += hashTable.search(i).getQuality();
				good ++;
			} else if (hashTable.search(i).getQ15() == 3) {
				badQ += hashTable.search(i).getQuality();
				bad ++;
			} else if (hashTable.search(i).getQ15() == 4) {
				veryBadQ += hashTable.search(i).getQuality();
				veryBad ++;
			}
		}
		
		quality[0] = veryGoodQ / veryGood;
		quality[1] = goodQ / good;
		quality[2] = badQ / bad;
		quality[3] = veryBadQ / veryBad;
		
		return quality;
	}
	
	public static void main(String[] args) throws IOException {
        CustomHashTable table = ReadFile.readResponsesFromFile("responses.txt");
        
        System.out.println("Gender Distribution: [Female, Male, Other, N/A] <-> " + Arrays.toString(genderDistribution(table)));
        System.out.println("Age Group Distribution: [<30, 30-45, 46-60, 60+] <-> " + Arrays.toString(ageGroupDistribution(table)));
        System.out.println("Residence Distribution: [Village, Town(<100k), Town(100k-500k), City(500k+)] <-> " + Arrays.toString(residenceDistribution(table)));
        System.out.println("Education Distribution: [Primary, Vocational, Secondary, Higher] <-> " + Arrays.toString(educationDistribution(table)));
        System.out.println("Income Source Distribution: [Employment, Pension, Retirement, Other] <-> " + Arrays.toString(incomeDistribution(table)));
        System.out.println("Marital Status Distribution: [Single, Married, Divorced, Widowed] <-> " + Arrays.toString(maritalDistribution(table)));
        System.out.println("Smoker Status Distribution: [Yes, No] <-> " + Arrays.toString(smokerDistribution(table)));
        System.out.println("Average Life Quality(All Respondents): " + lifeQualityGeneral(table));
        System.out.println("Average Life Quality(Gender Based): [Female, Male, Other, N/A] <-> " + Arrays.toString(lifeQualityGenderBased(table)));
        System.out.println("Average Life Quality(Age Based): [<30, 30-45, 46-60, 60+] <-> " + Arrays.toString(lifeQualityAgeBased(table)));
        System.out.println("Average Life Quality(Residence Based): [Village, Town(<100k), Town(100k-500k), City(500k+)] <-> " + Arrays.toString(lifeQualityResidenceBased(table)));
        System.out.println("Average Life Quality(Education Based): [Primary, Vocational, Secondary, Higher] <-> " + Arrays.toString(lifeQualityEducationBased(table)));
        System.out.println("Average Life Quality(Income Based): [Employment, Pension, Retirement, Other] <-> " + Arrays.toString(lifeQualityIncomeBased(table)));
        System.out.println("Average Life Quality(Marital Based): [Single, Married, Divorced, Widowed] <-> " + Arrays.toString(lifeQualityMaritalBased(table)));
        System.out.println("Average Life Quality(Smoker Based): [Yes, No] <-> " + Arrays.toString(lifeQualitySmokerBased(table)));
        System.out.println("Most Common Treatments(Descending Order): " + Arrays.toString(mostCommonTreatment(table)));
        System.out.println("Most Common Symptoms(Descending Order): " + Arrays.toString(mostCommonSymptoms(table)));
        System.out.println("Most Common Life Aspects Affected(Descending Order): " + Arrays.toString(mostCommonLifeAspects(table)));
        System.out.println("Average Life Quality(Mixed Conditions): [Single people living in city(500k+), Married people living in village or town(<100k)] <-> " + Arrays.toString(lifeQualityMixConditionsBased(table)));
        System.out.println("Average Life Quality(Response Based): [Very Good, Good, Bad, Very Bad] <-> " + Arrays.toString(lifeQualityResponseBased(table)));
    }

}
