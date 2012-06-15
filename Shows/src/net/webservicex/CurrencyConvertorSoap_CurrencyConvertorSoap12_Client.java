
package net.webservicex;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2012-06-10T12:44:16.623+02:00
 * Generated source version: 2.6.1
 * 
 */
public final class CurrencyConvertorSoap_CurrencyConvertorSoap12_Client {

    private static final QName SERVICE_NAME = new QName("http://www.webserviceX.NET/", "CurrencyConvertor");

    private CurrencyConvertorSoap_CurrencyConvertorSoap12_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CurrencyConvertor.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        CurrencyConvertor ss = new CurrencyConvertor(wsdlURL, SERVICE_NAME);
        CurrencyConvertorSoap port = ss.getCurrencyConvertorSoap12();  
        
        {
        System.out.println("Invoking conversionRate...");
        net.webservicex.Currency _conversionRate_fromCurrency = net.webservicex.Currency.EUR;
        net.webservicex.Currency _conversionRate_toCurrency = net.webservicex.Currency.USD;
        double _conversionRate__return = port.conversionRate(_conversionRate_fromCurrency, _conversionRate_toCurrency);
        System.out.println("conversionRate.result=" + _conversionRate__return);


        }

        System.exit(0);
    }

}
