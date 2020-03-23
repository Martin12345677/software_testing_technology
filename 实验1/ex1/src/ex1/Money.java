package ex1;

public class Money {
	private final static int FIFTY = 50;
	private final static int TWENTY = 20;
	private final static int TEN = 10;
	private final static int FIVE = 5;
	private final static int ONE = 1;
	private final static int[] NUM = {1, 1, 1, 2, 3};
	private final static int[] MONEY = {FIFTY, TWENTY, TEN, FIVE, ONE};
	private final static int MONEY_TYPE = 5;
	
	protected boolean hasMoney(int money) {
		return this.hasMoney(money, NUM);
	}
	
	private boolean hasMoney(int left, int[] used) {
		if(left == 0) {
			return true;
		}
		for(int i = 0; i < MONEY_TYPE; i++) {
			if(left >= MONEY[i] && used[i] > 0) {
//				System.out.println(used[i]);
				int[] use = this.copyArray(used);
				use[i]--;
				if(this.hasMoney(left - MONEY[i], use) || this.hasMoney(left, use)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private int[] copyArray(int[] array) {
		final int LENGTH = array.length;
		int[] newArray = new int[LENGTH];
		for(int i = 0; i < LENGTH; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		m.hasMoney(50);
		Money m = new Money();
		int[] test = {1, 20, 70, 60, 55, 39};
//		int[] test = {60};
		for(int i = 0; i < test.length; i++) {
//			Money m = new Money();
			System.out.println(m.hasMoney(test[i]));
		}
	}

}
