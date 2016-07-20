package code07;

import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeList implements Runnable {
	private ArrayList<BigInteger> primesFound;
	private int numPrimes;
	private int numDigits;
	
	public PrimeList(int numPrimes, int numDigits,boolean runInBackground) {
		super();
		this.numPrimes = numPrimes;
		this.numDigits = numDigits;
		primesFound = new ArrayList<>(numPrimes);
		if(runInBackground){
			Thread thread = new Thread(this);
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
		} else {
			run();
		}
	}
	
	@Override
	public void run() {
		BigInteger start = Primes.random(numDigits);
		for(int i=0;i<numPrimes;i++){
			start = Primes.nextPrime(start);
			synchronized (this) {
				primesFound.add(start);
			}
		}
	}
	
	public synchronized boolean isDone() {
	    return(primesFound.size() == numPrimes);
	}
	public synchronized ArrayList<BigInteger> getPrimesFound(){
		if(isDone()){
			return primesFound;
		} else {
			return (ArrayList<BigInteger>)primesFound.clone();
		}
	}
	
	public synchronized int numCalculatedPrimes() {
	    return(primesFound.size());
	}
	
	public int getNumPrimes() {
		return numPrimes;
	}

	public int getNumDigits() {
		return numDigits;
	}
	
}
