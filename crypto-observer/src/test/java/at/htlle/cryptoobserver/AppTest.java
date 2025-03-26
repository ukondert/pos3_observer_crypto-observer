package at.htlle.cryptoobserver;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for CrytoObserver.
 */
public class AppTest 
{
    class MockUpObserver implements CryptoObserver
    {
        protected boolean updateCalled = false;
        
        @Override
        public void update(CryptoCurrencySubject ob) 
        {
            updateCalled = true;
        }    
    }
    
    @Test
    public void testSubject() 
    {
        CryptoCurrencySubject testCoin = new CryptoCurrencySubject("testCoin", 300);
        MockUpObserver mo = new MockUpObserver();
        MockUpObserver mo2 = new MockUpObserver();
        MockUpObserver mo3 = new MockUpObserver();
        
        testCoin.addObserver(mo);
        testCoin.addObserver(mo2);
        testCoin.addObserver(mo3);
        
        testCoin.removeObserver(mo2);
        
        testCoin.updateObservers();
        
        assertTrue(mo.updateCalled);
        assertTrue(!mo2.updateCalled);
        assertTrue(mo3.updateCalled);
    }
    
    @Test
    public void testMsgObserver()
    {
        CryptoCurrencySubject testCoin = new CryptoCurrencySubject("testCoin", 300);
        CryptoMessageObserver msgObserver = new CryptoMessageObserver();
        
        testCoin.addObserver(msgObserver);
        testCoin.setRate(500);
        testCoin.updateObservers();
        testCoin.setRate(800);
        testCoin.updateObservers();
        
        List<String> msg = msgObserver.getMsg();
        
        assertTrue(msg.get(0).contains("testCoin"));
        assertTrue(msg.get(0).contains("500"));
        assertTrue(msg.get(1).contains("testCoin"));
        assertTrue(msg.get(1).contains("800"));
    }
    
    @Test
    public void testMaxRateObserver()
    {
        CryptoCurrencySubject testCoin = new CryptoCurrencySubject("testCoin", 300);
        CryptoMaxRateObserver maxObserver = new CryptoMaxRateObserver();
        
        testCoin.addObserver(maxObserver);
        testCoin.setRate(500);
        testCoin.updateObservers();
        testCoin.setRate(800);
        testCoin.updateObservers();
        testCoin.setRate(600);
        testCoin.updateObservers();
        
        String msg = maxObserver.toString();
        assertTrue(msg.contains("800"));
    }
    
    @Test
    public void testMulitpleObserver()
    {
        CryptoCurrencySubject testCoin = new CryptoCurrencySubject("testCoin", 300);
        CryptoCurrencySubject pestCoin = new CryptoCurrencySubject("pestCoin", 300);
        
        CryptoMessageObserver msgObserver = new CryptoMessageObserver();
        CryptoMaxRateObserver maxObserver = new CryptoMaxRateObserver();
        
        testCoin.addObserver(msgObserver);
        testCoin.addObserver(maxObserver);
        testCoin.setRate(500);
        testCoin.updateObservers();
        testCoin.setRate(800);
        testCoin.updateObservers();
        testCoin.setRate(600);
        testCoin.updateObservers();
        
        pestCoin.addObserver(msgObserver);
        pestCoin.addObserver(maxObserver);
        pestCoin.setRate(400);
        pestCoin.updateObservers();
        pestCoin.setRate(700);
        pestCoin.updateObservers();
        pestCoin.setRate(900);
        pestCoin.updateObservers();
        
        assertTrue(msgObserver.getMsg().get(0).contains("testCoin"));
        assertTrue(msgObserver.getMsg().get(0).contains("500"));
        assertTrue(msgObserver.getMsg().get(3).contains("pestCoin"));
        assertTrue(msgObserver.getMsg().get(3).contains("400"));
        
        String msg = maxObserver.toString();
        assertTrue(msg.contains("800"));
        assertTrue(msg.contains("900"));
    }
}
