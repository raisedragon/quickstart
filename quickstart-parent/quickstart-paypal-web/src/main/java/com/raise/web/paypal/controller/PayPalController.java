package com.raise.web.paypal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.raise.paypal.PayPalService;


@Controller()
@RequestMapping("/paypal")
public class PayPalController {

	private static final Logger logger = LoggerFactory
			.getLogger(PayPalController.class);
	@RequestMapping("/pay")
	public void pay(HttpServletRequest request,HttpServletResponse response) throws PayPalRESTException, IOException{
		PayPalService payPalService = new PayPalService();
		String accessToken = payPalService.getAccessToken();
		//create payment
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");

		APIContext apiContext = new APIContext(accessToken);
		apiContext.setConfigurationMap(sdkConfig);

		Details details = new Details();
		details.setSubtotal("10");
		details.setShipping("0");
		details.setTax("0");
		
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("10");
		amount.setDetails(details);
		
		Item item = new Item();
		item.setCurrency("USD");
		item.setPrice("10");
		item.setQuantity("1");
		item.setDescription("all");
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		itemList.setItems(items);

		Transaction transaction = new Transaction();
		transaction.setDescription("creating a payment");
		transaction.setAmount(amount);
		transaction.setItemList(itemList);
//		transaction.setPaymentOptions(PaymentOptions)

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
		
		payment = payment.create(apiContext);
		
		logger.info("Request = " + Payment.getLastRequest());
		logger.info("Response = " + Payment.getLastResponse());
		logger.info("Retrieved Payment status = " + payment.getState());

		response.sendRedirect(payment.getLinks().get(1).getHref());
	}
}
