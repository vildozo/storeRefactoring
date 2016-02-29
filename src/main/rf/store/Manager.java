package rf.store;

public class Manager extends Employee {

	public Manager(String firstName, String lastName, float fixedSalary) {
		super(firstName, lastName, fixedSalary);
	}

	public float salaryAfterAdditionsAndDeductions() {
		float benefits = salaryBenefits();
		float pensionFounds = calculatePercentageAmount(this.fixedSalary, 10) ;
		float tax = 0;
		if (fixedSalary > 3500)
			tax = calculatePercentageAmount(this.fixedSalary, 5);
		return fixedSalary + benefits - pensionFounds - tax;
	}

	private float salaryBenefits() {
		return this.subordinates.size() * 20;
	}
	
	public float calculatePercentageAmount(float amount, float percent){
		float cent=100f;
		return amount*percent/cent;
	}
	
	
}
