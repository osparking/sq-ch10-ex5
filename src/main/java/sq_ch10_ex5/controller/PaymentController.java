package sq_ch10_ex5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sq_ch10_ex5.dto.ErrorDetails;
import sq_ch10_ex5.exception.NotEnoughMoneyException;
import sq_ch10_ex5.service.PaymentService;

@RestController
@AllArgsConstructor
public class PaymentController {
	private final PaymentService service;
	
	@PostMapping("/payment")
	public ResponseEntity<?> processPayment() {
		try {
			var paymentDetails = service.processPayment();
			return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(paymentDetails);
		} catch (NotEnoughMoneyException neme) {
			ErrorDetails details = new ErrorDetails();
			details.setMessage("잔고가 부족합니다.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(details);
		}
	}
}
