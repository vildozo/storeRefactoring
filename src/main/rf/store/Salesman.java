package rf.store;

public class Salesman extends Employee {

	private int commissionPorcentage;
	private float monthQuota;

	public Salesman(String firstName, String lastName, float fixedSalary, int commissionPorcentage){
    	super(firstName, lastName, fixedSalary);
        this.commissionPorcentage = commissionPorcentage;
    }

	public void setCommissionPorcentage(int commissionPorcentage) {
		this.commissionPorcentage = commissionPorcentage;
	}

	public int getCommissionPorcentage() {
		return commissionPorcentage;
	}

	public float getMonthQuota() {
		return monthQuota;
	}

	public float netSalary() {
		float benefits = calculatePercentageAmount(monthQuota,commissionPorcentage);
		float pensionFounds = calculatePercentageAmount(fixedSalary,10) ;
		float tax = 0;
		if (fixedSalary > 3500)
			tax = calculatePercentageAmount(fixedSalary,5) ;
		return fixedSalary+benefits - pensionFounds - tax;
	}

	public float calculatePercentageAmount(float amount, float percent){
		float cent=100f;
		return amount*percent/cent;
	}
	
	
	public void updateMonthQuota(float addQuota) {
		monthQuota = monthQuota + addQuota;
	}
}
