package com.cmb.cashregister;

public class CashRegister {

	private Printer printer;

	public CashRegister(Printer printer) {
		this.printer = printer;
	}

	public void process(Purchase purchase) {
		double discount = calculateDiscount(purchase.getItems());
		printer.print(purchase.description() + "discount:" + discount);
	}

	public double calculateDiscount(Item[] items) {
		for (Item item : items) {
			if (item.getPrice() > 10) {
				return 0.7;
			}
		}
		return 0.8;
	}
}
