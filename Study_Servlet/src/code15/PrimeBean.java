package code15;

import java.math.BigInteger;

public class PrimeBean {
	private BigInteger prime;
	public PrimeBean(String lengthString) {
		int length;
		try {
			length = Integer.parseInt(lengthString);
		} catch (NumberFormatException e) {
			length = 150;
		}
	}
	public BigInteger getPrime() {
		return prime;
	}
	public void setPrime(BigInteger prime) {
		this.prime = prime;
	}
}
