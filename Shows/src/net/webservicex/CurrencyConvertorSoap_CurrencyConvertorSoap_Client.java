package net.webservicex;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */
import java.net.URL;

import javax.xml.namespace.QName;

import com.Shows.Domain.Model.Moneda;

/**
 * This class was generated by Apache CXF 2.6.1 2012-06-10T12:44:16.593+02:00
 * Generated source version: 2.6.1
 * 
 */
public final class CurrencyConvertorSoap_CurrencyConvertorSoap_Client {

	private static final QName SERVICE_NAME = new QName(
			"http://www.webserviceX.NET/", "CurrencyConvertor");

	public CurrencyConvertorSoap_CurrencyConvertorSoap_Client() {
	}

	public static double convert(Moneda divisa, Moneda moneda) {
		URL wsdlURL = CurrencyConvertor.WSDL_LOCATION;

		CurrencyConvertor currencyConvertor = new CurrencyConvertor(wsdlURL,
				SERVICE_NAME);
		CurrencyConvertorSoap currencyConvertorSoap = currencyConvertor
				.getCurrencyConvertorSoap();

		Currency fromCurrency = Currency.EUR;
		Currency toCurrency = Currency.EUR;

		if (divisa.toString().equals("EUR"))
			fromCurrency = Currency.EUR;
		else if (divisa.toString().equals("USD"))
			fromCurrency = Currency.USD;
		else if (divisa.toString().equals("GBP"))
			fromCurrency = Currency.GBP;

		if (moneda.toString().equals("EUR"))
			toCurrency = Currency.EUR;
		else if (moneda.toString().equals("USD"))
			toCurrency = Currency.USD;
		else if (moneda.toString().equals("GBP"))
			toCurrency = Currency.GBP;

		return currencyConvertorSoap.conversionRate(fromCurrency, toCurrency);
	}
}
