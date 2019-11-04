package com.e2eTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by m on 2019-11-04.
 */
public class PrimesTest {


  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testPrimesLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

    @Test
    public void testNonPrimes () {
      Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
  }

