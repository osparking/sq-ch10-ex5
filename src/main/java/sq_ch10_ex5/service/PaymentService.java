package sq_ch10_ex5.service;

import org.springframework.stereotype.Service;

import sq_ch10_ex5.dto.PaymentDetails;
import sq_ch10_ex5.exception.NotEnoughMoneyException;

@Service
public class PaymentService {
	public PaymentDetails processPayment() {
		throw new NotEnoughMoneyException();
	}
}
