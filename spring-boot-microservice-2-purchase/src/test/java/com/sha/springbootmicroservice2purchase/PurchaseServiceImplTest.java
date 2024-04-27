package com.sha.springbootmicroservice2purchase;
 
import java.util.List;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
 
import com.sha.springbootmicroservice2purchase.model.Purchase;
import com.sha.springbootmicroservice2purchase.service.PurchaseServiceImpl;
public class PurchaseServiceImplTest {
  
	private org.slf4j.Logger log = LoggerFactory.getLogger(PurchaseServiceImplTest.class);
    @BeforeAll
    static void initAll() {
    }
    @BeforeEach
    void init() {
    }
 
  @Test  
	@DisplayName("save Purchase")
    public void savePurchase(){  
		try {
			log.info("Starting execution of savePurchase");
Purchase expectedValue = null;
  Purchase purchase = null;
 
  
PurchaseServiceImpl purchaseserviceimpl  =new PurchaseServiceImpl();
Purchase actualValue=purchaseserviceimpl.savePurchase( purchase);
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
    }  
 
  @Test  
	@DisplayName("find All Purchases Of User")
    public void findAllPurchasesOfUser(){  
		try {
			log.info("Starting execution of findAllPurchasesOfUser");
List<Purchase> expectedValue = null;
  Long userId=0L;
 
  
PurchaseServiceImpl purchaseserviceimpl  =new PurchaseServiceImpl();
List<Purchase> actualValue=purchaseserviceimpl.findAllPurchasesOfUser( userId);
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
    }  
    @AfterEach
    void tearDown() {
    }
    @AfterAll
    static void tearDownAll() {
    }
}