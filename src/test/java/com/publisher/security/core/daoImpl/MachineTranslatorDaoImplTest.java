
package com.publisher.security.core.daoImpl;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import publisher.JUnitSpringTestBase;


/**
 *
 * @author satya
 */
public class MachineTranslatorDaoImplTest extends JUnitSpringTestBase
{

   
//	@Autowired
//	MachineTranslatorDao machineTranslatorDao;
    public MachineTranslatorDaoImplTest()
    {
    }

   @Test
    public void testGetAllIpsSignatureDocs()
    {
//        System.out.println("deleteById");
//        List<Document> data = machineTranslatorDao.getAllIpsSignatureDocs("Japanese");
//        System.out.println(data);
     }
   @Test
   public void testGetMostRecentIpsSignatureDoc(){
//	  System.out.println("testGetMostRecentIpsSignatureDoc");
//	  Document data = machineTranslatorDao.getMostRecentIpsSignatureDoc("Japanese");
//     System.out.println(data.getCreationDate());
   }
   @Test
   public void testGetLocalizedIpsSignatureDoc(){
//	  System.out.println("testGetMostRecentIpsSignatureDoc");
//	  Document data = machineTranslatorDao.getLocalizedIpsSignatureDoc("6840", "0", "Japanese");
//     System.out.println(data);
   }
   @Test
   @Transactional
   public void testSavePublishFailure(){
//	 machineTranslatorDao.savePublishFailure(1000291, "24508", "Tech Doc", "Test trace", "Test Reason", "Japanese");
//     System.out.println("Successfully aded");
   }
   @Test
   @Transactional
   public void testUpdateMtTrasactionLog(){
//	   MtTransactionLog mtTransactionLog = new MtTransactionLog();
//	   mtTransactionLog.setId(5062476);
//	 machineTranslatorDao.updateMtTrasactionLog(mtTransactionLog);
//	 System.out.println("Successfully testUpdateMtTrasactionLog ");
   }
   @Test
   public void testGetLanguageByName(){
//	   MtTransactionLog mtTransactionLog = new MtTransactionLog();
//	   mtTransactionLog.setId(5062476);
//	Language data =  machineTranslatorDao.getLanguageByName("Japanese");
//	 System.out.println("Successfully testGetLanguageByName " + data);
   }
   @Test
   public void testGetLanguagePropeties(){
//	   System.out.println("testGetLanguagePropeties started");
//	   List<MtTranslatorProps> data =  machineTranslatorDao.getLanguagePropeties(7,"HT_TECH_DOCS");
//	   System.out.println("Successfully testGetLanguagePropeties " + data);
   }
   
   @Test
   public void testIsCCOEndUrl(){
//	   System.out.println("isCCOEndUrl started");
//	   Boolean data =  machineTranslatorDao.isCCOEndUrl("http://www.cisco.com/warp/customer/477/TD/enhanced_nam_5743.shtml");
//	   System.out.println("Successfully isCCOEndUrl " + data);
   }
   
   @Test
   public void testIisEndUrl(){
//	   System.out.println("isEndUrl started");
//	   Boolean data =  machineTranslatorDao.isEndUrl("http://www.cisco.com/c/en/us/td/docs/voice_ip_comm/cwa/2_4/english/user/webatten/ac22_prf.html");
//	   System.out.println("Successfully isEndUrl " + data);
   }
   
   @Test
   public void testGetPrimaryFile(){
//	   System.out.println("getPrimaryFile started");
//	   String data =  machineTranslatorDao.getPrimaryFile(13562);
//	   System.out.println("Successfully getPrimaryFile " + data);
   }
   
   @Test
   public void testGetPublicUrlForDoc(){
//	   Document document = new Document();
//	   document.setDocumentId("1118086");
//	   System.out.println("getPublicUrlForDoc started");
//	   String data =  machineTranslatorDao.getPublicUrlForDoc(document);
//	   System.out.println("Successfully getPublicUrlForDoc " + data);
   }
   
   @Test
   public void testGetAllIpsSignatureDocs1(){
//	   System.out.println("getAllIpsSignatureDocs started");
//	   List<Document> data =  machineTranslatorDao.getAllIpsSignatureDocs("Japanese");
//	   System.out.println("Successfully getPublicUrlForDoc " + data);
   }
   
   @Test
   public void testGetMostRecentIpsSignatureIndexPageDoc(){
//	   System.out.println("getMostRecentIpsSignatureIndexPageDoc started");
//	   Document data =  machineTranslatorDao.getMostRecentIpsSignatureIndexPageDoc("Japanese");
//	   System.out.println("Successfully getMostRecentIpsSignatureIndexPageDoc " + data);
   }
   
}
