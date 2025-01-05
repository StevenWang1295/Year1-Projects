/* Name: Steven Wang
 * Email: swang177@u.rochester.edu
 * Date last modified: 10/6/2023
 * Homework3: DesignHW
 */

public class DesignHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person Person1 = new Person("Albert Einstein", 1879);
		Person Person2 = new Person("Barack Obama", 1961);

		Person1.setOcc("a physicist");
		Person2.setOcc("a politician");
		Person2.setStatus(true);

		System.out.println(Person1.toString());
		System.out.println(Person2.toString()+"\n");

		Person1.setName("Frida Kahlo");
		Person1.setYear(1954);
		Person1.setOcc("an artist");

		System.out.println(Person1.toString());
		System.out.println(Person2.toString());
		// Person class test

		System.out.println("---------------------------------------------");	

		Dog Dog1 = new Dog(34, 3);
		Dog Dog2 = new Dog(18, 10);

		System.out.println(Dog1.toString());
		System.out.println(Dog2.toString()+"\n");

		Dog1.setDogAge(8);
		Dog1.setSize(120);

		System.out.println(Dog1.toString());
		System.out.println(Dog2.toString());
		// Animal class test

		System.out.println("---------------------------------------------");
		
		Smartphone Smartphone1 = new Smartphone(1500);
		Smartphone Smartphone2 = new Smartphone(2200);
		
		System.out.println(Smartphone1.toString());
		System.out.println(Smartphone2.toString()+"\n");
		
		Smartphone1.setBluetooth(true);
		Smartphone1.setScreen(true);
		Smartphone1.setVoice(true);
		Smartphone1.setWifi(true);
		Smartphone2.setBluetooth(true);
		Smartphone2.setScreen(true);
		Smartphone2.setVoice(true);
		Smartphone2.setWifi(true);
		
		System.out.println(Smartphone1.toString());
		System.out.println(Smartphone2.toString()+"\n");
		// Smartphone class test
	}

	private static class Person {

		private String occupation = "";
		private boolean status = false;
		private String n;
		private int y;

		private Person(String name, int birth) {		
			n = name;
			y = birth;
		}

		public String getOcc() {		
			return occupation;
		}

		public boolean getStatus() {
			return status;
		}

		public String getName() {
			return n;
		}

		public int getYear() {
			return y;
		}

		public void setName(String newName) {
			this.n = newName;
		}

		public void setOcc(String newOcc) {
			this.occupation = newOcc;
		}

		public void setStatus(boolean newStatus) {
			this.status = newStatus;
		}

		public void setYear(int newYear) {
			this.y = newYear;
		}

		public String toString() {			
			if (getStatus()) {
				return getName() + " is " + getOcc() + " born in " + getYear();
			} else {
				return getName() + " was " + getOcc() + " born in " + getYear();
			}
		}

	}// Person class

	private static class Dog{

		private int w;
		private int dAge;
		private int[] hAgeSmall = {0, 15, 24, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80};
		private int[] hAgeMedium = {0, 15, 24, 28, 32, 36, 42, 47, 51, 56, 60, 65, 69, 74, 78, 83, 87};
		private int[] hAgeLarge = {0, 15, 24, 28, 32, 36, 45, 50, 55, 61, 66, 72, 77, 82, 88, 93, 99};
		private int[] hAgeGiant = {12, 22, 31, 38, 45, 49, 56, 64, 71, 79, 86, 93, 100, 107, 114, 121};

		private Dog(int weight, int dogAge) {
			w = weight;
			dAge = dogAge;	
		}

		public int getW() {	
			return w;
		}

		public int getDogAge() {
			return dAge;
		}

		public void setSize(int newWeight) {
			this.w = newWeight;
		}

		public void setDogAge(int newAge) {
			this.dAge = newAge;
		}

		public int DogtoHuman() {
			if (getW() <= 20) {
				return hAgeSmall[getDogAge()];
			} else if (getW() > 20 && getW() <= 50) {
				return hAgeMedium[getDogAge()];
			} else if (getW() > 50 && getW() <= 100) {
				return hAgeLarge[getDogAge()];
			} else {
				return hAgeGiant[getDogAge()];
			}	
		}

		public String toString() {
			return "Your " + dAge + " year old dog is " + DogtoHuman() + " in human years.";
		}
	}

	private static class Smartphone {

		private boolean screen = false;
		private boolean voice = false;
		private boolean wifi = false;
		private boolean bluetooth = false;
		private float standby = 5;
		private float mA;

		private Smartphone(float mAmps) {
			mA = mAmps;
		}

		public boolean getScreen() {		
			return screen;
		}

		public boolean getVoice() {
			return voice;
		}

		public boolean getWifi() {
			return wifi;
		}

		public boolean getBluetooth() {
			return bluetooth;
		}

		public void setScreen(boolean newState) {
			this.screen = newState;
		}

		public void setVoice(boolean newState) {
			this.voice = newState;
		}

		public void setWifi(boolean newState) {
			this.wifi = newState;
		}

		public void setBluetooth(boolean newState) {
			this.bluetooth = newState;
		}

		public float battLife() {	
			float pow = standby;

			if (screen) {
				pow += 500;
			}
			if (voice) {
				pow += 300;
			}
			if (wifi) {
				pow += 200;
			}
			if(bluetooth) {
				pow += 100;
			}
			
			return mA/pow;
		}
		
		public String toString() {
			return battLife() + " hours";
		}
		
	}

}
