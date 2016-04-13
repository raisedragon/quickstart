package com.raise.paypal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

public class PayPalService {
	
	private static final String CLIENT_ID = "Acy9krUIaL2aqegsOKVPrQSmKkqI4aqyx-tYqNdX1EbMq_Fea8SHqF7eC82l5PUcuCD15UaijbA3teHR";
	private static final String CLIENT_SECRET = "EJ7OmmUvefbigmOejynuXxlTQVMs4UmVkH0_yLq5X85lIQKE_RNGh7a5qJvYBK-U808LWVf_tyXMMClZ";
	
	
	public Payment createPayment() throws PayPalRESTException {
		
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");

		String accessToken = getAccessToken();
		APIContext apiContext = new APIContext(accessToken);
		apiContext.setConfigurationMap(sdkConfig);
		
		Details details = new Details();
		details.setSubtotal("12");
		details.setShipping("0");
		details.setTax("0");

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("12");
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setDescription("creating a payment");
		transaction.setAmount(amount);

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://devtools-paypal.com/guide/pay_paypal?cancel=true");
		redirectUrls.setReturnUrl("https://devtools-paypal.com/guide/pay_paypal?success=true");
		payment.setRedirectUrls(redirectUrls);

		Payment createdPayment = payment.create(apiContext);
		
		return createdPayment;
	}
	
	
	public String getAccessToken() throws PayPalRESTException {
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put(Constants.MODE, Constants.SANDBOX);
		return new OAuthTokenCredential(CLIENT_ID, CLIENT_SECRET,sdkConfig).getAccessToken();
	}
	
	
	public static void main(String[] args) throws PayPalRESTException {
		PayPalService service = new PayPalService();
		String token = service.getAccessToken();
		System.out.println(token);
		Payment payment = service.createPayment();
		
		System.out.println(payment.toJSON());
		
		
	}
	
	
}
