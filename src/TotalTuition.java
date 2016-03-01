import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;


public class TotalTuition {

	
	
	private double initialTuitionCost;
	private double percentageIncrease;
	private double repaymentAPR;
	private int term;
	private double total;
	private double monthlyPayment;

	
	public double getInitialTuitionCost() {
		return initialTuitionCost;
	}

	public void setInitialTuitionCost(double initialTuitionCost) {
		this.initialTuitionCost = initialTuitionCost;
	}

	public double getPercentageIncrease() {
		return percentageIncrease;
	}

	public void setPercentageIncrease(double percentageIncrease) {
		this.percentageIncrease = percentageIncrease;
	}

	public double getRepaymentAPR() {
		return repaymentAPR;
	}

	public void setRepaymentAPR(double repaymentAPR) {
		this.repaymentAPR = repaymentAPR;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}



	public static void main(String[] args) {
		TotalTuition t = new TotalTuition();
		t.setValues() ;
		
		
	}	
	
	public void setValues() {
	Scanner input = new Scanner(System.in);
		
		System.out.print("Intial Tuition Cost (0-25,000):");
		double initialTuitionCost = input.nextDouble();
		setInitialTuitionCost(initialTuitionCost);
		
		System.out.print("Percentage Increase (0-1):");
		double percentageIncrease = input.nextDouble();
		setPercentageIncrease(percentageIncrease);
		
		System.out.print("Repayment APR (0,1):");
		double repaymentAPR = input.nextDouble();
		setRepaymentAPR(repaymentAPR);
		
		System.out.print("Term (Number of Years):");
		int term = input.nextInt();
		setTerm(term);
		
		double yearOne = initialTuitionCost;
		double yearTwo = initialTuitionCost + initialTuitionCost*percentageIncrease;
		double yearThree = yearTwo + initialTuitionCost*percentageIncrease;
		double yearFour = yearThree + initialTuitionCost*percentageIncrease;
	
		total=yearOne+yearTwo+yearThree+yearFour;
		double monthlyPayment = FinanceLib.pmt(repaymentAPR/12, term*12, total, 0, false);
		
		System.out.printf("Total tuition: $%.2f",yearFour);
		System.out.printf("Total monthly payment: $%.2f", -1*monthlyPayment);
	}
}
