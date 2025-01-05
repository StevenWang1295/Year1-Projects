/* Name: Steven Wang
 * Email: swang177@u.rochester.edu
 * Date last modified: 11/29/2023
 * Homework6: Supply CHain
 * Lab Section: CSC-171-13
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SupplyChainHW {

	static Vehicle[] fleet;
	static List<Contract> contracts;
	static double total_pay;

	static class Contract {
		double m;
		double d;
		double p;

		public Contract(double mass, double dist, double pay) {
			m = mass;
			d = dist;
			p = pay;
		}

		public boolean isViable(Vehicle v) {
			if (this.m > v.mCargo) {
				return false;
			} else if (this.d > v.r) {
				return false;
			} else {
				return true;
			}
		}

		public double getCost(Vehicle v) {
			double cost = 0;
			double hours;

			hours = this.d / v.s;
			cost += (hours * v.hCost) + (this.d * v.fBurn);
			return cost;
		}

	}//Contract class to keep track of all contracts

	static class Vehicle {

		String n;
		double m;
		double mCargo;
		double r;
		double s;
		double hCost;
		double fBurn;

		public Vehicle(String name, double mass, double max_cargo, double range, double speed, double hourly_cost, double fuel_burn) {
			n = name;
			m = mass;
			mCargo = max_cargo;
			r = range;
			s = speed;
			hCost = hourly_cost;
			fBurn = fuel_burn;
		}

	}//Vehicle class to keep track of all vehicles

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		fleet = new Vehicle[num];
		contracts = new ArrayList<Contract>();
		boolean isQuit = false;

		for (int i = 0; i < num; i++) {
			String n = input.next();
			double m = input.nextDouble();
			double mCargo = input.nextDouble();
			double r = input.nextDouble();
			double s = input.nextDouble();
			double hCost = input.nextDouble();
			double fBurn = input.nextDouble();

			fleet[i] = new Vehicle(n, m, mCargo, r, s, hCost, fBurn);
		}

		while (!isQuit) {

			if (input.hasNext("quit")) {
				isQuit = true;
				break;
			}

			double mass = input.nextDouble();
			double dist = input.nextDouble();
			double pay = input.nextDouble();

			contracts.add(new Contract(mass, dist, pay));	
		}

		for (int i = 0; i < contracts.size(); i++) {
			double cost = contracts.get(i).p;
			String vehicle = "decline";
			for (int j = 0; j < fleet.length; j++) {
				if (contracts.get(i).isViable(fleet[j])) {
					if (contracts.get(i).getCost(fleet[j]) < cost) {
						cost = contracts.get(i).getCost(fleet[j]);
						vehicle = fleet[j].n;
					}
				}
			}
			System.out.print(vehicle + " ");
			if (cost < contracts.get(i).p) {
				System.out.printf("%.2f", contracts.get(i).p - cost);
				total_pay += (contracts.get(i).p - cost);
			}
			System.out.println();
		}//nested for loop to check each contract with every vehicle

		System.out.print("TotalPrateOfFireit: ");
		System.out.printf("%.2f" , total_pay);

	}

}

